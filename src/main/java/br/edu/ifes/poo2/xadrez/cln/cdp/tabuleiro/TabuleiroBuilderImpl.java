package br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro;

import br.edu.ifes.poo2.xadrez.cln.cdp.Posicao;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.fabrica.FabricaPecas;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.fabrica.FabricaPecasImpl;
import java.util.HashMap;
import java.util.Map;

public class TabuleiroBuilderImpl implements TabuleiroBuilder {

    private Tabuleiro tabuleiro;
    private Map<String, Posicao> posicoes;
    private final FabricaPecas fabricaPecas;

    public TabuleiroBuilderImpl() {
        inicializaBuilder();
        this.fabricaPecas = FabricaPecasImpl.getInstance();
    }

    private void inicializaBuilder() {
        this.tabuleiro = new Tabuleiro();
        this.posicoes = new HashMap<>();
    }

    @Override
    public void setPosicoes() {
        inicializaBuilder();
        //Montando as posições no Tabuleiro;
        for (char coluna = 'a'; coluna < 'i'; coluna++) {
            for (char linha = '1'; linha < '9'; linha++) {
                String idPosicao;
                Posicao posicao;

                //Montando a String
                idPosicao = "" + coluna + linha;
                //Criando a posição
                posicao = new Posicao(idPosicao, tabuleiro);
                //Salvando as posições
                posicoes.put(idPosicao, posicao);
            }
        }
        tabuleiro.setPosicoes(posicoes);
    }

    @Override
    public void setPecas() {
        criarPeoes();
        criarTorres();
        criarBispos();
        criarCavalos();
        criarReis();
        criarRainhas();
    }

    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }

    private Map<Cor, Peca[]> instanciarPecas(int quantidade, TipoPeca tipoPeca) {
        Map<Cor, Peca[]> pecas = new HashMap<>();

        pecas.put(Cor.PRETO, new Peca[quantidade]);
        pecas.put(Cor.BRANCO, new Peca[quantidade]);

        for (int nPeca = 0; nPeca < quantidade; nPeca++) {
            pecas.get(Cor.BRANCO)[nPeca] = fabricaPecas.fabricarPeca(Cor.BRANCO, tipoPeca);
            pecas.get(Cor.PRETO)[nPeca] = fabricaPecas.fabricarPeca(Cor.PRETO, tipoPeca);
        }

        return pecas;
    }

    private void criarPeoes() {
        //Criando os peoes;
        Map<Cor, Peca[]> pecas = instanciarPecas(16, TipoPeca.PEAO);

        //Salvando nas posições do Tabuleiro.
        salvarPeoes('2', pecas.get(Cor.BRANCO));
        salvarPeoes('7', pecas.get(Cor.PRETO));

    }

    private void salvarPeoes(char linha, Peca[] peoes) {
        int nPeoes = 0;
        for (char coluna = 'a'; coluna < 'i'; coluna++) {
            String idPosicao = "" + coluna + linha;
            Posicao posicao = posicoes.get(idPosicao);

            //Salvando
            posicao.setPeca(peoes[nPeoes]);
            nPeoes++;
        }
    }

    private void criarTorres() {
        Map<Cor, Peca[]> pecas = instanciarPecas(4, TipoPeca.TORRE);

        //Salvando as torres
        posicoes.get("a1").setPeca(pecas.get(Cor.BRANCO)[0]);
        posicoes.get("h1").setPeca(pecas.get(Cor.BRANCO)[1]);
        posicoes.get("a8").setPeca(pecas.get(Cor.PRETO)[0]);
        posicoes.get("h8").setPeca(pecas.get(Cor.PRETO)[1]);
    }

    private void criarBispos() {
        Map<Cor, Peca[]> pecas = instanciarPecas(4, TipoPeca.BISPO);

        //Salvando os bispos
        posicoes.get("c1").setPeca(pecas.get(Cor.BRANCO)[0]);
        posicoes.get("f1").setPeca(pecas.get(Cor.BRANCO)[1]);
        posicoes.get("c8").setPeca(pecas.get(Cor.PRETO)[0]);
        posicoes.get("f8").setPeca(pecas.get(Cor.PRETO)[1]);
    }

    private void criarCavalos() {
        Map<Cor, Peca[]> pecas = instanciarPecas(4, TipoPeca.CAVALO);

        //Salvando os cavalos
        posicoes.get("b1").setPeca(pecas.get(Cor.BRANCO)[0]);
        posicoes.get("g1").setPeca(pecas.get(Cor.BRANCO)[1]);
        posicoes.get("b8").setPeca(pecas.get(Cor.PRETO)[0]);
        posicoes.get("g8").setPeca(pecas.get(Cor.PRETO)[1]);
    }

    private void criarReis() {
        Map<Cor, Peca[]> pecas = instanciarPecas(2, TipoPeca.REI);

        //Salvando os bispos
        posicoes.get("e1").setPeca(pecas.get(Cor.BRANCO)[0]);
        posicoes.get("e8").setPeca(pecas.get(Cor.PRETO)[0]);
    }

    private void criarRainhas() {
        Map<Cor, Peca[]> pecas = instanciarPecas(2, TipoPeca.RAINHA);

        //Salvando os bispos
        posicoes.get("d1").setPeca(pecas.get(Cor.BRANCO)[0]);
        posicoes.get("d8").setPeca(pecas.get(Cor.PRETO)[0]);
    }

}
