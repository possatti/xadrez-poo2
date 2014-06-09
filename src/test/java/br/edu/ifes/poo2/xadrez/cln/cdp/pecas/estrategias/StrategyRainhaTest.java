package br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias;

import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroBuilderImpl;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroDirector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class StrategyRainhaTest {

    private TabuleiroBuilderImpl tabuleiroBuilder;
    private TabuleiroDirector tabuleiroDirector;
    private Tabuleiro tab;
    Peca rainhaPreta;
    Peca rainhaBranca;

    @Before
    public void before() {
        this.tabuleiroBuilder = new TabuleiroBuilderImpl();
        this.tabuleiroDirector = new TabuleiroDirector(tabuleiroBuilder);
        this.tabuleiroDirector.criarTabuleiro();
        this.tab = tabuleiroBuilder.getTabuleiro();
        this.rainhaBranca = this.tab.getPosicao("d1").getPeca();
        this.rainhaPreta = this.tab.getPosicao("d8").getPeca();
    }

    @Test
    public void testValidarMovimento() {
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("d8")));
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("c8")));
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("f8")));
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("c7")));
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("d7")));
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("f7")));

        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("d1")));
        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("c1")));
        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("f1")));
        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("c2")));
        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("d2")));
        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("f2")));

        tab.getPosicao("d4").setPeca(rainhaPreta);

        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("c5")));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("d5")));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("e5")));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("c4")));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("e4")));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("c3")));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("d3")));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("e3")));

    }

    @Test
    public void testValidarMovimentoCaptura() {
        tab.getPosicao("d4").setPeca(rainhaBranca);

        Assert.assertTrue(rainhaBranca.validarMovimentoCaptura(tab.getPosicao("a7")));
        Assert.assertTrue(rainhaBranca.validarMovimentoCaptura(tab.getPosicao("d7")));
        Assert.assertTrue(rainhaBranca.validarMovimentoCaptura(tab.getPosicao("g7")));
        Assert.assertFalse(rainhaBranca.validarMovimentoCaptura(tab.getPosicao("b2")));
        Assert.assertFalse(rainhaBranca.validarMovimentoCaptura(tab.getPosicao("c2")));
        Assert.assertFalse(rainhaBranca.validarMovimentoCaptura(tab.getPosicao("d2")));

    }
}
