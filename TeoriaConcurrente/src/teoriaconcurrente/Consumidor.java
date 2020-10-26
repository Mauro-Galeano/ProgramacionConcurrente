/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoriaconcurrente;

/**
 *
 * @author carme
 */
public class Consumidor implements Runnable{
    private BufferLimitado buffer;
    public Consumidor(BufferLimitado bf){
        buffer=bf;
    }
    public void run(){
        try{
            buffer.sacar();
        }catch(InterruptedException e){}
    }
}
