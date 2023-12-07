import java.util.Scanner;
// Clase Menu que proporciona un menú interactivo para gestionar la información de aeropuertos y vuelos//
public class Menu {
    public static void menu(ListaAeropuerto listaAeropuerto, ListaVuelos listaVuelos){
        Output output = new Output();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Mostrar el listado de Aeropueros.");
            System.out.println("2. Mostrar el listado de las salidas por cada Aeropuerto.");
            System.out.println("3. Mostrar el listado de las entradas por cada Aeropuerto.");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    output.listaAeorpuertos(listaAeropuerto);
                    System.out.println("");
                    break;
                case 2:
                    output.listaSalidas(listaVuelos, listaAeropuerto);
                    System.out.println("");
                    break;
                case 3:
                    output.listaEntradas(listaVuelos, listaAeropuerto);
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Opción inválida,  seleccione una opción válida.");
                    break;
            }
        } while (opcion != 4);
        scanner.close();
    }
}