/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loteria;

/**
 *
 * @author paugonzalezmarti
 */
public class ExcepcioApostaExistent extends Exception{

    public ExcepcioApostaExistent() {
        System.out.println("La aposta ja existeix!");
    }

    public ExcepcioApostaExistent(String message) {
        super(message);
    }
    
}
