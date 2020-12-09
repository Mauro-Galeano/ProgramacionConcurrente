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
    private Lock lockEscrituraP,lockLectura;//,lockEscrituraS;
    private Condition lectura;
    public BufferPrimario(int c) {
        capacidadMaxima = c;//capacidad maxima del buffer primario
        capacidadActual = 0;
        peticionesPrimaria = new char[c];
        lockEscrituraP=new ReentrantLock();//lock para asegurar exclusion mutua a la hora de escribir en el buffer primario
        //lockEscrituraS=new ReentrantLock();//lock para asegurar exclusion mutua a la hora de escribir en el buffer secundario
        lockLectura=new ReentrantLock();
        lectura= lockLectura.newCondition();
    }
    //lock solo para cada buffer. tanto para escribir como para leer, y uno general para la cola
    public void escribir(char aEscribir) {
        boolean bandera=false;
        lockEscrituraP.lock();
        if (capacidadMaxima <= capacidadActual) {//puedo usar tryLock()??
            System.out.println("Soy " + Thread.currentThread().getName() + " el buffer primario esta lleno, se guarda " + aEscribir + " en el secundario");
            //liberar escritura primaria. y usar escritura secundaria
            this.escribirEnSecundaria(aEscribir);
        } else {
            cola.poner(aEscribir);
            System.out.println(cola.toString());
            peticionesPrimaria[capacidadActual] = aEscribir;
            capacidadActual++;
            System.out.println("Soy " + Thread.currentThread().getName() + " escribi " + aEscribir + " en el primario");
            bandera=true;
            lockEscrituraP.unlock();
        }
        lockLectura.lock();
        lectura.signal();//aviso al servidor el cual esta dormido que puede imprimir
        lockLectura.unlock();
        if(!bandera){
            lockEscrituraP.unlock();
        }
    }

    private void escribirEnSecundaria(char aEscribir) {
        //lockEscrituraS.lock();
        cola.poner(aEscribir);//guardo en la cola para despues imprimir
        System.out.println("Soy " + Thread.currentThread().getName() + " escribi " + aEscribir + " en el secundario");
        //lockEscrituraS.unlock();
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
        lockLectura.lock();
        while (cola.esVacia()) {//verifico si hay algo en la cola para imprimir
            System.out.println("Soy " + Thread.currentThread().getName() + " no puedo imprimir, no hay nada en los buffers");
            //agergar sleep para simular escritura
            lectura.await();
        }
        char x = (char) cola.obtenerFrente();
        if (this.verificarSiEstaEnPrimario(x)) {//verifico si esta en el buffer primario, para saber si debo disminuir la cantidad actual del buffer limitado
            capacidadActual--;
        }
        System.out.println("Soy " + Thread.currentThread().getName() + " voy a imprimir");
        System.out.println(cola.obtenerFrente());
        cola.sacar();//saco lo que imprimi
        lockLectura.unlock();
    }

}
