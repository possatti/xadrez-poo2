/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo2.xadrez.ciu.cci;

import br.edu.ifes.poo2.xadrez.ciu.cih.CorPeca;
import br.edu.ifes.poo2.xadrez.ciu.cih.JPanelCasa;
import br.edu.ifes.poo2.xadrez.ciu.cih.TelaJogo;
import br.edu.ifes.poo2.xadrez.ciu.cih.TipoPecaGrafica;
import br.edu.ifes.poo2.xadrez.cln.cdp.Jogador;
import br.edu.ifes.poo2.xadrez.cln.cdp.TipoPartida;
import br.edu.ifes.poo2.xadrez.cln.cdp.dto.PecaDTO;
import br.edu.ifes.poo2.xadrez.cln.cdp.pecas.TipoPeca;
import br.edu.ifes.poo2.xadrez.cln.cgt.AplPartida;
import br.edu.ifes.poo2.xadrez.util.Validador;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Controla o aplicativo, fazendo intermédio entre o modelo de dados e a
 * interface.
 *
 * @author lucas
 */
public enum Controlador {

    INSTANCE;

    /* Indica a casa que foi clicada na interface */
    private JPanelCasa casaSelecionada;

    /* APL que controla as partidas. */
    private final AplPartida aplPartida = new AplPartida();

    /* Tela do jogo */
    private TelaJogo telaJogo;

    /**
     * Inicia a aplicação.
     */
    public void iniciarAplicacao() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Cria e exibe o formulário principal */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                telaJogo = new TelaJogo();
                telaJogo.setVisible(true);
            }
        });
    }

    /**
     * Marca uma casa do tabuleiro gráfico como selecionada.
     *
     * @param casa Casa que será marcada.
     */
    public void selecionarCasa(JPanelCasa casa) {
        // Deixa a casa selecionada.
        casa.selecionar();

        // Guarda a casa que foi clicada
        casaSelecionada = casa;
    }

    /**
     * Desmarca uma casa do tabuleiro gráfico como selecionada.
     *
     * @param casa Casa que será desmarcada.
     */
    public void deselecionarCasa(JPanelCasa casa) {
        // Desfaça a seleção da casa.
        casa.deselecionar();

        // Remove a referência a casa que anteriormente estava clicada.
        casaSelecionada = null;
    }

    /**
     * Processa os cliques dados as casas gráficas do tabuleiro.
     *
     * @param casaClicada A casa que no tabuleiro foi clicada.
     */
    public void cliqueCasa(JPanelCasa casaClicada) {
        if (casaSelecionada == null) {
            selecionarCasa(casaClicada);
        } else if (casaSelecionada == casaClicada) {
            deselecionarCasa(casaClicada);
        } else {
            // Se for um peão, e a segunda casa clicada for do outro lado do tabuleiro.
            if ((casaSelecionada.getPeca() == TipoPecaGrafica.PEAO_BRANCO
                    && casaClicada.getLinha() == 7)
                    || (casaSelecionada.getPeca() == TipoPecaGrafica.PEAO_PRETO
                    && casaClicada.getLinha() == 0)) {

                // Cria um ComboBox com as peças para as quais o peão pode ser promovido.
                TipoPeca[] items = {
                    TipoPeca.BISPO,
                    TipoPeca.CAVALO,
                    TipoPeca.RAINHA,
                    TipoPeca.TORRE
                };
                JComboBox<TipoPeca> jPecas = new JComboBox<>(items);

                // Define os elementos que irão para o diálogo.
                Object[] content = {
                    "Para qual peça o peão deve ser promovido?",
                    jPecas};
                //JOptionPane.showConfirmDialog(null, content, "Selecione uma peça", JOptionPane.OK_CANCEL_OPTION);
                JOptionPane.showMessageDialog(null, content);

                // Captura qual peça foi selecionada.
                TipoPeca peca = (TipoPeca) jPecas.getSelectedItem();

                // TODO Executar jogada com promoção.
                // TODO Deselecionar todas as casas.
            } else {
                // Separa os dados da jogada como a APL espera.
                String origem = Conversor.converterPosicao(casaSelecionada.getLinha(), casaSelecionada.getColuna());
                String destino = Conversor.converterPosicao(casaClicada.getLinha(), casaClicada.getColuna());

                // Executa jogada sem promoção.
                aplPartida.fazerJogada(origem, destino);

                // Deseleciona todas a casa de origem no tabuleiro.
                deselecionarCasa(casaSelecionada);

                // Atualiza o tabuleiro.
                atualizarTabuleiro();
            }
        }
    }

    /**
     * Exibe o diálogo para receber as informações de um novo jogador e, se tudo
     * for informado corretamente, o jogador é cadastrado.
     */
    public void cadastrarJogador() {
        // Define os dados que serão usados.
        JTextField jApelido = new JTextField();
        JTextField jEmail = new JTextField();
        JTextField jNome = new JTextField();
        String title = "Cadastrar novo jogador";
        Object[] message = {
            "Apelido:", jApelido,
            "E-mail:", jEmail,
            "Nome:", jNome,};

        // Lança o diálogo.
        int option = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);

        // Se o usuário clicou em OK
        if (option == JOptionPane.OK_OPTION) {
            // Captura as informações fornecidas pelo usuário.
            String apelido = jApelido.getText();
            String email = jEmail.getText();
            String nome = jNome.getText();

            // Verificação dos dados
            if (!apelido.matches(Validador.REGEX_APELIDO)) {
                JOptionPane.showMessageDialog(null, "O campo do apelido foi preenchido incorretamente.");
                return;
            }
            if (!email.matches(Validador.REGEX_EMAIL)) {
                JOptionPane.showMessageDialog(null, "O campo de e-mail foi preenchido incorretamente.");
                return;
            }
            if (!nome.matches(Validador.REGEX_NOME)) {
                JOptionPane.showMessageDialog(null, "O campo do nome foi preenchido incorretamente.");
                return;
            }

            // TODO Cadastrar os dados de jogador.
            //System.out.println(apelido);
            //System.out.println(email);
            //System.out.println(nome);
        }
    }

    /**
     * Exibe um diálogo para alteração dos dados de um jogador. Se todos os
     * dados forem fonecidos corretamente os dados cadastrados serão alterados.
     */
    public void editarJogador() {
        // Define os dados que serão usados.
        // TODO Usar um combobox com todos os jogadores já cadastrados no campo do
        // apelido atual.
        JTextField jApelidoAtual = new JTextField();
        JTextField jNovoApelido = new JTextField();
        JTextField jNovoEmail = new JTextField();
        JTextField jNovoNome = new JTextField();
        String title = "Editar dados de um jogador";
        Object[] message = {
            "Apelido atual:", jApelidoAtual,
            "Novo apelido:", jNovoApelido,
            "Novo e-mail:", jNovoEmail,
            "Novo nome:", jNovoNome,};

        // Lança o diálogo.
        int option = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);

        // Se o usuário clicou em OK.
        if (option == JOptionPane.OK_OPTION) {
            // Captura as informações fornecidas pelo usuário.
            String apelidoAtual = jApelidoAtual.getText();
            String novoApelido = jNovoApelido.getText();
            String novoEmail = jNovoEmail.getText();
            String novoNome = jNovoNome.getText();

            // Verificação dos dados.
            // TODO Verificar se realmente existe um jogador com o apelido atual.
            if (!novoApelido.matches(Validador.REGEX_APELIDO)) {
                JOptionPane.showMessageDialog(null, "O campo do apelido foi preenchido incorretamente.");
                return;
            }
            if (!novoEmail.matches(Validador.REGEX_EMAIL)) {
                JOptionPane.showMessageDialog(null, "O campo de e-mail foi preenchido incorretamente.");
                return;
            }
            if (!novoNome.matches(Validador.REGEX_NOME)) {
                JOptionPane.showMessageDialog(null, "O campo do nome foi preenchido incorretamente.");
                return;
            }

            // TODO alterar os dados de jogador.
            //System.out.println(novoApelido);
            //System.out.println(novoEmail);
            //System.out.println(novoNome);
        }
    }

    /**
     * Exibe um diálogo para apagar o registro de algum jogador no banco de
     * dados. Para identifica o jogador, o dado que será solicitado é o apelido
     * do jogador, pois é único.
     */
    public void apagarJogador() {
        // Define os dados que serão usados.
        // TODO Usar um combobox para obter o apelido do jogador. O combobox deve
        // ser preenchido com todos os apelidos cadastrados no banco.
        JTextField jApelido = new JTextField();
        String title = "Apagar um jogador";
        Object[] message = {
            "Apelido do jogador:", jApelido,};

        // Lança o diálogo.
        int option = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);

        // Se o usuário clicou em OK.
        if (option == JOptionPane.OK_OPTION) {
            // Captura o apelido do jogador selecionado.
            String apelido = jApelido.getText();

            // TODO Tentar deletar o jogador.
            //System.out.println(apelido);
        }
    }

    /**
     * Exibe o diálogo requerendo as informações necessárias para iniciar uma
     * nova partida singleplayer e toma conta de inicia-la corretamente e fazer
     * todas as preparações necessárias.
     */
    public void iniciarSingleplayer() {
        // Opções
        // TODO Pegar os jogadores do banco de dados mesmo.
        String[] maquinas = {"Zeus"};
        String[] jogadores = {"possatti", "phillipe"};
        String[] cores = {
            CorPeca.BRANCO.toString(),
            CorPeca.PRETO.toString()
        };

        // Define os elementos de obtenção de dados do usuário.
        JComboBox jJogador = new JComboBox(jogadores);
        JComboBox jMaquina = new JComboBox(maquinas);
        JComboBox jCorJogador = new JComboBox(cores);

        // Organiza os elementos que irão aparecer.
        String title = "Iniciar partida singleplayer";
        Object[] message = {
            "Jogador:", jJogador,
            "Máquina", jMaquina,
            "Cor do jogador:", jCorJogador
        };

        // Lança o diálogo.
        int option = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);

        // Se o usuário clicou em OK.
        if (option == JOptionPane.OK_OPTION) {
            // Captura os dados do usuário.
            String jogador = jJogador.getSelectedItem().toString();
            String maquina = jMaquina.getSelectedItem().toString();
            String cor = jCorJogador.getSelectedItem().toString();

            // Inicia um novo jogo.
            // FIXME Usar os jogadores do banco de dados mesmo.
            aplPartida.criarPartida(new Jogador("branco"), new Jogador("preto"), TipoPartida.SINGLEPLAYER);

            // Atualiza o tabuleiro conforme necessário.
            atualizarTabuleiro();
        }
    }

    /**
     * Exibe o diálogo requerendo as informações necessárias para iniciar uma
     * nova partida multiplayer e toma conta de inicia-la corretamente e fazer
     * todas as preparações necessárias.
     */
    public void iniciarMultiplayer() {
        // Opções
        // TODO Pegar os jogadores do banco de dados mesmo.
        String[] jogadores = {"possatti", "phillipe"};
        String[] cores = {
            CorPeca.BRANCO.toString(),
            CorPeca.PRETO.toString()
        };

        // Define os elementos de obtenção de dados do usuário.
        JComboBox jJogador1 = new JComboBox(jogadores);
        JComboBox jJogador2 = new JComboBox(jogadores);
        JComboBox jCorJogador = new JComboBox(cores);

        // Organiza os elementos que irão aparecer.
        String title = "Iniciar partida multiplayer";
        Object[] message = {
            "Jogador das peças brancas:", jJogador1,
            "jogador das peças pretas:", jJogador1
        };

        // Lança o diálogo.
        int option = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);

        // Se o usuário clicou em OK.
        if (option == JOptionPane.OK_OPTION) {
            // Captura os dados do usuário.
            String jogador1 = jJogador1.getSelectedItem().toString();
            String jogador2 = jJogador2.getSelectedItem().toString();
            String cor = jCorJogador.getSelectedItem().toString();

            // Verifica se os dois não são o mesmo jogador.
            if (jogador1.equals(jogador2)) {
                JOptionPane.showMessageDialog(null, "Os dois jogadores indicados, não podem ser os mesmos.");
                return;
            }

            // Inicia um novo jogo multiplayer.
            // FIXME Usar os jogadores do banco de dados mesmo.
            aplPartida.criarPartida(new Jogador("branco"), new Jogador("preto"), TipoPartida.MULTIPLAYER);

            // Atualiza o tabuleiro conforme necessário.
            atualizarTabuleiro();
        }
    }

    /**
     * Persiste a partida, para que ela possa ser continuada em outro momento.
     */
    public void salvarPartida() {
        // TODO salvar partida.
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Salva a partida em andamento e em seguida a encerra.
     */
    public void salvarPartidaETerminar() {
        // TODO salvar partida e termina-la.
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Sai da partida atual, sem salvar o progresso.
     */
    public void terminarPartidaSemSalvar() {
        // Define uma mensagem de aviso ao usuário.
        String title = "Terminar partida sem salvar";
        String message = "Tem certeza de que deseja terminar a partida sem salva-la?";

        // Lança uma caixa de diálogo ao usuário, pedindo uma confirmação.
        int option = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);

        // Se o jogador confirmar.
        if (option == JOptionPane.YES_OPTION) {
            // TODO Terminar a partida sem salvar.
        }
    }

    /**
     * Atualiza o tabuleiro que está representado graficamente, com a
     * correspondência do que realmente está dentro do jogo.
     */
    public void atualizarTabuleiro() {
        // Pega o estado atual do tabuleiro no modelo.
        PecaDTO[][] tabuleiroModelo = aplPartida.getTabuleiro();

        // Converte para a forma como o ambiente gráfico usa o tabuleiro.
        TipoPecaGrafica[][] tabuleiroGrafico = Conversor.converterTabuleiro(tabuleiroModelo);

        // Atualiza a tela do jogo.
        telaJogo.atualizarJPanelTabuleiro(tabuleiroGrafico);
    }
}
