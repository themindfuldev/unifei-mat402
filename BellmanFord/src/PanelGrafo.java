/*
 * PanelGrafo.java
 *
 * Created on 29 de Novembro de 2005, 16:22
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Tiago
 */
public class PanelGrafo extends JPanel {    
    private int nos;
    
    /** Creates a new instance of DesenhaGrafo */
    public PanelGrafo(int nos){
        this.nos = nos;
    }
    
    public Coordenada TransformaPolarCartesiana(double raio, double angulo){
        int x, y;
        Coordenada p;

        //angulo em radianos
        angulo = Math.toRadians(angulo);        

        x = (int) (raio * Math.cos(angulo));
        y = (int) (raio * Math.sin(angulo));
        
        p =  new Coordenada(x, y);
     
        return p;        
    }
    
    public void paintComponent(Graphics g) {        
        super.paintComponent(g);
        
        float a = 0;
        int m, n;
        Coordenada c;
        
        g.setColor(Color.BLACK);        
        
        while (a < 360) {
            c = TransformaPolarCartesiana(70, a);         
            
            m = 120 + c.getX();
            n = 120 + c.getY();
            
            g.drawOval(m, n, 20, 20);
            a += (int)(360/nos);            
        }
    }
    
}
