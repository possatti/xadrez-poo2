package br.edu.ifes.poo2.xadrez.cln.cgt;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import br.edu.ifes.poo2.xadrez.cln.cdp.Jogador;
import br.edu.ifes.poo2.xadrez.cln.cdp.Partida;
import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.TipoPartida;
import br.edu.ifes.poo2.xadrez.cln.cdp.dto.PecaDTO;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroCreator;
import br.edu.ifes.poo2.xadrez.util.exceptions.JogadaInvalidaException;
import br.edu.ifes.poo2.xadrez.util.exceptions.PosicaoInvalidaException;

public class AplPartida {

    private Partida partidaAtual;

    private final TabuleiroCreator tabuleiroCreator;

    private final Mapper mapper;

    public AplPartida() {
        this.tabuleiroCreator = TabuleiroCreator.getInstance();
        this.mapper = DozerBeanMapperSingletonWrapper.getInstance();
    }

    private enum Operacao {

        MOVIMENTO, CAPTURA, PROMOCAO, RMAIOR, RMENOR, XEQUE, XMATE;
    }

    /**
     * Executa uma jogada na partida atual.
     *
     * @param posicaoInicialId
     *            A string que representa a posição inicial da jogada. Exemplo:
     *            "{@literal a1}".
     * @param posicaoFinalId
     *            A string que representa a posição final da jogada, exceto para
     *            jogadas como Roque maior e Roque menor, onde apenas a posição
     *            do Rei é necessária.
     * @throws JogadaInvalidaException
     *             É lançada quando não existe nenhuma peça na
     *             {@code posicaoInicialId} ou quando não é a vez do jogador e
     *             ele tenta fazer uma jogada.
     */
    public void fazerJogada(String posicaoInicialId, String posicaoFinalId) {
        Operacao tipoJogada;
        Posicao posicaoInicial, posicaoFinal;

        posicaoInicial = getPosicaoTabuleiro(posicaoInicialId);

        if (!posicaoInicial.existePeca() || !ehJogadorAtual(posicaoInicial)) {
            throw new JogadaInvalidaException("Jogada inválida!");
        }

        tipoJogada = identificarOperacao(posicaoInicialId, posicaoFinalId);

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

        partidaAtual.trocaJogadorDaVez();
    }

    private boolean ehJogadorAtual(Posicao posicaoInicial) {
        return posicaoInicial.existePeca() && posicaoInicial.getPeca().getCor() == partidaAtual.getCor(partidaAtual.getJogadorDaVez());
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

        posicaoInicial = getPosicaoTabuleiro(posicaoInicialId);

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
        if (!validarStringPosicao(posicao)) {
            throw new PosicaoInvalidaException("Posição " + posicao + " é inválida!");
        }

        return this.partidaAtual.getTabuleiro().getPosicao(posicao);
    }

    public void criarPartida(Jogador jogadorBranco, Jogador jogadorPreto, TipoPartida tipoPartida) {
        Tabuleiro novoTabuleiro;

        novoTabuleiro = tabuleiroCreator.criarTabuleiro();

        this.partidaAtual = new Partida(jogadorBranco, jogadorPreto, novoTabuleiro, tipoPartida);
    }

    /**
     * Retorna uma representação do estado atual do tabuleiro com as peças.
     *
     * @return Uma matriz de {@code PecaDTO}, onde o primeiro índice da matriz
     *         representa as colunas e o segundo índice representa as linhas. No
     *         caso as colunas a correspondência se dá da seguinte forma: a -> 0
     *         b -> 1, sucessivamente. Para as linhas é só subtrair 1: 1 -> 0 2
     *         -> 1, sucessivamente.
     */
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
     * @param id
     *            O identificador da partida.
     */
    public void carregarPartida(String id) {
        throw new UnsupportedOperationException("Não implementado ainda!");
    }

    public String getNomeJogador(Cor cor) {
        return cor == Cor.BRANCO ? partidaAtual.getJogadorBranco().getNome() : partidaAtual.getJogadorPreto().getNome();
    }
}
