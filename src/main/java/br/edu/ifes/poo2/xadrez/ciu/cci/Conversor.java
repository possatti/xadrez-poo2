/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.xadrez.ciu.cci;

/**
 * Possui métodos para conversão de dados que sejam úteis para fazer a
 * comunicação entre o controlador e a camada de gestão de tarefas.
 *
 * @author possatti
 */
public class Conversor {

    /**
     * Impede que a classe seja instânciada externamente.
     */
    private Conversor() {
    }

    /**
     * Converte uma posição da sua representação na interface gráfica para a sua
     * representação que é usada na APL.
     *
     * @param linha Linha da posição, variando de 0 a 7.
     * @param coluna Coluna da posição, variando de 0 a 7.
     * @return String no formato que a APL aceita.
     */
    public static String converterPosicao(int linha, int coluna) throws NumberFormatException {
        String strLinha = String.valueOf(linha + 1);
        String strColuna;
        switch (coluna) {
            case 0:
                strColuna = "a";
                break;
            case 1:
                strColuna = "b";
                break;
            case 2:
                strColuna = "c";
                break;
            case 3:
                strColuna = "d";
                break;
            case 4:
                strColuna = "e";
                break;
            case 5:
                strColuna = "f";
                break;
            case 6:
                strColuna = "g";
                break;
            case 7:
                strColuna = "h";
                break;
            default:
                throw new NumberFormatException("Linha fora do alcançe do tabuleiro.");
        }
        return strColuna + strLinha;
    }

}
