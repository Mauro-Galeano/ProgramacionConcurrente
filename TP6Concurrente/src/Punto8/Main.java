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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SalaHemoterapia sala= new SalaHemoterapia();
        Pacientes[] colPacientes=new Pacientes[20];
        Thread[] colHilos=new Thread[20];
        for(int i=0;i<20;i++){
            colPacientes[i]=new Pacientes(sala);
            colHilos[i]=new Thread(colPacientes[i], "Paciente "+i);
        }
        for(int i=0;i<20;i++){
            colHilos[i].start();
        }
    }
    
}
