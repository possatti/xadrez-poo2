package br.edu.ifes.poo2.xadrez.cln.cdp;

import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroCreator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class InteligenciaArtificialTest {

    InteligenciaArtificial ia;
    Tabuleiro tabuleiro;

    @Before
    public void before() {
        this.ia = InteligenciaArtificial.getInstance();
        this.tabuleiro = TabuleiroCreator.getInstance().criarTabuleiro();
    }

    @Test
    public void calcularJogadaTest() {
        String[] jogada = ia.calcularJogada(tabuleiro, Cor.BRANCO);
        String regexPosicao = "^[a-h][1-8]$";

        Assert.assertTrue(jogada[0].matches(regexPosicao));
        Assert.assertTrue(jogada[1].matches(regexPosicao));
    }

}
