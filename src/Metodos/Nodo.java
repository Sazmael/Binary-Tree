package Metodos;

/**
 * Clase Nodos usados en la clase arbol para metodos del Arbol Binario
 * 
 */
public class Nodo {
   
    
    private Nodo izquierda;
    private Nodo derecha;
    private String letra;
    
    public Nodo(String letra){
        this.letra = letra;
        this.izquierda = this.derecha = null;
    }

    public String getLetra() {
        return letra;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }
    
    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }
    
    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }
    
    public boolean esHoja(){
        return ((derecha == null) && (izquierda == null));
    }
        
}
    
