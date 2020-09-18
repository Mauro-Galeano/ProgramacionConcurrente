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
