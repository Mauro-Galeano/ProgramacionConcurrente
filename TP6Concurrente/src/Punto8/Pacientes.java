/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto8;

/**
 *
 * @author carme
 */
public class Pacientes implements Runnable{
    private SalaHemoterapia sh;
    
    public Pacientes(SalaHemoterapia s){
        sh=s;
    }
    
    public void run(){
        try{
            sh.entrar();
        }catch(InterruptedException e){}
    }
}
