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
public class TP5Concurrente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x=(int)(Math.random()*2)+1;
        Comedor c=new Comedor(5,x,2,3);//el 1er numero es la cantidad de comederos, el 2do es la cantidad de perros y el 3ro la cantidad de gatos
        Perro[] colPerros= new Perro[2];
        Thread[] colHilosPerros=new Thread[2];
        Gato[] colGatos= new Gato[3];
        Thread[] colHilosGatos=new Thread[3];
        for(int i=0;i<2;i++){//Para los Perros
            colPerros[i]=new Perro(c);
            colHilosPerros[i]=new Thread(colPerros[i], "Perro "+i);
        }
        for(int j=0;j<3;j++){//Para los gatos
            colGatos[j]=new Gato(c);
            colHilosGatos[j]=new Thread(colGatos[j], "Gato "+j);
        }
        for(int k=0;k<2;k++){//start de los perros
            colHilosPerros[k].start();
        }
        for(int m=0;m<3;m++){//start de los gatos
            colHilosGatos[m].start();
        }
    }
}
