/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto4;

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
        Surtidor surti = new Surtidor();

        Auto[] col = new Auto[5];
        Thread[] colT = new Thread[5];
        for (int i = 0; i < 5; i++) {
            col[i] = new Auto("AAA" + i + i, "Audi", "", surti);
            colT[i] = new Thread(col[i], "AAA" + i + i);
        }
        for (int x = 0; x < 5; x++) {
            colT[x].start();
        }
    }

}
