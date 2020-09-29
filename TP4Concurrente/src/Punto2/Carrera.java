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
public class Carrera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //int x;
        Testigo t= new Testigo();
        Atleta[] colA= new Atleta[4];
        Thread[] colHilos= new Thread[4];
        for(int i=0;i<4;i++){
            colA[i]= new Atleta(t,"Atleta"+i);
            colHilos[i]= new Thread(colA[i]);
        }
        for(int i=0;i<4;i++){
            colHilos[i].start();
        }
    }
//    public static boolean verificar(int x, int []a){
//        boolean e=false;
//        for(int i=0;i<4;i++){
//            if(a[i]==x){
//                e=true;
//            }
//        }
//        return e;
//    }
//    public static int generarNumero(int i){
//        int x=-1;
//        int[] anteriores={-1,-1,-1,-1};
//            x=(int)(Math.random()*4)+1;
//            while(verificar(x,anteriores)){
//                x=(int)(Math.random()*4)+1;
//            }
//            anteriores[i]=x;
//        return x;
//    }
}
