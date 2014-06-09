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
import java.util.HashMap;

public class FabricaPecasImpl implements FabricaPecas {

    private final Map<TipoPeca, Peca> prototiposPecasBrancas;
    private final Map<TipoPeca, Peca> prototiposPecasPretas;

    private FabricaPecasImpl() {
        prototiposPecasBrancas = new HashMap<>();
        prototiposPecasPretas = new HashMap<>();
    }

    private static class FabricaPecasSingletonHolder {

        static FabricaPecasImpl instance = new FabricaPecasImpl();

        private FabricaPecasSingletonHolder() {

        }
    }

    public static FabricaPecas getInstance() {
        return FabricaPecasSingletonHolder.instance;
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
            throw new RuntimeException(ex);
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
        switch (cor) {
            case BRANCO:
                return this.prototiposPecasBrancas;
            case PRETO:
                return this.prototiposPecasPretas;
            default:
                throw new RuntimeException("Nao foi possivel obter instancia  de Map<TipoPeca, Peca>.");
        }
    }

    private boolean estaInstanciada(Cor cor, TipoPeca tipoPeca) {
        return (cor == Cor.BRANCO && prototiposPecasBrancas.containsKey(tipoPeca))
                || (cor == Cor.PRETO && prototiposPecasPretas.containsKey(tipoPeca));
    }

}
