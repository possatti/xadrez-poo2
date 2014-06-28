package br.edu.ifes.poo2.xadrez.cln.cdp.pecas.fabrica;

import java.util.Map;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Peca;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.Cor;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.PecaImpl;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias.StrategyBispo;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias.StrategyCavalo;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias.StrategyPeao;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias.StrategyRainha;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias.StrategyRei;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.estrategias.StrategyTorre;
import br.edu.ifes.poo2.xadrez.util.exceptions.ClonagemException;
import java.util.HashMap;

public enum FabricaPecasImpl implements FabricaPecas {

    INSTANCE;

    private final Map<TipoPeca, Peca> prototiposPecasBrancas;
    private final Map<TipoPeca, Peca> prototiposPecasPretas;

    private FabricaPecasImpl() {
        prototiposPecasBrancas = new HashMap<>();
        prototiposPecasPretas = new HashMap<>();
    }

    public static FabricaPecas getInstance() {
        return INSTANCE;
    }

    @Override
    public Peca fabricarPeca(Cor cor, TipoPeca tipoPeca) {
        if (!estaInstanciada(cor, tipoPeca)) {
            PecaImpl novaPeca = new PecaImpl();
            novaPeca.setTipoPeca(tipoPeca);
            novaPeca.setCor(cor);
            setStrategy(novaPeca);
            addToMap(cor, novaPeca);
        }

        try {
            return getMap(cor).get(tipoPeca).clone();
        } catch (CloneNotSupportedException ex) {
            throw new ClonagemException(ex);
        }
    }

    private void setStrategy(PecaImpl peca) {
        switch (peca.getTipoPeca()) {
        case BISPO:
            peca.setEstrategia(new StrategyBispo());
            break;
        case CAVALO:
            peca.setEstrategia(new StrategyCavalo());
            break;
        case PEAO:
            peca.setEstrategia(new StrategyPeao());
            break;
        case RAINHA:
            peca.setEstrategia(new StrategyRainha());
            break;
        case REI:
            peca.setEstrategia(new StrategyRei());
            break;
        case TORRE:
            peca.setEstrategia(new StrategyTorre());
            break;
        default:
            break;
        }
    }

    private void addToMap(Cor cor, Peca peca) {
        if (cor == Cor.BRANCO) {
            prototiposPecasBrancas.put(peca.getTipoPeca(), peca);
        } else if (cor == Cor.PRETO) {
            prototiposPecasPretas.put(peca.getTipoPeca(), peca);
        }
    }

    private Map<TipoPeca, Peca> getMap(Cor cor) {
        return cor == Cor.BRANCO ? this.prototiposPecasBrancas : this.prototiposPecasPretas;
    }

    private boolean estaInstanciada(Cor cor, TipoPeca tipoPeca) {
        return (cor == Cor.BRANCO && prototiposPecasBrancas.containsKey(tipoPeca)) || (cor == Cor.PRETO && prototiposPecasPretas.containsKey(tipoPeca));
    }

}
