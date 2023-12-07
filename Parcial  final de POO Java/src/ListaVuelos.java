import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
// Clase ListaVuelos que representa una lista de vuelos//
public class ListaVuelos{
    private List<Vuelo> vueloList;

    public ListaVuelos(List<Vuelo> vueloList) {
        this.vueloList = vueloList;
    }

    public ListaVuelos() {
        vueloList = new ArrayList<>();
    }

    public List<Vuelo> getVueloList() {
        return vueloList;
    }

    // Método para cargar la lista de vuelos desde un archivo de texto (vuelos.txt)
    public void listV(){
        String linea;
        String seccion = null;
        Vuelo vuelo;
        try (BufferedReader br = new BufferedReader(new FileReader("vuelos.txt"))) {
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) {
                    continue;
                }
                if (linea.startsWith("#")) {
                    seccion = linea;
                    continue;
                }
                if ("#Vuelos".equals(seccion)) {
                    // Parsear la línea y crear un objeto Vuelo//
                    String[] tokens = linea.split(";");
                    if (tokens.length >= 9) {
                        String x = tokens[0];
                        String departureAirport = tokens[1];
                        String arrivalAirport = tokens[2];
                        String duration = tokens[3];
                        String company = tokens[4];
                        String typePlane = tokens[5];
                        String seats = tokens[6];
                        String optional;
                        String schedule;
                        if(x.equals("R")){
                            optional = tokens[8];
                            schedule = tokens[7];
                        }else{
                            optional = tokens[7];
                            schedule = tokens[8];
                        }

                        vuelo = new Vuelo(x, departureAirport, arrivalAirport, duration, company, typePlane, Integer.parseInt(seats), optional, schedule);
                        // Agregar el vuelo a la lista//

                        vueloList.add(vuelo);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
