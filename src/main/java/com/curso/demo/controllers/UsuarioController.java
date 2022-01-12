package com.curso.demo.controllers;

import com.curso.demo.dao.UsuarioDao;
import com.curso.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * System:                 CleanBnB
 * Name:                   UsuarioController
 * Description:            Class that represents a UsuarioController's Entity in the application
 *
 * @author carlosdeltoro
 * @version 1.0
 * @since 1/8/22
 */
@RestController
public class UsuarioController
{
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setApellido("Del Toro");
        usuario.setEmail("Carldeltoro@gmail.com");
        usuario.setPassword("134$%·");
        usuario.setTelefono("+57-23434554");
        usuario.setTelefono("carlos");
        return usuario;
    }
    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/editar")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setApellido("Del Toro");
        usuario.setEmail("Carldeltoro@gmail.com");
        usuario.setPassword("134$%·");
        usuario.setTelefono("+57-23434554");
        usuario.setTelefono("carlos");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        usuarioDao.eliminar(id);
    }

    @RequestMapping(value = "api/buscar")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setApellido("Del Toro");
        usuario.setEmail("Carldeltoro@gmail.com");
        usuario.setPassword("134$%·");
        usuario.setTelefono("+57-23434554");
        usuario.setTelefono("carlos");
        return usuario;
    }
}
