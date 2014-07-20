package br.edu.ifes.poo2.xadrez.cln.cdp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "JOGADOR")
@EqualsAndHashCode(callSuper=true)
public class Jogador extends AbstractPersistable<Long> {

    @Column(unique = true)
    private String apelido;

    private String nome;

    @Column(unique = true)
    private String email;

    private int pontuacao;

    /**
     * Cria um jogador comum, com todos os dados necessários.
     *
     * @param apelido Apelido do jogador.
     * @param nome Nome do Jogador.
     * @param email Email do jogador.
     */
    public Jogador(String apelido, String nome, String email) {
        this.apelido = apelido;
        this.nome = nome;
        this.email = email;
    }


}
