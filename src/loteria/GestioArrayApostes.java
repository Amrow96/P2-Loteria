/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Totes les operacions que es facin sobre l’arrai d’apostes es faran en aquesta classe.
— Atributs: Contindrà només un atribut, que serà l’ArrayList amb les apostes.
— Constructor: Parametritzat. Rebrà com a paràmetre l’arrai d’apostes i el guardarà al
paràmetre corresponent.
— Getters i setters: Només hi haurà un getter per l’atribut que conté les apostes. No hi hauran
setters.

— afegirAposta(Aposta aposta): Rebrà com a paràmetre una aposta i, si no hi ha a l’arrai
cap aposta del mateix apostant (s’utilitzarà el mètode estaEnArrai), l’afegirà a l‘arrai. 
Si l’apostant ja hagués estat introduït, llençarà una excepció del tipus ExcepcioApostaExistent amb un missatge adequat.

— eliminarAposta(String nomApostant): Rebrà com a paràmetre el nom d’un apostant, recuperarà l’aposta d’aquest apostant 
(utilitzant el mètode recuperarAposta) i l’eliminarà de l’arrai d’apostes. Si l’aposta no fos a l’arrai, 
es rellançarà l’objecte del tipus ExcepcioApostaInexistent capturat.

— recuperarAposta(String nomApostant): Cercarà una aposta corresponent a l’apostant rebut com a paràmetre.
Si es troba l’aposta, es retornarà. Si no es troba, es llançarà una excepció del tipus ExcepcioApostaInexistent amb el missatge adient.

— estaEnArrai(Aposta aposta): Cerca en l’arrai d’apostes l’aposta rebuda com a paràmetre. 
Retorna un valor booleà, que serà true si s’ha trobat l’aposta a l’arrai, i false en cas contrari.

 */
package loteria;

import java.util.ArrayList;

/**
 *
 * @author paugonzalezmarti
 */
public class GestioArrayApostes {
    ArrayList<Aposta> apuestas;

    public GestioArrayApostes(ArrayList<Aposta> apuestas) {
        this.apuestas = apuestas;
    }

    public ArrayList<Aposta> getApuestas() {
        return apuestas;
    }
    
    public void afegirAposta(Aposta aposta) throws ExcepcioApostaExistent {
        boolean existeix = false;
        for (Aposta item : apuestas) {
            if (item.getNom().equals(aposta.getNom())) {
                existeix = true;
            }
        }
        if (existeix == true) {
            throw new ExcepcioApostaExistent();
        }else{
            apuestas.add(aposta);
        }
        
    }
    
    public void eliminarAposta(String nomApostant) throws ExcepcioApostaInexistent {
        boolean existeix = false;
        for (Aposta item : apuestas) {
            if (item.getNom().equals(nomApostant)) {
               existeix = true;
                apuestas.remove(item);
            }
        }
        if (existeix == true) {
            throw new ExcepcioApostaInexistent();
        }
    }
    
    public Aposta recuperarAposta(String nomApostant) throws ExcepcioApostaInexistent { 
        boolean existeix = false;
        Aposta escollida = null;
        for (Aposta item : apuestas) {
            if (item.getNom().equals(nomApostant)) {
               existeix = true;
               escollida = item;
            }
        }
        if (existeix == true) {
            throw new ExcepcioApostaInexistent();
        }
        return escollida;
    }
    
    public boolean estaEnArrai(Aposta aposta) {
        boolean resultat;
        for (Aposta item : apuestas) {
            if (item.equals(aposta)) {
               resultat = true;
            }
        }  
        return false;
    }
    
}
