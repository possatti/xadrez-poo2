package br.edu.ifes.poo2.xadrez.util.exceptions;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroCreator;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class PosicaoInvalidaExceptionTest {

    @Test(expected = PosicaoInvalidaException.class)
    public void exceptionStringTest() {
        throw new PosicaoInvalidaException("Teste!");
    }

    @Test(expected = PosicaoInvalidaException.class)
    public void exceptionThrowableTest() {
        Posicao pos = new Posicao("a1", TabuleiroCreator.getInstance().criarTabuleiro());

        try {
            pos.getPeca().getCor();
        } catch (NullPointerException e) {
            throw new PosicaoInvalidaException(e);
        }
    }
}
