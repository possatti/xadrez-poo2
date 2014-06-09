/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.xadrez.ciu.cci;

import br.edu.ifes.poo2.xadrez.ciu.cih.TipoPecaGrafica;
import br.edu.ifes.poo2.xadrez.cln.cdp.dto.PecaDTO;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca;

/**
 * Fornece uma série de métodos para facilitar a conversão de dados entre o
 * controlador e a camada de gestão de tarefas.
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

    /**
     * Converte o tabuleiro da sua representação no modelo para a sua
     * representação que é usada pelos combonentes gráficos.
     *
     * @param tabuleiroModelo Representação do tabuleiro segundo o modelo.
     * @return
     */
    public static TipoPecaGrafica[][] converterTabuleiro(PecaDTO[][] tabuleiroModelo) {
        // Inicia o novo tabuleiro.
        TipoPecaGrafica[][] tabuleiroGrafico = new TipoPecaGrafica[8][8];

        // É necessário rotaciona-los para fazer a conversão.
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                PecaDTO pecaDTO = tabuleiroModelo[coluna][linha];
                tabuleiroGrafico[linha][coluna] = converterPeca(pecaDTO);
            }
        }

        return tabuleiroGrafico;
    }

    public static TipoPecaGrafica converterPeca(PecaDTO dto) {
        // Se não há peça, devolvemos null.
        if (dto == null) {
            return null;
        }

        // Pega os dados do DTO.
        Cor corPeca = dto.getCor();
        TipoPeca tipoPeca = dto.getTipoPeca();
        TipoPecaGrafica pecaGrafica = null;

        // Converte para a peça gráfica.
        if (corPeca == Cor.BRANCO) {
            if (tipoPeca == TipoPeca.TORRE) {
                pecaGrafica = TipoPecaGrafica.TORRE_BRANCO;
            } else if (tipoPeca == TipoPeca.CAVALO) {
                pecaGrafica = TipoPecaGrafica.CAVALO_BRANCO;
            } else if (tipoPeca == TipoPeca.BISPO) {
                pecaGrafica = TipoPecaGrafica.BISPO_BRANCO;
            } else if (tipoPeca == TipoPeca.RAINHA) {
                pecaGrafica = TipoPecaGrafica.DAMA_BRANCO;
            } else if (tipoPeca == TipoPeca.REI) {
                pecaGrafica = TipoPecaGrafica.REI_BRANCO;
            } else if (tipoPeca == TipoPeca.PEAO) {
                pecaGrafica = TipoPecaGrafica.PEAO_BRANCO;
            }
        } else {
            if (tipoPeca == TipoPeca.TORRE) {
                pecaGrafica = TipoPecaGrafica.TORRE_PRETO;
            } else if (tipoPeca == TipoPeca.CAVALO) {
                pecaGrafica = TipoPecaGrafica.CAVALO_PRETO;
            } else if (tipoPeca == TipoPeca.BISPO) {
                pecaGrafica = TipoPecaGrafica.BISPO_PRETO;
            } else if (tipoPeca == TipoPeca.RAINHA) {
                pecaGrafica = TipoPecaGrafica.DAMA_PRETO;
            } else if (tipoPeca == TipoPeca.REI) {
                pecaGrafica = TipoPecaGrafica.REI_PRETO;
            } else if (tipoPeca == TipoPeca.PEAO) {
                pecaGrafica = TipoPecaGrafica.PEAO_PRETO;
            }
        }

        return pecaGrafica;
    }
}
