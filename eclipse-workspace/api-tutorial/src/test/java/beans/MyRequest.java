package beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyRequest {

	
	private String name;
	private String location;
	private int age;
	
	
	
	
	
	
}
