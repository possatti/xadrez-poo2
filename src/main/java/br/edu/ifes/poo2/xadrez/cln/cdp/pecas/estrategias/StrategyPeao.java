package br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import static br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor.BRANCO;
import static br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor.PRETO;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import java.util.ArrayList;
import java.util.List;

public class StrategyPeao extends StrategyPecaImpl {

    @Override
    public boolean validarMovimento(Posicao posicaoAnterior, Posicao novaPosicao) {
        List<String> caminho;
        Peca pecaAtual = posicaoAnterior.getPeca();
        caminho = criarCaminho(pecaAtual.getCor());
        int linhasAndadas = linhaNova - linhaAtual;

        super.setVariaveis(posicaoAnterior, novaPosicao);

        /**
         * Se não for o primeiro movimento, então o Peão anda apenas uma casa. O
         * peão anda duas ou uma casa, caso contrário.
         */
        if (pecaAtual.jaMovimentou()) {
            switch (pecaAtual.getCor()) {
                case BRANCO:
                    return (linhasAndadas == 1 && colunaAtual == colunaNova && !novaPosicao.existePeca());
                case PRETO:
                    return (linhasAndadas == -1 && colunaAtual == colunaNova && !novaPosicao.existePeca());
            }
        } else {
            switch (pecaAtual.getCor()) {
                case BRANCO:
                    return ((linhasAndadas == 2 || linhasAndadas == 1) && colunaAtual == colunaNova && !haPecas(caminho, posicaoAnterior.getTabuleiro()));
                case PRETO:
                    return ((linhasAndadas == -2 || linhasAndadas == -1) && colunaAtual == colunaNova && !haPecas(caminho, posicaoAnterior.getTabuleiro()));
            }
        }

        return false;
    }

    /**
     * Define o caminho pelo qual a peça deve passar.
     *
     * @param corAtual A cor atual da peça
     * @return Uma lista com as Strings que representam as posições.
     */
    private List<String> criarCaminho(Cor corAtual) {
        List<String> caminho = new ArrayList<>();

        if (corAtual == Cor.PRETO) {
            caminho.add("" + colunaAtual + (char) (linhaAtual - 1));
            caminho.add("" + colunaAtual + (char) (linhaAtual - 2));
        } else {
            caminho.add("" + colunaAtual + (char) (linhaAtual + 1));
            caminho.add("" + colunaAtual + (char) (linhaAtual + 2));
        }

        return caminho;
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao posicaoAnterior, Posicao novaPosicao) {
        super.setVariaveis(posicaoAnterior, novaPosicao);

        /**
         * Se a peça não existir, então não há captura e um movimento deverá ser
         * realizado.
         */
        if (novaPosicao.existePeca() && (novaPosicao.getPeca().getCor() != posicaoAnterior.getPeca().getCor())) {
            /**
             * Se a peça for branca, verificamos nas diagonais para cima, caso
             * contrário verificamos as diagonais abaixo.
             */
            if (posicaoAnterior.getPeca().getCor() == Cor.BRANCO) {
                return (Math.abs(colunaAtual - colunaNova) == 1) && ((linhaNova - linhaAtual) == 1);
            } else {
                return (Math.abs(colunaAtual - colunaNova) == 1) && ((linhaNova - linhaAtual) == -1);
            }
        } else {
            return false;
        }
    }
}
