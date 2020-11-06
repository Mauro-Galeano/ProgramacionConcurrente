/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

/**
 *
 * @author carme
 */
public class TP5Concurrente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x=(int)(Math.random()*2)+1;
        Comedor c=new Comedor(5,x,2,3);//el 1er numero es la cantidad de comederos, el 2do es la cantidad de perros y el 3ro la cantidad de gatos
        Perro p1= new Perro(c);
        Perro p2= new Perro(c);
        Thread h1= new Thread(p1,"Perro 1");
        Thread h2= new Thread(p2,"Perro 2");
        Gato g1= new Gato(c);
        Gato g2= new Gato(c);
        Gato g3= new Gato(c);
        Thread h3= new Thread(g1,"Gato 1");
        Thread h4= new Thread(g2,"Gato 2");
        Thread h5= new Thread(g3,"Gato 3");
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }
    
}
