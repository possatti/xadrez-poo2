package br.edu.ifes.poo2.xadrez.cln.cdp.pecas;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;

public interface Peca extends Cloneable {

    public Cor getCor();

    public TipoPeca getTipoPeca();

    public Posicao getPosicao();

    public void setPosicao(Posicao posicao);

    public void setPosicaoInicial(Posicao posicao);

    public boolean validarMovimento(Posicao novaPosicao);

    public boolean validarMovimentoCaptura(Posicao novaPosicao);

    public boolean jaMovimentou();

    public boolean moveuUmaVez();

    public Peca clone() throws CloneNotSupportedException;
}
