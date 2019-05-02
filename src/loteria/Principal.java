/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loteria;

import java.util.ArrayList;

/**
 *
 * @author paugonzalezmarti
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Aposta> apuestas = GestioArxiu.llegirArxiu("apostes.txt");
        AplicacioApostes aplicacioApostes = new AplicacioApostes(apuestas);
        aplicacioApostes.iniciar();
        GestioArxiu.guardarArxiu(apuestas);
       // menu();
    }
    
}
