/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;

/**
 *
 * @author phillipe
 */
public class StrategyRainha extends StrategyPecaImpl {

    StrategyTorre strategyTorre = new StrategyTorre();
    StrategyBispo strategyBispo = new StrategyBispo();

    @Override
    public boolean validarMovimento(Posicao posicaoAnterior, Posicao novaPosicao) {
        return strategyBispo.validarMovimento(posicaoAnterior, novaPosicao)
                || strategyTorre.validarMovimento(posicaoAnterior, novaPosicao);
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao posicaoAnterior, Posicao novaPosicao) {
        return strategyBispo.validarMovimentoCaptura(posicaoAnterior, novaPosicao)
                || strategyTorre.validarMovimentoCaptura(posicaoAnterior, novaPosicao);
    }

}
