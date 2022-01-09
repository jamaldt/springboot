package com.curso.demo.controllers;

import com.curso.demo.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping(value = "frutas")
    public List<String> frutas(){
        return List.of("manzana","pera","durazno");
    }

    @RequestMapping(value = "usuario/{id}")
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
    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){

        List<Usuario> userList = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setApellido("Del Toro");
        usuario.setEmail("Carldeltoro@gmail.com");
        usuario.setPassword("134$%·");
        usuario.setTelefono("+57-23434554");
        usuario.setTelefono("carlos");

        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setApellido("Del Toro");
        usuario2.setEmail("Carldeltoro@gmail.com");
        usuario2.setPassword("134$%·");
        usuario2.setTelefono("+57-23434554");
        usuario2.setTelefono("carlos");

        Usuario usuario3 = new Usuario();
        usuario3.setId(3L);
        usuario3.setApellido("Del Toro");
        usuario3.setEmail("Carldeltoro@gmail.com");
        usuario3.setPassword("134$%·");
        usuario3.setTelefono("+57-23434554");
        usuario3.setTelefono("carlos");

        userList.add(usuario);
        userList.add(usuario2);
        userList.add(usuario3);
        return userList;
    }

    @RequestMapping(value = "editar")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setApellido("Del Toro");
        usuario.setEmail("Carldeltoro@gmail.com");
        usuario.setPassword("134$%·");
        usuario.setTelefono("+57-23434554");
        usuario.setTelefono("carlos");
        return usuario;
    }

    @RequestMapping(value = "eliminar")
    public Usuario eliminar(){
        Usuario usuario = new Usuario();
        usuario.setApellido("Del Toro");
        usuario.setEmail("Carldeltoro@gmail.com");
        usuario.setPassword("134$%·");
        usuario.setTelefono("+57-23434554");
        usuario.setTelefono("carlos");
        return usuario;
    }
    @RequestMapping(value = "buscar")
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
