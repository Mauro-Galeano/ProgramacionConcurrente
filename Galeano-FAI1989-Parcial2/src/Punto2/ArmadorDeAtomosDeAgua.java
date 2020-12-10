/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto2;

/**
 *
 * @author carme
 */
public class ArmadorDeAtomosDeAgua implements Runnable{
    private Buffer buffer;
    public ArmadorDeAtomosDeAgua(Buffer b){
        buffer=b;
    }
    public void run(){
        while(true){
            buffer.hacerAgua();
        }
    }
}
