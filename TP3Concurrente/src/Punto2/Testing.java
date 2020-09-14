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
public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vida vida= new Vida();
        Personaje p= new Personaje(vida);
        Thread orco= new Thread(p, "orco");
        Thread curandero= new Thread(p, "curandero");
        orco.start();
        curandero.start();
        
        
        
        
      
    }
    
}
