/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto7;

/**
 *
 * @author carme
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cinta cinta=new Cinta(5);//5 es la cantidad maxima de pasteles que entran en la cinta/mostrador
        Empaquetador[] empaquetadores= new Empaquetador[2];
        Horno[] hornos= new Horno[3];
        Brazo brazo=new Brazo(cinta);
        Thread b1=new Thread(brazo, "Brazo");
        Thread[] colEmpaquetadores=new Thread[2];
        Thread[] colHornos=new Thread[3];
        for(int i=0;i<2;i++){
            empaquetadores[i]=new Empaquetador(cinta);
            colEmpaquetadores[i]=new Thread(empaquetadores[i], "Empaquetador "+i);
        }
        for(int i=0;i<3;i++){
            hornos[i]=new Horno(cinta);
            colHornos[i]=new Thread(hornos[i], "Horno "+i);
        }
        b1.start();
        for(int i=0;i<2;i++){
            colEmpaquetadores[i].start();
        }
        for(int i=0;i<3;i++){
            colHornos[i].start();
        }
    }
    
}
