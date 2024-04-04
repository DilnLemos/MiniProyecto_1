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
            System.out.println("5. Buscar cliente por nombre");
            System.out.println("6. Solicitar Prestamo");
            System.out.println("7. Calcular CDT del cliente");
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
                case 5:
                    buscar_cliente_por_nombre(); // Llamar al método para buscar un cliente por nombre
                    break;
                case 6:
                    prestamo_cliente();//Llamar al método para solicitar prestamo
                    break;
                case 7:
                    cdt_cliente();//Llamar al método para calcular el CDT del cliente
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

// Método para buscar un cliente por nombre
    public static void buscar_cliente_por_nombre() {
        System.out.println("Ingrese el nombre del cliente que desea buscar");
        Scanner scannerbus = new Scanner(System.in);
        String nombre = scannerbus.nextLine();

    // Buscar al cliente por nombre y mostrar su información
        for (int i = 0; i < mis_clientes.size(); i++) {
            if (nombre.equals(mis_clientes.get(i).getNombre())) {
            System.out.println(mis_clientes.get(i).getNombre() + " Su Ahorro: " + mis_clientes.get(i).getAhorro() + " cop");
        }   else {
             System.err.println("el cliente no existe"); // Mostrar un mensaje de error si el cliente no se encuentra
        }
    }
}

    // Método para hacer un préstamo al cliente
    public static void prestamo_cliente(){
        double cuota_mensual, interes;
        //Se ingresa el cliente que solicitará el prestamo
        System.out.println("Ingrese el nombre del cliente que desea buscar");
        Scanner scannerpcl = new Scanner(System.in);
        String nombre = scannerpcl.nextLine();
        //Se ingresa la cantidad de dinero que quiere prestar el cliente
        System.out.println("Ingrese la cantidad de dinero que quiere prestar");
        Scanner scannerprest = new Scanner(System.in);
        int prestamo = scannerprest.nextInt();
        
        //Se busca al cliente por nombre y se valoran las condiciones para validar el prestemo
        for (int i = 0; i < mis_clientes.size(); i++) {
            if (nombre.equals(mis_clientes.get(i).getNombre())) {
               if (prestamo <= mis_clientes.get(i).getAhorro()) {
                mis_clientes.get(i).setAhorro(mis_clientes.get(i).getAhorro() + prestamo);
                System.out.println("Su ahorro despues del prestamo es: " + mis_clientes.get(i).getAhorro() + " cop");
               }else {
                    if (prestamo <= (mis_clientes.get(i).getAhorro() * 2)){
                        mis_clientes.get(i).setAhorro(mis_clientes.get(i).getAhorro() + prestamo);
                        interes = (prestamo / 6);
                        cuota_mensual = ((0.001651581302 * prestamo) + interes);
                        System.out.println("La cuota mensual de su prestamo es de: "+ cuota_mensual + " cop");
                        System.out.println("Su ahorro despues del prestamo es: " + mis_clientes.get(i).getAhorro() + " cop");
                        //Si el presamos no es valido se muestra el mensaje en pantalla
                    }else {
                        System.out.println("Su prestamo no puede ser mayor que el doble de su ahorro");
                    }
               }   
            } else {
                System.err.println("el cliente no existe");
                }
        }
    }

    // Método para calcular el CDT del cliente
    public static void cdt_cliente(){
        //Se busca el cliente por el nombre
        System.out.println("Ingrese el nombre del cliente que desea buscar");
        Scanner scannerbusc = new Scanner(System.in);
        String nombrec = scannerbusc.nextLine();
        
        //El cliente elije el tiempo de su CDT
        System.out.println("elija  por cuanto tiempo quiere su CDT , 3 0 6 meses");
        Scanner sncannercdt= new Scanner(System.in);
        byte cdt= sncannercdt.nextByte();
        //Se valoran las condiciones para validar el CDT
         for (int i = 0; i < mis_clientes.size(); i++) {
            if (nombrec.equals(mis_clientes.get(i).getNombre()) && cdt == 3) {
                double total = mis_clientes.get(i).getAhorro()+(mis_clientes.get(i).getAhorro()*0.03*(3.0/12.0));
                System.out.println("su ganancia total es " + total+ " cop");
            } else if (nombrec.equals(mis_clientes.get(i).getNombre()) && cdt == 6) {
        
                double total2 = mis_clientes.get(i).getAhorro()+(mis_clientes.get(i).getAhorro()*0.05*(3.0/12.0));
                System.out.println("su ganancia total es " + total2 + " cop");

            }
            else{
                System.out.println("el CDT no funciona");
            }
        }

    }
}

// Prueba Final