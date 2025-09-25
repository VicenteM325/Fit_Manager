package com.archivos.fitmanager.login;

/**
 *
 * @author vicente
 */
public class SessionManager {
    private static int idUsuario;
    private static String nombreUsuario;
    private static String rol;

    public static void iniciarSesion(int id, String nombre, String rolUsuario) {
        idUsuario = id;
        nombreUsuario = nombre;
        rol = rolUsuario;
    }

    public static int getIdUsuario() {
        return idUsuario;
    }
    
    public static String getNombreUsuario(){
        return nombreUsuario;
    }

    public static String getRol() {
        return rol;
    }

    public static void cerrarSesion() {
        idUsuario = 0;
        nombreUsuario = null;
        rol = null;
    }
}
