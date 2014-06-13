package br.edu.ifes.poo2.xadrez.cln.cdp;

import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroCreator;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class PartidaTest {

    private Tabuleiro tab;

    @Before
    public void before() {
        this.tab = TabuleiroCreator.getInstance().criarTabuleiro();
    }

    @Test
    public void instanciarPartida() {
        JogadorCreator creator = JogadorCreator.getInstance();
        Partida partida = new Partida(creator.criarJogador("Branco"), creator.criarJogador("Preto"), tab, TipoPartida.MULTIPLAYER);

        Assert.assertEquals("Branco", partida.getJogadorBranco().getNome());
        Assert.assertEquals("Preto", partida.getJogadorPreto().getNome());
        Assert.assertEquals(partida.getJogadorBranco(), partida.getJogadorDaVez());
        Assert.assertEquals(partida.getTipoPartida(), TipoPartida.MULTIPLAYER);

    }
}
