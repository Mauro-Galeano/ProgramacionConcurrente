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
public class UsuarioA implements Runnable{
    
    private Buffer buffer;
    public UsuarioA(Buffer bf){
        buffer=bf;
    }
    public void run(){
        try{
            buffer.imprimirEnA('A');
            buffer.terminarDeImprimirA();
        }catch(InterruptedException e){}
    }
}
