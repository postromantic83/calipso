package ru.gazpromneft_at.components;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.gazpromneft_at.model.Messaga;

import java.util.UUID;

public class RequestHandlerBean{
    private Logger logger = LogManager.getLogger(RequestHandlerBean.class);
    public String generateCorrelationId(){
        String result = "ID:" + generateUUID();
        logger.info(result);
        return result;
    }

    public String generateResponseBody(){
        StringBuilder response = new StringBuilder();
        response.append("{response:test; valueId: 1}");
        return response.toString();
    }

    public Messaga getMessaga(){
        Messaga result = new Messaga(123L, "Messaga text");
        return result;
    }

    private String generateUUID(){
        return UUID.randomUUID().toString();
    }
}
