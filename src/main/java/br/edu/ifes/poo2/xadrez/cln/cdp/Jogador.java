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
@AllArgsConstructor
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

}
