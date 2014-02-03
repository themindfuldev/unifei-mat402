
public class Coordenada {
	   private double x, y;

	   /** Creates a new instance of Coordenada */
	   public Coordenada(double x, double y) {
		  setCoordenadas(x, y);
	   }
	   public Coordenada() {
		   this(0, 0);
	   }
		    
		public void setCoordenadas(double x, double y) {
		   this.x = x;
		   this.y = y;
		}
		    
		public double getX() {
		   return x;
		}
		    
		public double getY() {
		   return y;
		}
}
