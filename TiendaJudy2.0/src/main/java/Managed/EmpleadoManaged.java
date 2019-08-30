/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed;

import Dao.EmpleadoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.Empleado;


@Named
@ViewScoped
public class EmpleadoManaged implements Serializable {

    @EJB
    private EmpleadoDAO empleadoDAO;

    @EJB
    private Empleado empleado;

    private List<Empleado> empleados;

    public EmpleadoManaged() {
    }

    @PostConstruct
    public void init() {
        empleado = new Empleado();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getEmpleados() {
        if (empleados == null) {
            empleados = empleadoDAO.obtenerEmpleados();
        }
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    public void crearEmpleado(){
        if (empleado!= null) {
            if (empleadoDAO.buscarEmpleado(empleado.getIdEmpleado())==null) {
                empleadoDAO.createEmpleado(empleado);  
            }else{
            
            }
            
        }
    }
    
    
    
    
    public void editarEmpleado(){
        if (empleado!=null) {
            empleadoDAO.editarEmpleado(empleado);
        }
    }

}
