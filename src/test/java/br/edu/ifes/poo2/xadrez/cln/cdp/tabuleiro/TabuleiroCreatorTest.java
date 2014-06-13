package br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class TabuleiroCreatorTest {

    @Test
    public void criarTabuleiroTest() {
        Tabuleiro tab1, tab2;

        tab1 = TabuleiroCreator.getInstance().criarTabuleiro();
        tab2 = TabuleiroCreator.getInstance().criarTabuleiro();

        Assert.assertEquals(tab2, tab2);
        Assert.assertNotEquals(tab1, tab2);
    }
}
