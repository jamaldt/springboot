package com.curso.demo.models;

/**
 * System:                 CleanBnB
 * Name:                   Usuario
 * Description:            Class that represents a Usuario's Entity in the application
 *
 * @author carlosdeltoro
 * @version 1.0
 * @since 1/9/22
 */
public class Usuario
{
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String password;

    public Long getId()
    {
        return id;
    }

    public Usuario setId(Long id)
    {
        this.id = id;
        return this;
    }

    public String getNombre()
    {
        return nombre;
    }

    public Usuario setNombre(String nombre)
    {
        this.nombre = nombre;
        return this;
    }

    public String getApellido()
    {
        return apellido;
    }

    public Usuario setApellido(String apellido)
    {
        this.apellido = apellido;
        return this;
    }

    public String getEmail()
    {
        return email;
    }

    public Usuario setEmail(String email)
    {
        this.email = email;
        return this;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public Usuario setTelefono(String telefono)
    {
        this.telefono = telefono;
        return this;
    }

    public String getPassword()
    {
        return password;
    }

    public Usuario setPassword(String password)
    {
        this.password = password;
        return this;
    }
}
