/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
