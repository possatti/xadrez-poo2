package br.edu.ifes.poo2.xadrez.cln.cdp.pecas.fabrica;

import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca;

public interface FabricaPecas {

    public abstract Peca fabricarPeca(Cor cor, TipoPeca peca);

}
