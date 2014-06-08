package br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import java.util.ArrayList;
import java.util.List;

public class StrategyBispo extends StrategyPecaImpl {

    @Override
    public boolean validarMovimento(Posicao posicaoAnterior, Posicao novaPosicao) {
        List<String> caminho = caminhoDiagonal(posicaoAnterior, novaPosicao);

        //O movimento só é válido quando for diagonal, não houver peças em seu caminho e não existir nenhuma peça na nova posição.
        return ehCaminhoDiagonal(posicaoAnterior, novaPosicao) && !haPecas(caminho, posicaoAnterior.getTabuleiro()) && !novaPosicao.existePeca();
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao posicaoAnterior, Posicao novaPosicao) {
        List<String> caminho = caminhoDiagonal(posicaoAnterior, novaPosicao);
        Cor corAtual = posicaoAnterior.getPeca().getCor();

        //O movimento só é válido quando for diagonal, não houver peças em seu caminho,
        return ehCaminhoDiagonal(posicaoAnterior, novaPosicao) && !haPecas(caminho, posicaoAnterior.getTabuleiro())
                //existir uma peça na nova posição e esta peça for de outra cor.
                && novaPosicao.existePeca() && novaPosicao.getPeca().getCor() != corAtual;
    }

    /**
     * Verifica se a diagonal está vazia ate uma posiçao diagonal antes da peca
     * a ser capturada.
     *
     * @param posicaoAtual A posição atual da peça.
     * @param novaPosicao A nova posição da peça.
     * @return Uma lista com todos o caminho diagonal de uma posição a outra.
     */
    public List<String> caminhoDiagonal(Posicao posicaoAtual, Posicao novaPosicao) {
        List<String> caminho;

        super.setVariaveis(posicaoAtual, posicaoAtual);

        if (linhaNova > linhaAtual && colunaNova > colunaAtual) {
            caminho = getCaminhoNordeste();
        } else if (linhaNova > linhaAtual && colunaAtual > colunaNova) {
            caminho = getCaminhoNoroeste();
        } else if (linhaAtual > linhaNova && colunaAtual > colunaNova) {
            caminho = getCaminhoSudoeste();
        } else if (linhaAtual > linhaNova && colunaNova > colunaAtual) {
            caminho = getCaminhoSudeste();
        } else {
            throw new RuntimeException("Não foi possível gerar um caminho reto para a peça selecionada.");
        }

        return caminho;
    }

    private List<String> getCaminhoSudeste() {
        List<String> caminho = new ArrayList<>();
        char colunaCaminho = colunaAtual;
        char linhaCaminho = linhaAtual;

        linhaCaminho--;
        colunaCaminho++;
        while ((linhaCaminho) > linhaNova && (colunaCaminho) < colunaNova) {
            caminho.add("" + colunaCaminho + linhaCaminho);
            linhaCaminho--;
            colunaCaminho++;
        }

        return caminho;
    }

    private List<String> getCaminhoSudoeste() {
        List<String> caminho = new ArrayList<>();
        char colunaCaminho = colunaAtual;
        char linhaCaminho = linhaAtual;

        linhaCaminho--;
        colunaCaminho--;
        while ((linhaCaminho) > linhaNova && (colunaCaminho) > colunaNova) {
            caminho.add("" + colunaCaminho + linhaCaminho);
            linhaCaminho--;
            colunaCaminho--;
        }

        return caminho;
    }

    private List<String> getCaminhoNordeste() {
        List<String> caminho = new ArrayList<>();
        char colunaCaminho = colunaAtual;
        char linhaCaminho = linhaAtual;

        linhaCaminho++;
        colunaCaminho++;
        while ((linhaCaminho) < linhaNova && (colunaCaminho) < colunaNova) {
            caminho.add("" + colunaCaminho + linhaCaminho);
            linhaCaminho++;
            colunaCaminho++;
        }

        return caminho;
    }

    private List<String> getCaminhoNoroeste() {
        List<String> caminho = new ArrayList<>();
        char colunaCaminho = colunaAtual;
        char linhaCaminho = linhaAtual;

        linhaCaminho++;
        colunaCaminho--;
        while ((linhaCaminho) < linhaNova && (colunaCaminho) > colunaNova) {
            caminho.add("" + colunaCaminho + linhaCaminho);
            linhaCaminho++;
            colunaCaminho--;
        }

        return caminho;
    }

}
