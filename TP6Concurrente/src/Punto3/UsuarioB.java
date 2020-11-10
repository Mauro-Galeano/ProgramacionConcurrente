/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto3;

/**
 *
 * @author carme
 */
public class UsuarioB implements Runnable{
    private Buffer buffer;
    public UsuarioB(Buffer bf){
        buffer=bf;
    }
    public void run(){
        try{
            buffer.imprimirEnB('B');
            buffer.terminarDeImprimirB();
        }catch(InterruptedException e){}
    }
}
