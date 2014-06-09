package br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro;

/**
 *
 * @author phillipe
 */
public class TabuleiroCreator {

    private final TabuleiroBuilderImpl tabuleiroBuilder;
    private final TabuleiroDirector tabuleiroDirector;

    private static class TabuleiroCreatorSingletonHolder {

        private static final TabuleiroCreator INSTANCE = new TabuleiroCreator();
    }

    private TabuleiroCreator() {
        this.tabuleiroBuilder = new TabuleiroBuilderImpl();
        this.tabuleiroDirector = new TabuleiroDirector(tabuleiroBuilder);
    }

    public static TabuleiroCreator getInstance() {
        return TabuleiroCreatorSingletonHolder.INSTANCE;
    }

    public Tabuleiro criarTabuleiro() {
        this.tabuleiroDirector.criarTabuleiro();
        return this.tabuleiroBuilder.getTabuleiro();
    }
}
