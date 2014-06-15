package br.edu.ifes.poo2.xadrez.util.exceptions;

/**
 *
 * @author phillipe
 */
public class ClonagemException extends RuntimeException {

    public ClonagemException(String message) {
        super(message);
    }

    public ClonagemException(Throwable cause) {
        super(cause);
    }

}
