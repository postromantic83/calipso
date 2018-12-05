package ru.gazpromneft_at.components;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import ru.gazpromneft_at.model.Messaga;

import java.util.UUID;

public class RequestProcessor implements Processor {
    /**
     * Формирование ответа о приемке сообщения.
     * @param exchange
     * @throws Exception
     */
    public void process(Exchange exchange) throws Exception {
        String correlationId = generateUUID();
        exchange.getOut().setHeader("Accept", "Application/json, application/xhtml+xml");
        exchange.getOut().setHeader("Content-Type", "application/json; charset=UTF-8");
        Messaga requestRespMessage = new Messaga(null, "Your request in process", correlationId);
//        String requestRespMessage = "{correlationId:123456}";
        exchange.getOut().setBody(requestRespMessage);
//        exchange.getOut().setBody("correlationId:'" + correlationId + "'");
        exchange.getOut().setHeader("JMSCorrelationID", correlationId);
    }

    private String generateUUID(){
        return UUID.randomUUID().toString();
    }
}
