package br.edu.ifes.poo2.xadrez.cln.cgt;

import br.edu.ifes.poo2.xadrez.cgd.SessionManager;
import br.edu.ifes.poo2.xadrez.cln.cdp.Jogador;
import br.edu.ifes.poo2.xadrez.cln.cdp.JogadorFactory;
import org.hibernate.Session;

public class AplJogador {

    /**
     * Cria um novo jogador e persiste-o no banco de dados.
     *
     * @param apelido
     * @param nome
     * @param email
     * @return Novo Jogador criado.
     */
    public Jogador criarJogador(String apelido, String nome, String email) {
        // Cria o novo jogador.
        Jogador jogador = JogadorFactory.INSTANCE.criarJogador(apelido, nome, email);

        // Persiste o novo jogagor.
        Session session = SessionManager.openSession();
        session.save(jogador);
        session.close();

        return jogador;
    }

    public void editarJogador(String id, String novoNome) {
        throw new UnsupportedOperationException("Não implementado ainda.");
    }

    public void apagarJogador(String id) {
        throw new UnsupportedOperationException("Não implementado ainda.");
    }

}
