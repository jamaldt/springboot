package com.curso.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * System:                 CleanBnB
 * Name:                   Usuario
 * Description:            Class that represents a Usuario's Entity in the application
 *
 * @author carlosdeltoro
 * @version 1.0
 * @since 1/9/22
 */
@Entity
@Table(name = "usuarios")
public class Usuario
{
    @Id
    @Getter @Setter @Column(name = "id")
    private Long id;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private String apellido;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String telefono;
    @Getter @Setter
    private String password;

}
