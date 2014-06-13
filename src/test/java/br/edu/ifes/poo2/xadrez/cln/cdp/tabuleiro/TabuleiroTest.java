package br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class TabuleiroTest {

    private Tabuleiro tabuleiro;

    @Before
    public void before() {
        this.tabuleiro = TabuleiroCreator.getInstance().criarTabuleiro();
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

    @Test
    public void isRoqueMenorTest() {
        this.tabuleiro.getPosicao("d3").setPeca(tabuleiro.getPosicao("f1").getPeca());
        this.tabuleiro.getPosicao("f3").setPeca(tabuleiro.getPosicao("g1").getPeca());
        Assert.assertTrue(tabuleiro.isRoqueMenor(tabuleiro.getPosicao("e1")));

        this.tabuleiro.getPosicao("g1").setPeca(tabuleiro.getPosicao("h1").getPeca());
        this.tabuleiro.getPosicao("h1").setPeca(tabuleiro.getPosicao("g1").getPeca());

        Assert.assertFalse(tabuleiro.isRoqueMenor(tabuleiro.getPosicao("e1")));

        before();

        Assert.assertFalse(tabuleiro.isRoqueMenor(tabuleiro.getPosicao("e1")));
    }

    @Test
    public void isRoqueMaiorTest() {
        this.tabuleiro.getPosicao("b8").setPeca(tabuleiro.getPosicao("c6").getPeca());
        this.tabuleiro.getPosicao("c8").setPeca(tabuleiro.getPosicao("b6").getPeca());
        this.tabuleiro.getPosicao("d8").setPeca(tabuleiro.getPosicao("d3").getPeca());

        Assert.assertTrue(tabuleiro.isRoqueMaior(tabuleiro.getPosicao("e8")));

        this.tabuleiro.getPosicao("a8").setPeca(tabuleiro.getPosicao("b8").getPeca());
        this.tabuleiro.getPosicao("b8").setPeca(tabuleiro.getPosicao("a8").getPeca());

        Assert.assertFalse(tabuleiro.isRoqueMaior(tabuleiro.getPosicao("e8")));

        before();

        Assert.assertFalse(tabuleiro.isRoqueMaior(tabuleiro.getPosicao("e8")));
    }

    @Test
    public void isXequeTest() {
        this.tabuleiro.getPosicao("d6").setPeca(tabuleiro.getPosicao("e7").getPeca());
        this.tabuleiro.getPosicao("c6").setPeca(tabuleiro.getPosicao("d7").getPeca());
        this.tabuleiro.getPosicao("d3").setPeca(tabuleiro.getPosicao("e2").getPeca());

        Assert.assertTrue(tabuleiro.isXeque(tabuleiro.getPosicao("d1"), tabuleiro.getPosicao("e2")));

        before();

        this.tabuleiro.getPosicao("e5").setPeca(tabuleiro.getPosicao("d1").getPeca());
        Assert.assertFalse(tabuleiro.isXeque(tabuleiro.getPosicao("e5"), tabuleiro.getPosicao("e8")));
    }

    @Test
    public void isXequeMateTest() {
        this.tabuleiro.getPosicao("c5").setPeca(tabuleiro.getPosicao("b8").getPeca());

        Assert.assertTrue(tabuleiro.isXequeMate(tabuleiro.getPosicao("c5"), tabuleiro.getPosicao("d3")));

        before();

        this.tabuleiro.getPosicao("d6").setPeca(tabuleiro.getPosicao("e7").getPeca());
        this.tabuleiro.getPosicao("c6").setPeca(tabuleiro.getPosicao("d7").getPeca());
        this.tabuleiro.getPosicao("d3").setPeca(tabuleiro.getPosicao("e2").getPeca());

        Assert.assertFalse(tabuleiro.isXequeMate(tabuleiro.getPosicao("d1"), tabuleiro.getPosicao("e2")));
    }

    @Test
    public void isEnPassantTest() {
        this.tabuleiro.getPosicao("d5").setPeca(tabuleiro.getPosicao("d2").getPeca());
        this.tabuleiro.getPosicao("e5").setPeca(tabuleiro.getPosicao("e7").getPeca());

        Assert.assertTrue(tabuleiro.isEnPassant(tabuleiro.getPosicao("d5"), tabuleiro.getPosicao("e6")));
        Assert.assertFalse(tabuleiro.isEnPassant(tabuleiro.getPosicao("d5"), tabuleiro.getPosicao("e5")));
    }
}
