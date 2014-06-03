/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.xadrez.ciu.cih;

/**
 * Representa a cor de uma peça.
 * 
 * @author possatti
 */
public enum CorPeca {

    PRETO("Preto"), BRANCO("Branco");

    private String nome;

    private CorPeca(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
