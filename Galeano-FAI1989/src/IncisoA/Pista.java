/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IncisoA;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class Pista {

    private String nombre;
    private Semaphore semDespegar, semPista,sem;
    private Lista aux=new Lista();
    private int i=1;
    public Pista(String n) {
        nombre = n;
        semDespegar = new Semaphore(0);//
        semPista = new Semaphore(1);//es para controlar que solo un avion este en la pista.
        sem=new Semaphore(1);//mutex para comunicacion con la central.
    }
    public void comunicarmeConLaTorre(int n)throws InterruptedException{
        System.out.println("Me comunique con la central para pedir autorizacion, soy: "+Thread.currentThread().getName());
        sem.acquire();//creo que esto podria hacerlo con un lock.
        aux.insertar(n, i);//n es el numero que se genera random en avion, de esta manera luego podre buscar si hay alguno que quiera aterrizar, que es el 1.
        i++;
        sem.release();
    }
    public void aterrizar() throws InterruptedException {
        System.out.println("Estoy volando quiero aterrizar, soy " + Thread.currentThread().getName());
        semPista.acquire();
        System.out.println("Soy " + Thread.currentThread().getName() + " estoy aterrizando");
        //Thread.sleep((int) Math.random() * 1000);
        System.out.println("Soy " + Thread.currentThread().getName() + " ATERRICE");
        
        aux.eliminar(aux.localizar(1));//elimino el 1 que corresponde al avion que aterrizo.
        if(aux.localizar(1)==(-1)){//Si encuentro un -1 en la lista es xq no hay nadie mas que quiera aterrizar, por lo tanto ya pueden despegar los qiue estan en tierra
            semDespegar.release();
        }
        semPista.release();
    }

    public void despegar() throws InterruptedException {
        System.out.println("Estoy es tierra quiero despegar, soy " + Thread.currentThread().getName());
        if(aux.localizar(1)!=(-1)){//Me fijo si hay alguno que quiere despegar, en caso de que el localizar me devuelva un 1 entonces alguien quere aterrizar
            System.out.println("Soy "+Thread.currentThread().getName()+" no puedo despegar, hay alguien que quiere aterrizar, debo esperar");
            semDespegar.acquire();//tomo el semaforo para que se trabe en caso de que alguien quiera aterrizar
            semPista.acquire();
            System.out.println("Soy " + Thread.currentThread().getName() + " estoy despegando");
            Thread.sleep((int) Math.random() * 1000);
            System.out.println("Soy " + Thread.currentThread().getName() + " DESPEGUE");
            semPista.release();
        }else{//este caso es para cuando nadie quiere aterrizar.
            semPista.acquire();
            System.out.println("Soy " + Thread.currentThread().getName() + " estoy despegando");
            Thread.sleep((int) Math.random() * 1000);
            System.out.println("Soy " + Thread.currentThread().getName() + " DESPEGUE");
            semPista.release();
        }
    }
}
