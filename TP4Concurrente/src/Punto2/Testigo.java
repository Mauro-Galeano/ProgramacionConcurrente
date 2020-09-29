/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author carme
 */
public class Testigo {
    private Semaphore s1,s2,s3;
    
    public Testigo(){
        this.s1= new Semaphore(1);
//        this.s2= new Semaphore(0);
//        this.s3= new Semaphore(0);
    }
    
    public void correrAtleta() throws InterruptedException{
        s1.acquire();
        System.out.println("El corredor "+Thread.currentThread().getName()+" empieza a correr");
        int x=(int)(Math.random()*3+1)+8;
        Thread.sleep(x*100);
        System.out.println(Thread.currentThread().getName()+" corrio "+x+" segundos");
        s1.release();
    }
//    public void correrAtleta1(){
//        System.out.println("El corredor "+Thread.currentThread().getName()+" empieza a correr");
//        int x=(int)(Math.random()*3+1)+8;
//        try{
//            Thread.sleep(x*100);
//        }catch(InterruptedException e){}
//        System.out.println(Thread.currentThread().getName()+" corrio "+x+" segundos");
//        s1.release();
//    }
//    public void correrAtleta2() throws InterruptedException{
//        s1.acquire();
//        System.out.println("El corredor "+Thread.currentThread().getName()+" empieza a correr");
//        int x=(int)(Math.random()*3+1)+8;
//        Thread.sleep(x*100);
//        System.out.println(Thread.currentThread().getName()+" corrio "+x+" segundos");
//        s2.release();
//    }
//    public void correrAtleta3() throws InterruptedException{
//        s2.acquire();
//        System.out.println("El corredor "+Thread.currentThread().getName()+" empieza a correr");
//        int x=(int)(Math.random()*3+1)+8;
//        Thread.sleep(x*100);
//        System.out.println(Thread.currentThread().getName()+" corrio "+x+" segundos");
//        s3.release();
//    }
//    public void correrAtleta4() throws InterruptedException{
//        s3.acquire();
//        System.out.println("El corredor "+Thread.currentThread().getName()+" empieza a correr");
//        int x=(int)(Math.random()*3+1)+8;
//        Thread.sleep(x*100);
//        System.out.println(Thread.currentThread().getName()+" corrio "+x+" segundos");
//    }
}


