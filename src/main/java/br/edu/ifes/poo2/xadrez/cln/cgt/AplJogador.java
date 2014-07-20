package br.edu.ifes.poo2.xadrez.cln.cgt;

import br.edu.ifes.poo2.xadrez.cgd.JogadorRepository;
import br.edu.ifes.poo2.xadrez.cln.cdp.Jogador;
import br.edu.ifes.poo2.xadrez.cln.cdp.JogadorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Gerencia os objetos da classe Jogador.
 *
 * @author Lucas Possatti
 */
@Service
public class AplJogador implements CRUDService<Jogador, Long> {

    @Autowired
    JogadorRepository jogadorRepository;

    /**
     * Cria um novo jogador e persiste-o no banco de dados.
     *
     * @param apelido
     * @param nome
     * @param email
     * @return Novo Jogador criado.
     */
    public Jogador create(String apelido, String nome, String email) {
        // Cria o novo jogador.
        Jogador jogador = JogadorFactory.INSTANCE.criarJogador(apelido, nome, email);

        // Persiste o novo jogagor.
        save(jogador);

        return jogador;
    }

    @Override
    public void save(Jogador jogador) {
        jogadorRepository.save(jogador);
    }

    @Override
    public List<Jogador> getAll() {
        return jogadorRepository.findAll();
    }

    public Jogador getByApelido(String apelido) {
        return jogadorRepository.findByApelido(apelido);
    }

    public List<Jogador> getByNome(String nome) {
        return jogadorRepository.findByNome(nome);
    }

    public Jogador getByEmail(String email) {
        return jogadorRepository.findByEmail(email);
    }

    @Override
    public void delete(Long id) {
        jogadorRepository.delete(id);
    }

    @Override
    public Jogador get(Long id) {
        return jogadorRepository.findOne(id);
    }

    @Override
    public long count() {
        return jogadorRepository.count();
    }
}
