/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.xadrez.ciu.cih;

import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * Enumera os tipos de peças que podem existir, graficamente.
 *
 * @author possatti
 */
public enum TipoPecaGrafica {

    BISPO_PRETO("black_bishop.png"),
    REI_PRETO("black_king.png"),
    CAVALO_PRETO("black_knight.png"),
    PEAO_PRETO("black_pawn.png"),
    DAMA_PRETO("black_queen.png"),
    TORRE_PRETO("black_rook.png"),
    BISPO_BRANCO("white_bishop.png"),
    REI_BRANCO("white_king.png"),
    CAVALO_BRANCO("white_knight.png"),
    PEAO_BRANCO("white_pawn.png"),
    DAMA_BRANCO("white_queen.png"),
    TORRE_BRANCO("white_rook.png");

    /**
     * Imagem que representa a peça, graficamente.
     */
    private Image image;

    /**
     * Icone de imagem, que pode ser usado para exibir a figura da peça na tela.
     */
    private ImageIcon icon;

    /**
     * Inicia o tipo da peça, guardando uma referência para a imagem que
     * representa o tipo da peça.
     *
     * @param nomeArquivo Nome do arquivo da imagem.
     */
    private TipoPecaGrafica(String nomeArquivo) {
        try {
            // Carrega o arquivo de imagem da peça e associa a instância.
            this.image = ImageLoader.INSTANCE.loadImageResource(nomeArquivo);
            this.icon = new ImageIcon(this.image);
        } catch (IOException ex) {
            // Grava no log se as imagens não forem encontradas.
            Logger.getLogger(TipoPecaGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Image getImage() {
        return image;
    }

    public ImageIcon getIcon() {
        return icon;
    }

}
