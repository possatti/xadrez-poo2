package br.edu.ifes.poo2.xadrez.cln.cgt;

import br.edu.ifes.poo2.xadrez.cln.cdp.InteligenciaArtificial;
import br.edu.ifes.poo2.xadrez.cln.cdp.Partida;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroBuilderImpl;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.TabuleiroDirector;
import br.edu.ifes.poo2.xadrez.cln.cdp.Jogador;
import br.edu.ifes.poo2.xadrez.cln.cdp.tabuleiro.Tabuleiro;

public class AplPartida {

    private Partida partidaAtual;

    private final InteligenciaArtificial inteligenciaArtificial;

    private final TabuleiroBuilderImpl tabuleiroBuilder;

    private final TabuleiroDirector tabuleiroDirector;

    public AplPartida() {
        this.inteligenciaArtificial = InteligenciaArtificial.getInstance();
        this.tabuleiroBuilder = new TabuleiroBuilderImpl();
        this.tabuleiroDirector = new TabuleiroDirector(tabuleiroBuilder);
    }

    private void fazerJogada() {

    }

    public void fazerJogada(String posicaoInicial, String posicaoFinal) {

    }

    public void criarPartida(Jogador jogadorBranco, Jogador jogadorPreto) {
        Tabuleiro novoTabuleiro;

        tabuleiroDirector.criarTabuleiro();
        novoTabuleiro = tabuleiroBuilder.getTabuleiro();

        this.partidaAtual = new Partida(jogadorBranco, jogadorPreto, novoTabuleiro);
    }

    public void getTabuleiro() {

    }

    public void carregarPartida(String id) {

    }

}
