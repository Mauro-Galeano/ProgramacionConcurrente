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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x=(int)(Math.random()*2)+1;
        Comedor comedor=new Comedor(2, x, 3, 3);
        Perro[] colPerros= new Perro[3];
        Thread[] colHilosPerros=new Thread[3];
        Gato[] colGatos= new Gato[3];
        Thread[] colHilosGatos=new Thread[3];
        for(int i=0;i<3;i++){//Para los Perros
            colPerros[i]=new Perro(comedor);
            colHilosPerros[i]=new Thread(colPerros[i], "Perro "+i);
        }
        for(int j=0;j<3;j++){//Para los gatos
            colGatos[j]=new Gato(comedor);
            colHilosGatos[j]=new Thread(colGatos[j], "Gato "+j);
        }
        for(int k=0;k<3;k++){//start de los perros
            colHilosPerros[k].start();
        }
        for(int m=0;m<3;m++){//start de los gatos
            colHilosGatos[m].start();
        }
    }
    
}
