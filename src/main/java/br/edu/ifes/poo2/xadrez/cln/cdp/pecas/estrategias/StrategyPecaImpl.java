package br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import java.util.List;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;

public abstract class StrategyPecaImpl implements StrategyPeca {

    private char colunaAtual;
    private char linhaAtual;
    private char colunaNova;
    private char linhaNova;

    private void setVariaveis(Posicao posicaoInicial, Posicao posicaoFinal) {
        colunaAtual = posicaoInicial.getId().charAt(0);
        linhaAtual = posicaoInicial.getId().charAt(1);
        colunaNova = posicaoFinal.getId().charAt(0);
        linhaNova = posicaoFinal.getId().charAt(1);

    }

    protected boolean ehCaminhoReto(Posicao posicaoInicial, Posicao posicaoFinal) {
        setVariaveis(posicaoInicial, posicaoFinal);

        return ((colunaAtual - colunaNova) == 0) || ((linhaAtual - linhaNova) == 0);
    }

    protected boolean ehCaminhoDiagonal(Posicao posicaoInicial, Posicao posicaoFinal) {
        setVariaveis(posicaoInicial, posicaoFinal);

        return Math.abs(colunaAtual - colunaNova) == Math.abs(linhaAtual - linhaNova);
    }

    protected boolean haPecas(List<String> caminho, Tabuleiro tabuleiro) {

        for (String idPosicao : caminho) {
            if (tabuleiro.getPosicao(idPosicao).existePeca() == true) {
                return true;
            }
        }

        return false;
    }

}
