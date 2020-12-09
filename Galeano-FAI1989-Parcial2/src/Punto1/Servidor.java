/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carme
 */
public class Servidor implements Runnable{
    
    private BufferPrimario primario;
    public Servidor(BufferPrimario p){
        primario=p;
    }
    public void run(){
        while(true){
            try {
                primario.imprimir();
            } catch (InterruptedException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
