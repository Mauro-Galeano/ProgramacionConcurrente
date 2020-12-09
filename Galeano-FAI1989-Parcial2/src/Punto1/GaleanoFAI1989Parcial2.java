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
public class GaleanoFAI1989Parcial2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int espacioMaximoDelBuffer=2;
        BufferPrimario primario=new BufferPrimario(espacioMaximoDelBuffer);
        Servidor servidor=new Servidor(primario);
        Thread s=new Thread(servidor, "Servidor");
        Usuario[] colUsuarios=new Usuario[3];
        Thread[] colHU=new Thread[3];
        for(int i=0;i<3;i++){
            colUsuarios[i]=new Usuario(primario);
            colHU[i]=new Thread(colUsuarios[i], "Usuario "+i);
        }
        for(int i=0;i<3;i++){
            colHU[i].start();
        }
        s.start();
    }
    
}
