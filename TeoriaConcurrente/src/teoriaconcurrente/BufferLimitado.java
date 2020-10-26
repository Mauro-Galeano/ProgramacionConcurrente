/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoriaconcurrente;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class BufferLimitado {
    private Semaphore semAcceso,semCapacidad;
    private int capacidad,cont;
    public BufferLimitado(int n){
        semAcceso= new Semaphore(1);
        semCapacidad=new Semaphore(0);
        capacidad=n;//capacidad maxima
        cont=0;//capacidad actual
    }
    public void sacar()throws InterruptedException{
        semAcceso.acquire();
        System.out.println("La cantidad de elementos del buffer es: "+cont);//semCapacidad.availablePermits());
        System.out.println("Soy "+Thread.currentThread().getName()+" estoy consumiendo un elemento");
        Thread.sleep(1000);
        semCapacidad.acquire();
        cont--;
        System.out.println("La cantidad de elementos del buffer despues de consumir es: "+cont);//semCapacidad.availablePermits());

        semAcceso.release();
    }
    public void agregar()throws InterruptedException{
        semAcceso.acquire();
        if(cont<capacidad){
            System.out.println("La cantidad de elementos del buffer es: "+cont);//semCapacidad.availablePermits());
            System.out.println("Soy "+Thread.currentThread().getName()+" estoy agregando un elemento");
            Thread.sleep(1000);
            semCapacidad.release();
            cont++;
            System.out.println("La cantidad de elementos del buffer despues de agregar es: "+cont);//semCapacidad.availablePermits());
        }else{
            System.out.println("El buffer ya esta lleno");
        }
        semAcceso.release();
    }
}
