package br.edu.ifes.poo2.xadrez.util.exceptions;

/**
 *
 * @author phillipe
 */
public class PosicaoInvalidaException extends RuntimeException {

    public PosicaoInvalidaException(String string) {
        super(string);
    }

    public PosicaoInvalidaException(Throwable cause) {
        super(cause);
    }

}
