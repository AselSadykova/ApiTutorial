package tests;



import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class APITest {
	
	ObjectMapper mapper = new ObjectMapper();
	
//@Test
public void getProfileService() throws JsonParseException, JsonMappingException, IOException {
	Response mr = RestAssured.get("http://localhost:3000/profile");
	System.out.println(mr.asString());
	System.out.println(mr.getStatusCode());
	
	
	User user = mapper.readValue(mr.asString(), User.class);
	System.out.println(user.getAge());
	
	Assert.assertEquals(200, mr.getStatusCode());
	Assert.assertEquals(22, user.getAge());
	
	
}

@Test
public void postProfileService() throws IOException {
	User user = new User();
	user.setAge(31);
	user.setLocation("Alaska");
	user.setName("Asel");
	
	String myRequest = mapper.writeValueAsString(user);
	System.out.println(myRequest);
	
	
	Response mr = RestAssured.given().contentType(ContentType.JSON).body(myRequest).post("http://localhost:3000/profile");
	System.out.println(mr.getStatusCode());
	
	Response mr2 = RestAssured.get("http://localhost:3000/profile");
	
	User user2 = mapper.readValue(mr2.asString(), User.class);
	System.out.println(user2.getLocation());
	
	
	
	
	
}
}
