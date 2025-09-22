package com.archivos.fitmanager.model;

/**
 *
 * @author vicente
 */
public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String telefono;
    private int idRol;        
    private String rolNombre;   
    private String usuarioLogin;
    private String contrasena; 
    private Integer idSucursal; 

    public Empleado() {}

    public Empleado(int idEmpleado, String nombre, String apellido, String telefono,
                    int idRol, String rolNombre,
                    String usuarioLogin, String contrasena, Integer idSucursal) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.idRol = idRol;
        this.rolNombre = rolNombre;
        this.usuarioLogin = usuarioLogin;
        this.contrasena = contrasena;
        this.idSucursal = idSucursal;
    }
    
    public Empleado(int idEmpleado, String nombre, String apellido,
                String rolNombre, String usuarioLogin) {
    this.idEmpleado = idEmpleado;
    this.nombre = nombre;
    this.apellido = apellido;
    this.rolNombre = rolNombre;
    this.usuarioLogin = usuarioLogin;
}

    // Getters y Setters
    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public int getIdRol() { return idRol; }
    public void setIdRol(int idRol) { this.idRol = idRol; }

    public String getRolNombre() { return rolNombre; }
    public void setRolNombre(String rolNombre) { this.rolNombre = rolNombre; }

    public String getUsuarioLogin() { return usuarioLogin; }
    public void setUsuarioLogin(String usuarioLogin) { this.usuarioLogin = usuarioLogin; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public Integer getIdSucursal() { return idSucursal; }
    public void setIdSucursal(Integer idSucursal) { this.idSucursal = idSucursal; }
    
    @Override
    public String toString() {
        return nombre;
    }
}
