/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.xadrez.ciu.cih;

import java.awt.Color;

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
     * @param linha Linha da casa no tabuleiro.
     * @param coluna Coluna da casa no tabuleiro.
     * @return Casa
     */
    public static JPanelCasa criarCasa(Color color, int linha, int coluna) {
        JPanelCasa casa = new JPanelCasa(color, linha, coluna);
        casa.setBackground(color);

        return casa;
    }

    /**
     * Cria uma casa com o fundo da cor preta.
     *
     * @param linha Linha da casa no tabuleiro.
     * @param coluna Coluna da casa no tabuleiro.
     * @return Casa
     */
    public static JPanelCasa criarCasaPreta(int linha, int coluna) {
        return criarCasa(Color.LIGHT_GRAY, linha, coluna);
    }

    /**
     * Cria uma casa com o fundo da cor branca.
     *
     * @param linha Linha da casa no tabuleiro.
     * @param coluna Coluna da casa no tabuleiro.
     * @return Casa
     */
    public static JPanelCasa criarCasaBranca(int linha, int coluna) {
        return criarCasa(Color.WHITE, linha, coluna);
    }
}
