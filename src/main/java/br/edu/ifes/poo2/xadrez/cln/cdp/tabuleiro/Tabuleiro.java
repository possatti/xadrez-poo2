package br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import java.util.Map;

public class Tabuleiro implements Cloneable {

    private Map<String, Posicao> posicoes;

    public Posicao getPosicao(String id) {
        return null;
    }

    public Posicao getPosicaoRei(Cor cor) {
        return null;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
