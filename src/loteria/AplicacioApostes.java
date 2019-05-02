/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Aquesta classe serà la que realitzi la interacció amb l’usuari. Mostrarà els menús, 
els missatges informatius a l’usuari i li demanarà dades per teclat.

— Atributs: Només contindrà un atribut, que serà un objecte de la classe GestioArraiApostes.

— Constructor: Rebrà com a paràmetre un ArrayList amb les apostes, 
i crearà un objecte de la classe GestioArrayApostes, passant-li com a paràmetre l’ArrayList.                    <-----
Aquest objecte de la classe GestioArrayApostes serà guardat a l’atribut.

-------------------------------------------------------------------------------------------------------------------------------------------------

— iniciar(): Aquest mètode iniciarà l’aplicació: cridarà al mètode menu i, en funció de l’opció
escollida, anirà a cadascuna de les opcions. Si l’usuari introdueix una opció incorrecta,
mostrarà el missatge adequat. No sortirem del mètode iniciar mentre l’usuari no esculli
l’opcio de “Sortir”, la qual cosa significarà la sortida de l’aplicació.

— menu(): Aquest mètode mostrarà a l’usuari les opcions de menú, demanarà a l’usuari quina
opció vol i la retornarà. Si l’usuari escull una opció incorrecta o introdueix un valor
incorrecte, retornarà -1.

— opcioMostrarApostes(): Es mostrarà un llistat amb tots els apostants i la quantitat
apostada (un apostant per línia). Es cridarà al mètode getApostes de la classe GestioArraiApostes
per recuperar l’ArrayList d’apostes. Si no hi ha cap aposta a l’arrai d’apostes, haurem d’informar a l’usuari.

— opcioMostrarAposta(): Es demanarà a l’usuari el nom d’un apostant, 
es recuperarà la seva aposta (amb el mètode recuperarAposta de la classe GestioArraiApostes) 
i es mostrarà la quantitat apostada per l’apostant.

— opcioAfegirAposta(): Demanarà a l’usuari el nom d’un apostant i la quantitat apostada,
crearà un objecte de la classe Aposta i afegirà l’aposta en l’arrai d’apostes cridant al mètode afegirAposta de la classe GestioArraiApostes. 
Finalment, es mostrarà a l’usuari un missatge confirmat que l’aposta ha estat afegida.

— opcioEliminarAposta(): Demanarà a l’usuari el nom d’un apostant i cridarà al mètode eliminarAposta de la classe GestioArraiApostes. 
Finalment, es mostrarà a l’usuari un missatge confirmat que l’aposta ha estat eliminada.

— opcioModificarAposta(): Demanarà a l’usuari el nom d’un apostant i recuperarà l’aposta realitzada
per ell cridant al mètode recuperarAposta de la classe GestioArraiApostes. 
A continuació, mostrarà a l’usuari la quantitat actual apostada, i demanarà a l’usuari la nova quantitat de l’aposta. 
Si la quantitat apostada és diferent de 0 (si és 0 se suposarà que no la vol modificar), 
es modificarà la quantitat a l’objecte de la classe Aposta i es mostrarà a l’usuari un missatge de confirmació de la modificació de l’aposta.

— calcularTotalApostes(): Recuperarà l’arrai d’apostes (cridant al mètode getApostes de la classe GestioArraiApostes), 
calcularà la quantitat total, en euros, corresponent a totes les apostes, i la mostrarà per pantalla.
*/
package loteria;

import java.util.ArrayList;

/**
 *
 * @author paugonzalezmarti
 */
public class AplicacioApostes {
    
    GestioArrayApostes gestio;

    public AplicacioApostes(ArrayList<Aposta> apostes){
        gestio = new GestioArrayApostes(apostes);
    }
     
    public void iniciar() { 
        int eleccio;
        boolean elector=false;

        while(elector==false){
            
            eleccio = menu();
            
            if (eleccio==-1) {
                System.out.println("El valor que has introduit no es el correcte, prova-ho de nou.");
            } else {
                
                switch(eleccio){
                    case 1:
                        opcioMostrarApostes();
                        break;
                    case 2:
                        opcioMostrarAposta();
                        break;
                    case 3:
                        opcioAfegirAposta();
                        break;
                    case 4:
                        opcioEliminarAposta();
                        break;
                    case 5:
                        opcioModificarAposta();
                        break;
                    case 6:
                        calcularTotalApostes();
                        break;
                    case 0:
                        elector=true;
                        System.out.println("Bye Bye ;P");
                        break;
                }
            }
        }   
    }
    
    public int menu() {
        int opcio=0;
            System.out.println( "MENÚ PRINCIPAL\n" +
                                "1 - Mostrar totes les apostes\n" +
                                "2 - Mostrar una aposta\n" +
                                "3 - Afegir una aposta\n" +
                                "4 - Eliminar una aposta\n" +
                                "5 - Modificar una aposta\n" +
                                "6 - Calcular total apostes\n" +
                                "0 - Sortir\n\n" +
                                "Opció:\n");
            opcio = Teclat.leerInt("");
            
            if(opcio>6 || opcio<0) {
                opcio=-1;
            }
        return opcio;
    }

    private void opcioMostrarApostes() {
        for(Aposta item : gestio.getApuestas()){
            System.out.println("El apostant " + item.getNom() + " ha apostat " + item.getAposta() + "€");
        }
    }

    private void opcioMostrarAposta() {
        try{
            String nom = Teclat.leerString("Introdueix el nom del apostant a modificar: ");
            Aposta aposta = gestio.recuperarAposta(nom);
            System.out.println("Aquesta aposta és de " + aposta.getAposta() + "€");    
        }
        catch(ExcepcioApostaInexistent e){
            System.out.println(e.toString());
        }
    }

    private void opcioAfegirAposta() {
        try{
            String nom = Teclat.leerString("Introdueix el nom del apostant: ");
            int valor = Teclat.leerInt("Introdueix la aposta a fer: ");

            Aposta aposta = new Aposta(nom, valor);
            
            gestio.afegirAposta(aposta);
            System.out.println("S'ha creat la aposta amb exit!");
            
        }catch(ExcepcioApostaExistent e){
            System.out.println(e.toString());}    }

    private void opcioEliminarAposta() {
        try {
            String nom = Teclat.leerString("Introdueix el nom del apostant a eliminar: ");
            Aposta aposta = gestio.recuperarAposta(nom);
                gestio.eliminarAposta(nom);
                System.out.println("S'ha eliminat la aposta amb exit!");
        }
        catch(ExcepcioApostaInexistent e){
            System.out.println(e.toString());}    }

    private void opcioModificarAposta() {
        try{
            String nom = Teclat.leerString("Introdueix el nom del apostant a modificar: ");
            Aposta aposta = gestio.recuperarAposta(nom);
            System.out.println("Aquesta aposta és de " + aposta.getAposta() + "€");
            int nova = Teclat.leerInt("Introdueix la nova xifra(0 per cancelar): ");
            if (nova != 0) {
                aposta.setAposta(nova);
                gestio.eliminarAposta(nom);
                gestio.afegirAposta(aposta);
                System.out.println("S'ha modificat la aposta amb exit!");
            }
        }catch(ExcepcioApostaInexistent e){
            System.out.println(e.toString());}
        catch(ExcepcioApostaExistent e){
            System.out.println(e.toString());}
    }

    private void calcularTotalApostes() {
        int total = 0;
        for(Aposta item :gestio.getApuestas()){
            total = total + item.getAposta();
        }
        System.out.println(total + "€");
    }

    
}
