package br.edu.ifes.poo2.xadrez.cln.cgt;

import br.edu.ifes.poo2.xadrez.cln.cdp.InteligenciaArtificial;
import br.edu.ifes.poo2.xadrez.cln.cdp.Partida;
import br.edu.ifes.poo2.xadrez.cln.cdp.Jogador;
import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.TipoPartida;
import br.edu.ifes.poo2.xadrez.cln.cdp.dto.PecaDTO;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroCreator;
import br.edu.ifes.poo2.xadrez.util.exceptions.PosicaoInvalidaException;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

public class AplPartida {

    private Partida partidaAtual;

    private final InteligenciaArtificial inteligenciaArtificial;

    private final TabuleiroCreator tabuleiroCreator;

    private final Mapper mapper;

    public AplPartida() {
        this.inteligenciaArtificial = InteligenciaArtificial.getInstance();
        this.tabuleiroCreator = TabuleiroCreator.getInstance();
        this.mapper = DozerBeanMapperSingletonWrapper.getInstance();
    }

    private enum Operacao {

        MOVIMENTO, CAPTURA, PROMOCAO, RMAIOR, RMENOR, XEQUE, XMATE;
    }

    public void fazerJogada(String posicaoInicialId, String posicaoFinalId) {
        Operacao tipoJogada;
        Posicao posicaoInicial, posicaoFinal;

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
                this.executarRoqueMaior(posicaoInicial);
                break;
            case RMENOR:
                this.executarRoqueMenor(posicaoInicial);
                break;
            case XEQUE:
                posicaoFinal = getPosicaoTabuleiro(posicaoFinalId);
                posicaoFinal.setPeca(posicaoInicial.getPeca());
                break;
            case XMATE:
                break;
            case PROMOCAO:
                break;
            default:
                break;
        }
    }

    private void executarRoqueMaior(Posicao posicaoInicial) {
        char linhaAtual = posicaoInicial.getId().charAt(1);

        Peca rei = posicaoInicial.getPeca();
        Peca torre = getPosicaoTabuleiro("a" + linhaAtual).getPeca();
        getPosicaoTabuleiro("c" + linhaAtual).setPeca(rei);
        getPosicaoTabuleiro("d" + linhaAtual).setPeca(torre);
    }

    private void executarRoqueMenor(Posicao posicaoInicial) {
        char linhaAtual = posicaoInicial.getId().charAt(1);

        Peca rei = posicaoInicial.getPeca();
        Peca torre = getPosicaoTabuleiro("h" + linhaAtual).getPeca();
        this.getPosicaoTabuleiro("g" + linhaAtual).setPeca(rei);
        this.getPosicaoTabuleiro("f" + linhaAtual).setPeca(torre);
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

    public void criarPartida(Jogador jogadorBranco, Jogador jogadorPreto, TipoPartida tipoPartida) {
        Tabuleiro novoTabuleiro;

        novoTabuleiro = tabuleiroCreator.criarTabuleiro();

        this.partidaAtual = new Partida(jogadorBranco, jogadorPreto, novoTabuleiro, tipoPartida);
    }

    public PecaDTO[][] getTabuleiro() {
        PecaDTO[][] tabuleiro = new PecaDTO[8][8];
        Posicao posicaoTemp;

        int coluna = 0;
        for (char colunaChar = 'a'; colunaChar < 'i'; colunaChar++) {
            int linha = 0;
            for (char linhaChar = '1'; linhaChar < '9'; linhaChar++) {
                posicaoTemp = this.partidaAtual.getTabuleiro().getPosicao("" + colunaChar + linhaChar);
                tabuleiro[coluna][linha] = posicaoTemp.existePeca() ? mapper.map(posicaoTemp.getPeca(), PecaDTO.class) : null;
                linha++;
            }
            coluna++;
        }

        return tabuleiro;
    }

    /**
     * Carrega uma partida salva no banco de dados.
     *
     * @param id O identificador da partida.
     */
    public void carregarPartida(String id) {
        throw new UnsupportedOperationException("Não implementado ainda!");
    }

}
