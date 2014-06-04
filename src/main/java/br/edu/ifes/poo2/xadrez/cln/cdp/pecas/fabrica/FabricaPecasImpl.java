package br.edu.ifes.poo2.xadrez.cln.cdp.pecas.fabrica;

import java.util.Map;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca;

public class FabricaPecasImpl implements FabricaPecas {

	private static FabricaPecasImpl instance;

	private Map prototiposPeca;

	private Peca[] peca;

	private void FabricaPeca() {

	}

	public static FabricaPecas getInstance() {
		return null;
	}


	/**
	 * @see br.edu.ifes.poo2.xadrez.cln.cdp.pecas.fabrica.FabricaPecas#fabricarPeca(br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor, br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca)
	 */
	public Peca fabricarPeca(Cor Cor, TipoPeca peca) {
		return null;
	}

}
