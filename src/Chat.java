
import java.awt.Color;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.TopicSubscriber;
import net.miginfocom.swing.MigLayout;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author kaion
 */
public class Chat extends javax.swing.JFrame {

    private static ChatConnection chat;

    /**
     * Creates new form NewJFrame
     */
    public Chat() {
        initComponents();

        chatPanel.setLayout(new MigLayout("fillx"));
    }

    public void setChatObject(ChatConnection chat) {
        System.out.println(chat.toString());
        this.chat = chat;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        chatPanel = new javax.swing.JPanel();
        generalChatButton = new javax.swing.JButton();
        private1Button = new javax.swing.JButton();
        private2Button = new javax.swing.JButton();
        private3Button = new javax.swing.JButton();
        sendButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout chatPanelLayout = new javax.swing.GroupLayout(chatPanel);
        chatPanel.setLayout(chatPanelLayout);
        chatPanelLayout.setHorizontalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );
        chatPanelLayout.setVerticalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(chatPanel);

        generalChatButton.setText("Chat Geral");
        generalChatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalChatButtonActionPerformed(evt);
            }
        });

        private1Button.setText("Chat privado 1");
        private1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                private1ButtonActionPerformed(evt);
            }
        });

        private2Button.setText("Chat privado 2");
        private2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                private2ButtonActionPerformed(evt);
            }
        });

        private3Button.setText("Chat privado 3");
        private3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                private3ButtonActionPerformed(evt);
            }
        });

        sendButton.setBackground(new java.awt.Color(51, 51, 51));
        sendButton.setForeground(new java.awt.Color(255, 255, 255));
        sendButton.setText("Enviar");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        messageTextArea.setColumns(20);
        messageTextArea.setLineWrap(true);
        messageTextArea.setRows(5);
        jScrollPane2.setViewportView(messageTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generalChatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(private1Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(private2Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(private3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(private3Button, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(private2Button)
                        .addComponent(private1Button))
                    .addComponent(generalChatButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(4, 4, 4)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generalChatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalChatButtonActionPerformed
        generalChatButton.setBackground(Color.red);
        private1Button.setBackground(new Color(187,187,187));
        private2Button.setBackground(new Color(187,187,187));
        private3Button.setBackground(new Color(187,187,187));
        
        try {
            String username = chat.getUsername();
            chat.close();
            chat = new ChatConnection("QueueCF", "all", username, chatPanel, false);
        } catch (JMSException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_generalChatButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        String text = messageTextArea.getText().trim();
        try {
            MessageRight item = new MessageRight(chat.getUsername() + ": " + text);
            chat.writeMessage(text);
            chatPanel.add(item, "wrap, al right");
            chatPanel.repaint();
            chatPanel.revalidate();
            messageTextArea.setText("");
        } catch (JMSException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_sendButtonActionPerformed

    private void private2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_private2ButtonActionPerformed
        private2Button.setBackground(Color.red);
        generalChatButton.setBackground(new Color(187,187,187));
        private1Button.setBackground(new Color(187,187,187));
        private3Button.setBackground(new Color(187,187,187));
        
        try {
            String username = chat.getUsername();
            chat.close();
            chat = new ChatConnection("QueueCF", "private2", "P-" + username, chatPanel, true);
        } catch (JMSException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_private2ButtonActionPerformed

    private void private1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_private1ButtonActionPerformed
        private1Button.setBackground(Color.red);
        generalChatButton.setBackground(new Color(78, 80, 82));
        private2Button.setBackground(new Color(187,187,187));
        private3Button.setBackground(new Color(187,187,187));
        
        try {
            String username = chat.getUsername();
            chat.close();
            chat = new ChatConnection("QueueCF", "private1", "P-" + username, chatPanel, true);
        } catch (JMSException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_private1ButtonActionPerformed

    private void private3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_private3ButtonActionPerformed
        private3Button.setBackground(Color.red);
        generalChatButton.setBackground(new Color(78, 80, 82));
        private1Button.setBackground(new Color(187,187,187));
        private2Button.setBackground(new Color(187,187,187));
        
        try {
            String username = chat.getUsername();
            chat.close();
            chat = new ChatConnection("QueueCF", "private3", "P-" + username, chatPanel, true);
        } catch (JMSException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_private3ButtonActionPerformed

    public javax.swing.JPanel getPanel() {
        return chatPanel;
    }

    // Roda o Chat
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Chat chatFrame = new Chat();
                chatFrame.setVisible(true);
                try {
                    //Habilita o envio de mensagens por linha de comando
                    Scanner commandLine = new Scanner(System.in);

                    System.out.print("Digite seu nome: ");
                    String name = commandLine.nextLine();
                    chat = new ChatConnection("QueueCF", "all", name, chatFrame.chatPanel, false);
//                    chatFrame.checkMessages(chat.getSubscriber());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chatPanel;
    private javax.swing.JButton generalChatButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JButton private1Button;
    private javax.swing.JButton private2Button;
    private javax.swing.JButton private3Button;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables

}
