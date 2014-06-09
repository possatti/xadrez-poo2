package br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias;

import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroBuilderImpl;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroDirector;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class StrategyCavaloTest {

    private TabuleiroBuilderImpl tabuleiroBuilder;
    private TabuleiroDirector tabuleiroDirector;
    private Tabuleiro tab;
    private Peca peca;

    @Before
    public void before() {
        this.tabuleiroBuilder = new TabuleiroBuilderImpl();
        this.tabuleiroDirector = new TabuleiroDirector(tabuleiroBuilder);
        this.tabuleiroDirector.criarTabuleiro();
        this.tab = this.tabuleiroBuilder.getTabuleiro();
        this.peca = this.tab.getPosicao("b1").getPeca();
    }

    @Test
    public void testValidarMovimento() {
        Assert.assertTrue(this.peca.validarMovimento(this.tab.getPosicao("a3")));
        Assert.assertTrue(this.peca.validarMovimento(this.tab.getPosicao("c3")));
        Assert.assertFalse(this.peca.validarMovimento(this.tab.getPosicao("d2")));
    }
}
