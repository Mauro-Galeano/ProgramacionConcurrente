/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilosofosCenando;

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
        Tenedor[] colTenedores= new Tenedor[5];
        for(int i=0;i<5;i++){
            colTenedores[i]=new Tenedor();
        }
        
        Filosofo filo1= new Filosofo(colTenedores[0], colTenedores[1]);
        Filosofo filo2= new Filosofo(colTenedores[1], colTenedores[2]);
        Filosofo filo3= new Filosofo(colTenedores[2], colTenedores[3]);
        Filosofo filo4= new Filosofo(colTenedores[3], colTenedores[4]);
        Filosofo filo5= new Filosofo(colTenedores[4], colTenedores[1]);
        
        Thread f1= new Thread(filo1, "Filosofo 1");
        Thread f2= new Thread(filo2, "Filosofo 2");
        Thread f3= new Thread(filo3, "Filosofo 3");
        Thread f4= new Thread(filo4, "Filosofo 4");
        Thread f5= new Thread(filo5, "Filosofo 5");
        
        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();
//        Filosofo[] colFilosofos=new Filosofo[5];
//        Thread[] colHilos=new Thread[5];
//        for(int i=0;i<5;i++){
//            colFilosofos[i]= new Filosofo(colTenedores[i],colTenedores[i+1]);
//            colHilos[i]= new Thread(colFilosofos[i]);
//        }

    }
    
}
