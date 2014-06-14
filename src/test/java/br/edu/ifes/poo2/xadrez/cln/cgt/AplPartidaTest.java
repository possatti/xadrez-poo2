package br.edu.ifes.poo2.xadrez.cln.cgt;

import br.edu.ifes.poo2.xadrez.cln.cdp.Jogador;
import br.edu.ifes.poo2.xadrez.cln.cdp.TipoPartida;
import br.edu.ifes.poo2.xadrez.cln.cdp.dto.PecaDTO;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class AplPartidaTest {

    private AplPartida aplPartida;
    private Jogador jogadorBranco, jogadorPreto;
    final int LINHA_PEAO_BRANCO = 1;
    final int LINHA_PEAO_PRETO = 6;

    @Before
    public void before() {
        this.aplPartida = new AplPartida();
        this.jogadorBranco = new Jogador("Jogaddor Branco");
        this.jogadorPreto = new Jogador("Jogador Preto");
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
}
