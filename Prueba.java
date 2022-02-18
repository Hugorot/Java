

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Codigo practico, GUI y Ficheros.
 * Universidad Catolica Santiago de Guayaquil.
 * @author PC
 */
public class Prueba {

    public Prueba(String survivor, String pclass, String Name, String Sex, String Age, String SiblingsSpousesAboard, String ParentsChildrenAboard, String Fare) {
    }

   

  


    public static Prueba[] cargarPersonas() {
        
        
        ArrayList<Prueba> personas = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\hugol\\Documents\\NetBeansProjects\\Examen2Parcial\\titanic.csv"))) {
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String survivor = campos[0];
                String pclass = campos[1];
                String Name= campos[2];
                String Sex=campos[3];
                String Age= campos[4];
                String SiblingsSpousesAboard=campos[5];
                String ParentsChildrenAboard=campos[6];
                String Fare=campos[7];
                Prueba persona = new Prueba(survivor,pclass,Name,Sex,Age,SiblingsSpousesAboard,ParentsChildrenAboard,Fare);
                personas.add(persona);

            }
            System.out.println("persona cargadas");
        } catch (IOException ex) {
            System.out.println("error al guaradar");
        }
        Prueba[] arrPersonas = new Prueba[personas.size()];
        for (int i = 0; i < arrPersonas.length; i++) {
            arrPersonas[i] = personas.get(i);
        }

        return arrPersonas;

    }

    public static void main(String[] args) {
        Prueba[] personas = cargarPersonas();
        for (Prueba persona : personas) {
            System.out.println(personas);

        }

    }
}
