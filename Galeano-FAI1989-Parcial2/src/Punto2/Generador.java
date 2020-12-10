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
public class Generador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int capcidadMaxima=2;
        Buffer bf=new Buffer(capcidadMaxima);
        ArmadorDeAtomosDeAgua armador=new ArmadorDeAtomosDeAgua(bf);
        Thread a= new Thread(armador, " Armador");
        Oxigeno[] colOxigenos=new Oxigeno[3];
        Hidrogeno[] colHidrogenos=new Hidrogeno[6];
        Thread[] colHO=new Thread[3];
        Thread[] colHH=new Thread[6];
        for(int i=0;i<colOxigenos.length;i++){
            colOxigenos[i]=new Oxigeno(bf);
            colHO[i]=new Thread(colOxigenos[i], "Oxigeno"+i);
        }
        for(int i=0;i<colHidrogenos.length;i++){
            colHidrogenos[i]=new Hidrogeno(bf);
            colHH[i]=new Thread(colHidrogenos[i], "Hidrogeno"+i);
        }
        a.start();
        for(int i=0;i<colHH.length;i++){
            colHH[i].start();
        }
        for(int i=0;i<colHO.length;i++){
            colHO[i].start();
        }
    }
    
}
