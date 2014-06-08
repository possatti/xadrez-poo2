/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.xadrez.ciu.cih;

import br.edu.ifes.poo2.xadrez.ciu.cci.Controlador;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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

        jPanelChat1 = new br.edu.ifes.poo2.xadrez.ciu.cih.JPanelChat();
        jPanelJogo1 = new br.edu.ifes.poo2.xadrez.ciu.cih.JPanelJogo();
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
        setMaximumSize(new java.awt.Dimension(260, 487));

        jMenuPartidas.setText("Partidas");

        jMenuItemSingleplayer.setText("Nova partida singleplayer");
        jMenuItemSingleplayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSingleplayerActionPerformed(evt);
            }
        });
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
        jMenuItemCadastrarJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarJogadorActionPerformed(evt);
            }
        });
        jMenujogadores.add(jMenuItemCadastrarJogador);

        jMenuItemEditarJogador.setText("Editar jogador");
        jMenujogadores.add(jMenuItemEditarJogador);

        jMenuItemApagarJogador.setText("Apagar jogador");
        jMenuItemApagarJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemApagarJogadorActionPerformed(evt);
            }
        });
        jMenujogadores.add(jMenuItemApagarJogador);

        jMenuBar1.add(jMenujogadores);

        jMenuAjuda.setText("Ajuda");

        jMenuItemSobre.setText("Sobre");
        jMenuItemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSobreActionPerformed(evt);
            }
        });
        jMenuAjuda.add(jMenuItemSobre);

        jMenuBar1.add(jMenuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelChat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelJogo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelJogo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelChat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSingleplayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSingleplayerActionPerformed
        // Opções
        String maquinas[] = {"Zeus"};
        String jogadores[] = {"Possatti", "Phillipe"};
        String cores[] = {
            CorPeca.BRANCO.toString(),
            CorPeca.PRETO.toString()
        };

        // Abre o diálogo de novo jogo
        JComboBox jogador = new JComboBox(jogadores);
        JComboBox maquina = new JComboBox(maquinas);
        JComboBox corJogador = new JComboBox(cores);

        Object[] message = {
            "Jogador:", jogador,
            "Máquina", maquina,
            "Cor do jogador:", corJogador,};
        JOptionPane.showConfirmDialog(null, message, "Iniciar partida singleplayer", JOptionPane.OK_CANCEL_OPTION);

        // TODO Inicia o novo jogo.
        System.out.println(jogador.getSelectedItem());
        System.out.println(maquina.getSelectedItem());
        System.out.println(corJogador.getSelectedItem());
    }//GEN-LAST:event_jMenuItemSingleplayerActionPerformed

    private void jMenuItemCadastrarJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarJogadorActionPerformed
        Controlador.INSTANCE.cadastrarJogador();
    }//GEN-LAST:event_jMenuItemCadastrarJogadorActionPerformed

    private void jMenuItemApagarJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemApagarJogadorActionPerformed
        // Abre o diálogo
        JTextField jApelido = new JTextField();
        Object[] message = {
            "Apelido:", jApelido,};
        JOptionPane.showConfirmDialog(null, message, "Iniciar partida singleplayer", JOptionPane.OK_CANCEL_OPTION);

        // Captura as informações.
        String apelido = jApelido.getText();

        // TODO Grava os dados.
        System.out.println(apelido);
    }//GEN-LAST:event_jMenuItemApagarJogadorActionPerformed

    private void jMenuItemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSobreActionPerformed
        new JDialogSobre(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItemSobreActionPerformed

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
    private br.edu.ifes.poo2.xadrez.ciu.cih.JPanelChat jPanelChat1;
    private br.edu.ifes.poo2.xadrez.ciu.cih.JPanelJogo jPanelJogo1;
    // End of variables declaration//GEN-END:variables
}
