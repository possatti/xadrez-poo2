package br.edu.ifes.poo2.xadrez.cln.cgt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.ifes.poo2.xadrez.cln.cdp.Jogador;
import br.edu.ifes.poo2.xadrez.cln.cdp.TipoPartida;
import br.edu.ifes.poo2.xadrez.cln.cdp.dto.PecaDTO;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca;
import br.edu.ifes.poo2.xadrez.util.exceptions.JogadaInvalidaException;
import br.edu.ifes.poo2.xadrez.util.exceptions.PosicaoInvalidaException;

/**
 *
 * @author phillipe
 */
public class AplPartidaTest {

    private AplPartida aplPartida;
    private Jogador jogadorBranco, jogadorPreto;
    private final int LINHA_PEAO_BRANCO = 1;
    private final int LINHA_PEAO_PRETO = 6;
    private final String NOME_JOGADOR_BRANCO = "Jogador Branco";
    private final String NOME_JOGADOR_PRETO = "Jogador Preto";

    @Before
    public void before() {
        this.aplPartida = new AplPartida();
        this.jogadorBranco = new Jogador(NOME_JOGADOR_BRANCO);
        this.jogadorPreto = new Jogador(NOME_JOGADOR_PRETO);
        this.aplPartida.criarPartida(jogadorBranco, jogadorPreto, TipoPartida.MULTIPLAYER);
    }

    @Test
    public void getTabuleiroTest() {
        PecaDTO[][] tabuleiro = aplPartida.getTabuleiro();

        for (int coluna = 0; coluna < 8; coluna++) {
            Assert.assertEquals(TipoPeca.PEAO, tabuleiro[coluna][LINHA_PEAO_BRANCO].getTipoPeca());
            Assert.assertEquals(Cor.BRANCO, tabuleiro[coluna][LINHA_PEAO_BRANCO].getCor());
            Assert.assertEquals(TipoPeca.PEAO, tabuleiro[coluna][LINHA_PEAO_PRETO].getTipoPeca());
            Assert.assertEquals(Cor.PRETO, tabuleiro[coluna][LINHA_PEAO_PRETO].getCor());
        }

        for (int coluna = 0; coluna < 8; coluna++) {
            Assert.assertEquals(Cor.BRANCO, tabuleiro[coluna][0].getCor());
            Assert.assertEquals(Cor.PRETO, tabuleiro[coluna][7].getCor());
        }
    }

    @Test(expected = JogadaInvalidaException.class)
    public void fazerJogadaInvalidaSemPecaTest() {
        this.aplPartida.fazerJogada("h3", "h4");
    }

    @Test(expected = JogadaInvalidaException.class)
    public void fazerJogadaInvalidaJogadorDaVezTest() {
        this.aplPartida.fazerJogada("a7", "a6");
    }

    @Test(expected = PosicaoInvalidaException.class)
    public void fazerJogadaPosicaoInvalidaTest() {
        this.aplPartida.fazerJogada("d1", "d3");
    }

    @Test(expected = PosicaoInvalidaException.class)
    public void fazerJogadaPosicaoInvalidaStringTest() {
        this.aplPartida.fazerJogada("j1", "d3");
    }

    @Test
    public void fazerJogadaMovimentoTest() {
        this.aplPartida.fazerJogada("a2", "a4");
        this.aplPartida.fazerJogada("e7", "e5");
        this.aplPartida.fazerJogada("b2", "b3");
        this.aplPartida.fazerJogada("g8", "h6");

        Assert.assertNotNull(aplPartida.getTabuleiro()[0][3]);
        Assert.assertNotNull(aplPartida.getTabuleiro()[1][2]);
        Assert.assertNotNull(aplPartida.getTabuleiro()[4][4]);
        Assert.assertNotNull(aplPartida.getTabuleiro()[7][5]);

        Assert.assertNull(aplPartida.getTabuleiro()[0][1]);
        Assert.assertNull(aplPartida.getTabuleiro()[1][1]);
        Assert.assertNull(aplPartida.getTabuleiro()[4][6]);
        Assert.assertNull(aplPartida.getTabuleiro()[6][7]);
    }

    @Test
    public void fazerJogadaCapturaTest() {
        this.aplPartida.fazerJogada("a2", "a4");
        this.aplPartida.fazerJogada("b7", "b5");
        //Primeira captura.
        this.aplPartida.fazerJogada("a4", "b5");
        this.aplPartida.fazerJogada("a7", "a6");
        //Segunda captura.
        this.aplPartida.fazerJogada("a1", "a6");

        Assert.assertEquals(aplPartida.getTabuleiro()[1][4].getCor(), Cor.BRANCO);
        Assert.assertEquals(aplPartida.getTabuleiro()[1][4].getTipoPeca(), TipoPeca.PEAO);

        Assert.assertEquals(aplPartida.getTabuleiro()[0][5].getCor(), Cor.BRANCO);
        Assert.assertEquals(aplPartida.getTabuleiro()[0][5].getTipoPeca(), TipoPeca.TORRE);
    }

    @Test
    public void fazerJogadaRoqueMaiorTest() {
        this.aplPartida.fazerJogada("b1", "a3");
        this.aplPartida.fazerJogada("b8", "a6");
        this.aplPartida.fazerJogada("b2", "b4");
        this.aplPartida.fazerJogada("b7", "b5");
        this.aplPartida.fazerJogada("c1", "b2");
        this.aplPartida.fazerJogada("c8", "b7");
        this.aplPartida.fazerJogada("d2", "d4");
        this.aplPartida.fazerJogada("d7", "d5");
        this.aplPartida.fazerJogada("d1", "d3");
        this.aplPartida.fazerJogada("d8", "d6");

        this.aplPartida.fazerJogada("e1", null);
        this.aplPartida.fazerJogada("e8", null);

        //Verifica se a torre moveu
        Assert.assertNull(aplPartida.getTabuleiro()[0][0]);
        Assert.assertNull(aplPartida.getTabuleiro()[0][7]);

        //Verifica se o rei moveu
        Assert.assertNull(aplPartida.getTabuleiro()[4][0]);
        Assert.assertNull(aplPartida.getTabuleiro()[4][7]);

        //Verifica se a rei está onde deveria
        Assert.assertEquals(TipoPeca.REI, aplPartida.getTabuleiro()[2][0].getTipoPeca());
        Assert.assertEquals(Cor.BRANCO, aplPartida.getTabuleiro()[2][0].getCor());
        Assert.assertEquals(TipoPeca.REI, aplPartida.getTabuleiro()[2][7].getTipoPeca());
        Assert.assertEquals(Cor.PRETO, aplPartida.getTabuleiro()[2][7].getCor());

        //Verifica s e a torre está onde deveria.
        Assert.assertEquals(TipoPeca.TORRE, aplPartida.getTabuleiro()[3][0].getTipoPeca());
        Assert.assertEquals(Cor.BRANCO, aplPartida.getTabuleiro()[3][0].getCor());
        Assert.assertEquals(TipoPeca.TORRE, aplPartida.getTabuleiro()[3][7].getTipoPeca());
        Assert.assertEquals(Cor.PRETO, aplPartida.getTabuleiro()[3][7].getCor());
    }

    @Test
    public void fazerJogadaRoqueMenorTest() {
        this.aplPartida.fazerJogada("g1", "h3");
        this.aplPartida.fazerJogada("g8", "h6");
        this.aplPartida.fazerJogada("g2", "g3");
        this.aplPartida.fazerJogada("g7", "g6");
        this.aplPartida.fazerJogada("f1", "g2");
        this.aplPartida.fazerJogada("f8", "g7");

        this.aplPartida.fazerJogada("e1", null);
        this.aplPartida.fazerJogada("e8", null);

        //Verifica se a torre moveu
        Assert.assertNull(aplPartida.getTabuleiro()[7][0]);
        Assert.assertNull(aplPartida.getTabuleiro()[7][7]);

        //Verifica se o rei moveu
        Assert.assertNull(aplPartida.getTabuleiro()[4][0]);
        Assert.assertNull(aplPartida.getTabuleiro()[4][7]);

        //Verifica se a rei está onde deveria
        Assert.assertEquals(TipoPeca.REI, aplPartida.getTabuleiro()[6][0].getTipoPeca());
        Assert.assertEquals(Cor.BRANCO, aplPartida.getTabuleiro()[6][0].getCor());
        Assert.assertEquals(TipoPeca.REI, aplPartida.getTabuleiro()[6][7].getTipoPeca());
        Assert.assertEquals(Cor.PRETO, aplPartida.getTabuleiro()[6][7].getCor());

        //Verifica s e a torre está onde deveria.
        Assert.assertEquals(TipoPeca.TORRE, aplPartida.getTabuleiro()[5][0].getTipoPeca());
        Assert.assertEquals(Cor.BRANCO, aplPartida.getTabuleiro()[5][0].getCor());
        Assert.assertEquals(TipoPeca.TORRE, aplPartida.getTabuleiro()[5][7].getTipoPeca());
        Assert.assertEquals(Cor.PRETO, aplPartida.getTabuleiro()[5][7].getCor());
    }

    @Test
    public void fazerJogadaXequeTest() {
        this.aplPartida.fazerJogada("f2", "f4");
        this.aplPartida.fazerJogada("d7", "d5");
        this.aplPartida.fazerJogada("d2", "d3");
        this.aplPartida.fazerJogada("d8", "d6");
        this.aplPartida.fazerJogada("g1", "h3");
        //Xeque
        this.aplPartida.fazerJogada("d6", "b4");
    }

    @Test
    public void getNomeJogadorTest() {
        Assert.assertEquals(NOME_JOGADOR_BRANCO, aplPartida.getNomeJogador(Cor.BRANCO));
        Assert.assertEquals(NOME_JOGADOR_PRETO, aplPartida.getNomeJogador(Cor.PRETO));
    }
}
