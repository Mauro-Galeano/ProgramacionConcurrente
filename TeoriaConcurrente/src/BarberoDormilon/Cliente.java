/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarberoDormilon;

/**
 *
 * @author carme
 */
public class Cliente implements Runnable{
    private String miNombre;
    private Barberia bar;

    public Cliente(Barberia barbe, String nomb) {
        this.bar = barbe;
        this.miNombre = nomb;
    }

    private void irBarberia() {
        System.out.println("Soy " + miNombre + " y voy a la barberia");
        try {
            Thread.sleep((int) (Math.random() * 500));
        } catch (InterruptedException e) {
        }
    }
    public void run() {
        this.irBarberia();
        if (bar.entrarBarberia(miNombre)) {
            bar.solicitoCorte(miNombre);
            bar.salir();
            System.out.println("Soy " + miNombre + ", y ya dejé la barberia!");
        } else {
            System.out.println("Soy " + miNombre + ", el barbero esta ocupado. Me voy!");
        }
    }
}
