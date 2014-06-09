/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class StrategyBispoTest {

    private TabuleiroBuilderImpl tabuleiroBuilder;
    private TabuleiroDirector tabuleiroDirector;
    private Tabuleiro tab;
    private Peca bispoBranco;
    private Peca bispoPreto;

    @Before
    public void before() {
        this.tabuleiroBuilder = new TabuleiroBuilderImpl();
        this.tabuleiroDirector = new TabuleiroDirector(tabuleiroBuilder);
        this.tabuleiroDirector.criarTabuleiro();
        this.tab = tabuleiroBuilder.getTabuleiro();
        this.bispoBranco = tab.getPosicao("f1").getPeca();
        this.bispoPreto = tab.getPosicao("c8").getPeca();
    }

    @Test
    public void testValidarMovimentoCaptura() {
        Assert.assertFalse(bispoPreto.validarMovimentoCaptura(tab.getPosicao("d6")));

        tab.getPosicao("b7").setPeca(tab.getPosicao("b2").getPeca());
        tab.getPosicao("d7").setPeca(tab.getPosicao("d2").getPeca());

        Assert.assertTrue(bispoPreto.validarMovimentoCaptura(tab.getPosicao("b7")));
        Assert.assertTrue(bispoPreto.validarMovimentoCaptura(tab.getPosicao("d7")));

    }

    @Test
    public void testValidarMovimento() {
        Assert.assertFalse(bispoBranco.validarMovimento(tab.getPosicao("e2")));
        Assert.assertFalse(bispoBranco.validarMovimento(tab.getPosicao("f2")));
        Assert.assertFalse(bispoBranco.validarMovimento(tab.getPosicao("g2")));
        Assert.assertFalse(bispoBranco.validarMovimento(tab.getPosicao("e1")));
        Assert.assertFalse(bispoBranco.validarMovimento(tab.getPosicao("g1")));
        Assert.assertFalse(bispoBranco.validarMovimento(tab.getPosicao("d3")));

        tab.getPosicao("e3").setPeca(tab.getPosicao("e2").getPeca());
        tab.getPosicao("g3").setPeca(tab.getPosicao("g2").getPeca());

        Assert.assertTrue(bispoBranco.validarMovimento(tab.getPosicao("e2")));
        Assert.assertTrue(bispoBranco.validarMovimento(tab.getPosicao("d3")));
        Assert.assertTrue(bispoBranco.validarMovimento(tab.getPosicao("g2")));
        Assert.assertTrue(bispoBranco.validarMovimento(tab.getPosicao("h3")));

    }
}
