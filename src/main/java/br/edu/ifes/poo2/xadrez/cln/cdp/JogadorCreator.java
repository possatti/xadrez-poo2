package br.edu.ifes.poo2.xadrez.cln.cdp;

/**
 *
 * @author phillipe
 */
public class JogadorCreator {

    private static class JogadorCreatorSingletonHolder {

        private static final JogadorCreator INSTANCE = new JogadorCreator();
    }

    private JogadorCreator() {

    }

    public static JogadorCreator getInstance() {
        return JogadorCreatorSingletonHolder.INSTANCE;
    }

    public Jogador criarJogador(String nome) {
        return new Jogador(nome);
    }
}
