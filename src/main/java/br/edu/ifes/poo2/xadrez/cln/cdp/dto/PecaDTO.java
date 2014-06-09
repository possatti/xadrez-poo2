package br.edu.ifes.poo2.xadrez.cln.cdp.dto;

import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author phillipe
 */
@Getter
@Setter
public class PecaDTO {

    private TipoPeca tipoPeca;
    private Cor cor;
}
