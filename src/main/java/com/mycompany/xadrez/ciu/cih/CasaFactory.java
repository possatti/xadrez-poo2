/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.xadrez.ciu.cih;

import java.awt.Color;
import javax.swing.JLabel;

/**
 * Componente visual que representa uma casa no tabuleiro.
 *
 * @author possatti
 */
public class CasaFactory {

    private CasaFactory() {
    }

    /**
     * Cria uma casa com a cor especificada como fundo.
     *
     * @param color Cor do fundo
     * @return Casa
     */
    public static JPanelCasa criarCasa(Color color, int linha, int coluna) {
        JPanelCasa casa = new JPanelCasa(linha, coluna);
        casa.setBackground(color);
        casa.add(new JLabel());

        return casa;
    }

    /**
     * Cria uma casa com o fundo da cor preta.
     *
     * @return Casa
     */
    public static JPanelCasa criarCasaPreta(int linha, int coluna) {
        return criarCasa(Color.BLACK, linha, coluna);
    }

    /**
     * Cria uma casa com o fundo da cor branca.
     *
     * @return Casa
     */
    public static JPanelCasa criarCasaBranca(int linha, int coluna) {
        return criarCasa(Color.WHITE, linha, coluna);
    }
}
