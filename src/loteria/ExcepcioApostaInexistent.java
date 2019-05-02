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
public class ExcepcioApostaInexistent extends Exception{

    public ExcepcioApostaInexistent() {
        System.out.println("La aposta no existeix");
    }

    public ExcepcioApostaInexistent(String message) {
        super(message);
    }
    
}
