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
public class Personaje implements Runnable{
    private Vida vida;
    
    public Personaje(Vida v){
      this.vida=v;
    }
    
    public synchronized void curar(){
        if(vida.getVida()>0){
            //System.out.println("La vida es de: "+ vida.getVida());
            System.out.println("curandero cura ");
            vida.curar();
            System.out.println("La vida ahora es de: "+vida.getVida());
        }else{
            System.out.println("La vida es menor a 0");
        }
    }
    
    public synchronized void dañar(){
        if(vida.getVida()>0){
            //System.out.println("La vida es de: "+ vida.getVida());
            System.out.println("orco ataca ");
            vida.dañar();
            System.out.println("La vida ahora es de: "+vida.getVida());
        }else{
            System.out.println("La vida es menor a 0");
        }
    }
    
    
    public void run(){
        while(vida.getVida()>0){
            if(Thread.currentThread().getName().equals("orco")){
                this.dañar();
            }else{
                this.curar();
            }
        }
        
    }
    
}
