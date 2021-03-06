package com.curso.demo.controllers;

import com.curso.demo.dao.UsuarioDao;
import com.curso.demo.models.Usuario;
import com.curso.demo.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
    @Autowired
    private JWTUtil _jwtUtil;

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

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value="Authorization") String token){
        if(!validarToken(token)){
            return  null;
        }

        return usuarioDao.getUsuarios();
    }

    private boolean validarToken(String token){
        String usuarioId = _jwtUtil.getKey(token);

        return usuarioId !=null;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody Usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024, 1,usuario.getPassword());
        usuario.setPassword(hash);

         usuarioDao.registar(usuario);
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
    public void eliminar(@RequestHeader(value="Authorization") String token,@PathVariable Long id){
        if(!validarToken(token)){
            return;
        }

        usuarioDao.eliminar(id);
    }
}
