/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.xadrez.ciu.cih;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * Dá suporte ao carregamento de imagens, para facilitar a elaboração de
 * componentes gráficos.
 *
 * @author possatti
 */
public enum ImageLoader {
    INSTANCE;

    //private static final String RESOURCES_FOLDER = "src/main/resources/";

    /**
     * Carrega uma imagem a partir do caminho específicado.
     *
     * @param caminho Caminho relativo a imagem.
     * @return Imagem carregada.
     * @throws java.io.IOException
     */
    public Image loadImage(String caminho) throws IOException {
        return ImageIO.read(new File(caminho));
    }

    /**
     * Carrega uma determinada imagem da pasta de "resources".
     *
     * @param nome Nome do arquivo a ser carregado.
     * @return Imagem carregada.
     * @throws IOException
     */
    public Image loadImageResource(String nome) throws IOException {
        InputStream imageInputStream = getClass().getResourceAsStream("/images/" + nome);
        return ImageIO.read(imageInputStream);
        //return ImageIO.read(new File(RESOURCES_FOLDER + nome));
    }
}
