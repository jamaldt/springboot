package com.curso.demo.dao;

import com.curso.demo.models.Usuario;
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
        entityManager.remove(id);
    }
}
