package com.curso.demo.controllers;

import com.curso.demo.models.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "frutas")
    public List<String> frutas(){
        return List.of("manzana","pera","durazno");
    }

     @RequestMapping(value = "usuario")
    public Usuario getUsuario(){
        Usuario usuario = new Usuario();
        usuario.setApellido("Del Toro");
        usuario.setEmail("Carldeltoro@gmail.com");
        usuario.setPassword("134$%·");
        usuario.setTelefono("+57-23434554");
        usuario.setTelefono("carlos");
        return usuario;
    }
}
