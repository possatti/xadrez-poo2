package br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;

public class StrategyCavalo extends StrategyPecaImpl {

    @Override
    public boolean validarMovimento(Posicao posicaoAnterior, Posicao novaPosicao) {
        super.setVariaveis(posicaoAnterior, novaPosicao);

        if (!novaPosicao.existePeca()) {
            return ((Math.abs(colunaAtual - colunaNova) == 2) && (Math.abs(linhaAtual - linhaNova) == 1))
                    || ((Math.abs(colunaAtual - colunaNova) == 1) && (Math.abs(linhaAtual - linhaNova) == 2));
        }
        return false;
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao posicaoAnterior, Posicao novaPosicao) {
        super.setVariaveis(posicaoAnterior, novaPosicao);
        Cor corAtual = posicaoAnterior.getPeca().getCor();

        if (novaPosicao.existePeca() && novaPosicao.getPeca().getCor() != corAtual) {
            return ((Math.abs(colunaAtual - colunaNova) == 2) && (Math.abs(linhaAtual - linhaNova) == 1))
                    || ((Math.abs(colunaAtual - colunaNova) == 1) && (Math.abs(linhaAtual - linhaNova) == 2));
        }
        return false;
    }

}
