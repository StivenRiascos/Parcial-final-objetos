import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaAeropuerto{
    private List<Aeropuerto> aeropuertoList;

    public ListaAeropuerto(List<Aeropuerto> aeropuertoList) {
        this.aeropuertoList = aeropuertoList;
    }

    public ListaAeropuerto() {
        aeropuertoList = new ArrayList<>();
    }

    public List<Aeropuerto> getAeropuertoList() {
        return aeropuertoList;
    }

    // Método para cargar la lista de aeropuertos desde un archivo de texto (vuelos.txt)
    public void listA(){
            String linea;
            String seccion = null;
            Aeropuerto aeropuerto;
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
                    // Parsar la línea y crear un objeto Aeropuerto//

                    if ("#Aeropuertos".equals(seccion)) {
                        String[] tokens = linea.split(";");
                        if (tokens.length >= 5) {
                            String code = tokens[0];
                            String name = tokens[1];
                            String population = tokens[2];
                            String country = tokens[3];
                            String GMT = tokens[4];
                            aeropuerto = new Aeropuerto(code, name, population, country, GMT);
                            aeropuertoList.add(aeropuerto);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    // Método que devuelve el nombre de un aeropuerto dado su código//
    public String getNameByCode(String code){
        String name = "";
        for(Aeropuerto aeropuerto : aeropuertoList){
            if(code.equals(aeropuerto.getCode())){
                name = aeropuerto.getName();
            }
        }
        return name;
    }
}