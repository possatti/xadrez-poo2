/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.xadrez.ciu.cih;

/**
 *
 * @author possatti
 */
public class JPanelChat extends javax.swing.JPanel {

    /**
     * Creates new form JPanelChat
     */
    public JPanelChat() {
        initComponents();
    }
    
    /**
     * Envia a mensagem do campo de texto para a tela do chat.
     */
    public void enviarMensagem() {
        String mensagem = jTextFieldMensagem.getText();
        
        // Se a string não estiver vazia. A mensagem e adicionada ao chat.
        if(!"".equals(mensagem)) {
            jTextAreaChat.append(mensagem + "\n");
            jTextFieldMensagem.setText("");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaChat = new javax.swing.JTextArea();
        jTextFieldMensagem = new javax.swing.JTextField();
        jButtonEnviar = new javax.swing.JButton();

        jTextAreaChat.setEditable(false);
        jTextAreaChat.setColumns(20);
        jTextAreaChat.setLineWrap(true);
        jTextAreaChat.setPreferredSize(null);
        jScrollPane1.setViewportView(jTextAreaChat);

        jTextFieldMensagem.setPreferredSize(null);
        jTextFieldMensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMensagemtecla_enter(evt);
            }
        });

        jButtonEnviar.setText("Enviar");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTextFieldMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEnviar)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldMensagemtecla_enter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMensagemtecla_enter
        // Se a tecla enter for pressionada, manda a mensagem para o chat.
        if ('\n' == evt.getKeyChar()) {
            enviarMensagem();
        }
    }//GEN-LAST:event_jTextFieldMensagemtecla_enter

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        enviarMensagem();
    }//GEN-LAST:event_jButtonEnviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaChat;
    private javax.swing.JTextField jTextFieldMensagem;
    // End of variables declaration//GEN-END:variables
}
