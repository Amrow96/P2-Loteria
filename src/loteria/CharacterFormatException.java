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
public class CharacterFormatException extends Exception{
    	
    public CharacterFormatException(){}

    public CharacterFormatException(String s){
        super(s);
        //System.out.println(s);
            
    }
}
