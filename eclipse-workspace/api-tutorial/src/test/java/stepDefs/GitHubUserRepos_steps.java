package stepDefs;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.MyResponse;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GitHubUserRepos_steps {
	
	 WebDriver driver;
	 MyResponse [] repos;
	
	@When("^user goes to gitHub account for \"([^\"]*)\"$")
	public void user_goes_to_gitHub_account_for(String url)  {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.get(url);
	}

	@When("^user hits github repos service with \"([^\"]*)\"$")
	public void user_hits_github_repos_service_with(String uri) throws JsonParseException, JsonMappingException, IOException  {
	  Response mr = RestAssured.given().get(uri);
	  System.out.println(mr.asString());
	  ObjectMapper mapper = new ObjectMapper();
	   repos = mapper.readValue(mr.asString(), MyResponse[].class);
	  for(MyResponse repo : repos) {
		  System.out.println(repo.getName());
	  }
	  
	}

	@Then("^user validates repositories data with UI and API$")
	public void user_validates_repositories_data_with_UI_and_API()  {
	    WebElement size = driver.findElement(By.xpath("//a[@title='Repositories']/span"));
	    System.out.println("Size ui: "+ size.getText());
	    System.out.println("Size api: "+ repos.length);
	}


}
