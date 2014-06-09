/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class TestTabuleiro {

    private TabuleiroBuilderImpl tabuleiroBuilder;
    private TabuleiroDirector tabuleiroDirector;
    private Tabuleiro tabuleiro;

    @Before
    public void before() {
        this.tabuleiroBuilder = new TabuleiroBuilderImpl();
        this.tabuleiroDirector = new TabuleiroDirector(tabuleiroBuilder);
        this.tabuleiroDirector.criarTabuleiro();
        this.tabuleiro = tabuleiroBuilder.getTabuleiro();
    }

    @Test
    public void getPosicao() {
        for (char coluna = 'a'; coluna < 'i'; coluna++) {
            for (char linha = '1'; linha < '9'; linha++) {
                String pos1;
                String pos2;
                char proxLinha = (char) (linha + 1);
                pos1 = "" + coluna + linha;
                pos2 = "" + coluna + proxLinha;
                Assert.assertNotNull(this.tabuleiro.getPosicao(pos1));
                Assert.assertNotSame(this.tabuleiro.getPosicao(pos1), this.tabuleiro.getPosicao(pos2));
                Assert.assertEquals(pos1, this.tabuleiro.getPosicao(pos1).getId());
            }
        }
    }
}
