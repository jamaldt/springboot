package com.curso.demo.dao;

import com.curso.demo.models.Usuario;

import java.util.List;

/**
 * System:                 CleanBnB
 * Name:                   UsuarioDao
 * Description:            Class that represents a UsuarioDao's Entity in the application
 *
 * @author carlosdeltoro
 * @version 1.0
 * @since 1/10/22
 */
public interface UsuarioDao
{
    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registar(Usuario usuario);

    Usuario obtnerUsuarioPorCredenciales(Usuario usuario);
}
