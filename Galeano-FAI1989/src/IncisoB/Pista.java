/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IncisoB;

import java.util.concurrent.Semaphore;

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
        semAterrizar= new Semaphore(0);//semaforo para trabar al que quiere aterrizar en caso de ser necesario.
    }

    private void comunicarmeConLaTorre(int n) throws InterruptedException {
        //System.out.println("Me comunique con la central para pedir autorizacion, soy: " + Thread.currentThread().getName());
        semComunicacion.acquire();
        aux.insertar(n, i);//n es el numero que se genera random en avion, de esta manera luego podre buscar si hay alguno que quiera aterrizar, que es el 1.
        i++;
        semComunicacion.release();
    }

    public void aterrizar(int n) throws InterruptedException {
        comunicarmeConLaTorre(n);
        System.out.println("Estoy volando quiero aterrizar, soy " + Thread.currentThread().getName());
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
            semAterrizar.acquire();
            semPista.acquire();
            System.out.println("Soy " + Thread.currentThread().getName() + " estoy aterrizando");
            Thread.sleep((int) Math.random() * 1000);//simula que aterriza
            System.out.println("Soy " + Thread.currentThread().getName() + " ATERRICE");
            aux.eliminar(aux.localizar(1));//elimino el 1 que corresponde al avion que aterrizo.
            if (aux.localizar(1) == (-1)) {//Si encuentro un -1 en la lista es xq no hay nadie mas que quiera aterrizar, por lo tanto ya pueden despegar los qiue estan en tierra
                semDespegar.release();
            }
            semPista.release();
        }
    }

    public void despegar(int n) throws InterruptedException {
        comunicarmeConLaTorre(n);
        System.out.println("Estoy en tierra quiero despegar, soy " + Thread.currentThread().getName());
        if (aux.localizar(1) != (-1)) {//Me fijo si hay alguno que quiere despegar, en caso de que el localizar me devuelva algo distinto de -1 entonces alguien quere aterrizar
            System.out.println("Soy " + Thread.currentThread().getName() + " no puedo despegar, hay alguien que quiere aterrizar, debo esperar");
            semDespegar.acquire();//tomo el semaforo para que se trabe en caso de que alguien quiera aterrizar
            semPista.acquire();
            System.out.println("Soy " + Thread.currentThread().getName() + " estoy despegando");
            Thread.sleep((int) Math.random() * 1000);//simula el despegue
            System.out.println("Soy " + Thread.currentThread().getName() + " DESPEGUE");
            if(prioridad){//si es true significa que despego xq tenia la prioridad, y ahora debo reiniciar los permisos para los aterrizajes
                semAterrizajes.release(2);
                semAterrizar.release();
                prioridad=false;
            }else{
                semDespegar.release();//solo suelto el permiso de despegar en caso de que no haya entrado por prioridad ya que sino voy a soltar permiso de mas
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
