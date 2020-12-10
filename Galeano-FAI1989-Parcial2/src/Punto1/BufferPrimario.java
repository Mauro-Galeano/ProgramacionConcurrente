/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author carme
 */
public class BufferPrimario {

    private int capacidadMaxima, capacidadActual;
    private Cola cola= new Cola();//para darle orden
    private char[] peticionesPrimaria;
    private Lock lockBufferP,lockBufferS,lockCola;
    private Condition espera;
    boolean bandera=false;//se escribio en el primario?
    public BufferPrimario(int c) {
        capacidadMaxima = c;//capacidad maxima del buffer primario
        capacidadActual = 0;
        peticionesPrimaria = new char[c];
        lockBufferP=new ReentrantLock();//lock para asegurar exclusion mutua a la hora de escribir en el buffer primario
        lockBufferS=new ReentrantLock();//lock para asegurar exclusion mutua a la hora de escribir en el buffer secundario
        lockCola=new ReentrantLock();
        espera=lockCola.newCondition();
    }
    //lock solo para cada buffer. tanto para escribir como para leer, y uno general para la cola
    public void escribir(char aEscribir) {
        //boolean bandera=false;//se escribio en el primario?
        lockBufferP.lock();
        if (capacidadMaxima <= capacidadActual) {
            System.out.println("Soy " + Thread.currentThread().getName() + " el buffer primario esta lleno, se guardará " + aEscribir + " en el secundario");
            lockBufferP.unlock();//liberar escritura primaria. y usar escritura secundaria
            this.escribirEnSecundaria(aEscribir);
        } else {
            lockCola.lock();
            cola.poner(aEscribir);
            espera.signalAll();//aviso que se agrego algo al buffer para que el servidor imprima
            lockCola.unlock();
            peticionesPrimaria[capacidadActual] = aEscribir;
            capacidadActual++;
            System.out.println("Soy " + Thread.currentThread().getName() + " escribi " + aEscribir + " en el primario");
            lockBufferP.unlock();//liberar escritura primaria. y usar escritura secundaria
            //bandera=true;
            //lockEscrituraP.unlock();
        }
//        lockLectura.lock();
//        lectura.signal();//aviso al servidor el cual esta dormido que puede imprimir
//        lockLectura.unlock();
//        if(bandera){
//            lockBufferP.unlock();
//        }
    }

    private void escribirEnSecundaria(char aEscribir) {
        lockBufferS.lock();
        lockCola.lock();
        cola.poner(aEscribir);//guardo en la cola para despues imprimir
        espera.signalAll();//aviso que se agrego algo al buffer para que el servidor imprima
        lockCola.unlock();
        System.out.println("Soy " + Thread.currentThread().getName() + " escribi " + aEscribir + " en el secundario");
        lockBufferS.unlock();
    }

    private boolean verificarSiEstaEnPrimario(char a) {//sirve para verificar si el elemento que imprimi esta en el buffer primario
        boolean exito = false;
        int i = 0;
        while (i < capacidadActual && !exito) {//busco hasta encontrar
            if (peticionesPrimaria[i] == a) {
                peticionesPrimaria[i] = ' ';
                exito = true;
            }
            i++;
        }
        return exito;
    }

    public void imprimir() throws InterruptedException {//se dormiria sobre el lock de la cola, si esta vacia se duerme sobre el buffer de la cola.
        lockCola.lock();
        while (cola.esVacia()) {//verifico si hay algo en la cola para imprimir
            System.out.println("Soy " + Thread.currentThread().getName() + " no puedo imprimir, no hay nada en los buffers");
            espera.await();//duermo al servidor hasta que agreguen algo para imprimir
        }
        char x = (char) cola.obtenerFrente();
        lockBufferP.lock();
        if (this.verificarSiEstaEnPrimario(x)) {//verifico si esta en el buffer primario, para saber si debo disminuir la cantidad actual del buffer limitado
            capacidadActual--;
        }
        lockBufferP.unlock();
        System.out.println("Soy " + Thread.currentThread().getName() + " voy a imprimir "+cola.obtenerFrente());
        //System.out.println(cola.obtenerFrente());
        cola.sacar();//saco lo que imprimi
        lockCola.unlock();
    }
}
