/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto3;

/**
 *
 * @author carme
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Buffer buffer=new Buffer(1, 1);
        UsuarioA impA1=new UsuarioA(buffer);
        UsuarioA impA2=new UsuarioA(buffer);
        UsuarioB impB1=new UsuarioB(buffer);
        UsuarioB impB2=new UsuarioB(buffer);
        Thread a1= new Thread(impA1, "Impresora A1");
        Thread a2= new Thread(impA2, "Impresora A2");
        Thread b1= new Thread(impB1, "Impresora B1");
        Thread b2= new Thread(impB2, "Impresora B2");
        a1.start();
        a2.start();
        b1.start();
        b2.start();
    }
    
}
