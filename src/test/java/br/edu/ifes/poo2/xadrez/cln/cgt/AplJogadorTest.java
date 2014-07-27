package br.edu.ifes.poo2.xadrez.cln.cgt;

import br.edu.ifes.poo2.xadrez.AbstractTest;
import br.edu.ifes.poo2.xadrez.cln.cdp.Jogador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 * Testa a AplJogador. A cada teste que é feito, o teste limpa a
 * "sujeira" que fez no banco de dados para que os próximos teste
 * possam assumir que são o único teste rodando.
 *
 * @author Lucas Possatti
 */
public class AplJogadorTest extends AbstractTest {

    @Autowired
    AplJogador aplJogador;

    private final String apelido = "whatever";
    private final String nome = "What Ever";
    private final String email = "whatever@mail.com";

    private Jogador john;
    private long john_id;
    private final String john_apelido = "johndoe";
    private final String john_nome = "John Doe";
    private final String john_email = "johndoe@mail.com";

    private Jogador joao;
    private long joao_id;
    private final String joao_apelido = "joaosilva";
    private final String joao_nome = "João Silva";
    private final String joao_email = "joaosilva@mail.com.br";

    private long quantidade;

    @Before
    public void before() {
        // Cria dois jogadores
        john = aplJogador.create(john_apelido, john_nome, john_email);
        joao = aplJogador.create(joao_apelido, joao_nome, joao_email);
        quantidade = 2;

        // Pega os IDs.
        john_id = john.getId();
        joao_id = joao.getId();
    }

    @Test
    public void testcreate() {
        // Verifica a quantidade atual.
        long count = aplJogador.count();

        // Cria um novo jogador.
        Jogador jogador = aplJogador.create(apelido, nome, email);

        // Verifica se a quantidade subiu.
        Assert.assertEquals(count + 1, aplJogador.count());

        // Limpa a sujeira do teste.
        aplJogador.delete(jogador.getId());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void create_sameEmail() {
        // Tenta criar um jogador com um email já existente.
        aplJogador.create(apelido, nome, john_email);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void create_sameApelido() {
        // Tenta criar um jogador com um email já existente.
        aplJogador.create(john_apelido, nome, email);
    }

    @Test
    public void save() {
        // Modifica um jogador e salva.
        john.setNome("John Snipps");
        aplJogador.save(john);

        // Verifica se ele realmente foi salvo corretamente.
        Assert.assertEquals(john, aplJogador.get(john_id));

        // Limpa a sujeira do teste.
        john.setNome(john_nome);
        aplJogador.save(john);
    }

    @Test
    public void getAll() {
        Assert.assertNotNull(aplJogador.getAll());
    }

    @Test
    public void getByApelido() {
        Assert.assertEquals(john, aplJogador.getByApelido(john_apelido));
    }

    @Test
    public void getByNome() {
        Assert.assertEquals(john, aplJogador.getByNome(john_nome).get(0));
    }

    @Test
    public void getByEmail() {
        Assert.assertEquals(john, aplJogador.getByEmail(john_email));
    }

    @Test
    public void delete() {
        // Pega o número atual de jogadores.
        long earlycount = aplJogador.count();

        // Insere algum novo jogador
        Jogador novoJogador = aplJogador.create(apelido, email, nome);

        // E o remove.
        aplJogador.delete(novoJogador.getId());

        // Verifica se ele realmente foi removido.
        Assert.assertEquals(earlycount, aplJogador.count());
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void delete_notExists() {
        // Remove algum jogador que nunca foi inserido.
        aplJogador.delete(456123L);
    }

    @Test
    public void get() {
        // Traz o john.
        Jogador john = aplJogador.get(john_id);

        // E verifica se é ele mesmo.
        Assert.assertEquals(this.john, john);
    }

    @Test
    public void count() {
        Assert.assertEquals(quantidade, aplJogador.count());
    }

}
