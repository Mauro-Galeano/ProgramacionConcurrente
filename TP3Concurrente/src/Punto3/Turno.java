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
    private int i;
    private String resultado="";
    public Turno(){
        this.i=1;
    }
    
    public String imprimir(String n){
        
        if(n=="A"&&i==1){
            resultado=resultado+n;
            i=2;
        }else{
            if(n=="BB"&&i==2){
                resultado=resultado+n;
                i=3;
            }else{
                resultado=resultado+n;
                i=1;
            }
        }
        return resultado;
    }
}
