package br.edu.ifes.poo2.xadrez.util.exceptions;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroCreator;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class JogadaInvalidaExceptionTest {

    @Test(expected = JogadaInvalidaException.class)
    public void exceptionStringTest() {
        throw new JogadaInvalidaException("Teste!");
    }

    @Test(expected = JogadaInvalidaException.class)
    public void exceptionThrowableTest() {
        Posicao pos = new Posicao("a1", TabuleiroCreator.getInstance().criarTabuleiro());

        try {
            pos.getPeca().getCor();
        } catch (NullPointerException e) {
            throw new JogadaInvalidaException(e);
        }
    }
}
