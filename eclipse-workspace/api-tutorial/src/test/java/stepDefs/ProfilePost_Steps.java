package stepDefs;

import org.junit.Assert;

import beans.Book;
import beans.MyRequest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.ServiceRunner;

public class ProfilePost_Steps {
	@When("^user hits Profile GET request with \"([^\"]*)\"$")
	public void user_hits_Profile_GET_request_with(String uri) {
		ServiceRunner.runGetRequest(uri);
	}

	@Then("^user should get \"([^\"]*)\" status code$")
	public void user_should_get_status_code(String statusCode) {
		int statusCodeInt = Integer.valueOf(statusCode);
		System.out.println("expected statusCode " + statusCodeInt);
		System.out.println("actual statusCode " + ServiceRunner.getStatusCode());
		Assert.assertEquals(statusCodeInt, ServiceRunner.getStatusCode());
	}

	@Then("^user verifies mandatory attributes for profile$")
	public void user_verifies_mandatory_attributes_for_profile() {
		String name = ServiceRunner.getResponse().getName();
		String location = ServiceRunner.getResponse().getLocation();
		String address = ServiceRunner.getResponse().getAddress();
		System.out.println(name);
		System.out.println(location);
		System.out.println(address);

		Assert.assertTrue("Mandatory attribute 'name' failed", name != null);
		Assert.assertTrue("Mandatory attribute 'location' failed", location != null);
//		Assert.assertTrue("Mandatory attribute 'address' failed", address != null);
		// Assert.assertTrue("Mandatory attribute 'friend' failed",
		// ServiceRunner.getResponse().getFriend()!= null);

	}

	@Then("^user verifies mandatory attribute for profile book title field$")
	public void user_verifies_mandatory_attribute_for_profile_book_title_field() {
		int counter = 0;
     for(Book book : ServiceRunner.getResponse().getBooks()) {
    	 System.out.println(book.getTitle());
    	 Assert.assertTrue("Book title attribute failed: "+ counter, book.getTitle() !=null);
    	 counter++;
     }
	}
	
	@When("^user hits Profile POST request with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_hits_Profile_POST_request_with(String uri, String name, String location, String age)  {
	   MyRequest body = new MyRequest();
	   body.setName(name);
	   body.setLocation(location);
	   body.setAge(Integer.valueOf(age));
	   
		
		ServiceRunner.runPostRequest(uri, body);
	    
	}

	@Then("^user validates the data in the profile response with the requested data \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_validates_the_data_in_the_profile_response_with_the_requested_data(String name, String location, String age) {
		String nameActual = ServiceRunner.getResponse().getName();
		String locationActual = ServiceRunner.getResponse().getLocation();
		int ageActual = ServiceRunner.getResponse().getAge();
		
		System.out.println(nameActual);
		System.out.println(locationActual);
		System.out.println(ageActual);
		
		Assert.assertEquals("Name attribute not matching", name, nameActual);
		Assert.assertEquals("Location attribute not matching", location, locationActual);
		Assert.assertEquals("Age attribute not matching", age, String.valueOf(ageActual));
		
		
		
		
		
		
	}


}
