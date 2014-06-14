package br.edu.ifes.poo2.xadrez.util.exceptions;

/**
 *
 * @author phillipe
 */
public class JogadaInvalidaException extends RuntimeException {

    public JogadaInvalidaException(String message) {
        super(message);
    }

    public JogadaInvalidaException(Throwable cause) {
        super(cause);
    }
}
