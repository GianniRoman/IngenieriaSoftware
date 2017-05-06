package Modelos;

public class Usuario {
    
    String nombre;
    String contraseña;
    int tipo;
    
    public Usuario()
    {   
        nombre = null;
        contraseña = null;
        tipo = -1;
    }
    
    public Usuario(String nombre, String pw, int tipo)
    {
        this.nombre = nombre;
        this.contraseña = pw;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
    
}


