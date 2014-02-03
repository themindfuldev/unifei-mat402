/*
 * Grafo.java
 *
 * Created on 26 de Novembro de 2005, 10:23
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Tiago
 */
public class Grafo {    
    private int[][] matriz;
	
    /** Creates a new instance of Grafo */
    public Grafo(int nos) {
        matriz = new int[nos][nos];
    }
	
    public void setAresta(int noInicial, int noFinal, int peso) {
        matriz[noInicial][noFinal] = peso;
	// (noInicial != noFinal) ? matriz[noFinal][noInicial] = peso; // se não for direcionado  		
    }
	
    public int getAresta(int noInicial, int noFinal) {
	return matriz[noInicial][noFinal];
    }    
    
    public int getTamanho() {
        return matriz.length;
    }
    
}


