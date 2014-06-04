package br.edu.ifes.poo2.xadrez.cln.cdp.pecas;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;

public interface Peca extends Cloneable {

	public abstract Cor getCor();

	public abstract TipoPeca getTipoPeca();

	public abstract Posicao getPosicao();

	public abstract void setPosicao(Posicao posicao);

	public abstract boolean validarMovimento(Posicao novaPosicao);

	public abstract boolean validarMovimentoCaptura(Posicao novaPosicao);

	public abstract boolean jaMovimentou();

}
