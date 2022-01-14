package com.curso.demo.controllers;

import com.curso.demo.dao.UsuarioDao;
import com.curso.demo.models.Usuario;
import com.curso.demo.utils.JWTUtil;
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
    @Autowired
    private JWTUtil jwtUtil;


    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        Usuario miAuthUser = usuarioDao.obtnerUsuarioPorCredenciales(usuario);
        if(miAuthUser!= null){

            String tokenJWT = jwtUtil.create(String.valueOf(miAuthUser.getId()),miAuthUser.getEmail());

            return tokenJWT;
        }
        return "Fail";
    }
}
