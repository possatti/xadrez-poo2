/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author phillipe
 */
public class Tabuleiro {

    private Map<String, Posicao> mapNomePosicao = new HashMap<>();
    private Map<Posicao, String> mapPosicaoNome = new HashMap<>();
    private static final Tabuleiro instance = new Tabuleiro();

    public Tabuleiro() {
        //Criando Posições.
        Posicao[] posicoes;
        posicoes = new Posicao[64];

        for (int nPosicao = 0; nPosicao < posicoes.length; nPosicao++) {
            posicoes[nPosicao] = new Posicao();
        }

        salvarPosicoes(posicoes);
        criaPeoes();
        criarTorres();
        criarBispos();
        criarCavalos();

    }

    /**
     *
     * @return Uma instância de Tabuleiro.
     */
    public static Tabuleiro getInstance() {
        return Tabuleiro.instance;
    }

    public Peca getPeca(String posicao) {
        return Tabuleiro.instance.mapNomePosicao.get(posicao).getPecaAtual();
    }

    public Posicao getPosicao(String id) {
        return Tabuleiro.instance.mapNomePosicao.get(id);
    }

    /**
     *
     * @param posicoes Vetor de posições.
     */
    private void salvarPosicoes(Posicao[] posicoes) {
        //Montando as posições no Tabuleiro;
        int contadorPosicoes = 0;

        for (char coluna = 'a'; coluna < 'i'; coluna++) {
            for (char linha = '1'; linha < '9'; linha++) {
                StringBuffer idPosicao;
                idPosicao = new StringBuffer();
                //Montando a String
                idPosicao.append(coluna);
                idPosicao.append(linha);
                //Salvando as posições
                mapNomePosicao.put(idPosicao.toString(), posicoes[contadorPosicoes]);
                mapPosicaoNome.put(posicoes[contadorPosicoes], idPosicao.toString());
                contadorPosicoes++;
            }
        }

    }

    //Funções de criação das peças. São utilizadas no construtor da Classe.    
    private void criaPeoes() {
        //Criando os peoes;
        PecasFactory pecasFactory = new PecasFactory();
        Map<Cor, Peca[]> pecas = pecasFactory.getPecas(16, "Peao");

        //Salvando nas posições do Tabuleiro.
        salvarPeoes('2', pecas.get(Cor.BRANCO));
        salvarPeoes('7', pecas.get(Cor.PRETO));

    }

    private void salvarPeoes(char linha, Peca[] peoes) {
        int nPeoes = 0;
        for (char coluna = 'a'; coluna < 'i'; coluna++) {
            StringBuffer posicao;
            posicao = new StringBuffer();

            //Montando a posicao.
            posicao.append(coluna);
            posicao.append(linha);

            //Salvando
            mapNomePosicao.get(posicao.toString()).setPecaAtual(peoes[nPeoes]);
            nPeoes++;
        }
    }

    private void criarTorres() {
        PecasFactory pecasFactory = new PecasFactory();
        Map<Cor, Peca[]> pecas = pecasFactory.getPecas(4, "Torre");

        //Salvando as torres
        mapNomePosicao.get("a1").setPecaAtual(pecas.get(Cor.BRANCO)[0]);
        mapNomePosicao.get("h1").setPecaAtual(pecas.get(Cor.BRANCO)[1]);
        mapNomePosicao.get("a8").setPecaAtual(pecas.get(Cor.PRETO)[0]);
        mapNomePosicao.get("h8").setPecaAtual(pecas.get(Cor.PRETO)[1]);
    }

    private void criarBispos() {
        PecasFactory pecasFactory = new PecasFactory();
        Map<Cor, Peca[]> pecas = pecasFactory.getPecas(4, "Bispo");

        //Salvando os bispos
        mapNomePosicao.get("b1").setPecaAtual(pecas.get(Cor.BRANCO)[0]);
        mapNomePosicao.get("g1").setPecaAtual(pecas.get(Cor.BRANCO)[1]);
        mapNomePosicao.get("b8").setPecaAtual(pecas.get(Cor.PRETO)[0]);
        mapNomePosicao.get("g8").setPecaAtual(pecas.get(Cor.PRETO)[1]);
    }

    private void criarCavalos() {
        PecasFactory pecasFactory = new PecasFactory();
        Map<Cor, Peca[]> pecas = pecasFactory.getPecas(4, "Cavalo");

        //Salvando os bispos
        mapNomePosicao.get("c1").setPecaAtual(pecas.get(Cor.BRANCO)[0]);
        mapNomePosicao.get("f1").setPecaAtual(pecas.get(Cor.BRANCO)[1]);
        mapNomePosicao.get("c8").setPecaAtual(pecas.get(Cor.PRETO)[0]);
        mapNomePosicao.get("f8").setPecaAtual(pecas.get(Cor.PRETO)[1]);
    }

    private void criarReis() {
        PecasFactory pecasFactory = new PecasFactory();
        Map<Cor, Peca[]> pecas = pecasFactory.getPecas(2, "Rei");

        //Salvando os bispos
        mapNomePosicao.get("d1").setPecaAtual(pecas.get(Cor.BRANCO)[0]);
        mapNomePosicao.get("d8").setPecaAtual(pecas.get(Cor.PRETO)[0]);
    }

    private void criarRainhas() {
        PecasFactory pecasFactory = new PecasFactory();
        Map<Cor, Peca[]> pecas = pecasFactory.getPecas(2, "Rainha");

        //Salvando os bispos
        mapNomePosicao.get("e1").setPecaAtual(pecas.get(Cor.BRANCO)[0]);
        mapNomePosicao.get("e8").setPecaAtual(pecas.get(Cor.PRETO)[0]);
    }
}
