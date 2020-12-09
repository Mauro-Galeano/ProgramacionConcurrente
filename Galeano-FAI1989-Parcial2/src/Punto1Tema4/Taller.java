/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1Tema4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author carme
 */
public class Taller {
    private Lock accesoCesto1,accesoCesto2,lockEnsamblador;
    private int numMaxMangas,numMaxCuerpos,mangasActual,cuerposActual;
    private Condition colaMangas,colaCuerpos,colaEnsamblador;
    public Taller(int nM, int nMC){
        numMaxCuerpos=nMC;
        numMaxMangas=nM;
        mangasActual=0;
        cuerposActual=0;
        //lockEnsamblador=new ReentrantLock();//para dormir al ensamblador cuando no puede armar sueters 
        accesoCesto1=new ReentrantLock();//para las mangas
        accesoCesto2=new ReentrantLock();//para los cuerpos
        //colaEnsamblador=lockEnsamblador.newCondition();
        colaMangas=accesoCesto1.newCondition();//cola para que la costurera y el emsamblador se duerman esperando
        colaCuerpos=accesoCesto2.newCondition();
    }
    //lock general de mangas y cuerpos, y en armar cuerpos uso cada uno en el caso que sea necesario
    public void dejarManga()throws InterruptedException{
        accesoCesto1.lock();
        while(numMaxMangas<mangasActual){
            System.out.println(Thread.currentThread().getName()+": no puedo dejar la manga, el cesto esta lleno");
            colaMangas.await();
        }
        System.out.println(Thread.currentThread().getName()+": dejo una manga en el cesto");
        mangasActual++;
//        lockEnsamblador.lock();
//        colaEnsamblador.signalAll();//despierto al ensamblador para que verifique si puede armar un sueter
//        lockEnsamblador.unlock();
        colaMangas.signalAll();//aviso al ensamblador que hay una manga mas/ PODRIA HACER UN IF, QUE CUANDO HAYA 2 MANGAS AVISE??
        accesoCesto1.unlock();
    }
    
    public void dejarCuerpo()throws InterruptedException{
        accesoCesto2.lock();
        while(numMaxCuerpos<cuerposActual){
            System.out.println(Thread.currentThread().getName()+": no puedo dejar el cuerpo, el cesto esta lleno");
            colaCuerpos.await();
        }
        System.out.println(Thread.currentThread().getName()+": dejo un cuerpo en el cesto");
        cuerposActual++;
        colaCuerpos.signalAll();//despierto al ensamblador para que verifique si puede armar un sueter
        accesoCesto2.unlock();
    }
    public void armarSueter()throws InterruptedException{
        accesoCesto1.lock();
        while(mangasActual<2){
            colaMangas.await();//duermo al ensamblador en la cola del cesto 1 que es de las mangas, hasta que agreguen una y me avisen
        }
        mangasActual=mangasActual-2;
        System.out.println("Cantidad de mangas: "+mangasActual);
        colaMangas.signalAll();//despierto a todos para que las costureras puedan seguir cociendo mangas
        accesoCesto1.unlock();
        accesoCesto2.lock();
        while(cuerposActual<1){
            colaCuerpos.await();//duermo al ensamblador en la cola del cesto 2 que es de los cuerpos, hasta que agreguen uno
        }
        cuerposActual--;
        System.out.println("Cantidad de cuerpos: "+cuerposActual);
        colaCuerpos.signalAll();//despierto a todos para que los que hacen cuerpos puedan seguir haciendo cuerpos
        accesoCesto2.unlock();
        System.out.println(Thread.currentThread().getName()+": armo un sueter");
        
    }
//    public void armarSueter() throws InterruptedException{
//        lockEnsamblador.lock();
//        while(cuerposActual<1 || mangasActual<2){//si tengo menos de un cuerpo o menos de dos mangas, me duermo, solo voy a salir del while cuando ambos sean falsos
//            //tengo que dormir al ensamblador
//            colaEnsamblador.await();//despierto al ensamblador para que verifique si puede armar un sueter
//        }
//        System.out.println(Thread.currentThread().getName()+": armo un sueter");
//        accesoCesto2.lock();//tomo el lock xq es una seccion critica
//        cuerposActual--;
//        colaCuerpos.signalAll();//despierto al armador para que siga haciendo cuerpos
//        accesoCesto2.unlock();
//        accesoCesto1.lock();//aca hago lo mismo que arriba x lo mismo
//        mangasActual=mangasActual-2;
//        colaMangas.signalAll();//despierto a la costurera para que siga haciendo mangas
//        accesoCesto1.unlock();
//        lockEnsamblador.unlock();
//    }
}
