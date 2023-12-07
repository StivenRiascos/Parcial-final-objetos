import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Output {

    // Método para generar y mostrar un archivo de texto con el listado de aeropuertos//
    public void listaAeorpuertos (ListaAeropuerto listaAeropuerto) {
        String nombreArchivo = "ListaAeropuertos.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {

            // Encabezado y formato de la tabla

            writer.write("Listado de Aeropuertos: ");
            writer.newLine();
            writer.newLine();
            writer.newLine();
            writer.write(String.format("%-9s %-25s %-15s %-15s %s",
                    "Codigo", "Nombre", "Poblacion", "Pais", "GTM"));
            writer.newLine();
            writer.write("-------------------------------------------------------------------------");
            writer.newLine();
            writer.newLine();

            // Iterar sobre la lista de aeropuertos y escribir en el archivo//
            for (Aeropuerto aeropuerto : listaAeropuerto.getAeropuertoList()){
                writer.write(String.format("%-9s %-25s %-15s %-15s %s",
                        aeropuerto.getCode(),
                        aeropuerto.getName(),
                        aeropuerto.getPopulation(),
                        aeropuerto.getCountry(),
                        aeropuerto.getGMT()));
                writer.newLine();
                writer.newLine();
            }

            // Línea de separación final y abrir el archivo en el escritorio//
            writer.write("-------------------------------------------------------------------------");
            writer.newLine();
            writer.write("Aeropuertos: " + listaAeropuerto);
            File file = new File(nombreArchivo);
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método para generar y mostrar un archivo de texto con el listado de salidas por aeropuerto//
    public void listaSalidas (ListaVuelos listaVuelos, ListaAeropuerto listaAeropuerto) {
        String nombreArchivo = "ListaSalidas.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("Listado de salidas: ");
            writer.newLine();
            writer.newLine();
            writer.newLine();
            writer.write("--------------------------------------------------------------------------------------------------------------");
            for(Aeropuerto aeropuerto : listaAeropuerto.getAeropuertoList()){
                writer.newLine();
                writer.newLine();
                writer.newLine();
                writer.write("Aeropuerto: " + aeropuerto.getName());
                writer.newLine();
                writer.newLine();
                writer.write(String.format("%-25s %-15s %-15s %-10s %-7s %s",
                        "Destino - Aeropuerto", "Duracion", "Compañia", "Avion", "Plazas", "Cronograma"));
                writer.newLine();
                writer.write("--------------------------------------------------------------------------------------------------------------");
                writer.newLine();
                for (Vuelo vuelo: listaVuelos.getVueloList()){
                    if(vuelo.getDepartureAirport().equals(aeropuerto.getCode())){

                        writer.write(String.format("%-25s %-15s %-15s %-10s %-7s %s",
                                listaAeropuerto.getNameByCode(vuelo.getArrivalAirport()),
                                vuelo.getDuration(),
                                vuelo.getCompany(),
                                vuelo.getTypePlane(),
                                vuelo.getSeats(),
                                vuelo.getSchedule()));
                        writer.newLine();
                    }
                }
                writer.write("--------------------------------------------------------------------------------------------------------------");
            }
            File file = new File(nombreArchivo);
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método para generar y mostrar un archivo de texto con el listado de salidas por aeropuerto
    public void listaEntradas (ListaVuelos listaVuelos, ListaAeropuerto listaAeropuerto) {
        String nombreArchivo = "ListaEntradas.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Encabezado y formato de la tabla
            writer.write("Listado de entradas: ");
            writer.newLine();
            writer.newLine();
            writer.newLine();
            writer.write("--------------------------------------------------------------------------------------------------------------");

            // Iterar sobre la lista de aeropuertos y vuelos y escribir en el archivo//
            for(Aeropuerto aeropuerto : listaAeropuerto.getAeropuertoList()){
                writer.newLine();
                writer.newLine();
                writer.newLine();
                writer.write("Aeropuerto: " + aeropuerto.getName());
                writer.newLine();
                writer.newLine();
                writer.write(String.format("%-25s %-15s %-15s %-10s %-7s %s",
                        "Origen - Aeropuerto", "Duracion", "Compañia", "Avion", "Plazas", "Cronograma"));
                writer.newLine();
                writer.write("--------------------------------------------------------------------------------------------------------------");
                writer.newLine();
                for (Vuelo vuelo: listaVuelos.getVueloList()){
                    if(vuelo.getArrivalAirport().equals(aeropuerto.getCode())){

                        writer.write(String.format("%-25s %-15s %-15s %-10s %-7s %s",
                                listaAeropuerto.getNameByCode(vuelo.getDepartureAirport()),
                                vuelo.getDuration(),
                                vuelo.getCompany(),
                                vuelo.getTypePlane(),
                                vuelo.getSeats(),
                                vuelo.getSchedule()));
                        writer.newLine();
                    }
                }
                writer.write("--------------------------------------------------------------------------------------------------------------");
            }
            // Abrir el archivo en el escritorio//
            File file = new File(nombreArchivo);
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}