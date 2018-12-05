package ru.gazpromneft_at.components;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gazpromneft_at.model.Messaga;

public class DmzContainerProcessor implements Processor {
    private Logger logger = LogManager.getLogger(DmzContainerProcessor.class);

    @Autowired
    private DmzContainer dmzContainer;
    /**
     * Обработка сообщений в кеш.
     * @param exchange
     * @throws Exception
     */
    public void process(Exchange exchange) throws Exception {
        String correlation = (String) exchange.getMessage().getHeader("JMSCorrelationID");
        String messga = (String)exchange.getIn().getMandatoryBody();
        logger.info("MESSAGA TEXT: " + messga);
        dmzContainer.addresult(correlation, new Messaga(null, messga, correlation));
        logger.info("Add to Cache: " + correlation);
        logger.info("CACHE SIZE:" + dmzContainer.getSize());
    }
}
