/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Edwin CR
 */
public class logica {

    private String ruta_txt = "env.txt";

    public void Crear() {
        File file = new File(ruta_txt);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al Crear El Archivo env");
        }
    }

    public String Recorrer() {
        String linea = null;
        File file = new File(ruta_txt);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            if ((linea = br.readLine()) != null) {

            } else {
                JOptionPane.showMessageDialog(null, "No hay datos en el archivo env");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linea;
    }

    public void Guardar(pool_bd pool) {
        FileWriter fw;
        PrintWriter pw;
        File file = new File(ruta_txt);
        try {
            
            if (file.exists()) {
                JOptionPane.showMessageDialog(null, "YA EXISTE UNA CONFIGURACION\n"
                        + "Si desea elimine la configuracion para poder escribir una nueva.");
            } else {
                this.Crear();
                fw = new FileWriter(ruta_txt);
                pw = new PrintWriter(fw);
                pw.println(pool.getDato());
                pw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR AL GRABAR EL ARCHIVO:");
        }
    }

    public void Eliminar() {
        File file = new File(ruta_txt);
        file.delete();
    }

}
