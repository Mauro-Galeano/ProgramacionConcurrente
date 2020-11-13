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
public class Observatorio {
    private int capacidad,cantPersonasDentro,visitantes,investigadores;
    public Observatorio(){
        capacidad=25;
        cantPersonasDentro=0;
        visitantes=0;
        investigadores=0;
    }
    
    public synchronized void entrarVisitante()throws InterruptedException{
        while(cantPersonasDentro>capacidad || investigadores>0){
            System.out.println("Soy "+Thread.currentThread().getName()+"(visitante) no puedo entrar esta lleno");
            this.wait();
        }
        System.out.println("Soy "+Thread.currentThread().getName()+"(visitante) entre al observatorio");
        cantPersonasDentro++;
        visitantes++;
    }
    public synchronized void salirDelObservatorioVisitante(){
        System.out.println("Soy "+Thread.currentThread().getName()+"(visitante) me voy");
        visitantes--;
        cantPersonasDentro--;
        this.notifyAll();
    }
    public synchronized void entrarEnSilla()throws InterruptedException{
        while(cantPersonasDentro>10 || investigadores>0){
            System.out.println("Soy "+Thread.currentThread().getName()+" estoy en silla de ruedas no puedo entrar porque hay mas de 30 personas");
            this.wait();
        }
        System.out.println("Soy "+Thread.currentThread().getName()+"(visitante en silla de ruedas) entre al observatorio");
        cantPersonasDentro++;
        visitantes++;
        capacidad=10;
    }
    public synchronized void salirDelObservatorioSilla(){
        System.out.println("Soy "+Thread.currentThread().getName()+"(visitante en silla de ruedas) me voy");
        cantPersonasDentro--;
        visitantes--;
        capacidad=25;
        this.notifyAll();
    }
    public synchronized void entrarMantenimiento()throws InterruptedException{
        while(visitantes>0 || investigadores>0 || cantPersonasDentro>capacidad){
            System.out.println("Soy "+Thread.currentThread().getName()+"(mantenimiento) no puedo entrar debo esperar");
            this.wait();
        }
        System.out.println("Soy "+Thread.currentThread().getName()+"(mantenimiento) entre al observatorio");
        cantPersonasDentro++;
    }
    public synchronized void salirObservatorio(){
        System.out.println("Soy "+Thread.currentThread().getName()+"(mantenimiento) me voy");
        cantPersonasDentro--;
        this.notifyAll();
    }
    public synchronized void entrarInvestigador()throws InterruptedException{
        while(cantPersonasDentro>0){
            System.out.println("Soy "+Thread.currentThread().getName()+"(investigador) hay gente en el observatorio debo esperar a que salgan");
            this.wait();
        }
        System.out.println("Soy "+Thread.currentThread().getName()+"(investigador) entre al observatorio");
        cantPersonasDentro++;
        investigadores++;
    }
    public synchronized void salirObservatoriInvestigadoro(){
        System.out.println("Soy "+Thread.currentThread().getName()+"(investigador) me voy");
        cantPersonasDentro--;
        investigadores--;
        this.notifyAll();
    }
}
