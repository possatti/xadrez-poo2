package br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias;

import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroCreator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class StrategyReiTest {

    private Tabuleiro tab;
    Peca reiPreto;
    Peca reiBranco;

    @Before
    public void before() {
        this.tab = TabuleiroCreator.getInstance().criarTabuleiro();
        this.reiPreto = tab.getPosicao("e8").getPeca();
        this.reiBranco = tab.getPosicao("e1").getPeca();
    }

    @Test
    public void testValidarMovimento() {
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("d7")));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("e7")));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("f7")));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("d8")));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("f8")));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("e8")));

        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("d2")));
        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("e2")));
        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("f2")));
        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("d1")));
        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("f1")));
        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("e1")));

        tab.getPosicao("d5").setPeca(reiPreto);

        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("c6")));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("d6")));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("e6")));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("c4")));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("d4")));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("e4")));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("c5")));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("e5")));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("d5")));
    }
}
