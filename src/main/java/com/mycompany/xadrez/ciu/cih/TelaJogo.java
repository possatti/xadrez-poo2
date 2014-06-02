/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.xadrez.ciu.cih;

/**
 *
 * @author lucas
 */
public class TelaJogo extends javax.swing.JFrame {

    /**
     * Creates new form TelaJogo
     */
    public TelaJogo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuPartidas = new javax.swing.JMenu();
        jMenuItemSingleplayer = new javax.swing.JMenuItem();
        jMenuItemMultiplayer = new javax.swing.JMenuItem();
        jMenuItemSalvar = new javax.swing.JMenuItem();
        jMenuItemSalvarSair = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenujogadores = new javax.swing.JMenu();
        jMenuItemCadastrarJogador = new javax.swing.JMenuItem();
        jMenuItemEditarJogador = new javax.swing.JMenuItem();
        jMenuItemApagarJogador = new javax.swing.JMenuItem();
        jMenuAjuda = new javax.swing.JMenu();
        jMenuItemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuPartidas.setText("Partidas");

        jMenuItemSingleplayer.setText("Nova partida singleplayer");
        jMenuPartidas.add(jMenuItemSingleplayer);

        jMenuItemMultiplayer.setText("Nova partida multiplayer");
        jMenuPartidas.add(jMenuItemMultiplayer);

        jMenuItemSalvar.setText("Salvar partida atual");
        jMenuPartidas.add(jMenuItemSalvar);

        jMenuItemSalvarSair.setText("Salvar e sair");
        jMenuPartidas.add(jMenuItemSalvarSair);

        jMenuItemSair.setText("Sair sem salvar");
        jMenuPartidas.add(jMenuItemSair);

        jMenuBar1.add(jMenuPartidas);

        jMenujogadores.setText("Jogadores");

        jMenuItemCadastrarJogador.setText("Cadastrar novo jogador");
        jMenujogadores.add(jMenuItemCadastrarJogador);

        jMenuItemEditarJogador.setText("Editar jogador");
        jMenujogadores.add(jMenuItemEditarJogador);

        jMenuItemApagarJogador.setText("Apagar jogador");
        jMenujogadores.add(jMenuItemApagarJogador);

        jMenuBar1.add(jMenujogadores);

        jMenuAjuda.setText("Ajuda");

        jMenuItemSobre.setText("Sobre");
        jMenuAjuda.add(jMenuItemSobre);

        jMenuBar1.add(jMenuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuAjuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemApagarJogador;
    private javax.swing.JMenuItem jMenuItemCadastrarJogador;
    private javax.swing.JMenuItem jMenuItemEditarJogador;
    private javax.swing.JMenuItem jMenuItemMultiplayer;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemSalvar;
    private javax.swing.JMenuItem jMenuItemSalvarSair;
    private javax.swing.JMenuItem jMenuItemSingleplayer;
    private javax.swing.JMenuItem jMenuItemSobre;
    private javax.swing.JMenu jMenuPartidas;
    private javax.swing.JMenu jMenujogadores;
    // End of variables declaration//GEN-END:variables
}
