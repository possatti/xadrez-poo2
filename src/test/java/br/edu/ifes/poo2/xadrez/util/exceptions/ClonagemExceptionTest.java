package br.edu.ifes.poo2.xadrez.util.exceptions;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroCreator;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class ClonagemExceptionTest {

    @Test(expected = ClonagemException.class)
    public void exceptionStringTest() {
        throw new ClonagemException("Teste!");
    }

    @Test(expected = ClonagemException.class)
    public void exceptionThrowableTest() {
        Posicao pos = new Posicao("a1", TabuleiroCreator.getInstance().criarTabuleiro());

        try {
            pos.getPeca().getCor();
        } catch (NullPointerException e) {
            throw new ClonagemException(e);
        }
    }
}
