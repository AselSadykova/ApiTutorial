package tests;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Book;
import beans.MyRequest;
import beans.MyResponse;
import beans.User;
import utility.ServiceRunner;

public class JsonTest {
	
//	@Test
	public void jsonTest() throws IOException {
User user = new User();
user.setAge(22);
user.setLocation("New York");
user.setName("James Bond");

ObjectMapper mapper = new ObjectMapper();
String json = mapper.writeValueAsString(user);
System.out.println(json);

User user2 = mapper.readValue(json, User.class);
System.out.println(user2.getAge());

}
	
//	@Test
	public void utilTest() {
		ServiceRunner.runGetRequest("http://localhost:3000/profile");
		String location = ServiceRunner.getResponse().getLocation();
		System.out.println(location);
		
		String title = ServiceRunner.getResponse().getBooks().get(0).getTitle();
	
		System.out.println(title);
	
		for( Book book: ServiceRunner.getResponse().getBooks()) {
			System.out.println(book.getTitle()!= null);
		}
	
	
	}
	
	@Test
	public void utilTestPost() {
		MyRequest mr = new MyRequest();
		mr.setAge(44);
		mr.setLocation("Nashvile");
		
		ServiceRunner.runPostRequest("http://localhost:3000/profile", mr);
		String location = ServiceRunner.getResponse().getLocation();
		System.out.println(location);
		
		
	}
	
}