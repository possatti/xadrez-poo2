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
public class StrategyPeaoTest {

    private TabuleiroBuilderImpl tabuleiroBuilder;
    private TabuleiroDirector tabuleiroDirector;
    private Tabuleiro tab;
    Peca peaoPreto;
    Peca peaoBranco;

    @Before
    public void before() {
        this.tabuleiroBuilder = new TabuleiroBuilderImpl();
        this.tabuleiroDirector = new TabuleiroDirector(tabuleiroBuilder);
        this.tabuleiroDirector.criarTabuleiro();
        this.tab = this.tabuleiroBuilder.getTabuleiro();
        this.peaoPreto = tab.getPosicao("d7").getPeca();
        this.peaoBranco = tab.getPosicao("c2").getPeca();
    }

    @Test
    public void testValidarMovimento() {
        Assert.assertFalse(peaoPreto.validarMovimento(tab.getPosicao("d7")));
        Assert.assertTrue(peaoPreto.validarMovimento(tab.getPosicao("d6")));
        Assert.assertTrue(peaoPreto.validarMovimento(tab.getPosicao("d5")));
        Assert.assertFalse(peaoPreto.validarMovimento(tab.getPosicao("d4")));

        Assert.assertFalse(peaoBranco.validarMovimento(tab.getPosicao("c2")));
        Assert.assertTrue(peaoBranco.validarMovimento(tab.getPosicao("c3")));
        Assert.assertTrue(peaoBranco.validarMovimento(tab.getPosicao("c4")));
        Assert.assertFalse(peaoBranco.validarMovimento(tab.getPosicao("c5")));

        tab.getPosicao("d6").setPeca(peaoPreto);
        Assert.assertTrue(peaoPreto.validarMovimento(tab.getPosicao("d5")));
        Assert.assertFalse(peaoPreto.validarMovimento(tab.getPosicao("d4")));

        tab.getPosicao("c3").setPeca(peaoBranco);
        Assert.assertFalse(peaoBranco.validarMovimento(tab.getPosicao("c5")));
        Assert.assertTrue(peaoBranco.validarMovimento(tab.getPosicao("c4")));
    }

    @Test
    public void testValidarMovimentoCaptura() {
        Assert.assertFalse(peaoPreto.validarMovimentoCaptura(tab.getPosicao("d7")));
        Assert.assertFalse(peaoPreto.validarMovimentoCaptura(tab.getPosicao("d6")));
        Assert.assertFalse(peaoPreto.validarMovimentoCaptura(tab.getPosicao("e6")));
        Assert.assertFalse(peaoPreto.validarMovimentoCaptura(tab.getPosicao("c6")));

        tab.getPosicao("e6").setPeca(tab.getPosicao("e2").getPeca());
        tab.getPosicao("c6").setPeca(tab.getPosicao("c2").getPeca());

        Assert.assertTrue(peaoPreto.validarMovimentoCaptura(tab.getPosicao("e6")));
        Assert.assertTrue(peaoPreto.validarMovimentoCaptura(tab.getPosicao("c6")));
        Assert.assertFalse(peaoPreto.validarMovimentoCaptura(tab.getPosicao("d6")));

        before();

        tab.getPosicao("b3").setPeca(tab.getPosicao("b7").getPeca());
        tab.getPosicao("d3").setPeca(tab.getPosicao("d7").getPeca());
        tab.getPosicao("c3").setPeca(tab.getPosicao("c7").getPeca());

        Assert.assertTrue(peaoBranco.validarMovimentoCaptura(tab.getPosicao("b3")));
        Assert.assertTrue(peaoBranco.validarMovimentoCaptura(tab.getPosicao("d3")));
        Assert.assertFalse(peaoBranco.validarMovimentoCaptura(tab.getPosicao("c3")));

    }
}
