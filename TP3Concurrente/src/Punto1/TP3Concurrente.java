/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

/**
 *
 * @author carme
 */
public class TP3Concurrente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VerificarCuenta vc= new VerificarCuenta();
        Thread Luis= new Thread(vc, "Luis");
        Thread Manuel= new Thread(vc,"Manuel");
        Luis.start();
        Manuel.start();
    }
}
/** a) El resultado que se obtiene al ejecutar el ejercicio es erroneo, ya que en algunos casos la cuenta de cuanta plata 
   le queda en la cuenta se hace mal, debido a que el otro hilo toma el cpu y no le da el tiempo al hilo anterior a guardar
   los datos actualizados. 
   Lo que deberia hacer es poner un syncronized en mi "recurso" asi de esta manera cuando el hilo que toma la llave para usar
   la cpu termina el run o corta por alguna exepcion suelta el recurso y le da la posibilidad al otro hilo que esta en espera
   de tomar la llave para usar el recurso. 
    
   */