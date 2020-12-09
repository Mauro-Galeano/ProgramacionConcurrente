/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1Tema4;

/**
 *
 * @author carme
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Taller taller=new Taller(2, 3);//2 es el maximo de mangas y 3 el de cuerpos
        Costurera costurera=new Costurera(taller);
        ArmadorDeCuerpos armador=new ArmadorDeCuerpos(taller);
        Ensamblador ensamblador=new Ensamblador(taller);
        Thread c=new Thread(costurera, "Costurera");
        Thread a=new Thread(armador, "ArmadorDeCuerpos");
        Thread e=new Thread(ensamblador, "Ensamblador");
        c.start();
        a.start();
        e.start();
    }
    
}
