package br.edu.ifes.poo2.xadrez.cln.cdp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Jogador {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String apelido;

    @Column(unique = true)
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
