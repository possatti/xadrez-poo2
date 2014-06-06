package br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro;

public class TabuleiroDirector {

    private final TabuleiroBuilder tabuleiroBuilder;

    public TabuleiroDirector(TabuleiroBuilder builder) {
        this.tabuleiroBuilder = builder;
    }

    public void criarTabuleiro() {
        tabuleiroBuilder.setPosicoes();
        tabuleiroBuilder.setPecas();
    }

}
