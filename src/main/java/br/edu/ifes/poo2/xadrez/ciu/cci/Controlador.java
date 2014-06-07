/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.xadrez.ciu.cci;

import br.edu.ifes.poo2.xadrez.ciu.cih.JPanelCasa;
import br.edu.ifes.poo2.xadrez.ciu.cih.TelaJogo;
import br.edu.ifes.poo2.xadrez.ciu.cih.TipoPecaGrafica;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * Controla o aplicativo, fazendo intermédio entre o modelo de dados e a
 * interface.
 *
 * @author lucas
 */
public enum Controlador {

    INSTANCE;

    /* Indica a casa que foi clicada na interface */
    private JPanelCasa primeiraCasaClicada;

    /**
     * Inicia a aplicação.
     */
    public void iniciarAplicacao() {
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

        /* Cria e exibe o formulário principal */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaJogo().setVisible(true);
            }
        });
    }

    /**
     * Processa os cliques dados as casas gráficas do tabuleiro.
     *
     * @param casaClicada A casa que no tabuleiro foi clicada.
     */
    public void cliqueCasa(JPanelCasa casaClicada) {
        if (primeiraCasaClicada == null) {
            // Deixa a casa selecionada.
            casaClicada.selecionar();

            // Guarda a casa que foi clicada
            primeiraCasaClicada = casaClicada;
        } else if (primeiraCasaClicada == casaClicada) {
            // Desfaça a seleção da casa.
            casaClicada.deselecionar();

            // Remove a referência a casa que anteriormente estava clicada.
            primeiraCasaClicada = null;
        } else {
            // Se for um peão, e a segunda casa clicada for do outro lado do tabuleiro.
            if ((primeiraCasaClicada.getPeca() == TipoPecaGrafica.PEAO_BRANCO
                    && casaClicada.getLinha() == 7)
                    || (primeiraCasaClicada.getPeca() == TipoPecaGrafica.PEAO_PRETO
                    && casaClicada.getLinha() == 0)) {

                // Cria um ComboBox com as peças para as quais o peão pode ser promovido.
                TipoPeca[] items = {
                    TipoPeca.BISPO,
                    TipoPeca.CAVALO,
                    TipoPeca.RAINHA,
                    TipoPeca.TORRE};
                JComboBox<TipoPeca> jPecas = new JComboBox<>(items);

                // Define os elementos que irão para o diálogo.
                Object[] content = {
                    "Para qual peça o peão deve ser promovido?",
                    jPecas};
                //JOptionPane.showConfirmDialog(null, content, "Selecione uma peça", JOptionPane.OK_CANCEL_OPTION);
                JOptionPane.showMessageDialog(null, content);

                // Captura qual peça foi selecionada.
                TipoPeca peca = (TipoPeca) jPecas.getSelectedItem();

                // TODO Executar jogada com promoção.
                System.out.println(peca);

                // TODO Deselecionar todas as casas.
            } else {
                // TODO Executar jogada sem promoção.

                // TODO Deselecionar todas as casas.
            }
        }
    }
}
