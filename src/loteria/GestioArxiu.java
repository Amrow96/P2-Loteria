/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.

Contindrà els mètodes que permeten accedir a l’arxiu. 
Només es podrà accedir a l’arxiu a través dels mètodes d’aquesta classe. 
L’arxiu a llegir/gravar haurà de contenir en la seva primera línia el número de registres que conté l’arxiu,
i en les següents línies, cadascun dels camps (nom de l’apostant i quantitat apostada) dels registres, un camp per línia. 
La classe GestioArxiu no tindrà atributs ni constructor i només contindrà dos mètodes estàtics:
— llegirArxiu: No rebrà paràmetres i retornarà un objecte de la classe ArrayList amb les
apostes llegides des de l’arxiu. Si l’arxiu existeix, llegirà les dades de l’arxiu en un ArrayList d’apostes i el retornarà;
si l’arxiu no existeix, es mostrarà un missatge informatiu a l’usuari i es retornarà el mateix objecte de la classe ArrayList,
però sense cap element.
— guardarArxiu: Rebrà com a paràmetre un ArrayList amb les dades de les apostes i no retornarà res. 
El mètode guardarà les dades de l’ArrayList en l’arxiu. Si no es pot gravar, es mostrarà a l’usuari un missatge informatiu.
 */
package loteria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author pautrompeta
 */
public class GestioArxiu {
   // public final String RUTA = "apostes.txt";
    
    public static void guardarArxiu(ArrayList<Aposta> array) {
        String ruta = "apostes.txt";
        File f;
        f = new File(ruta);
        //Si el fichero existe y anyadir es false, elimina el fichero para
        //que no haya datos antiguos
        if (f.exists()) {
            f.delete();
        }
        //Escribir con buffer para hacerlo línea a línea
        FileWriter flujoSalida = null;
        BufferedWriter salida = null;
        try {
            flujoSalida = new FileWriter(f);
            salida = new BufferedWriter(flujoSalida);
            /*Escribo nom en el fichero, hago un salto de línea y escribo aposta,
             es necesario pasar la aposta a String*/
          
            Iterator<Aposta> nombreIterator = array.iterator();
            while(nombreIterator.hasNext()){
                Aposta elemento = nombreIterator.next();
                String nom = elemento.getNom();
                salida.write(nom);
                salida.newLine();
                int aposta = elemento.getAposta();
                salida.write(Integer.toString(aposta));
                salida.newLine();
            }
           

        } catch (IOException ex) {
            System.err.println("Error de escritura");
            //ex.printStackTrace();
        } finally {
            try {
                salida.close();
                flujoSalida.close();
            } catch (IOException ex) {
                System.out.println("Problemas cerrando el fichero en la escritura");
                //ex.printStackTrace();
            }
        }
    }

    public static ArrayList<Aposta> llegirArxiu(String nombreFichero) {

        Aposta a;
        String nom, apostaStr;
        int aposta;
        ArrayList<Aposta> Apos = new ArrayList<Aposta>();

        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(new FileReader(nombreFichero));

            //Mientras haya líneas
            while ((nom = entrada.readLine()) != null) {

                apostaStr = entrada.readLine();
                aposta = Integer.parseInt(apostaStr);

                //Pasar campos al objeto a
                a = new Aposta(nom, aposta);
                Apos.add(a);
                //Imprmir a
                //System.out.println(a);
            }

            System.out.println("Imprimiendo ArrayList");
            ListIterator it = Apos.listIterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }

        } catch (FileNotFoundException ex) {
            System.err.println("No existe el fichero");
            //ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Error de Lectura");
            //ex.printStackTrace();
        } finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException ex) {
                System.out.println("Problemas cerrando el fichero");
            }
        }
        return Apos;
    }
}
