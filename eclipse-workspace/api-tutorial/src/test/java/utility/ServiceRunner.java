package utility;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.MyRequest;
import beans.MyResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ServiceRunner {
	
	private static ObjectMapper mapper = new ObjectMapper();
	private static MyResponse resp;
	private static int statusCode;
	
	
public static void runGetRequest(String uri) {
	Response mr = RestAssured.get(uri);
	statusCode = mr.statusCode();
	
	try {
		resp = mapper.readValue(mr.asString(), MyResponse.class);
	} catch (Exception e) {
		System.out.println("Can not map into MyResponse Object");
		e.printStackTrace();
	}
	
}
public static void runPostRequest(String uri, MyRequest body) {
	String json="";
	
	
	try {
		 json=mapper.writeValueAsString(body);
	} catch (JsonProcessingException e) {
		System.out.println("Couldnt convert from POJO to Json");
		e.printStackTrace();
	}
	
	Response mr = RestAssured.given().contentType(ContentType.JSON).body(json).post(uri);
	statusCode = mr.statusCode();
	try {
		resp = mapper.readValue(mr.asString(), MyResponse.class);
	} catch (Exception e) {
		System.out.println("Can not map into MyResponse Object");
		e.printStackTrace();
	}
	
}
public static MyResponse getResponse() {
	return resp;
}

public static int getStatusCode() {
	return statusCode;
}


}
