import javax.swing.*;
/**
 *
 * @author Rep
 */
public class Teste {
    
    public static void main (String args[]){
        JOptionPane tela = new JOptionPane();
        JFrame frame = new JFrame();
        DesenhaGrafo tel_ini;
        int nos;
        
        nos = Integer.parseInt(tela.showInputDialog("Digite o número de nós:"));
        
        tel_ini = new DesenhaGrafo(nos);
        
        frame.add(tel_ini);
        frame.setSize(300, 300);
        frame.setVisible(true);   
    }
}
