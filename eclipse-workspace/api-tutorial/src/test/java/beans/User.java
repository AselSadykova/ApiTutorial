package beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	private String name;
	private String location;
	private int age;
	
	
	
	
	
	
}
