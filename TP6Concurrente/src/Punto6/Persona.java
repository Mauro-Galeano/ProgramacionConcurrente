/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto6;

/**
 *
 * @author carme
 */
public class Persona implements Runnable{
    
    private Observatorio observatorio;
    //private boolean esVisitante,esDeMantenimiento,esInvestigador;
    private int r,r2;
    public Persona(Observatorio obs){
        observatorio=obs;
        r=(int)(Math.random()*3)+1;//aleatorio para ser visitante(1), de mantenimiento(2) o investigador(3)
        r2=(int)(Math.random()*2)+1;//para que el visitante tenga silla de ruedas o no, de manera aleatoria, en caso de tener silla de ruedas es 1 y en caso contrario 0
    }
    public void run(){
        try{
            switch(r){
            case 1:
                if(r2==1){//entra al if si es un visitante en silla de ruedas
                    observatorio.entrarEnSilla();
                    this.recorrerObservatorio();
                    observatorio.salirDelObservatorioSilla();
                }else{//entra en caso de ser un visitante sin silla de ruedas
                    observatorio.entrarVisitante();
                    this.recorrerObservatorio();
                    observatorio.salirDelObservatorioSilla();
                }
                break;
            case 2:
                observatorio.entrarMantenimiento();
                this.recorrerObservatorio();
                observatorio.salirObservatorio();
                break;
            case 3:
                observatorio.entrarInvestigador();
                this.recorrerObservatorio();
                observatorio.salirObservatorio();
                break;
        }
        }catch(InterruptedException e){}
        
    }
    private void recorrerObservatorio()throws InterruptedException{
        Thread.sleep(2500);
    }
    
}
