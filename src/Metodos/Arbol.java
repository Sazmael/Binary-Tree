/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Interfaz.GUI;
import Interfaz.pintarArbol;
import javax.swing.JPanel;

/**
 *
 * @author Olman
 */
public class Arbol {

    protected Nodo raiz;
    int altura;

    public Arbol() {
        raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public boolean agregar(String letra) {
        insertar(letra);
        return true;
    }
    
    //Metodo para insertar
    public void insertar(String letra) {
        if (this.raiz == null) {
            //Si el arbol esta vacio, inserta la letra como raiz
            this.raiz = new Nodo(letra);

        } else {
            //Inserta los nodos
            this.insertar(this.raiz, letra);

        }         
    }

    GUI gui;

    public void insertar(Nodo padre, String letra) {
        //Metodo para insertar en orden de Arbol binario             
        if (letra.compareTo(padre.getLetra()) > 0) { //Se comparan las letras mediante el compare to, contando el abecedario 
            if (padre.getDerecha() == null) {
                padre.setDerecha(new Nodo(letra));
            } else {

                this.insertar(padre.getDerecha(), letra);

            }
        } else {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(new Nodo(letra));
            } else {
                this.insertar(padre.getIzquierda(), letra);
            }
        }

    }

    public boolean Buscar(String letra) {
        return Buscar(raiz, letra);//Retorna false si no encuentra el nodo o retorna true si encuentra el nodo.
    }

    //Método para buscar el nodo de acuerdo con la raiz y la letra.
    private boolean Buscar(Nodo nodo, String letra) {
        if (nodo == null) {//Si la raíz es null entra en este if.
            return (false);
        } else {//Si la raíz tiene un dato entra en este else.
            if (letra.compareTo(nodo.getLetra()) > 0) {//Se compara que el dato ingresado sea mayor al dato del nodo y si lo es entra en este if.
                return (Buscar(nodo.getDerecha(), letra));//retorna false si no lo encuentra el nodo en el subarbol derecho, o returna true si lo encuentra.
            } else {//Si no es mayor entra en este else.
                if (letra.compareTo(nodo.getLetra()) < 0) {//Se compara que el dato ingresado sea menor al dato del nodo y si lo es entra en este if.
                    return (Buscar(nodo.getIzquierda(), letra));//retorna false si no lo encuentra el nodo en el subarbol izquierdo, o returna true si lo encuentra.
                } else {
                    return (true);//retorna true si lo encuetra 
                }
            }
        }
    }

    public boolean eliminar(String letra) {
        Nodo padre = raiz;
        Nodo auxiliar = raiz;
        boolean esIzquierdo = true;

        while (!letra.equals(auxiliar.getLetra())) {
            padre = auxiliar;

            if (letra.compareTo(auxiliar.getLetra()) < 0) {
                auxiliar = auxiliar.getIzquierda();
                esIzquierdo = true;
            } else {
                auxiliar = auxiliar.getDerecha();
                esIzquierdo = false;
            }

            if (auxiliar == null) {
                return false;
            }
        }

        if (auxiliar.esHoja()) { //Si el nodo encontrado es Hoja, lo elimina
            eliminarHoja(padre, auxiliar, esIzquierdo);
        } else {
            return false;
        }

        return true;
    }

    public void eliminarHoja(Nodo padre, Nodo auxiliar, boolean esIzquierdo) {
        if (auxiliar == raiz) {
            raiz = null;
        } else if (esIzquierdo) {
            padre.setIzquierda(null);
        } else {
            padre.setDerecha(null);
        }
    }

    private void altura(Nodo aux, int nivel) {
        if (aux != null) {
            altura(aux.getIzquierda(), nivel + 1);
            altura = nivel;
            altura(aux.getDerecha(), nivel + 1);
        }
    }

    //Devuleve la altura del arbol
    public int getAltura() {
        altura(raiz, 1);
        return altura;
    }

    public JPanel getdibujo() {
        return new pintarArbol(this);
        
    }
 
}
