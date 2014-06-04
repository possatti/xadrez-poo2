package br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import java.util.ArrayList;
import java.util.List;

public class StrategyTorre extends StrategyPecaImpl {

    @Override
    public boolean validarMovimento(Posicao posicaoAnterior, Posicao novaPosicao) {
        List<String> caminho;

        super.setVariaveis(posicaoAnterior, novaPosicao);

        if (!novaPosicao.existePeca()) {
            caminho = caminhoReto(posicaoAnterior, novaPosicao);
            return ehCaminhoReto(posicaoAnterior, novaPosicao) && !haPecas(caminho, posicaoAnterior.getTabuleiro());
        }

        return false;
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao posicaoAnterior, Posicao novaPosicao) {
        List<String> caminho;
        Cor corAtual = posicaoAnterior.getPeca().getCor();

        if (novaPosicao.existePeca() && novaPosicao.getPeca().getCor() != corAtual) {
            caminho = caminhoReto(posicaoAnterior, novaPosicao);
            return ehCaminhoReto(posicaoAnterior, novaPosicao) && !haPecas(caminho, posicaoAnterior.getTabuleiro());
        }

        return false;
    }

    /**
     * Verifica se a reta está vazia ate uma posiçao antes da peca a ser
     * capturada
     *
     * @param posicaoAtual A posição atual.
     * @param novaPosicao A nova posição da peça.
     * @return Uma lista com todos o caminho reto de uma posição a outra.
     */
    public List<String> caminhoReto(Posicao posicaoAtual, Posicao novaPosicao) {
        List<String> caminho;

        //Norte
        if (colunaAtual == colunaNova && linhaAtual < linhaNova) {
            caminho = getCaminhoNorte();
        } //Leste
        else if (colunaAtual < colunaNova && linhaAtual == linhaNova) {
            caminho = getCaminhoLeste();
        } //Sul
        else if (colunaAtual == colunaNova && linhaAtual > linhaNova) {
            caminho = getCaminhoSul();
        } //Oeste
        else if (colunaAtual > colunaNova && linhaAtual == linhaNova) {
            caminho = getCaminhoOeste();
        } else {
            throw new RuntimeException("Não foi possível gerar um caminho reto para a peça selecionada.");
        }

        return caminho;
    }

    List<String> getCaminhoLeste() {
        List<String> caminho = new ArrayList<>();
        char colunaCaminho = colunaAtual;

        colunaCaminho++;
        while (colunaCaminho < colunaNova) {
            caminho.add("" + colunaCaminho + linhaAtual);
            colunaCaminho++;
        }

        return caminho;
    }

    List<String> getCaminhoOeste() {
        List<String> caminho = new ArrayList<>();
        char colunaCaminho = colunaAtual;

        colunaCaminho--;
        while (colunaCaminho > colunaNova) {
            caminho.add("" + colunaCaminho + linhaAtual);
            colunaCaminho--;
        }

        return caminho;
    }

    List<String> getCaminhoSul() {
        List<String> caminho = new ArrayList<>();
        char linhaCaminho = linhaAtual;

        linhaCaminho--;
        while (linhaCaminho > linhaNova) {
            caminho.add("" + colunaAtual + linhaCaminho);
            linhaCaminho--;
        }

        return caminho;
    }

    List<String> getCaminhoNorte() {
        List<String> caminho = new ArrayList<>();
        char linhaCaminho = linhaAtual;

        linhaCaminho++;
        while (linhaCaminho < linhaNova) {
            caminho.add("" + colunaAtual + linhaCaminho);
            linhaCaminho++;
        }

        return caminho;
    }

}
