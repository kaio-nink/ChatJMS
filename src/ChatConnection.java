
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

public class ChatConnection implements MessageListener{

        private TopicSession pubSession;
        private TopicPublisher publisher;
        private TopicSubscriber subscriber;
        private TopicConnection connection;
        private String username;
//        private ArrayList<String> messageList;
        private JPanel chatPanel;

        /* Construtor usado para inicializar o cliente JMS do Chat */
        public ChatConnection(String topicFactory, String topicName, String username, JPanel chatPanel) throws Exception {
            // Obtem os dados da conexao JNDI atraves 
            // do arquivo jndi.properties
            InitialContext ctx = new InitialContext();
            // O cliente utiliza o TopicConnectionFactory 
            // para criar um objeto do tipo
            // TopicConnection com o provedor JMS
            TopicConnectionFactory conFactory = (TopicConnectionFactory) ctx.lookup(topicFactory);

            // Utiliza o TopicConnectionFactory para criar 
            //a conexao com o provedor JMS
            TopicConnection connection = conFactory.createTopicConnection();
            connection.setClientID(username);
            // Utiliza o TopicConnection para criar a sessao para o produtor
            // Atributo false -> uso ou nao de transacoes (tratar uma serie de
            // envios/recebimentos como unidade atomica e controla-la via commit e rollback)
            // Atributo AUTO_ACKNOWLEDGE -> Exige confirmacao automatica apos recebimento correto
            TopicSession pubSession
                    = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            // Utiliza o TopicConnection para criar a sessao para o consumidor
            TopicSession subSession
                    = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            // Pesquisa o destino do topico via JNDI
            Topic chatTopic = (Topic) ctx.lookup(topicName);
            // Cria o topico JMS do produtor das mensagens 
            // atraves da sessao e o nome do topico

            TopicPublisher publisher
                    = pubSession.createPublisher(chatTopic);

            // Cria (Assina) o topico JMS do consumidor das 
            // mensagens atraves da sessao e o nome do topico
            TopicSubscriber subscriber
                    = subSession.createDurableSubscriber(chatTopic, username, "", false);
            // Escuta o topico para receber as mensagens 
            // atraves do metodo onMessage()

            subscriber.setMessageListener(this);

            // Inicializa as variaveis do Chat
            this.connection = connection;
            this.pubSession = pubSession;
            this.publisher = publisher;
            this.subscriber = subscriber;
            this.username = username;
            this.chatPanel = chatPanel;
            // Inicia a conexao JMS, permite que 
            // mensagens sejam entregues
            connection.start();
        }
        public void mess(){
            
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
                System.out.println(text);
                if (!text.contains(connection.getClientID())) {
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
            // Recebe um objeto da sessao para criar 
            // uma mensagem do tipo TextMessage
            TextMessage message = pubSession.createTextMessage();
            // Seta no objeto a mensagem que sera enviada
            message.setText(username + ": " + text);
            // Publica a mensagem no topico
            publisher.publish(message);
        }

        public String getClientID() throws JMSException {
            return connection.getClientID();
        }

        // Fecha a conexao JMS
        public void close() throws JMSException {
            connection.close();
        }
    }