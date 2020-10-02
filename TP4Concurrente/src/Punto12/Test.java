/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto12;

/**
 *
 * @author carme
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Plato p1=new Plato();
        Hamaca h1=new Hamaca();
        Ruedita r1=new Ruedita();
        
        Hamsters[] colH=new Hamsters[5];
        Thread[] colHilos=new Thread[5];
        for(int i=0;i<5;i++){
            colH[i]= new Hamsters("Hamster"+i, p1, h1, r1);
            colHilos[i]= new Thread(colH[i]);
        }
        for(int j=0;j<5;j++){
            colHilos[j].start();
        }
    }
    
}
