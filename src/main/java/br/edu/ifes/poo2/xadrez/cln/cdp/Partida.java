package br.edu.ifes.poo2.xadrez.cln.cdp;

import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import java.util.Map;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Partida {

    private Jogador jogadorDaVez;

    private Map<Jogador, List<Peca>> pecasCapturadas;

    private Tabuleiro tabuleiro;

    private Jogador jogadorBranco;

    private Jogador jogadorPreto;

    private TipoPartida tipoPartida;

    public Partida(Jogador jogadorBranco, Jogador jogadorPreto, Tabuleiro tabuleiro) {

    }

}
