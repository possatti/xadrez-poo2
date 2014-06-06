package br.edu.ifes.poo2.xadrez.cln.cdp.pecas;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias.StrategyPeca;
import lombok.Getter;
import lombok.Setter;

public class PecaImpl implements Peca {

    private boolean jaMovimentou;

    private boolean moveuUmaVez;

    @Getter
    @Setter
    private Cor cor;

    @Getter
    @Setter
    private TipoPeca tipoPeca;

    @Setter
    private StrategyPeca estrategia;

    @Getter
    private Posicao posicao;

    @Override
    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;

        this.verificarMovimento();
    }

    @Override
    public void setPosicaoInicial(Posicao posicao) {
        this.posicao = posicao;
    }

    public void verificarMovimento() {
        this.moveuUmaVez = !this.jaMovimentou;

        if (!this.jaMovimentou) {
            this.jaMovimentou = true;
        }
    }

    @Override
    public boolean validarMovimento(Posicao novaPosicao) {
        return estrategia.validarMovimento(posicao, novaPosicao);
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao) {
        return estrategia.validarMovimentoCaptura(posicao, novaPosicao);
    }

    @Override
    public Peca clone() throws CloneNotSupportedException {
        return (Peca) super.clone();
    }

    @Override
    public boolean jaMovimentou() {
        return jaMovimentou;
    }

    @Override
    public boolean moveuUmaVez() {
        return this.moveuUmaVez;
    }
}
