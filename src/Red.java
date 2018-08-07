import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Red {
	
	WebDriver driver = null;
	
	@Given("^the user enters the Redbus Webpage$")
	public void the_user_enters_the_Redbus_Webpage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		Map<String,Object> prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		
		
		driver = new ChromeDriver(options);
		driver.get("https://www.redbus.in/bus-tickets/");   
	
	}

	@When("^the user enters the source location$")
	public void the_user_enters_the_source_location() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"txtSource\"]")).sendKeys("Bangalore Intl Airport");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"txtSource\"]")).sendKeys(Keys.ENTER);
	}

	@When("^the destination location$")
	public void the_destination_location() throws Throwable {
		WebElement s2=driver.findElement(By.xpath("//*[@id=\"txtDestination\"]"));
		s2.sendKeys("Chennai Intl Airport");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\\\"txtDestination\\\"]")).sendKeys(Keys.ENTER);	
		
	}

	@When("^the user enters the onward date and return dates$")
	public void the_user_enters_the_onward_date_and_return_dates() throws Throwable {
	
		
		driver.findElement(By.xpath("//*[@id=\"txtOnwardCalendar\"]")).sendKeys("29-Aug-2018");;
		
		
		}

	@Then("^the user searches for the available buses$")
	public void the_user_searches_for_the_available_buses() throws Throwable {
		driver.findElement(By.xpath("/html/body/div[1]/div[4]/button")).click();
		
		}

	@Then("^the user views the seat to book$")
	public void the_user_views_the_seat_to_book() throws Throwable {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"10655565\"]/div/div[2]/div[1]")).click();
		
		}

	@Then("^the user prefers for certain seat location$")
	public void the_user_prefers_for_certain_seat_location() throws Throwable {
		Thread.sleep(4000);
		WebElement seat = driver.findElement(By.xpath("//*[@id=\"rt_10655565\"]/div/div/div/div[2]/div[2]/div[2]/canvas"));
	    Actions act=new Actions(driver);
	    act.moveToElement(seat, 80,30 ).click().build().perform();}
	

	@Then("^the user enters the exact pickup location$")
	public void the_user_enters_the_exact_pickup_location() throws Throwable {
		Thread.sleep(4000);
	//driver.findElement(By.xpath("//*[@id=\"8368723\"]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/li[1]/span[2]")).click();   
			
	}

	@Then("^the user proceeds to fill in details page$")
	public void the_user_proceeds_to_fill_in_details_page() throws Throwable {
		//Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"10655565\"]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[6]/button")).click();   
		
	}

	@Then("^the user enters the necessary details such as name,gender,age,email,phone number$")
	public void the_user_enters_the_necessary_details_such_as_name_gender_age_email_phone_number() throws Throwable {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"seatno-04\"]")).sendKeys("saran");
		driver.findElement(By.xpath("//*[@id=\"22_0\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"seatno-01\"]")).sendKeys("21");
		driver.findElement(By.xpath("//*[@id=\"seatno-05\"]")).sendKeys("saran@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"seatno-06\"]")).sendKeys("9795236412");
	}

	@Then("^the user finally proceeds to payment page$")
	public void the_user_finally_proceeds_to_payment_page() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div[2]/input")).click();
	}
}
