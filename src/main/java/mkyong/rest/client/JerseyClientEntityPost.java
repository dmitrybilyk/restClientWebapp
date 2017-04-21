package mkyong.rest.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.codehaus.jackson.map.ObjectMapper;

public class JerseyClientEntityPost {

  public static void main(String[] args) {

	try {

		Client client = Client.create();

		WebResource webResource = client
						.resource("http://localhost:8080/rest/json/metallica/post/entity");

//		String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";
		TrackClient input = new TrackClient();
		input.setSinger("dima");
		input.setTitle("best");

		ObjectMapper objectMapper = new ObjectMapper();
		String inputJson = objectMapper.writeValueAsString(input);

		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class, inputJson);

		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
			     + response.getStatus());
		}

		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println(output);

	  } catch (Exception e) {

		e.printStackTrace();

	  }

	}
}