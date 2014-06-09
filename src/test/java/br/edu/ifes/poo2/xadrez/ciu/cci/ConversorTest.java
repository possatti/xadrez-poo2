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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author possatti
 */
public class ConversorTest {

    // Tabuleiros
    PecaDTO[][] tabuleiroModelo = new PecaDTO[8][8];
    TipoPecaGrafica[][] tabuleiroGrafico = new TipoPecaGrafica[8][8];

    @Before
    public void setUp() {
        construirTabuleiroModelo();
        construirTabuleiroGrafico();
    }

    public void construirTabuleiroModelo() {
        // Posiciona peões brancos.
        for (int coluna = 0; coluna < 8; coluna++) {
            tabuleiroModelo[coluna][1] = new PecaDTO(TipoPeca.PEAO, Cor.BRANCO);
        }

        // Posiciona peões pretos.
        for (int coluna = 0; coluna < 8; coluna++) {
            tabuleiroModelo[coluna][6] = new PecaDTO(TipoPeca.PEAO, Cor.PRETO);
        }

        // Posiciona outras peças brancas.
        tabuleiroModelo[0][0] = new PecaDTO(TipoPeca.TORRE, Cor.BRANCO);
        tabuleiroModelo[1][0] = new PecaDTO(TipoPeca.CAVALO, Cor.BRANCO);
        tabuleiroModelo[2][0] = new PecaDTO(TipoPeca.BISPO, Cor.BRANCO);
        tabuleiroModelo[3][0] = new PecaDTO(TipoPeca.RAINHA, Cor.BRANCO);
        tabuleiroModelo[4][0] = new PecaDTO(TipoPeca.REI, Cor.BRANCO);
        tabuleiroModelo[5][0] = new PecaDTO(TipoPeca.BISPO, Cor.BRANCO);
        tabuleiroModelo[6][0] = new PecaDTO(TipoPeca.CAVALO, Cor.BRANCO);
        tabuleiroModelo[7][0] = new PecaDTO(TipoPeca.TORRE, Cor.BRANCO);

        // Posiciona outras peças pretas.
        tabuleiroModelo[0][7] = new PecaDTO(TipoPeca.TORRE, Cor.PRETO);
        tabuleiroModelo[1][7] = new PecaDTO(TipoPeca.CAVALO, Cor.PRETO);
        tabuleiroModelo[2][7] = new PecaDTO(TipoPeca.BISPO, Cor.PRETO);
        tabuleiroModelo[3][7] = new PecaDTO(TipoPeca.RAINHA, Cor.PRETO);
        tabuleiroModelo[4][7] = new PecaDTO(TipoPeca.REI, Cor.PRETO);
        tabuleiroModelo[5][7] = new PecaDTO(TipoPeca.BISPO, Cor.PRETO);
        tabuleiroModelo[6][7] = new PecaDTO(TipoPeca.CAVALO, Cor.PRETO);
        tabuleiroModelo[7][7] = new PecaDTO(TipoPeca.TORRE, Cor.PRETO);
    }

    public void construirTabuleiroGrafico() {
        // Posiciona peões brancos.
        for (int coluna = 0; coluna < 8; coluna++) {
            tabuleiroGrafico[1][coluna] = TipoPecaGrafica.PEAO_BRANCO;
        }

        // Posiciona peões pretos.
        for (int coluna = 0; coluna < 8; coluna++) {
            tabuleiroGrafico[6][coluna] = TipoPecaGrafica.PEAO_PRETO;
        }

        // Posiciona outras peças brancas.
        tabuleiroGrafico[0][0] = TipoPecaGrafica.TORRE_BRANCO;
        tabuleiroGrafico[0][1] = TipoPecaGrafica.CAVALO_BRANCO;
        tabuleiroGrafico[0][2] = TipoPecaGrafica.BISPO_BRANCO;
        tabuleiroGrafico[0][3] = TipoPecaGrafica.DAMA_BRANCO;
        tabuleiroGrafico[0][4] = TipoPecaGrafica.REI_BRANCO;
        tabuleiroGrafico[0][5] = TipoPecaGrafica.BISPO_BRANCO;
        tabuleiroGrafico[0][6] = TipoPecaGrafica.CAVALO_BRANCO;
        tabuleiroGrafico[0][7] = TipoPecaGrafica.TORRE_BRANCO;

        // Posiciona outras peças pretas.
        tabuleiroGrafico[7][0] = TipoPecaGrafica.TORRE_PRETO;
        tabuleiroGrafico[7][1] = TipoPecaGrafica.CAVALO_PRETO;
        tabuleiroGrafico[7][2] = TipoPecaGrafica.BISPO_PRETO;
        tabuleiroGrafico[7][3] = TipoPecaGrafica.DAMA_PRETO;
        tabuleiroGrafico[7][4] = TipoPecaGrafica.REI_PRETO;
        tabuleiroGrafico[7][5] = TipoPecaGrafica.BISPO_PRETO;
        tabuleiroGrafico[7][6] = TipoPecaGrafica.CAVALO_PRETO;
        tabuleiroGrafico[7][7] = TipoPecaGrafica.TORRE_PRETO;
    }

    @Test
    public void testConverterPosicao() {
        // Dados segundo a interface.
        int linha = 3;
        int coluna = 4;

        // Define o resultado esperado.
        String expResult = "e4";

        // Converte os dados.
        String result = Conversor.converterPosicao(linha, coluna);

        // Verifica se os resultados batem.
        assertEquals(expResult, result);
    }

    @Test
    public void testConverterTabuleiro() {
        // Converte o tabuleiro.
        TipoPecaGrafica[][] result = Conversor.converterTabuleiro(tabuleiroModelo);

        // Verifica se a conversão aconteceu corretamente.
        assertArrayEquals(tabuleiroGrafico, result);
    }

    @Test
    public void testConverterPeca() {
        // DTOs de peças.
        PecaDTO pecaDTO1 = new PecaDTO(TipoPeca.CAVALO, Cor.PRETO);
        PecaDTO pecaDTO2 = new PecaDTO(TipoPeca.RAINHA, Cor.PRETO);
        PecaDTO pecaDTO3 = new PecaDTO(TipoPeca.CAVALO, Cor.BRANCO);

        // Converssões.
        TipoPecaGrafica result1 = Conversor.converterPeca(pecaDTO1);
        TipoPecaGrafica result2 = Conversor.converterPeca(pecaDTO2);
        TipoPecaGrafica result3 = Conversor.converterPeca(pecaDTO3);
        TipoPecaGrafica resultNull = Conversor.converterPeca(null);

        // Verifica se os resultados estão como o esperado.
        assertEquals(TipoPecaGrafica.CAVALO_PRETO, result1);
        assertEquals(TipoPecaGrafica.DAMA_PRETO, result2);
        assertEquals(TipoPecaGrafica.CAVALO_BRANCO, result3);
        assertEquals(null, resultNull);
    }

}
