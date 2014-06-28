package br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro;

/**
 *
 * @author phillipe
 */
public enum TabuleiroCreator {

    INSTANCE;

    private final TabuleiroBuilderImpl tabuleiroBuilder;
    private final TabuleiroDirector tabuleiroDirector;

    private TabuleiroCreator() {
        this.tabuleiroBuilder = new TabuleiroBuilderImpl();
        this.tabuleiroDirector = new TabuleiroDirector(tabuleiroBuilder);
    }

    public static TabuleiroCreator getInstance() {
        return INSTANCE;
    }

    public Tabuleiro criarTabuleiro() {
        this.tabuleiroDirector.criarTabuleiro();
        return this.tabuleiroBuilder.getTabuleiro();
    }
}
