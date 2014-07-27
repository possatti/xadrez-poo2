package br.edu.ifes.poo2.xadrez.cln.cdp;

/**
 * Fábrica de jogadores.
 *
 * @author Lucas Possatti
 */
public enum JogadorFactory {

    INSTANCE;

    /**
     * Método fábrica para instanciar jogadores.
     *
     * @param apelido Apelido
     * @param nome Nome
     * @param email E-mail
     * @return Novo Jogador
     */
    public Jogador criarJogador(String apelido, String nome, String email) {
        return new Jogador(apelido, nome, email);
    }
}
