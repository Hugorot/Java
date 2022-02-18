
/**
 * Codigo practico, GUI y Ficheros.
 * Universidad Catolica Santiago de Guayaquil.
 * @author PC
 */

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUItitanic {

    static String usuario;
    static ArrayList<String> credenciales;

    public static void main(String[] args) throws IOException {


        JPanel panelLogin = new JPanel();
        panelLogin.setLayout(null);
        panelLogin.setBounds(0, 0, 1000, 1000);

        
        
        credenciales = cargarCredenciales();
        
        JLabel labelsurvived = new JLabel("Sobreviviente:");
        JLabel labelPclass = new JLabel("Pclass");
        JLabel labelName = new JLabel("Nombre");
        JLabel labelsex = new JLabel("Sexo");
        JLabel labelage = new JLabel("Edad");
        JLabel labelsiblings = new JLabel("Siblings");
        JLabel labelparents = new JLabel("Parientes");
        JLabel labelfare = new JLabel("Fare");

        JTextField textsurvived = new JTextField();
        JTextField textpclass = new JTextField();
        JTextField textname = new JTextField();
        JTextField textsex = new JTextField();
        JTextField textage = new JTextField();
        JTextField textsiblings = new JTextField();
        JTextField textparents = new JTextField();
        JTextField textfare = new JTextField();

        JButton btnRegistro = new JButton("Registrar");
        btnRegistro.addActionListener(e -> {
            try {
                guardarCredenciales(textsurvived.getText(), textpclass.getText(), textname.getText(), textsex.getText(), textage.getText(), textsiblings.getText(), textparents.getText(), textfare.getText());
            } catch (IOException ex) {
                System.out.println("Error al registrarse");
            }
        });
        

        labelsurvived.setBounds(100, 100, 200, 50);
        labelPclass.setBounds(100, 150, 200, 50);
        labelName.setBounds(100, 200, 200, 50);
        labelsex.setBounds(100, 250, 200, 50);
        labelage.setBounds(100, 300, 200, 50);
        labelsiblings.setBounds(100, 350, 200, 50);
        labelparents.setBounds(100, 400, 200, 50);
        labelfare.setBounds(100, 450, 200, 50);

        panelLogin.add(labelsurvived);
        panelLogin.add(labelPclass);
        panelLogin.add(labelName);
        panelLogin.add(labelsex);
        panelLogin.add(labelage);
        panelLogin.add(labelsiblings);
        panelLogin.add(labelparents);
        panelLogin.add(labelfare);

        textsurvived.setBounds(300, 100, 200, 50);
        textpclass.setBounds(300, 150, 200, 50);
        textname.setBounds(300, 200, 200, 50);
        textsex.setBounds(300, 250, 200, 50);
        textage.setBounds(300, 300, 200, 50);
        textsiblings.setBounds(300, 350, 200, 50);
        textparents.setBounds(300, 400, 200, 50);
        textfare.setBounds(300, 450, 200, 50);

        btnRegistro.setBounds(100, 500, 200, 50);

        panelLogin.add(textsurvived);
        panelLogin.add(textpclass);
        panelLogin.add(textname);
        panelLogin.add(textsex);
        panelLogin.add(textage);
        panelLogin.add(textsiblings);
        panelLogin.add(textparents);
        panelLogin.add(textfare);

        panelLogin.add(btnRegistro);

        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(true);
        ventana.setSize(800, 700);
        ventana.getContentPane().setBackground(new Color(221, 186, 255));
        ventana.setTitle("Nuevo Pasajero");

        ventana.setLayout(null);

        ventana.add(panelLogin);

        ventana.setVisible(true);
        
        

    }

    private static ArrayList<String> cargarCredenciales() throws IOException {
        ArrayList<String> credenciales = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader("src\\titanic.csv"))) {
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                credenciales.add(campos[0] + "," + campos[1] + "," + campos[2] + "," + campos[3] + "," + campos[4] + "," + campos[5] + "," + campos[6] + "," + campos[7]);
            }
        }
        return credenciales;
    }

    private static void guardarCredenciales(String survivor, String pclass, String name, String sex, String age, String siblings, String parents, String fare) throws IOException {
        if (survivor.isBlank()) {
            System.out.println("Codigo de superviviente no puede estar vacio");
            return;
        }
        if (pclass.isBlank()) {
            System.out.println("Clase no puede estar vacio");
            return;
        }
        if (name.isBlank()) {
            System.out.println("Nombre no puede estar vacio");
            return;
        }
        if (sex.isBlank()) {
            System.out.println("Sexo no puede estar vacio");
            return;
        }
        if (age.isBlank()) {
            System.out.println("Edad no puede estar vacio");
            return;
        }
        if (siblings.isBlank()) {
            System.out.println("Hermanos no puede estar vacio");
            return;
        }
        if (parents.isBlank()) {
            System.out.println("Parientes no puede estar vacio");
            return;
        }
        if (fare.isBlank()) {
            System.out.println("Fare no puede estar vacio");
            return;
        }
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter("src\\titanic.csv"))) {
            bw.write("Survived,Pclass,Name,Sex,Age,Siblings/Spouses Aboard,Parents/Children Aboard,Fare\n");
            for (String credencial : credenciales) {
                bw.write(credencial.replace(",", ",") + "\n");
            }
            bw.write(survivor + "," + pclass + "," + name + "," + sex + "," + age + "," + siblings + "," + parents + "," + fare + "\n");
            credenciales.add(survivor + "," + pclass + "," + name + "," + sex + "," + age + "," + siblings + "," + parents + "," + fare);
        }
        System.out.println("Registrado");
    }

}
