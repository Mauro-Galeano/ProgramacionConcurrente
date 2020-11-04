/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IncisoB;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author carme
 */
public class Pista {

    private String nombre;
    private boolean prioridad=false;
    private Semaphore semDespegar, semPista, semComunicacion, semAterrizajes,semAterrizar;
    private Lista aux = new Lista();
    private int i = 1;

    public Pista(String n) {
        nombre = n;
        semDespegar = new Semaphore(0);//semaforo para trabar al que quiere despegar en caso de ser necesario
        semPista = new Semaphore(1);//es para controlar que solo un avion este en la pista.
        semComunicacion = new Semaphore(1);//mutex para comunicacion con la central.
        semAterrizajes = new Semaphore(2);//semaforo con la cantidad de aterrizajes.
        semAterrizar= new Semaphore(1);//semaforo para trabar al que quiere aterrizar en caso de ser necesario.
    }

    private void comunicarmeConLaTorre(int n) throws InterruptedException {
        System.out.println("Me comunique con la central para pedir autorizacion, soy: " + Thread.currentThread().getName());
        semComunicacion.acquire();//creo que esto podria hacerlo con un lock.
        aux.insertar(n, i);//n es el numero que se genera random en avion, de esta manera luego podre buscar si hay alguno que quiera aterrizar, que es el 1.
        i++;
        semComunicacion.release();
    }

    public void aterrizar(int n) throws InterruptedException {
        System.out.println("Estoy volando quiero aterrizar, soy " + Thread.currentThread().getName());
        comunicarmeConLaTorre(n);
        if (semAterrizajes.tryAcquire()){
            semPista.acquire();
            System.out.println("Soy " + Thread.currentThread().getName() + " estoy aterrizando");
            Thread.sleep((int) Math.random() * 1000);//simula que aterriza
            System.out.println("Soy " + Thread.currentThread().getName() + " ATERRICE");
            aux.eliminar(aux.localizar(1));//elimino el 1 que corresponde al avion que aterrizo.
            if (aux.localizar(1) == (-1)) {//Si encuentro un -1 en la lista es xq no hay nadie mas que quiera aterrizar, por lo tanto ya pueden despegar los qiue estan en tierra
                semDespegar.release();
            }
            semPista.release();
        }else{
            System.out.println("La prioridad la tiene los que quieren despegar, soy "+Thread.currentThread().getName()+" debo esperar");
            semDespegar.release();
            prioridad=true;
            semAterrizar.acquire();//trabo al avion que quiere aterrizar xq la prioridad pasa a ser del q quiere despegar.
            //Creo que no funciona xq una vez que logra tomar el permiso de aterrizar, no tiene nada para hacer, tal vez se soluciona con
            //while(true) en el run de aviones.
            //Tiene un problema, y es q cuando tienen prioridad los que depegan, debe despegar uno solo y volver a la normalidad
            //pero despegan todos y despues aterrizan
        }
        
    }

    public void despegar(int n) throws InterruptedException {
        System.out.println("Estoy en tierra quiero despegar, soy " + Thread.currentThread().getName());
        comunicarmeConLaTorre(n);
        if (aux.localizar(1) != (-1)) {//Me fijo si hay alguno que quiere despegar, en caso de que el localizar me devuelva algo distinto de -1 entonces alguien quere aterrizar
            System.out.println("Soy " + Thread.currentThread().getName() + " no puedo despegar, hay alguien que quiere aterrizar, debo esperar");
            semDespegar.acquire();//tomo el semaforo para que se trabe en caso de que alguien quiera aterrizar
            semPista.acquire();
            System.out.println("Soy " + Thread.currentThread().getName() + " estoy despegando");
            Thread.sleep((int) Math.random() * 1000);//simula el despegue
            System.out.println("Soy " + Thread.currentThread().getName() + " DESPEGUE");
            if(prioridad){
                semAterrizajes.release(2);
                semAterrizar.release();
            }else{
                semDespegar.release();
            }
            semPista.release();
        } else {//este caso es para cuando nadie quiere aterrizar.
            semPista.acquire();
            System.out.println("Soy " + Thread.currentThread().getName() + " estoy despegando");
            Thread.sleep((int) Math.random() * 1000);//simula el despegue
            System.out.println("Soy " + Thread.currentThread().getName() + " DESPEGUE");
            semPista.release();
        }
    }
}
