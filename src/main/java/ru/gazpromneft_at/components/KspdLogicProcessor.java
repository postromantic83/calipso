package ru.gazpromneft_at.components;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.gazpromneft_at.model.Messaga;

/**
 * Класс для реализации логики на стороне КСПД.
 *
 */
public class KspdLogicProcessor implements Processor {
    private Logger logger = LogManager.getLogger(MessageReceiver.class);
    public void process(Exchange exchange) throws Exception {
        String correlation = (String) exchange.getMessage().getHeader("JMSCorrelationID");
        logger.info("KSPD LOGICS with correlId: " + correlation);
        exchange.getIn().setBody(new Messaga(345L, "This answer has been generated in KSPD!", correlation));
        exchange.getIn().setHeader("JMSCorrelationID", correlation);
        exchange.getOut().setBody(new Messaga(777L, "This answer has been generated in KSPD PROCESSOR!", correlation));
        exchange.getOut().setHeader("JMSCorrelationID", correlation);
        exchange.getMessage().setBody(new Messaga(888L, "EEE!", correlation));
        exchange.getOut().setHeader("Accept", "x-java-serialized-object");
        exchange.getOut().setHeader("Content-Type", "x-java-serialized-object, charset=UTF-8");
//        exchange.getIn().setHeader("JMSCorrelationID", correlation);
    }
}
