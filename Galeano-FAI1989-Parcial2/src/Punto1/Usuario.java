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
public class Usuario implements Runnable{
    private BufferPrimario primario;
    private char aEscribir;
    private int r;
    public Usuario(BufferPrimario p){
        primario=p;
    }
    
    @Override
    public void run(){
        while(true){
            r=(int)(Math.random()*5)+1;
            this.letraAlAzar(r);//genero una letra aleatoria para que imprima
            primario.escribir(aEscribir);
        }
    }
    
    public void letraAlAzar(int r){
        switch(r){
            case 1:
                aEscribir='A';
                break;
            case 2:
                aEscribir='B';
                break;
            case 3:
                aEscribir='C';
                break;
            case 4:
                aEscribir='D';
                break;
            case 5:
                aEscribir='E';
                break;
        }
    }
}
