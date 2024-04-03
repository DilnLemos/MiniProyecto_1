// Se importan todas las librerias a usar en el código

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Clase Principal de la aplicación
public class App {

    // Método principal de la aplicación
    public static void main(String[] args) throws Exception {

        Scanner scanner_opcion = new Scanner(System.in);
        byte opcion;

        // Bucle para mostrar el menú de opciones
        do {

            // Mostrar el menú de opciones al usuario
            System.out.println("elija una opcion");
            System.out.println("1. ingresar un cliente");

            opcion = scanner_opcion.nextByte();
            switch (opcion) {
                case 1:
                    persona();
                    break;



            }




        } while (opcion != 0);
    }

    static List<Cliente> mis_clientes = new ArrayList<Cliente>(); // Lista para almacenar los clientes

    // Método para ingresar un cliente

    public static void persona(){

        Cliente cliente1 = new Cliente();

        // Solicitar y establecer los datos del cliente

        // Nombre del Cliente

        System.out.println("ingrese el nombre del cliente");
        Scanner nombre_cliente = new Scanner(System.in);
        String nombre = nombre_cliente.nextLine();
        cliente1.setNombre(nombre);

        // Cédula del Cliente
        System.out.println("ingrese la cedula del cliente");
        Scanner cedula_cliente = new Scanner(System.in);
        String cedula = cedula_cliente.nextLine();
        cliente1.setCedula(cedula);

        // Fecha de incorporación del Cliente
        System.out.println("ingrese la fecha de incorporacion del cliente");
        Scanner fecha_cliente = new Scanner(System.in);
        String fecha = fecha_cliente.nextLine();
        cliente1.setFecha(fecha);

        // Nivel de ingresos del Cliente
        System.out.println("ingrese el nivel de ingresos del cliente");
        System.out.println(Arrays.toString(Nivel_Ingresos.values()));
        Scanner scanner = new Scanner(System.in);
        String nivel_ingresos = scanner.nextLine();
        Nivel_Ingresos ni = Nivel_Ingresos.valueOf(nivel_ingresos);
        cliente1.setNivel_ingresos(ni);
        
        // Ahorro del Cliente
        System.out.println("ingrese el ahorro del cliente");
        Scanner ahorro_cliente = new Scanner(System.in);
        int ahorro = ahorro_cliente.nextInt();
        cliente1.setAhorro(ahorro);

        // Agregar el cliente a la lista de clientes
        mis_clientes.add(cliente1);



    }


















}

