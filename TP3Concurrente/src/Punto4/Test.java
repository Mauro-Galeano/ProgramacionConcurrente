/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto4;

/**
 *
 * @author carme
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Surtidor surti= new Surtidor();
        Auto a1= new Auto("123asd", "asd", "dsa",surti);
        Auto a2= new Auto("asd123", "fgh", "hgf",surti);
        Auto a3= new Auto("456fgh", "654", "456",surti);
        Auto a4= new Auto("", "", "",surti);
        Auto a5= new Auto("", "", "",surti);
        Auto a6= new Auto("", "", "",surti);
        
        Thread auto1= new Thread(a1);
        Thread auto2= new Thread(a2);
        Thread auto3= new Thread(a3);
        Thread auto4= new Thread(a4);
        Thread auto5= new Thread(a5);
        Thread auto6= new Thread(a6);
        
        auto1.start();
        auto2.start();
        auto3.start();
        auto4.start();
        auto5.start();
        auto6.start();
    }
        
    
    
}
