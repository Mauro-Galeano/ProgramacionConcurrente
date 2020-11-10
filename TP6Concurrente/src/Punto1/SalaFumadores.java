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
public class SalaFumadores {
    private String[] colIngredientes={"Papel","Fosforo","Tabaco"};
    private String ingredienteFaltante;
    private boolean hayAlguienFumando=false, hayIngredientesEnLaMesa=false;
    public SalaFumadores(){
       ingredienteFaltante="";
    }
    
    public synchronized void colocar(int ingrediente1)throws InterruptedException{
        while(hayAlguienFumando||hayIngredientesEnLaMesa){
            this.wait();
        }
        System.out.println("Soy el agente pongo los ingredientes en la mesa, el ingrediente que falta es: "+colIngredientes[ingrediente1]);
        Thread.sleep(2500);
        ingredienteFaltante=colIngredientes[ingrediente1];
        hayIngredientesEnLaMesa=true;
        this.notifyAll();
    }
    
    public synchronized void entrarAFumar(int id)throws InterruptedException{
        while(!ingredienteFaltante.equals(colIngredientes[id])){
            System.out.println("Soy "+Thread.currentThread().getName()+" tengo "+colIngredientes[id]+" pero no es el ingrediente que falta, voy a esperar");
            this.wait();
        }
        hayAlguienFumando=true;
        System.out.println("Soy "+Thread.currentThread().getName()+" voy a armar un cigarro");
        Thread.sleep(2500);
    }
    public synchronized void terminarDeFumar(){
        System.out.println("Soy "+Thread.currentThread().getName()+" termine de fumar, me voy.");
        ingredienteFaltante="";
        hayAlguienFumando=false;
        hayIngredientesEnLaMesa=false;
        this.notifyAll();
    }
}
