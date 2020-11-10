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
public class Fumador implements Runnable{

    private int id;
    private SalaFumadores sala;

    public Fumador(int id, SalaFumadores sala) {
        this.id = id;
        this.sala = sala;
    } //constructor

    public void run() {
        while (true) {
            try {
                sala.entrarAFumar(id);
                System.out.println("Fumador"+id +" está fumando");
                Thread.sleep(1000);
                sala.terminarDeFumar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } //catch
        } //while
    } //run
}
