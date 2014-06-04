package br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import java.util.List;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;

public class StrategyPecaImpl implements StrategyPeca {

	protected boolean ehCaminhoReto(Posicao posicaoInicial, Posicao posicaoFinal) {
		return false;
	}

	protected boolean ehCaminhoDiagonal(Posicao posicaoInicial, Posicao posicaoFinal) {
		return false;
	}

	protected boolean haPecas(List caminho, Tabuleiro tabuleiro) {
		return false;
	}


	/**
	 * @see br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias.StrategyPeca#validarMovimento(br.edu.ifes.poo2.xadrez.cln.cdp.Posicao, br.edu.ifes.poo2.xadrez.cln.cdp.Posicao)
	 */
	public boolean validarMovimento(Posicao posicaoAnterior, Posicao novaPosicao) {
		return false;
	}


	/**
	 * @see br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias.StrategyPeca#validarMovimentoCaptura(br.edu.ifes.poo2.xadrez.cln.cdp.Posicao, br.edu.ifes.poo2.xadrez.cln.cdp.Posicao)
	 */
	public boolean validarMovimentoCaptura(Posicao posicaoAnterior, Posicao novaPosicao) {
		return false;
	}

}
