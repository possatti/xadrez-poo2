package br.edu.ifes.poo2.xadrez.cln.cdp;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Jogador {

    @Id
    private Long id;

    private String nome;

    private int pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
    }
}
