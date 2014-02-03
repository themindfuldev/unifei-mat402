import javax.swing.*;
import java.awt.*;

public class PanelGrafo extends JPanel {
   private int nos;
   private Dimension[] posicoes;
   static final long serialVersionUID = 0;   
	    
   public PanelGrafo(int nos){
       this.nos = nos;
       posicoes = new Dimension[nos];
   }
	    
   public Dimension transformaPolarCartesiana(int raio, double angulo){
      double x, y;
      Dimension d = new Dimension();

      // Ângulo em radianos
      angulo = Math.toRadians(angulo);        

      x = raio * Math.cos(angulo);
      y = raio * Math.sin(angulo);
      
      d.setSize(x, y);
	        
      return d;        
   }
	    
   public void paintComponent(Graphics g) {        
      super.paintComponent(g);
      
      double a = 0;
      int m, n, medida, texto;
      JLabel[] nomes = new JLabel[nos];
      Dimension letra;
      
      medida = (int)(360/nos);
	        
      for (int i = 0; i < nos; i++) {
    	  posicoes[i] = transformaPolarCartesiana(100, a);                  
	            
    	  m = (int) (135 + posicoes[i].getHeight());
    	  n = (int) (140 + posicoes[i].getWidth());
         
    	  posicoes[i].setSize(m, n);
    	  
    	  g.setColor(Color.BLACK);
    	  g.fillOval(m, n, 5, 5);    
         
    	  nomes[i] = new JLabel();
    	  
    	  nomes[i].setText(new Integer(i).toString());
    	  texto = nomes[i].getText().length();
    	  
    	  letra = transformaPolarCartesiana(120, a);
    	  
    	  m = (int) (127 + letra.getHeight());
    	  n = (int) (132 + letra.getWidth());
    	  
    	  g.drawOval(m, n, 20, 20);
    	  g.setColor(Color.WHITE);
    	  g.fillOval(m, n, 19, 19);    	  
    	  
    	  nomes[i].setBounds(m + 10 - (texto * 2), n, 20, 20);    	  
    	  
    	  add(nomes[i]);	            
     
    	  a += medida;            
      }
   }
   
   public Dimension[] getPosicoes() {
	   return posicoes;
   }  

}
