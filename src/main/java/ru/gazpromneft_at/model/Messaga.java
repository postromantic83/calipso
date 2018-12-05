package ru.gazpromneft_at.model;

import java.io.Serializable;

public class Messaga implements Serializable {
    private Long id;
    private String messageText;
    private String correlationId;

    public Messaga(Long id, String messageText) {
        this.id = id;
        this.messageText = messageText;
    }

    public Messaga(Long id, String messageText, String correlationId) {
        this.id = id;
        this.messageText = messageText;
        this.correlationId = correlationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    @Override
    public String toString() {
        return "Messaga{" +
                "id=" + id +
                ", messageText='" + messageText + '\'' +
                ", correlationId='" + correlationId + '\'' +
                '}';
    }
}
