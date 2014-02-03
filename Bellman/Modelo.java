import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Modelo {
   private Grafo grafo;
   private Dimension[] posicoes;
   
   private int al = 16;		// Arrow length
   private int aw = 12;		// Arrow width
   private int haw = aw/2;	// Half arrow width
   private int xValues[] = new int[3];
   private int yValues[] = new int[3];
    
   public JPanel novoGrafo() {
	  String retorno = JOptionPane.showInputDialog(null, "Quantos nós este grafo possui?", "Criação de um novo grafo", JOptionPane.QUESTION_MESSAGE);
	  PanelGrafo panelGrafo;
	  int nos = 0;
	  
	  try {
		  nos = Integer.parseInt(retorno);
		  if (nos <= 0 || nos > 11) {			  
			  JOptionPane.showMessageDialog(null, "Entrada inválida!\nDigite um número inteiro positivo menor que 12!");
			  panelGrafo = null;
		  }
		  else {
			  grafo = new Grafo(nos);
			  panelGrafo = new PanelGrafo(grafo.getTamanho());
			  posicoes = panelGrafo.getPosicoes();
		  }
	  }
	  catch (NumberFormatException ex) {
		  JOptionPane.showMessageDialog(null, "Entrada inválida!\nDigite um número inteiro positivo!");
		  panelGrafo = null;
	  }			
	  catch (Exception ex) {		  
		  panelGrafo = null;
	  }	  
	  
      return panelGrafo;
   }
   
   public void insereAresta(JPanel panelGrafo) {
	   Graphics g;
	   Integer entradaNo;
	   Integer[] inteiros;
	   String entradaPeso;	   
 
	   int noI, noF, peso, noIx, noIy, noFx, noFy;
	   
	   if (grafo == null) {
		   JOptionPane.showMessageDialog(null, "O grafo não foi criado!");
		   return;
	   }
	   
	   g = panelGrafo.getGraphics();
	   inteiros = new Integer[grafo.getTamanho()];
	   
	   for (int i = 0; i < grafo.getTamanho(); i++) 
		  inteiros[i] = new Integer(i);
  	  
	   entradaNo = (Integer) JOptionPane.showInputDialog(null, "Especifique o nó inicial: ", "Criação de uma aresta", JOptionPane.QUESTION_MESSAGE, null, inteiros, inteiros[0]);
	   if (entradaNo == null) return;
	   noI = entradaNo.intValue();
	   
	   entradaNo = (Integer) JOptionPane.showInputDialog(null, "Especifique o nó final: ", "Criação de uma aresta", JOptionPane.QUESTION_MESSAGE, null, inteiros, inteiros[0]);
	   if (entradaNo == null) return;
	   noF = entradaNo.intValue();
	   
	   entradaPeso = JOptionPane.showInputDialog(null, "Qual é o peso da aresta?", "Criação de uma aresta", JOptionPane.QUESTION_MESSAGE);	   
	   
	   try {
		  peso = Integer.parseInt(entradaPeso);
		  if (peso == 0)
			  JOptionPane.showMessageDialog(null, "Entrada inválida!\nDigite um número inteiro diferente de zero!");			  
		  else {
			  grafo.setAresta(noI, noF, peso);
			   
			  noIx = (int) posicoes[noI].getWidth();
			  noIy = (int) posicoes[noI].getHeight();
			  noFx = (int) posicoes[noF].getWidth();
			  noFy = (int) posicoes[noF].getHeight();
			  
			  //g.drawLine(noIx, noIy, noFx, noFy);			  
			  drawArrow(g, noIx, noIy, noFx, noFy);
		  }
	   }
	   catch (NumberFormatException ex) {
		  JOptionPane.showMessageDialog(null, "Entrada inválida!\nDigite um número inteiro diferente de zero!");		  
	   }			
	   catch (Exception ex) {
		   
	   }
   }   

   public void escreveArestas() {
	   String exp = "";
	   int peso;	   
	   
	   if (grafo == null) {
		   JOptionPane.showMessageDialog(null, "O grafo não foi criado!");
		   return;
	   }	   
	   
	   for (int i = 0; i < grafo.getTamanho(); i++) {
		   for (int j = 0; j < grafo.getTamanho(); j++) {
			   peso = grafo.getAresta(i, j);
			   if (peso != 0) {
				   exp += "\n" + i + " -> " + j + " = " + peso;
			   }				   
		   }
	   }
	   
	   JOptionPane.showMessageDialog(null, "O peso das arestas é:\n" + exp);
   }
   
   public void drawArrow(Graphics g, int x1, int y1, int x2, int y2) {
       // Draw line
	   g.drawLine(x1,y1,x2,y2);
	   // Calculate x-y values for arrow head
	   calcValues(x1,y1,x2,y2);
	   g.fillPolygon(xValues,yValues,3);
   }

   /* CALC VALUES: Calculate x-y values. */
   	
   public void calcValues(int x1, int y1, int x2, int y2) {
	   // North or south	
	   if (x1 == x2) { 
		   // North
		   if (y2 < y1) arrowCoords(x2,y2,x2-haw,y2+al,x2+haw,y2+al);
		   // South
		   else arrowCoords(x2,y2,x2-haw,y2-al,x2+haw,y2-al);
		   return;
	   }	
	   // East or West	
	   if (y1 == y2) {
		   // East
		   if (x2 > x1) arrowCoords(x2,y2,x2-al,y2-haw,x2-al,y2+haw);
		   // West
		   else arrowCoords(x2,y2,x2+al,y2-haw,x2+al,y2+haw);
		   return;
	   }
	   // Calculate quadrant	
	   calcValuesQuad(x1,y1,x2,y2);
	}

   /* CALCULATE VALUES QUADRANTS: Calculate x-y values where direction is not
   parallel to eith x or y axis. */
   
   public void calcValuesQuad(int x1, int y1, int x2, int y2) { 
	   double arrowAng = Math.toDegrees (Math.atan((double) haw/(double) al));
	   double dist = Math.sqrt(al*al + aw);
	   double lineAng = Math.toDegrees(Math.atan(((double) Math.abs(x1-x2))/((double) Math.abs(y1-y2))));
				
	   // Adjust line angle for quadrant
	   if (x1 > x2) {
		   // South East
		   if (y1 > y2) lineAng = 180.0-lineAng;
	   }
	   else {
		   // South West
		   if (y1 > y2) lineAng = 180.0+lineAng;
		   // North West
		   else lineAng = 360.0-lineAng;
	   }
	
	   // Calculate coords
	
	   xValues[0] = x2;
	   yValues[0] = y2;	
	   calcCoords(1,x2,y2,dist,lineAng-arrowAng);
	   calcCoords(2,x2,y2,dist,lineAng+arrowAng);
	}
   
   /* CALCULATE COORDINATES: Determine new x-y coords given a start x-y and
   a distance and direction */   
   public void calcCoords(int index, int x, int y, double dist, double dirn) {
	   //System.out.println("dirn = " + dirn);
	   while(dirn < 0.0)   dirn = 360.0+dirn;
	   while(dirn > 360.0) dirn = dirn-360.0;
	   //System.out.println("dirn = " + dirn);
		
	   // North-East
	   if (dirn <= 90.0) {
		   xValues[index] = x + (int) (Math.sin(Math.toRadians(dirn))*dist);
		   yValues[index] = y - (int) (Math.cos(Math.toRadians(dirn))*dist);
		   return;
	   }
	   // South-East
	   if (dirn <= 180.0) {
		   xValues[index] = x + (int) (Math.cos(Math.toRadians(dirn-90))*dist);
		   yValues[index] = y + (int) (Math.sin(Math.toRadians(dirn-90))*dist);
		   return;
	   }
	   // South-West
	   if (dirn <= 90.0) {
		   xValues[index] = x - (int) (Math.sin(Math.toRadians(dirn-180))*dist);
		   yValues[index] = y + (int) (Math.cos(Math.toRadians(dirn-180))*dist);
	   }
	   // Nort-West    
	   else {
		   xValues[index] = x - (int) (Math.cos(Math.toRadians(dirn-270))*dist);
		   yValues[index] = y - (int) (Math.sin(Math.toRadians(dirn-270))*dist);
	   }
   }      
   
   // ARROW COORDS: Load x-y value arrays */   
   public void arrowCoords(int x1, int y1, int x2, int y2, int x3, int y3) {
       xValues[0] = x1;
       yValues[0] = y1;
       xValues[1] = x2;
       yValues[1] = y2;
       xValues[2] = x3;
       yValues[2] = y3;
   }   

   public void bellmanFord() {	   
	   if (grafo == null) {
		   JOptionPane.showMessageDialog(null, "O grafo não foi criado!");
		   return;
	   }
	   
	   int s, tam = grafo.getTamanho();
	   Integer escolha;
	   Integer[] inteiros = new Integer[tam];
	   double[] d = new double[tam];
	   LinkedList[] pi = new LinkedList[tam];
	   boolean retorno = true;
	   String exp;
	   
	   for (int i = 0; i < grafo.getTamanho(); i++) 
		   inteiros[i] = new Integer(i);
	  	  
	   escolha = (Integer) JOptionPane.showInputDialog(null, "Especifique o nó origem: ", "Cálculo do caminho mínimo", JOptionPane.QUESTION_MESSAGE, null, inteiros, inteiros[0]);
	   if (escolha == null) return;
	   s = escolha.intValue();
	   
	   // Algoritmo
	   inicializaUnicaOrigem(s, d, pi);
	   for (int i = 0; i < tam; i++) {
		   for (int u = 0; u < tam; u++) {
			   for (int v = 0; v < tam; v++) {
				   if (grafo.getAresta(u, v) != 0) {
					   relax(u, v, d, pi);
				   }
			   }
		   }
	   }
	   for (int u = 0; u < tam; u++) {
		   for (int v = 0; v < tam; v++) {
			   if (grafo.getAresta(u, v) != 0) {
				   if (d[v] > d[u] + grafo.getAresta(u, v))
					   retorno = false;
			   }
		   }
	   }	   
	   // Fim do Algoritmo
	   
	   if (retorno) {
		   exp = "O caminho mínimo pi[i] e seu peso d[i], a partir\n" +
		   		 "do nó origem " + s + ", para cada nó i, neste grafo,\n" +
		   		 "pelo algoritmo de Bellman-Ford é:\n";
		   for (int i = 0; i < tam; i++) {
			   exp += "\n d[" + i + "] = ";
			   exp += (d[i] != Double.POSITIVE_INFINITY? new Integer((int) d[i]).toString(): "Infinito");
			   exp += "\n pi -> " + s;
			   if (pi[i].isEmpty() == false) { 
				   exp += concatena((Integer) pi[i].getLast(), pi);
			   	   exp += " -> " + i;
			   }
		   }
		   JOptionPane.showMessageDialog(null, exp);
	   }		   
	   else
		   JOptionPane.showMessageDialog(null, "O grafo apresenta um ciclo de peso negativo,\nportanto, o algoritmo retorna FALSO.");
   }
   
   private void inicializaUnicaOrigem(int s, double[] d, LinkedList[] pi) {
	   for (int v = 0; v < grafo.getTamanho(); v++) {
		   d[v] = Double.POSITIVE_INFINITY;
		   pi[v] = new LinkedList();
	   }
	   d[s] = 0;
   }
   
   private void relax(int u, int v, double[] d, LinkedList[] pi) {
	   if (d[v] > (d[u] + grafo.getAresta(u, v))) {
		   d[v] = d[u] + grafo.getAresta(u, v);
		   pi[v].addLast(new Integer(u));
	   }
   }
   
   private String concatena(Integer s, LinkedList pi[]) {
	   if (pi[s.intValue()].isEmpty() == true) return "";
	   return concatena((Integer) pi[s.intValue()].getLast(), pi) + " -> " + s;
   }
}
