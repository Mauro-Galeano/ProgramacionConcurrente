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
public class Turno {
    private int i=1;
    private String resultado="";
    public Turno(){
       
    }
    
//    public synchronized void imprimir(String n){
//        System.out.println("El turno es "+i);
//        
//        if(n.equalsIgnoreCase("A") && i==1){
//            resultado=resultado+n;
//            //System.out.print(n);
//            i=2;
//        }else{
//            if(n.equalsIgnoreCase("BB") || (i==2)){
//                resultado=resultado+n;
//                System.out.print(n);
//                i=3;
//            }else{
//                resultado=resultado+n;
//                //System.out.print(n);
//                i=1;
//            }
//        }
//        
//        //return resultado;
//    }
    public synchronized void incrementar(){
        if(i==3){
            i=1;
        }else{
            i++;
        }
    }
    public synchronized int getTurno(){
        return i;
    }
}
