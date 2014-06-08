package br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import static br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor.BRANCO;
import static br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor.PRETO;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.fabrica.FabricaPecasImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Setter;

public class Tabuleiro {

    @Setter
    private Map<String, Posicao> posicoes;

    /**
     * Pega uma posição do Tabuleiro
     *
     * @param id id da Posição. Ex.: {@code "11"} para coluna 1 e linha 1 ou
     * {@code "32"} para coluna 3 e linha 2
     * @return a Posicao pedida.
     */
    public Posicao getPosicao(String id) {
        return posicoes.get(id);
    }

    public Posicao getPosicaoRei(Cor cor) {
        Posicao posicaoRei = null;

        for (Map.Entry<String, Posicao> entry : posicoes.entrySet()) {
            Posicao posicao = entry.getValue();

            if (posicao.existePeca() && posicao.getPeca().getTipoPeca() == TipoPeca.REI
                    && posicao.getPeca().getCor() == cor) {
                posicaoRei = posicao;
            }
        }

        return posicaoRei;
    }

    /**
     * Pega todas as peças da cor dada.
     *
     * @param cor A cor das peças.
     * @return Uma lista com todas as peças da cor dada.
     */
    private List<Peca> getPecas(Cor cor) {
        List<Peca> pecas = new ArrayList<>();

        for (Map.Entry<String, Posicao> entry : posicoes.entrySet()) {
            Posicao posicao = entry.getValue();

            if (posicao.existePeca() && posicao.getPeca().getCor() == cor) {
                pecas.add(posicao.getPeca());
            }
        }

        return pecas;
    }

    @SuppressWarnings("null")
    public boolean isEnPassant(Posicao posicaoAtual, Posicao novaPosicao) {
        Peca peaoAtual;
        Posicao posicaoCaptura = null;
        boolean andouDuasCasas = false;
        char novaColuna = novaPosicao.getId().charAt(0);
        char novaLinha = novaPosicao.getId().charAt(1);

        if (!contemPeao(novaPosicao)
                || estaAndandoUmaColuna(posicaoAtual, novaPosicao)) {
            return false;
        }

        peaoAtual = posicaoAtual.getPeca();

        switch (peaoAtual.getCor()) {
            case BRANCO:
                posicaoCaptura = this.getPosicao("" + novaColuna + ((char) (novaLinha - 1)));
                andouDuasCasas = posicaoCaptura != null && posicaoCaptura.getId().charAt(1) == '5';
                break;
            case PRETO:
                posicaoCaptura = this.getPosicao("" + novaColuna + ((char) (novaLinha + 1)));
                andouDuasCasas = posicaoCaptura != null && posicaoCaptura.getId().charAt(1) == '4';
                break;
        }

        return andouDuasCasas
                && !novaPosicao.existePeca()
                && posicaoCaptura.existePeca()
                && posicaoCaptura.getPeca().getTipoPeca() == TipoPeca.PEAO
                && posicaoCaptura.getPeca().moveuUmaVez();
    }

    private boolean estaAndandoUmaColuna(Posicao posicaoAtual, Posicao novaPosicao) {
        return Math.abs(novaPosicao.getId().charAt(0) - posicaoAtual.getId().charAt(0)) == 1;
    }

    private boolean contemPeao(Posicao posicao) {
        return posicao.existePeca()
                && posicao.getPeca().getTipoPeca() == TipoPeca.PEAO;
    }

    /**
     * Verifica se o rei ficará em xeque com essa movimentação.
     *
     * @param posicaoAtual Posicao atual da peça.
     * @param posicaoFinal Movimento que deixará o rei em xeque.
     * @return {@code true} se for xeque ou {@code false} caso contrário.
     */
    public boolean isXeque(Posicao posicaoAtual, Posicao posicaoFinal) {
        Cor corAtual = posicaoAtual.getPeca().getCor();
        Cor corAdversaria;
        Peca copiaPecaAtual;
        boolean reiEmPerigo;

        copiaPecaAtual = copiaPecaNaPosicao(posicaoAtual);

        if (posicaoFinal.existePeca()) {
            return false;
        }

        switch (corAtual) {
            case BRANCO:
                corAdversaria = Cor.PRETO;
                break;
            case PRETO:
                corAdversaria = Cor.BRANCO;
                break;
            default:
                corAdversaria = null;
                break;
        }

        // Aqui verifico se o rei está em perigo.
        Posicao posicaoRei = this.getPosicaoRei(corAdversaria);
        posicaoFinal.setPeca(copiaPecaAtual);
        reiEmPerigo = copiaPecaAtual.validarMovimentoCaptura(posicaoRei);
        posicaoFinal.setPeca(null);

        // Se o movimento for válido e o rei estiver em perigo na nova posição, então é um Xeque.
        return posicaoAtual.getPeca().validarMovimento(posicaoFinal)
                && reiEmPerigo;
    }

    private Peca copiaPecaNaPosicao(Posicao posicao) {
        if (posicao.existePeca()) {
            Peca pecaOriginal = posicao.getPeca();
            return FabricaPecasImpl.getInstance().fabricarPeca(pecaOriginal.getCor(), pecaOriginal.getTipoPeca());
        } else {
            throw new NullPointerException();
        }
    }

    public boolean isXequeMate(Posicao posicaoAtual, Posicao posicaoFinal) {
        Cor corAdversario;
        Posicao posicaoRei;
        List<Posicao> posicoesEscape;
        List<Peca> pecas;
        boolean isXequeMate = true;

        if (!isXeque(posicaoAtual, posicaoFinal)) {
            return false;
        }

        if (posicaoAtual.getPeca().getCor() == Cor.BRANCO) {
            corAdversario = Cor.PRETO;
        } else {
            corAdversario = Cor.BRANCO;
        }

        posicaoRei = this.getPosicaoRei(corAdversario);
        posicoesEscape = posicoesEscapeRei(posicaoRei);
        pecas = this.getPecas(posicaoAtual.getPeca().getCor());

        for (Posicao posicaoEscape : posicoesEscape) {
            boolean posicaoAmeacada = false;
            for (Peca peca : pecas) {
                if (peca.validarMovimento(posicaoEscape) || peca.validarMovimentoCaptura(posicaoEscape)) {
                    posicaoAmeacada = posicaoAmeacada || true;
                }
            }
            isXequeMate = isXequeMate && posicaoAmeacada;
        }

        return isXequeMate;
    }

    /**
     * Acha todas as posições que um rei pode escapar, pelo movimento ou pela
     * captura de alguma outra peça.
     *
     * @param posicaoRei A posição que o rei se encontra.
     * @return Uma lista com as possíveis posições.
     */
    private List<Posicao> posicoesEscapeRei(Posicao posicaoRei) {
        List<Posicao> posicoesRei = new ArrayList<>();
        Peca rei = posicaoRei.getPeca();
        List<String> idPosicoesPossiveis = new ArrayList<>();
        char colunaAtual = posicaoRei.getId().charAt(0);
        char linhaAtual = posicaoRei.getId().charAt(1);

        //Norte
        idPosicoesPossiveis.add("" + colunaAtual + ((char) (linhaAtual + 1)));
        //Sul
        idPosicoesPossiveis.add("" + colunaAtual + ((char) (linhaAtual - 1)));
        //Leste
        idPosicoesPossiveis.add("" + ((char) (colunaAtual + 1)) + linhaAtual);
        //Oeste
        idPosicoesPossiveis.add("" + ((char) (colunaAtual - 1)) + linhaAtual);
        //Noroeste
        idPosicoesPossiveis.add("" + ((char) (colunaAtual - 1)) + ((char) (linhaAtual + 1)));
        //Nordeste
        idPosicoesPossiveis.add("" + ((char) (colunaAtual + 1)) + ((char) (linhaAtual + 1)));
        //Sudoeste
        idPosicoesPossiveis.add("" + ((char) (colunaAtual - 1)) + ((char) (linhaAtual - 1)));
        //Sudeste
        idPosicoesPossiveis.add("" + ((char) (colunaAtual - 1)) + ((char) (linhaAtual - 1)));

        for (String idPosicao : idPosicoesPossiveis) {
            Posicao posicaoPossivel = this.getPosicao(idPosicao);
            if (posicaoPossivel != null
                    && (rei.validarMovimento(posicaoPossivel) || rei.validarMovimentoCaptura(posicaoPossivel))) {
                posicoesRei.add(posicaoPossivel);
            }
        }

        return posicoesRei;
    }

    /**
     * Verifica se é um RoqueMaior.
     *
     * @param posicaoAtual É a posição inicial do rei.
     * @return {@code true} se é um roque maior ou {@code false} caso contrário.
     */
    public boolean isRoqueMaior(Posicao posicaoAtual) {
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunhaAtual = posicaoAtual.getId().charAt(0);
        Posicao posicaoTorre = this.getPosicao("1" + linhaAtual);
        List<String> caminho = new ArrayList<>();

        for (int nCaminho = 1; nCaminho < 3; nCaminho++) {
            caminho.add("" + ((char) (colunhaAtual - nCaminho)) + linhaAtual);
        }

        return (posicaoAtual.existePeca()
                && !posicaoAtual.getPeca().jaMovimentou()
                && posicaoAtual.getPeca().getTipoPeca() == TipoPeca.REI)
                && haPeca(caminho)
                && posicaoTorre.existePeca()
                && !posicaoTorre.getPeca().jaMovimentou();
    }

    /**
     * Verifica se é um roque menor.
     *
     * @param posicaoAtual A posição inicial do Rei.
     * @return {@code true} se é um roque maior ou {@code false} caso contrário.
     */
    public boolean isRoqueMenor(Posicao posicaoAtual) {
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunhaAtual = posicaoAtual.getId().charAt(0);
        Posicao posicaoTorre = this.getPosicao("8" + linhaAtual);
        List<String> caminho = new ArrayList<>();

        for (int nCaminho = 1; nCaminho < 3; nCaminho++) {
            caminho.add("" + ((char) (colunhaAtual + nCaminho)) + linhaAtual);
        }

        return (posicaoAtual.existePeca()
                && !posicaoAtual.getPeca().jaMovimentou()
                && posicaoAtual.getPeca().getTipoPeca() == TipoPeca.REI)
                && haPeca(caminho)
                && posicaoTorre.existePeca()
                && !posicaoTorre.getPeca().jaMovimentou();
    }

    private boolean haPeca(List<String> caminho) {

        for (String idPosicao : caminho) {
            if (this.getPosicao(idPosicao).existePeca() == true) {
                return true;
            }
        }

        return false;
    }
}
