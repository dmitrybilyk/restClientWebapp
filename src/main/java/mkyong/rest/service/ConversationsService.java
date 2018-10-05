package mkyong.rest.service;

import mkyong.rest.client.Conversation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Collection;

@Path("/conversations")
public class ConversationsService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Conversation> getTrackInJSON() throws IOException {

		Conversation conversation = new Conversation("1010", "asdf", "0504759475", "dmitry.bilyk@gmail.com");
		DB.conversationMap.put(conversation.getSubevaluationId(), conversation);
		Conversation conversation2 = new Conversation("1011", "asdf", "0504759476", "dmitry.bilyk@gmail.com");
		DB.conversationMap.put(conversation2.getSubevaluationId(), conversation);

		return DB.conversationMap.values();
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Conversation conversation) {

		DB.conversationMap.put(conversation.getSubevaluationId(), conversation);
		return Response.status(201).entity("Conversation is saved").build();

	}

}