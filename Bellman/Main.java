import javax.swing.*;

public class Main {
   public static void main(String[] args) {
      Interface app = new Interface();
	        
      app.setResizable(false);
      app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      app.setSize(280, 370);      
      app.setVisible(true);
   }

}
