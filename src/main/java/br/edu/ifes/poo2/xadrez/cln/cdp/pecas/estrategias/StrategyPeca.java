package br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;

public interface StrategyPeca {

    public abstract boolean validarMovimento(Posicao posicaoAnterior, Posicao novaPosicao);

    public abstract boolean validarMovimentoCaptura(Posicao posicaoAnterior, Posicao novaPosicao);

}
