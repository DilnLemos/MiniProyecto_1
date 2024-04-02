// Clase que representa a un cliente
public class Cliente {

    // Atributos de la clase "Cliente"
    private String nombre;    
    private String Cedula;
    private String fecha;
    private Nivel_Ingresos nivel_ingresos;
    private int ahorro; 


    // Constructor de la clase "Cliente" con parámetros
    public Cliente(String nombre, String cedula, String fecha, Nivel_Ingresos nivel_ingresos, int ahorro) {
        this.nombre = nombre;
        this.Cedula = cedula;
        this.fecha = fecha;
        this.nivel_ingresos = nivel_ingresos;
        this.ahorro = ahorro;
    }

    // Constructor de la clase Cliente sin parámetros
    public Cliente() {
    }

    // Método getter para obtener el nombre del cliente
    public String getNombre() {
        return nombre;
    }

    // Método setter para establecer el nombre del cliente
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método getter para obtener la cédula del cliente
    public String getCedula() {
        return Cedula;
    }

    // Método setter para establecer la cédula del cliente
    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    // Método getter para obtener la fecha de incorporación del cliente
    public String getFecha() {
        return fecha;
    }

    // Método setter para establecer la fecha de incorporación del cliente
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    // Método getter para obtener el nivel de ingresos del cliente
    public Nivel_Ingresos getNivel_ingresos() {
        return nivel_ingresos;
    }

    // Método setter para establecer el nivel de ingresos del cliente
    public void setNivel_ingresos(Nivel_Ingresos nivel_ingresos) {
        this.nivel_ingresos = nivel_ingresos;
    }

    // Método getter para obtener el ahorro del cliente
    public int getAhorro() {
        return ahorro;
    }

    // Método setter para establecer el ahorro del cliente
    public void setAhorro(int ahorro) {
        this.ahorro = ahorro;
    }
}

