
import java.util.ArrayList;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;
import javax.swing.JPanel;

public class ChatConnection implements MessageListener {

    private TopicSession pubSession;
    private TopicPublisher publisher;
    private TopicSubscriber subscriber;
    private TopicConnection connection;
    private String username;
    private JPanel chatPanel;

    /* Construtor usado para inicializar o cliente JMS do Chat */
    public ChatConnection(String topicFactory, String topicName, String username, JPanel chatPanel, Boolean isPrivate) throws Exception {

        InitialContext ctx = new InitialContext();

        TopicConnectionFactory conFactory = (TopicConnectionFactory) ctx.lookup(topicFactory);

        TopicConnection connection = conFactory.createTopicConnection();
        connection.setClientID(username);

        TopicSession pubSession
                = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);


        TopicSession subSession
                = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);


        Topic chatTopic = (Topic) ctx.lookup(topicName);


        TopicPublisher publisher
                = pubSession.createPublisher(chatTopic);

        TopicSubscriber subscriber
                = subSession.createDurableSubscriber(chatTopic, username, "", false);


        subscriber.setMessageListener(this);
        if (isPrivate) {
            username = username.replace("P-", "");
        }
        // Inicializa as variaveis do Chat
        this.connection = connection;
        this.pubSession = pubSession;
        this.publisher = publisher;
        this.subscriber = subscriber;
        this.username = username;
        this.chatPanel = chatPanel;
        connection.start();
    }

    public void mess() {

    }

    public TopicSubscriber getSubscriber() {
        return subscriber;
    }

    public MessageListener checkMessages() throws JMSException {
        return this.subscriber.getMessageListener();
    }
    // Recebe as mensagens do topico assinado

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            if (!text.contains(username)) {
                MessageRight item = new MessageRight(text);
                JPanel chatP = chatPanel;
                chatPanel.add(item, "wrap");
                chatPanel.repaint();
                chatPanel.revalidate();
            }

        } catch (JMSException jmse) {
            jmse.printStackTrace();
        }
    }

    // Cria a mensagem de texto e a publica no topico. Evento referente ao
    //produtor
    public void writeMessage(String text) throws JMSException {
        TextMessage message = pubSession.createTextMessage();
        message.setText(username + ": " + text);
        publisher.publish(message);
    }

    public String getUsername() throws JMSException {
        return username;
    }

    // Fecha a conexao JMS
    public void close() throws JMSException {
        connection.close();
    }

    public void stop() throws JMSException {
//            connection.stop();
        pubSession.close();
    }
}
