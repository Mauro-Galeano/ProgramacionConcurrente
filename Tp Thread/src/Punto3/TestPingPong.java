/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto3;

/**
 *
 * @author carme
 */
public class TestPingPong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PingPong t1= new PingPong("PING", 2000);
        PingPong t2= new PingPong("PONG", 2000);
        PingPong t3= new PingPong("PANG", 2000);
        PingPong t4= new PingPong("PUNG", 4000);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        for(int i=1; i<100;i++){
            System.out.println("HOLA");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        };
    }
    
}
/*a) Al sacar el sleep de la calse ping pong la esjecucion se mucho mas rapida
  b) Lo que podemos ver que los carteles que aparecen van variando, se van intercalando los hilos para tomar la cpu e imprimir 
  e) Lo que puedo deducir es que una vez que agregue el sleep dentro de mi for, los carteles se vieron mucho mas intercalados que antes,
    ya que antes salian practicamente todos los 'HOLA' primero y aparecian 1 o 2 'PING' o 'PONG' en el medio.
    */