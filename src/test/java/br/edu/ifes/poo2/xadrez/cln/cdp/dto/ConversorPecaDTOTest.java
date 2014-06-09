package br.edu.ifes.poo2.xadrez.cln.cdp.dto;

import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.fabrica.FabricaPecasImpl;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class ConversorPecaDTOTest {

    private Peca peca;
    private PecaDTO pecaDTO;
    private Mapper mapper;

    @Before
    public void inicializa() {
        this.peca = FabricaPecasImpl.getInstance().fabricarPeca(Cor.PRETO, TipoPeca.PEAO);
        this.mapper = DozerBeanMapperSingletonWrapper.getInstance();
    }

    @Test
    public void testConverterPecaToPecaDTO() {
        pecaDTO = mapper.map(this.peca, PecaDTO.class);

        Assert.assertTrue(pecaDTO instanceof PecaDTO);
        Assert.assertEquals(pecaDTO.getCor(), Cor.PRETO);
        Assert.assertEquals(pecaDTO.getTipoPeca(), TipoPeca.PEAO);
    }
}
