
public class Grafo {
	  private int[][] matriz;
		
	   /** Creates a new instance of Grafo */
	   public Grafo(int nos) {
	      matriz = new int[nos][nos];
	   }
		
	   public void setAresta(int noInicial, int noFinal, int peso) {
	      matriz[noInicial][noFinal] = peso;
	      // (noInicial != noFinal) ? matriz[noFinal][noInicial] = peso; // se n�o for direcionado  		
	   }
		
	   public int getAresta(int noInicial, int noFinal) {
		  return matriz[noInicial][noFinal];
	   }    
	    
	   public int getTamanho() {
	      return matriz.length;
	   }
}
