/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.pecas;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.MovimentoPeca;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.TipoPeca;

/**
 *
 * @author phillipe
 */
public class Torre extends PecaImpl {

    public Torre() {
        desenho = "T";
        tipo=TipoPeca.TORRE;
        
    }
    
    
    @Override
    public boolean validarMovimento(Posicao novaPosicao) {

        return MovimentoPeca.isStraight(this.getPosicao(), novaPosicao);
    }
    
    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
