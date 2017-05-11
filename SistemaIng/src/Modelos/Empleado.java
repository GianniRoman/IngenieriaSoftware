package Modelos;

public class Empleado {
    String legajo;
    String dni;
    String nombre;
    String telefono;
    boolean Sesion;
    
    public Empleado()
    {
        this.legajo = null;
        this.dni  = null;
        this.nombre  = null;
        this.telefono = null;
        this.Sesion = false;       
    }

    public Empleado(String elegajo, String dni, String nombre, String telefono) {
        this.legajo = elegajo;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.Sesion = false;
    }

    public String getlegajo() {
        return legajo;
    }

    public void setlegajo(String elegajo) {
        this.legajo = elegajo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isSesion() {
        return Sesion;
    }

    public void setSesion(boolean Sesion) {
        this.Sesion = Sesion;
    }
    
    
       
}
