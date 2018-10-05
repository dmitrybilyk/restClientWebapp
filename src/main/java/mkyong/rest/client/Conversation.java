package mkyong.rest.client;

/**
 * Created by dmitry on 05.10.18.
 */
public class Conversation {
    private String subevaluationId;
    private String conversationId;
    private String phoneNumber;
    private String email;

    public Conversation() {
    }

    public Conversation(String subevaluationId, String conversationId, String phoneNumber, String email) {
        this.subevaluationId = subevaluationId;
        this.conversationId = conversationId;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getSubevaluationId() {
        return subevaluationId;
    }

    public void setSubevaluationId(String subevaluationId) {
        this.subevaluationId = subevaluationId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
