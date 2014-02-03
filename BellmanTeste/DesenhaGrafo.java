
	import java.awt.*;
	import javax.swing.*;
	/**
	 *
	 * @author Rep
	 */
	public class DesenhaGrafo extends JPanel {
	    private int nos;
	    
	    /** Creates a new instance of DesenhaGrafo */
	    public DesenhaGrafo(int nos){
	        this.nos = nos;
	    }
	    public Coordenada TransformaPolarCartesiana(double raio, double angulo){
	        Coordenada p = new Coordenada();
	        //angulo em radianos
	        angulo = Math.toRadians(angulo);        
	        p.setCoordenadas((int)(raio * Math.cos(angulo)), (int)(raio * Math.sin(angulo)));
	     
	        return p;        
	    }
	    public void paintComponent(Graphics g) {
	        
	        super.paintComponent(g);        
	        float a = 0;
	        int m,n;
	        Coordenada c = new Coordenada();
	        g.setColor(Color.BLACK);        
	        
	        while (a< 360){
	            c = TransformaPolarCartesiana(70, a);         
	            
	            m = 120 + (int)(c.getX());
	            n = 120 + (int)(c.getY());
	            
	            g.drawOval(m, n, 20,20);
	            a += (int)(360/nos);
	            
	        }
	    }
	    
	}


