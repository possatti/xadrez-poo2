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
public class StrategyTorreTest {

    private TabuleiroBuilderImpl tabuleiroBuilder;
    private TabuleiroDirector tabuleiroDirector;
    private Tabuleiro tab;
    private Peca torreBranca;
    private Peca torrePreta;

    @Before
    public void before() {
        this.tabuleiroBuilder = new TabuleiroBuilderImpl();
        this.tabuleiroDirector = new TabuleiroDirector(tabuleiroBuilder);
        this.tabuleiroDirector.criarTabuleiro();
        this.tab = tabuleiroBuilder.getTabuleiro();
        this.torrePreta = this.tab.getPosicao("h8").getPeca();
        this.torreBranca = this.tab.getPosicao("a1").getPeca();
    }

    @Test
    public void testValidarMovimento() {
        Assert.assertFalse(torrePreta.validarMovimento(tab.getPosicao("a2")));
        Assert.assertFalse(torrePreta.validarMovimento(tab.getPosicao("b2")));
        Assert.assertFalse(torrePreta.validarMovimento(tab.getPosicao("b1")));

        Assert.assertFalse(torrePreta.validarMovimento(tab.getPosicao("h7")));
        Assert.assertFalse(torrePreta.validarMovimento(tab.getPosicao("g7")));
        Assert.assertFalse(torrePreta.validarMovimento(tab.getPosicao("g8")));

        Assert.assertFalse(torrePreta.validarMovimento(tab.getPosicao("h5")));

        tab.getPosicao("d5").setPeca(torreBranca);

        Assert.assertTrue(torreBranca.validarMovimento(tab.getPosicao("e5")));
        Assert.assertTrue(torreBranca.validarMovimento(tab.getPosicao("f5")));
        Assert.assertTrue(torreBranca.validarMovimento(tab.getPosicao("d6")));
        Assert.assertTrue(torreBranca.validarMovimento(tab.getPosicao("d4")));

    }

    @Test
    public void testValidarMovimentoCaptura() {
        tab.getPosicao("d5").setPeca(torrePreta);

        Assert.assertTrue(torrePreta.validarMovimentoCaptura(tab.getPosicao("d2")));
        Assert.assertFalse(torrePreta.validarMovimentoCaptura(tab.getPosicao("d8")));
        Assert.assertFalse(torrePreta.validarMovimentoCaptura(tab.getPosicao("d5")));
    }
}
