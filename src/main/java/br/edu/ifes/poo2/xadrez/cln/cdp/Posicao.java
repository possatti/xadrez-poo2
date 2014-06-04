package br.edu.ifes.poo2.xadrez.cln.cdp;

import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;
import lombok.Getter;

@Getter
public class Posicao {

    final private String id;
    final private Tabuleiro tabuleiro;
    private Peca peca;

    public Posicao(String id, Tabuleiro tabuleiro) {
        this.id = id;
        this.tabuleiro = tabuleiro;
    }

    public void setPeca(Peca peca) {
        Posicao posicaoAnt;
        this.peca = peca;

        // Aqui é verificado se é a primeira vez que é a primeira vez que a posição é definida.
        try {
            posicaoAnt = peca.getPosicao();
        } catch (NullPointerException e) {
            this.peca = null;
            return;
        }
        if (posicaoAnt != null) {
            posicaoAnt.peca = null;
            peca.setPosicao(this);
        } else {
            peca.setPosicaoInicial(this);
        }
    }

    public boolean existePeca() {
        return this.peca != null;
    }
}
