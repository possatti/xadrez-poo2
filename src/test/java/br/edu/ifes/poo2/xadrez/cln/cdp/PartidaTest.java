package br.edu.ifes.poo2.xadrez.cln.cdp;

import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroBuilderImpl;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroDirector;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class PartidaTest {

    private TabuleiroBuilderImpl tabuleiroBuilder;
    private TabuleiroDirector tabuleiroDirector;
    private Tabuleiro tab;

    @Before
    public void before() {
        this.tabuleiroBuilder = new TabuleiroBuilderImpl();
        this.tabuleiroDirector = new TabuleiroDirector(tabuleiroBuilder);
        this.tabuleiroDirector.criarTabuleiro();
        this.tab = tabuleiroBuilder.getTabuleiro();
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
