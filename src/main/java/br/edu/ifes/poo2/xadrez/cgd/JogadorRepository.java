package br.edu.ifes.poo2.xadrez.cgd;

import br.edu.ifes.poo2.xadrez.cln.cdp.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    Jogador findByApelido(String apelido);

    List<Jogador> findByNome(String nome);

    Jogador findByEmail(String email);

}
