package br.edu.ifes.poo2.xadrez.cln.cdp;

import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import java.util.Map;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Partida {

    private Jogador jogadorDaVez;

    private Map<Jogador, List<Peca>> pecasCapturadas;

    private Map<Jogador, Integer> pontuacao;

    private Tabuleiro tabuleiro;

    private Jogador jogadorBranco;

    private Jogador jogadorPreto;

    private TipoPartida tipoPartida;

    public Partida(Jogador jogadorBranco, Jogador jogadorPreto, Tabuleiro tabuleiro) {
        this.jogadorBranco = jogadorBranco;
        this.jogadorPreto = jogadorPreto;
        this.tabuleiro = tabuleiro;
        this.pecasCapturadas = new HashMap<>();
        this.pontuacao = new HashMap<>();
        this.pecasCapturadas.put(jogadorPreto, new ArrayList<Peca>());
        this.pecasCapturadas.put(jogadorBranco, new ArrayList<Peca>());
    }

    public void addPecaCapturada(Peca peca) {
        Jogador jogador;
        switch (peca.getCor()) {
            case BRANCO:
                jogador = this.jogadorBranco;
                break;
            case PRETO:
                jogador = this.jogadorPreto;
                break;
            default:
                throw new RuntimeException();
        }
        pecasCapturadas.get(jogador).add(peca);
    }

}
