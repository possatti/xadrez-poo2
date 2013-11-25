/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leds
 */
public class PecasFactory {

    public Map<Cor, Peca[]> getPecas(int quantidade, String nomePeca) {
        Map<Cor, Peca[]> pecas;
        pecas = this.criarMapPecas(quantidade);
        try {
            this.instanciarPecas(pecas, nomePeca);
        } catch (Exception ex) {
            Logger.getLogger(PecasFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pecas;
    }

    /**
     *
     * @param quantidade A quantidade total de peças que se deseja criar.
     * @return Um Map que a cada cor associada, retorna um vetor vazio do tipo
     * Peça.
     */
    private Map<Cor, Peca[]> criarMapPecas(int quantidade) {
        Peca[] pecasBrancas;
        Peca[] pecasPretas;
        Map<Cor, Peca[]> pecas;
        pecasBrancas = new Peca[quantidade];
        pecasPretas = new Peca[quantidade];

        pecas = new HashMap<>();
        pecas.put(Cor.BRANCO, pecasBrancas);
        pecas.put(Cor.PRETO, pecasPretas);

        return pecas;
    }

    /**
     *
     * @param pecas Um mapa com dois vetores vazios de Pecas. As classes filhas
     * implementam suas respectivas classes.
     * @param nomePeca O nome do tipo de peças a serem criadas. Ex.: Peao,
     * Cavalo.
     * @throws java.lang.ClassNotFoundException
     */
    private void instanciarPecas(Map<Cor, Peca[]> pecas, String nomePeca) throws Exception {
        Peca[] pecasBrancas = pecas.get(Cor.BRANCO);
        Peca[] pecasPretas = pecas.get(Cor.PRETO);
        String nomePacote = "br.edu.ifes.poo1.xadrez.cdp.";
        Class c = Class.forName(nomePacote + nomePeca);

        for (int nPeca = 0; nPeca < pecasBrancas.length; nPeca++) {
            pecasBrancas[nPeca] = (Peca) c.newInstance();
            pecasBrancas[nPeca].setCor(Cor.BRANCO);
        }

        for (int nPeca = 0; nPeca < pecasPretas.length; nPeca++) {
            pecasPretas[nPeca] = new Torre();
            pecasPretas[nPeca].setCor(Cor.PRETO);
        }
    }
}
