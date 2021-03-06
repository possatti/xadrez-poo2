package br.edu.ifes.poo2.xadrez.cln.cdp;

import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;
import java.util.List;
import java.util.Map;

public enum InteligenciaArtificial {

    INSTANCE;

    public static InteligenciaArtificial getInstance() {
        return INSTANCE;
    }

    public String[] calcularJogada(Tabuleiro tabuleiro, Cor corJogador) {
        String[] jogada = new String[2];
        Map<String, Posicao> posicoes = tabuleiro.getPosicoes();
        List<Peca> pecas = tabuleiro.getPecas(corJogador);

        for (Map.Entry<String, Posicao> entry : posicoes.entrySet()) {
            Posicao posicao = entry.getValue();
            for (Peca peca : pecas) {
                // Verificamos se é um movimento possível.
                if (movimentoPossivel(peca, posicao, tabuleiro)) {
                    jogada[0] = peca.getPosicao().getId();
                    jogada[1] = posicao.getId();
                    // Verificamos se é uma captura possível.
                } else if (capturaPossivel(peca, posicao, tabuleiro)) {
                    jogada[1] = posicao.getId();
                    jogada[0] = peca.getPosicao().getId();
                    // Verificado se é um Roque maior.
                } else if (tabuleiro.isRoqueMaior(peca.getPosicao())) {
                    jogada[0] = peca.getPosicao().getId();
                    // Verificado se é um Roque menor.
                } else if (tabuleiro.isRoqueMenor(peca.getPosicao())) {
                    jogada[0] = peca.getPosicao().getId();
                    // Verifica se é um Xeque.
                } else if (tabuleiro.isXeque(peca.getPosicao(), posicao) && !tabuleiro.isXequeMate(peca.getPosicao(), posicao)) {
                    jogada[0] = peca.getPosicao().getId();
                    jogada[1] = posicao.getId();
                    // Verifica se é um xeque mate.
                } else if (tabuleiro.isXequeMate(peca.getPosicao(), posicao)) {
                    jogada[0] = peca.getPosicao().getId();
                    jogada[1] = posicao.getId();
                }
            }
        }
        return jogada;
    }

    private boolean capturaPossivel(Peca peca, Posicao posicao, Tabuleiro tabuleiro) {
        return (peca.validarMovimentoCaptura(posicao) && posicao.getPeca().getTipoPeca() != TipoPeca.REI) || tabuleiro.isEnPassant(peca.getPosicao(), posicao);
    }

    private boolean movimentoPossivel(Peca peca, Posicao posicao, Tabuleiro tabuleiro) {
        return peca.validarMovimento(posicao) && !tabuleiro.isXeque(peca.getPosicao(), posicao);
    }

}
