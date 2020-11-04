/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IncisoB;

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
         Pista p=new Pista("Cordoba");
        Avion[] aviones=new Avion[5];
        Thread[] hilosAviones=new Thread[5];
        for(int i=0;i<5;i++){
            aviones[i]= new Avion(p);
            hilosAviones[i]=new Thread(aviones[i], "Avion "+i);
        }
        for(int j=0;j<5;j++){
            hilosAviones[j].start();
        }
    }
    
}
