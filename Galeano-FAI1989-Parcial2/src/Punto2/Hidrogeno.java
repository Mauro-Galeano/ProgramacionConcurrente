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
public class Hidrogeno implements Runnable {

    private Buffer buffer;

    public Hidrogeno(Buffer bf) {
        buffer = bf;
    }

    @Override
    public void run() {
        buffer.hListo();
    }
    //Hice que el hidrogeno solo avise que esta listo, de esta manera los oxigenos seran los encargados de buscar a los hidrogenos para formar el agua.
    //En caso de que los hidrogenos sean los que buscan a los oxigenos, deberiamos cambiar el oxigeno para que solo avise que esta listo, y en el hidrogeno
    //debemos buscar a los oxigenos, con el encontrarOxigeno que esta comentado en el buffer.
}
