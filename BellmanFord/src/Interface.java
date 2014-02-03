/*
 * Interface.java
 *
 * Created on 26 de Novembro de 2005, 10:27
 */

import javax.swing.*;

/**
 *
 * @author  Tiago
 */
public class Interface extends javax.swing.JFrame {
    Modelo modelo;
    
    /** Creates new form Interface */
    public Interface() {
        initComponents();
        modelo = new Modelo();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelGrafo = new javax.swing.JPanel();
        botao1 = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmo de BellmanFord");
        panelGrafo.setMinimumSize(new java.awt.Dimension(300, 200));
        panelGrafo.setPreferredSize(new java.awt.Dimension(300, 200));
        panelGrafo.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 300;
        gridBagConstraints.gridheight = 18;
        getContentPane().add(panelGrafo, gridBagConstraints);

        botao1.setText("Criar novo grafo");
        botao1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botao1MousePressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        getContentPane().add(botao1, gridBagConstraints);

        pack();
    }
    // </editor-fold>//GEN-END:initComponents

    private void botao1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botao1MousePressed
        String retorno = JOptionPane.showInputDialog(null,"Quantos n�s este grafo possui?","Cria��o de um novo grafo",1);
        
        modelo.setGrafo(Integer.parseInt(retorno));
        panelGrafo = modelo.desenhaGrafo();
        getContentPane().repaint();
    }//GEN-LAST:event_botao1MousePressed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }
    
    private void desenhaGrafo(Grafo grafo) {                
        int i, j, tam = grafo.getTamanho();
        int[][] desenho = new int[tam][tam];
        
        for (i=0; i < tam; i++) {
            for (j=0; j < tam; j++) {
                                
            }
        }
        
        for (i=0; i < tam; i++) {
            for (j=0; j < tam; j++) {
                if (grafo.getAresta(i, j) != 0) {
                    
                }
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao1;
    private javax.swing.JPanel panelGrafo;
    // End of variables declaration//GEN-END:variables
    
}