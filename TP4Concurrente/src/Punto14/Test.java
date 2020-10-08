/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto14;

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
        Mesa mesa1=new Mesa();
        Mozo m1=new Mozo(mesa1);
        Cocinero coc= new Cocinero(mesa1);
        Empleado c1= new Empleado(mesa1);
        Empleado c2= new Empleado(mesa1);
        Empleado c3= new Empleado(mesa1);
        Thread juan=new Thread(m1, "juan");
        Thread walter=new Thread(coc, "walter");
        Thread arturo=new Thread(c1, "arturo");
        Thread rodrigo=new Thread(c2, "rodrigo");
        Thread pedro=new Thread(c3, "pedro");
        
        juan.start();
        walter.start();
        arturo.start();
        rodrigo.start();
        pedro.start();
    }
    
}
