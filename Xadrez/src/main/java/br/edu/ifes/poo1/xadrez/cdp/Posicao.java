/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import br.edu.ifes.poo1.xadrez.cdp.pecas.PecaImpl;

/**
 *
 * @author phillipe
 */
public class Posicao {

    private String id;
    private Peca peca = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Peca getPeca() {
        return peca;
    }

    /**
     * Coloca uma peca na posição e retira da posição anterior.
     *
     * @param peca
     */
    public void setPeca(Peca peca) {
        Posicao posicaoAnt;
        this.peca = peca;

        try {
            posicaoAnt = peca.getPosicao();
        } catch (NullPointerException e) {
            return;
        }

        if (posicaoAnt != null) {
            posicaoAnt.setPeca(null);
        }

        peca.setPosicao(this);
    }

    /**
     *
     * @return Retorna true se há alguma peça na posição atual e false caso
     * contrário.
     */
    public boolean existePeca() {
        return this.peca != null;
    }

    
}
