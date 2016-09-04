package io.itera.jms.channel.core.mdb;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.apache.log4j.Logger;

public class SimpleListener implements MessageListener {

    private static final Logger LOG = Logger.getLogger(SimpleListener.class);
    
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                LOG.info(((TextMessage) message).getText());
            } catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
    }
}
