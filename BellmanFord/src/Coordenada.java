/*
 * Coordenada.java
 *
 * Created on 29 de Novembro de 2005, 16:07
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

/**
 *
 * @author Tiago
 */
public class Coordenada {
    
    private int x, y;
    /** Creates a new instance of Coordenada */
    public Coordenada(int x, int y) {
        setCoordenadas(x, y);
    }
    public Coordenada() {
        this(0, 0);
    }
    
    public void setCoordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
}
