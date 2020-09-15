/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto2;

/**
 *
 * @author carme
 */
public class Personaje implements Runnable {

    private Vida vida;

    public Personaje(Vida v) {
        this.vida = v;
    }

//    public synchronized void curar() {
//            System.out.println("curandero cura ");
//            vida.recibirCura();
//            System.out.println("La vida ahora es de: " + vida.getVida());
//    }
//
//    public synchronized void dañar() {
//            System.out.println("orco ataca ");
//            vida.recibirDaño();
//            System.out.println("La vida ahora es de: " + vida.getVida());
//    }

    public void run() {
        if (Thread.currentThread().getName().equals("orco")){
            vida.recibirDaño();
            System.out.println(vida.getVida());
        }else{
            vida.recibirCura();
            System.out.println(vida.getVida());
        }
   
    }

}
