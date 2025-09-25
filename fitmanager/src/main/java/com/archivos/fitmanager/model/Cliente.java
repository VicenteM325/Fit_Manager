package com.archivos.fitmanager.model;

import java.sql.Timestamp;

/**
 *
 * @author vicente
 */
public class Cliente {

    private int idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private Timestamp fechaRegistro;
    private Integer idEntrenador; 
    private Integer idMembresia; 

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String apellido, String telefono, Integer idEntrenador, Integer idMembresia) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.idEntrenador = idEntrenador;
        this.idMembresia = idMembresia;
    }

    public Cliente(String nombre, String apellido, String telefono, Integer idEntrenador, Integer idMembresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.idEntrenador = idEntrenador;
        this.idMembresia = idMembresia;
        this.fechaRegistro = null; 
    }

    public Cliente(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    
    public Cliente(int idCliente, String nombre, String apellido, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    // Getters y Setters
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public Timestamp getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Timestamp fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public Integer getIdEntrenador() { return idEntrenador; }
    public void setIdEntrenador(Integer idEntrenador) { this.idEntrenador = idEntrenador; }
    public Integer getIdMembresia() { return idMembresia; }
    public void setIdMembresia(Integer idMembresia) { this.idMembresia = idMembresia; }
}
