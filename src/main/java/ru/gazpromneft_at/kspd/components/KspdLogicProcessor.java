package ru.gazpromneft_at.kspd.components;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.gazpromneft_at.kspd.model.Messaga;

/**
 * Класс для реализации логики на стороне КСПД.
 *
 */
public class KspdLogicProcessor implements Processor {
    private Logger logger = LogManager.getLogger(MessageReceiver.class);
    public void process(Exchange exchange) throws Exception {
        String correlation = (String) exchange.getMessage().getHeader("JMSCorrelationID");
        logger.info("KSPD LOGICS with correlId: " + correlation);
        exchange.getIn().setBody(new Messaga(345L, "Proceseed with KSPD!", correlation));
        exchange.getIn().setHeader("JMSCorrelationID", correlation);
        exchange.getIn().setHeader("Accept", "Application/json");
        exchange.getIn().setHeader("Content-Type", "application/json; charset=UTF-8");
        exchange.getIn().setHeader("JMSCorrelationID", correlation);
    }
}
