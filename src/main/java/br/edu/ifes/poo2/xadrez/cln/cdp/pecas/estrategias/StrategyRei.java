package br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;

public class StrategyRei extends StrategyPecaImpl {

    @Override
    public boolean validarMovimento(Posicao posicaoAnterior, Posicao novaPosicao) {
        setVariaveis(posicaoAnterior, novaPosicao);

        return !novaPosicao.existePeca() && Math.abs(colunaAtual - colunaNova) <= 1 && Math.abs(linhaAtual - linhaNova) <= 1;
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao posicaoAnterior, Posicao novaPosicao) {
        setVariaveis(posicaoAnterior, novaPosicao);
        Cor corAtual = posicaoAnterior.getPeca().getCor();

        //Tem que existir alguma peça na nova posição, além de serem de cores diferentes.
        return novaPosicao.existePeca() && novaPosicao.getPeca().getCor() != corAtual
                //O movimento tem que ser o mesmo que o de validar movimento.
                && Math.abs(colunaAtual - colunaNova) <= 1 && Math.abs(linhaAtual - linhaNova) <= 1;
    }

}
