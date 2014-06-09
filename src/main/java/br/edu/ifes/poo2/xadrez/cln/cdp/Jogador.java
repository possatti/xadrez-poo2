package br.edu.ifes.poo2.xadrez.cln.cdp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jogador {

    private String nome;

    private int pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
    }
}
