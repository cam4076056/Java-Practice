/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.*;

/**
 *
 * @author Christian Camilo Méndez Pulido
 */
public class EscribeFichero {

    public static void main(String[] ar) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            archivo = new File("C:\\Pruebas\\prueba.txt");
            /**
             * fr: Lee series de caracteres en un archivo con texto
             * br: Lee el texto disponible en la lectura de una serie de caracteres
             */
            fr= new FileReader(archivo);
            br= new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try{
                if (null != fr){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
