/*
 * Modelo.java
 *
 * Created on 29 de Novembro de 2005, 16:10
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

import javax.swing.*;

/**
 *
 * @author Tiago
 */
public class Modelo {
    Grafo grafo;
    
    /** Creates a new instance of Modelo */
    public Modelo() {
    }
    
    public void setGrafo(int nos) {
        grafo = new Grafo(nos);
    }
    
    public JPanel desenhaGrafo() {
        return new PanelGrafo(grafo.getTamanho());
    }
    
}
