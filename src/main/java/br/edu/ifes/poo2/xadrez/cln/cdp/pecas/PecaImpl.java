package br.edu.ifes.poo2.xadrez.cln.cdp.pecas;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias.StrategyPeca;

public class PecaImpl implements Peca {

	private boolean jaMovimentou;

	private Cor cor;

	private TipoPeca tipoPeca;

	private Posicao posicao;

	private StrategyPeca estrategia;


	/**
	 * @see br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca#getCor()
	 */
	public Cor getCor() {
		return null;
	}


	/**
	 * @see br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca#getTipoPeca()
	 * 
	 *  
	 */
	public TipoPeca getTipoPeca() {
		return null;
	}


	/**
	 * @see br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca#getPosicao()
	 */
	public Posicao getPosicao() {
		return null;
	}


	/**
	 * @see br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca#setPosicao(br.edu.ifes.poo2.xadrez.cln.cdp.Posicao)
	 * 
	 *  
	 */
	public void setPosicao(Posicao posicao) {

	}


	/**
	 * @see br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca#validarMovimento(br.edu.ifes.poo2.xadrez.cln.cdp.Posicao)
	 */
	public boolean validarMovimento(Posicao novaPosicao) {
		return false;
	}


	/**
	 * @see br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca#validarMovimentoCaptura(br.edu.ifes.poo2.xadrez.cln.cdp.Posicao)
	 */
	public boolean validarMovimentoCaptura(Posicao novaPosicao) {
		return false;
	}


	/**
	 * @see br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca#jaMovimentou()
	 */
	public boolean jaMovimentou() {
		return false;
	}

}
