package ru.gazpromneft_at.kspd.components;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.qpid.jms.JmsQueue;
import org.apache.qpid.jms.message.JmsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gazpromneft_at.kspd.model.Messaga;


import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;

@Component
public class MessageReceiver implements Processor {
    private Logger logger = LogManager.getLogger(MessageReceiver.class);

    @Autowired
    private org.apache.qpid.jms.JmsConnectionFactory amqpDmzConnectionFactory;

    public void process(Exchange exchange) throws Exception {
        logger.info("START RECEIVER PROCESSOR!");

            Connection connection = amqpDmzConnectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination queue = new JmsQueue("que_out");
            MessageConsumer consumer = session.createConsumer(queue);
            connection.start();
            try {
                JmsMessage messageReceived = (JmsMessage) consumer.receive();
                logger.info("Message Id:" + messageReceived.getJMSMessageID());
                logger.info("Message CorrelationId:" + messageReceived.getJMSCorrelationID());
                exchange.getIn().setBody(messageReceived.getBody(Messaga.class));
                exchange.getIn().setHeader("Accept", "Application/json");
                exchange.getIn().setHeader("Content-Type", "application/json; charset=UTF-8");
            } catch (Exception e){
                logger.error("Ошибка получения сообщения!" + e.getMessage());
                exchange.getIn().setBody("Ошибка получения сообщения!");
        }

            connection.stop();
            connection.close();


    }
}
