package com.archivos.fitmanager.controller;

import com.archivos.fitmanager.dao.EmpleadoDAO;
import com.archivos.fitmanager.model.Empleado;
import java.util.List;

/**
 *
 * @author vicente
 */
public class EmpleadoController {
    private final EmpleadoDAO empleadoDAO;

    public EmpleadoController() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    public boolean registrarEmpleado(Empleado emp) {
        return empleadoDAO.registrarEmpleado(emp);
    }

    public List<Empleado> listarEntrenadores() {
        EmpleadoDAO dao = new EmpleadoDAO();
        return dao.obtenerEntrenadores();
    }

}
