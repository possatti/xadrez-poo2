package br.edu.ifes.poo2.xadrez.cln.cdp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroCreator;

public class PartidaTest {

    private Tabuleiro tab;
    private Jogador branco = JogadorFactory.INSTANCE.criarJogador("branco", "Branco", "branco@xadrez.com");
    private Jogador preto = JogadorFactory.INSTANCE.criarJogador("preto", "Preto", "preto@xadrez.com");
   

    @Before
    public void before() {
        this.tab = TabuleiroCreator.getInstance().criarTabuleiro();
    }

    @Test
    public void instanciarPartidaTest() {
        Partida partida = new Partida(branco, preto, tab, TipoPartida.MULTIPLAYER);

        Assert.assertEquals("Branco", partida.getJogadorBranco().getNome());
        Assert.assertEquals("Preto", partida.getJogadorPreto().getNome());
        Assert.assertEquals(partida.getJogadorBranco(), partida.getJogadorDaVez());
        Assert.assertEquals(partida.getTipoPartida(), TipoPartida.MULTIPLAYER);
    }

    @Test
    public void getCorTest() {
        Partida partida = new Partida(branco, preto, tab, TipoPartida.MULTIPLAYER);

        Assert.assertEquals(Cor.BRANCO, partida.getCor(branco));
        Assert.assertEquals(Cor.PRETO, partida.getCor(preto));
    }

    @Test
    public void addPecaCapturadaTest() {
        Partida partida = new Partida(branco, preto, tab, TipoPartida.MULTIPLAYER);
        Peca preta, branca;

        preta = tab.getPosicao("c7").getPeca();
        branca = tab.getPosicao("a2").getPeca();

        partida.addPecaCapturada(preta);
        partida.addPecaCapturada(branca);

        Assert.assertEquals(preta, partida.getPecasCapturadas().get(partida.getJogadorBranco()).get(0));
        Assert.assertEquals(branca, partida.getPecasCapturadas().get(partida.getJogadorPreto()).get(0));
    }
}
