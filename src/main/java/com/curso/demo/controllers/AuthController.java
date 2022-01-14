package com.curso.demo.controllers;

import com.curso.demo.dao.UsuarioDao;
import com.curso.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * System:                 CleanBnB
 * Name:                   AuthController
 * Description:            Class that represents a AuthController's Entity in the application
 *
 * @author carlosdeltoro
 * @version 1.0
 * @since 1/13/22
 */
@RestController
public class AuthController
{
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){

        if(usuarioDao.verificarCredenciales(usuario)){
            return "ok";
        }
        return "Fail";
    }
}
