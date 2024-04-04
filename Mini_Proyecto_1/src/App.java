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
        byte opcion; // Variable para almacenar la opción seleccionada por el usuario

        // Bucle para mostrar el menú de opciones
        do {

            // Mostrar el menú de opciones al usuario
            System.out.println("elija una opcion");
            System.out.println("1. ingresar un cliente");
            System.out.println("2. listar los clientes");
            System.out.println("3. Actualizar dinero de un cliente");
            System.out.println("4. eliminar dinero de un cliente");
            System.out.println("0. salir");

            opcion = scanner_opcion.nextByte();
            switch (opcion) {
                case 1:
                    persona(); // Llamar al método para ingresar un nuevo cliente 
                    break;
                case 2:
                    listar_clientes(); // Llamar al método para listar los clientes
                    break;
                case 3:
                    actualizar_dinero_ahorrado(); // Llamar al método para actualizar el dinero ahorrado de un cliente
                    break;
                case 4:
                    eliminar_dinero_ahorrado(); // Llamar al método para eliminar dinero ahorrado de un cliente
                    break;
                
            }
        } while (opcion != 0); //Condición para cerrar el bucle
    }

    // Lista para almacenar los clientes
    static List<Cliente> mis_clientes = new ArrayList<Cliente>(); 

    // Método para ingresar un cliente
    public static void persona(){

        // Crear un nuevo cliente
        Cliente cliente1 = new Cliente();

        // Solicitar y establecer los datos del cliente

        // Nombre y apellido del Cliente
        System.out.println("ingrese el nombre y apellido del cliente");
        Scanner nombre_cliente = new Scanner(System.in);
        String nombre = nombre_cliente.nextLine();
        cliente1.setNombre(nombre);

        // Cédula del Cliente
        System.out.println("ingrese la cedula del cliente");
        Scanner cedula_cliente = new Scanner(System.in);
        String cedula = cedula_cliente.nextLine();
        cliente1.setCedula(cedula);

        // Fecha de incorporación del Cliente
        System.out.println("ingrese la fecha de incorporacion del cliente (dd/mm/yyyy):");
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

    // Método para listar todos los clientes del banco
    public static void listar_clientes() {

        for ( int i = 0; i < mis_clientes.size(); i++){

            System.out.println("Cliente " + (i + 1) + ": " + mis_clientes.get(i).getNombre() + " y su ahorro es: " + mis_clientes.get(i).getAhorro()+" cop");
        }
    }

    // Método para actualizar el dinero ahorrado de un cliente
    public static void actualizar_dinero_ahorrado() {
        System.out.println("Ingrese su nombre para actualizar su ahorro");
        Scanner scanneract = new Scanner(System.in);
        String comparar = scanneract.nextLine();

         // Buscar al cliente por nombre y actualizar su ahorro
        for (int i = 0; i < mis_clientes.size(); i++) {
            if (comparar.equals(mis_clientes.get(i).getNombre())) {
                System.out.println("Ingrese la cantidad de dinero que desea agregar a su ahorro");
                int dinero = scanneract.nextInt();
                mis_clientes.get(i).setAhorro(mis_clientes.get(i).getAhorro() + dinero);
                System.out.println("El nuevo ahorro de " + mis_clientes.get(i).getNombre() + " es de " + mis_clientes.get(i).getAhorro() + " cop");
            }
    }

}

   // Método para eliminar dinero ahorrado de un cliente
   public static void eliminar_dinero_ahorrado() {
    System.out.println("Ingrese su nombre para eliminar su ahorro");
    Scanner scannerelim = new Scanner(System.in);
    String comparazao = scannerelim.nextLine();

    // Buscar al cliente por nombre y eliminar una cantidad específica de su ahorro
    for (int i = 0; i < mis_clientes.size(); i++) {
        if (comparazao.equals(mis_clientes.get(i).getNombre())) {
            System.out.println("Ingrese la cantidad de dinero que desea eliminar de su ahorro");
            int dinero = scannerelim.nextInt();
            if (dinero <= mis_clientes.get(i).getAhorro()) {
                mis_clientes.get(i).setAhorro(mis_clientes.get(i).getAhorro() - dinero);
                System.out.println("El nuevo ahorro de " + mis_clientes.get(i).getNombre() + " es de " + mis_clientes.get(i).getAhorro() + " cop");
            } else {
                System.err.println("No se puede eliminar más dinero que su ahorro"); // Mostrar un mensaje de error si la cantidad a eliminar es mayor que el ahorro del cliente
                break;
            }
            return;
        }        
    }
}




}
