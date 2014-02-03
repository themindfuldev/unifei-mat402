import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interface extends JFrame {
   private Modelo modelo;
   private JPanel panelBotoes, panelGrafo, panelTemp;
   private JButton botao[];
   static final long serialVersionUID = 0;
   
   /** Creates new form Interface */
   public Interface() {	   
	   super("Algoritmo de BellmanFord");

	   modelo = new Modelo();
	   botao = new JButton[4];
	   
	   botao[0] = new JButton("Novo grafo");
	   botao[1] = new JButton("Inserir aresta");
	   botao[2] = new JButton("Exibir pesos");
	   botao[3] = new JButton("Caminho mínimo");
	   panelGrafo = new JPanel();	   
	   panelBotoes = new JPanel();

	   getContentPane().add(panelGrafo, BorderLayout.CENTER);	   
       
	   panelBotoes.setLayout(new GridLayout(2, 2));	   
	   
       botao[0].addMouseListener(new MouseAdapter() {
    	   public void mousePressed(MouseEvent evt) {
    		   panelTemp = modelo.novoGrafo();
    		   if (panelTemp != null) {
    			   remove(panelGrafo);
    			   panelGrafo = panelTemp;
    			   getContentPane().add(panelGrafo);    		   
    			   validate();
    		   }
    	   }
       });
       panelBotoes.add(botao[0]);      
       
       botao[1].addMouseListener(new MouseAdapter() {
    	   public void mousePressed(MouseEvent evt) {
    		   modelo.insereAresta(panelGrafo);
    	   }
       });
       panelBotoes.add(botao[1]);
       
       botao[2].addMouseListener(new MouseAdapter() {
    	   public void mousePressed(MouseEvent evt) {
    		   modelo.escreveArestas();
    	   }
       });
       panelBotoes.add(botao[2]);
       
       botao[3].addMouseListener(new MouseAdapter() {
    	   public void mousePressed(MouseEvent evt) {
    		   modelo.bellmanFord();
    	   }
       });
       panelBotoes.add(botao[3]);
       
       getContentPane().add(panelBotoes, BorderLayout.SOUTH);       
       
       pack();       
   }

}
