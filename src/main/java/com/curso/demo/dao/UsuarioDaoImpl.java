package com.curso.demo.dao;

import com.curso.demo.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * System:                 CleanBnB
 * Name:                   UsuarioDaoImpl
 * Description:            Class that represents a UsuarioDaoImpl's Entity in the application
 *
 * @author carlosdeltoro
 * @version 1.0
 * @since 1/10/22
 */
@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao
{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios()
    {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id)
    {
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }

    @Override
    public void registar(Usuario usuario)
    {
        entityManager.merge(usuario);
    }

    @Override
    public boolean verificarCredenciales(Usuario usuario)
    {
        String query = "FROM Usuario WHERE  email = :email";
        List<Usuario> lista =  entityManager.createQuery(query)
            .setParameter("email",usuario.getEmail())
            .getResultList();

        if (lista.isEmpty()){
            return false;
        }
        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        boolean isPassword = argon2.verify(passwordHashed,usuario.getPassword());

        return !lista.isEmpty();
    }
}
