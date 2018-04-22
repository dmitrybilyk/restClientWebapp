package mkyong.rest.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import mkyong.rest.client.TrackClient;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/client/test")
public class JSONService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public TrackClient getTrackInJSON() throws IOException {

		TrackClient track = new TrackClient();
		track.setTitle("Dimon");
		track.setSinger("Metallica from client");
//
//		Client client = Client.create();
//
//		WebResource webResource = client
//						.resource("http://localhost:8080/rest/json/metallica/post/entity");
//
//		TrackClient input = new TrackClient();
//		input.setSinger("dima");
//		input.setTitle("best");
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		String inputJson = objectMapper.writeValueAsString(input);
//
//		ClientResponse response = webResource.type("application/json")
//						.post(ClientResponse.class, inputJson);
//
//		if (response.getStatus() != 201) {
//			throw new RuntimeException("Failed : HTTP error code : "
//							+ response.getStatus());
//		}
//
//		System.out.println("Output from Server .... \n");
//		String output = response.getEntity(String.class);
//		System.out.println(output);

		return track;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(TrackClient track) {

		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();

	}

	@POST
	@Path("/post/entity")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSONforEntity(TrackClient track) {

		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();

	}

	
}