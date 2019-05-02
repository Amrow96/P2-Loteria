/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Contindrà les dades d’una aposta: bàsicament, el nom de l’apostant i la quantitat apostada.
— Atributs: nom de l’apostant i diners apostats (en euros). Només es podran apostar quantitats
que siguin múltiples de 20.
— Constructor: parametritzat, amb tots els atributs.
— Getters: tots
— Setters: Només el corresponent a l’atribut que conté els diners apostats.
— Mètode equals: Només compararà el nom de l’apostant.
— Mètode toString: Retornarà un string que contindrà el nom de l’apostant i la quantitat
apostada.
 */
package loteria;

import java.util.Objects;

/**
 *
 * @author paugonzalezmarti
 */
public class Aposta {
     
     String nom;
     int aposta;

    public Aposta(String nom, int aposta) {
        
        if (multiple(aposta)==true) {
            this.nom = nom;
            this.aposta = aposta;
        }
    }

    public String getNom() {
        return nom;
    }

    public int getAposta() {
        return aposta;
    }

    public void setAposta(int aposta) {
       
        if (multiple(aposta)==true) {
            
            this.aposta = aposta;
            
        }
    }

    @Override
    public boolean equals(Object obj) {
        Aposta other = (Aposta) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Apostant:" + nom + "\n Quantitat: " + aposta + "€";
    }
     
    public static boolean multiple(int numero1) {
        boolean multiple=false;
        int numero2 = 20;
        int resto = numero1%numero2;
 
        if (resto==0) {
            multiple = true;
        } else {
            System.out.println("La aposta no es multiple de 20, torna-hi de nou");
        }
    
        return multiple;
    }
}
