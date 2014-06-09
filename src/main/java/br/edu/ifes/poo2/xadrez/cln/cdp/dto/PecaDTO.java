package br.edu.ifes.poo2.xadrez.cln.cdp.dto;

import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca;
import lombok.Data;

/**
 *
 * @author phillipe
 */
@Data
public class PecaDTO {

    private TipoPeca tipoPeca;
    private Cor cor;

    public PecaDTO() {
    }

}
