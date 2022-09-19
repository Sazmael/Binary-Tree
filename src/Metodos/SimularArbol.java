/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import javax.swing.JPanel;

/**
 *
 * @author Olman
 */
public class SimularArbol {

    public Arbol arbol = new Arbol();

    public SimularArbol() {
    }

    public boolean insertar(String letra) {
        return (this.arbol.agregar(letra));
    }

    public JPanel getDibujo() {
        return this.arbol.getdibujo();
    }

}
