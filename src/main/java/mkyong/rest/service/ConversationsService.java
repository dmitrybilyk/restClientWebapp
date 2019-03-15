package mkyong.rest.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import mkyong.Result;
import mkyong.Survey;
import mkyong.rest.client.Conversation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Path("/conversations")
public class ConversationsService {
	private static List<Result> resultList = new ArrayList<Result>();

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Conversation getTrackInJSON() throws IOException {

		return DB.conversationMap.values().iterator().next();
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Conversation conversation) {

		DB.conversationMap.put(conversation.getSubevaluationId(), conversation);
		return Response.status(201).entity("Conversation is saved successfully").build();

	}

	@GET
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerPath(@QueryParam("path") String path) {

//		System.out.println(path);
		Client client = Client.create();

		WebResource webResource = client
				.resource(path);

		String input = "{\"surveyId\":\"7771\",\"email\":\"dmitry.bilyk@gmail.com\", \"emailText\":\"Please click to rate the agent\", \"questionText\":\"какой-то текст вопроса\", \"commentLabel\":\"Комментарий\"}";

		ClientResponse response = webResource.type("application/json")
				.post(ClientResponse.class, input);
		if (response.getStatus() != 200) {
			return Response.status(500).entity("Fail").build();
		} else {
			return Response.status(200).entity("Good job").build();
		}
	}

	@GET
	@Path("/surveys")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNewSurveys() {
// Obtain a number between [0 - 49].
			return Response.status(200).entity(Arrays.asList(getSurvey(), getSurvey())).build();
	}

	private Survey getSurvey() {
		Random random = new Random();
		Survey survey = new Survey();
		int surveyId = random.nextInt(500000);
		survey.setSurveyId(surveyId);
		survey.setId(surveyId);
		survey.setContact("dmitry.bilyk@gmail.com");
		return survey;
	}

	@GET
	@Path("/result/{id}/{result}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response handleResult(@PathParam("id") String id,
	                             @PathParam("result") String result) {
		Result result1 = new Result(id, result);
		resultList.add(result1);
		return Response.status(200).entity(result1).build();
	}

	@GET
	@Path("/results")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResults() {
		return Response.status(200).entity(resultList).build();
	}

}