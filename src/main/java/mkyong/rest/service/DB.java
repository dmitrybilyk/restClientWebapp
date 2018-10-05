package mkyong.rest.service;

import mkyong.rest.client.Conversation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmitry on 05.10.18.
 */
public class DB {
    static {
        conversationMap = new HashMap<String, Conversation>();
        Conversation conversation = new Conversation("1010", "asdf", "0504759475", "dmitry.bilyk@gmail.com");
        DB.conversationMap.put(conversation.getSubevaluationId(), conversation);
        Conversation conversation2 = new Conversation("1011", "asdf", "0504759476", "dmitry.bilyk@gmail.com");
        DB.conversationMap.put(conversation2.getSubevaluationId(), conversation2);

    }
    public static Map<String, Conversation> conversationMap;
}
