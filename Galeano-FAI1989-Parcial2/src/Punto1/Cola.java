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
public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola() {
        //Constructor de la cola generica
        this.frente = null;
        this.fin = null;
    }

    public boolean poner(Object elem) {
        //Metodo que permite poner un elemento en la cola
        boolean res;
        Nodo nuevoNodo;
        //Creo nodo
        nuevoNodo = new Nodo(elem);
        //Si la cola esta vacia entonces el fin y el frente son iguales al nodo nuevo
        if (frente == null && fin == null) {
            //Esta vacia entonces guardo el nuevoNodo en fin y frente
            this.frente = nuevoNodo;
            this.fin = nuevoNodo;
            res = true;
        } else {
            //No esta vacia entonces seteo el nodo al fin, y guardo nuevo fin
            this.fin.setEnlace(nuevoNodo);
            this.fin = nuevoNodo;
            res = true;
        }
        return res;
    }

    public boolean sacar() {
        //Metodo que permite sacar un elemento en la cola
        boolean res = false;
        //Si el frente es distinto de null
        if (this.frente != null) {
            //Es distinto de null entonces saco elemento del frente, seteando al frente con el enlace de el mismo
            this.frente = this.frente.getEnlace();
            //Si el nuevo frente es null
            if (this.frente == null) {
                //Es null entonces no hay mas nada en la cola y el fin es null, porque la cola esta vacia
                this.fin = null;
            }
            res = true;
        }
        return res;
    }

    public Object obtenerFrente() {
        //Permite obtener elemento del frente de la cola
        Object elem;
        if (esVacia()) {
            //Esta vacia entonces elemento es null
            elem = null;
        } else {
            //No esta vacia entonces obtengo elemento
            elem = this.frente.getElemento();
        }
        return elem;
    }

    public boolean esVacia() {
        //Permite verificar si la cola esta vacia
        boolean res = false;
        //Si el frente es null entonces la cola esta vacia
        if (this.frente == null) {
            res = true;
        }
        return res;
    }

    public void vaciar() {
        //Permite vaciar la cola
        this.frente = null;
        this.fin = null;
    }

    public Cola clone() {
        //Metodo que permite clonar la cola
        Cola clon = new Cola();
        Nodo aux = this.frente;
        clon.frente = aux;
        clon.fin = aux;
        while (aux != null) {
            //Permite ir poniendo los elementos en la cola
            clon.poner(aux.getElemento());
            aux = aux.getEnlace();
        }
        return clon;
    }

    public String toString() {
        //Metodo que permite mostrar un string con todos los datos de la cola
        String res = "[";
        Nodo aux = this.frente;
        while (aux != null) {
            //Guarda todos los datos de la cola en el string
            res += aux.getElemento().toString();
            if (aux.getEnlace() != null) {
                res += ",";
            }
            aux = aux.getEnlace();
        }
        return res + "]";
    }
}
