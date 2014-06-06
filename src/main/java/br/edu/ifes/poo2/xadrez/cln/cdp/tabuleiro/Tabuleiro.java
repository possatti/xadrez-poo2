package br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca;
import java.util.Map;
import lombok.Setter;

public class Tabuleiro {

    @Setter
    private Map<String, Posicao> posicoes;

    /**
     * Pega uma posição do Tabuleiro
     *
     * @param id id da Posição. Ex.: {@code "11"} para coluna 1 e linha 1 ou
     * {@code "32"} para coluna 3 e linha 2
     * @return a Posicao pedida.
     */
    public Posicao getPosicao(String id) {
        return posicoes.get(id);
    }

    public Posicao getPosicaoRei(Cor cor) {
        Posicao posicaoRei = null;

        for (Map.Entry<String, Posicao> entry : posicoes.entrySet()) {
            Posicao posicao = entry.getValue();

            if (posicao.existePeca() && posicao.getPeca().getTipoPeca() == TipoPeca.REI
                    && posicao.getPeca().getCor() == cor) {
                posicaoRei = posicao;
            }
        }

        return posicaoRei;
    }
}
