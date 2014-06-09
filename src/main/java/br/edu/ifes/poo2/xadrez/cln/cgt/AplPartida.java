package br.edu.ifes.poo2.xadrez.cln.cgt;

import br.edu.ifes.poo2.xadrez.cln.cdp.InteligenciaArtificial;
import br.edu.ifes.poo2.xadrez.cln.cdp.Partida;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroBuilderImpl;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroDirector;
import br.edu.ifes.poo2.xadrez.cln.cdp.Jogador;
import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;
import br.edu.ifes.poo2.xadrez.util.exceptions.PosicaoInvalidaException;

public class AplPartida {

    private Partida partidaAtual;

    private final InteligenciaArtificial inteligenciaArtificial;

    private final TabuleiroBuilderImpl tabuleiroBuilder;

    private final TabuleiroDirector tabuleiroDirector;

    public AplPartida() {
        this.inteligenciaArtificial = InteligenciaArtificial.getInstance();
        this.tabuleiroBuilder = new TabuleiroBuilderImpl();
        this.tabuleiroDirector = new TabuleiroDirector(tabuleiroBuilder);
    }

    private enum Operacao {

        MOVIMENTO, CAPTURA, PROMOCAO, RMAIOR, RMENOR, XEQUE, XMATE;
    }

    private void fazerJogada() {

    }

    public void fazerJogada(String posicaoInicialId, String posicaoFinalId) {
        Operacao tipoJogada;
        Posicao posicaoInicial, posicaoFinal;
        Peca rei, torre;
        char linhaAtual;

        tipoJogada = identificarOperacao(posicaoInicialId, posicaoFinalId);
        posicaoInicial = getPosicaoTabuleiro(posicaoInicialId);

        switch (tipoJogada) {
            case MOVIMENTO:
                posicaoFinal = getPosicaoTabuleiro(posicaoFinalId);
                posicaoFinal.setPeca(posicaoInicial.getPeca());
                break;
            case CAPTURA:
                posicaoFinal = getPosicaoTabuleiro(posicaoFinalId);
                posicaoFinal.setPeca(posicaoInicial.getPeca());
                break;
            case RMAIOR:
                linhaAtual = posicaoInicial.getId().charAt(1);
                rei = posicaoInicial.getPeca();
                torre = getPosicaoTabuleiro("a" + linhaAtual).getPeca();
                getPosicaoTabuleiro("c" + linhaAtual).setPeca(rei);
                getPosicaoTabuleiro("d" + linhaAtual).setPeca(torre);
                break;
            case RMENOR:
                linhaAtual = posicaoInicial.getId().charAt(1);
                rei = posicaoInicial.getPeca();
                torre = this.getPosicaoTabuleiro("h" + linhaAtual).getPeca();
                this.getPosicaoTabuleiro("g" + linhaAtual).setPeca(rei);
                this.getPosicaoTabuleiro("f" + linhaAtual).setPeca(torre);
                break;
            case XEQUE:
                posicaoFinal = getPosicaoTabuleiro(posicaoFinalId);
                posicaoFinal.setPeca(posicaoInicial.getPeca());
                break;
            case XMATE:
                break;
            case PROMOCAO:
                break;
        }
    }

    private void executaMovimento(Posicao posicaoInicial, Posicao posicaoFinal) {

    }

    private Operacao identificarOperacao(String posicaoInicialId, String posicaoFinalId) {
        Posicao posicaoInicial;
        Posicao posicaoFinal;
        Peca pecaTmp;
        Tabuleiro tabuleiro = this.partidaAtual.getTabuleiro();

        if (!validarStringPosicao(posicaoInicialId)) {
            throw new PosicaoInvalidaException("Posição " + posicaoFinalId + " é inválida!");
        } else {
            posicaoInicial = getPosicaoTabuleiro(posicaoInicialId);
        }

        if (posicaoFinalId == null || posicaoFinalId.matches("")) {
            if (tabuleiro.isRoqueMaior(posicaoInicial)) {
                return Operacao.RMAIOR;
            } else if (tabuleiro.isRoqueMenor(posicaoInicial)) {
                return Operacao.RMENOR;
            }
        } else if (validarStringPosicao(posicaoFinalId)) {
            posicaoFinal = getPosicaoTabuleiro(posicaoFinalId);
            pecaTmp = posicaoInicial.getPeca();

            if (tabuleiro.isXeque(posicaoInicial, posicaoFinal)) {
                return Operacao.XEQUE;
            } else if (tabuleiro.isXequeMate(posicaoInicial, posicaoFinal)) {
                return Operacao.XMATE;
            } else if (pecaTmp.validarMovimento(posicaoFinal)) {
                return Operacao.MOVIMENTO;
            } else if (pecaTmp.validarMovimentoCaptura(posicaoFinal)) {
                return Operacao.CAPTURA;
            }
        }

        throw new PosicaoInvalidaException("Não foi possível identificar o tipo da jogada!");
    }

    private boolean validarStringPosicao(String posicao) {
        return posicao.matches("([a-h]{1}[1-8]{1})");
    }

    private Posicao getPosicaoTabuleiro(String posicao) {
        return this.partidaAtual.getTabuleiro().getPosicao(posicao);
    }

    public void criarPartida(Jogador jogadorBranco, Jogador jogadorPreto) {
        Tabuleiro novoTabuleiro;

        tabuleiroDirector.criarTabuleiro();
        novoTabuleiro = tabuleiroBuilder.getTabuleiro();

        this.partidaAtual = new Partida(jogadorBranco, jogadorPreto, novoTabuleiro);
    }

    public void getTabuleiro() {

    }

    public void carregarPartida(String id) {

    }

}
