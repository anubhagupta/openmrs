package step_definitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.openmrs.guice.provider.PageHelperLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class Steps {
	public WebDriver driver;
	By user = By.id("username");
	By pwd = By.id("password");
	By isolationWard = By.id("Isolation Ward");
	By loginButton = By.id("loginButton");
	By errorMessage = By.id("error-message");
	By registrationApp = By.xpath("//a[contains(@id,'registrationapp')]");
	By search = By.className("icon-search");
	By givenName = By.name("givenName");
	By familyName = By.name("familyName");
	By nextButton = By.id("next-button");
	By genderField = By.id("gender-field");
	By birthdateDayField = By.id("birthdateDay-field");
	By birthdateMonthField = By.id("birthdateMonth-field");
	By birthdateYearField = By.id("birthdateYear-field");
	By address1 = By.id("address1");
	By address2 = By.id("address2");
	By cityVillage = By.id("cityVillage");
	By stateProvince = By.id("stateProvince");
	By country = By.id("country");
	By postalCode = By.id("postalCode");
	By phoneNumber = By.name("phoneNumber");
	
	By relationshipType = By.id("relationship_type");
	By submit = By.id("submit");
	By home = By.xpath("//i[@href='/openmrs/index.htm']");
	By patientSearch = By.id("patient-search");
	By searchResult = By.xpath("//table[@id='patient-search-results-table']/tbody/tr[1]/td");
	By delete = By.id("org.openmrs.module.coreapps.deletePatient");
	By deleteReason = By.id("delete-reason");
	By confirmRight = By.xpath("//button[@text()='Confirm']");
	By noResult = By.xpath("//td[text()='No matching records found']");
	By logOut = By.xpath("//a[contains(text(),'Logout')]");
	

@Given("^user on the Login Page$")
public void user_on_the_Login_Page() throws Throwable {
	
	WebDriverManager.chromedriver().setup();	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.openmrs.org/openmrs/login.htm");
}

@Given("^user enters \"(.*?)\" with \"(.*?)\"$")
public void user_enters_with(String arg1, String arg2) throws Throwable {
	if(arg1.equals("user"))
    PageHelperLogger.sendKey(driver, user, arg2, arg1);
	else
		 PageHelperLogger.sendKey(driver, pwd, arg2, arg1);
	
}


@Given("^user clicks location with \"(.*?)\"$")
public void user_clicks_location_with(String arg1) throws Throwable {
	PageHelperLogger.click(driver, isolationWard, arg1);
}

@Given("^user clicks login button$")
public void user_clicks_login_button() throws Throwable {
	PageHelperLogger.click(driver, loginButton, "Login");
}

@Then("^user should see Admin Account$")
public void user_should_see_Admin_Account() throws Throwable {
	Assert.assertTrue(PageHelperLogger.isDisplayed(driver, registrationApp, "Home"), "Home page should displayed");   
}
 

@Then("^error message displayed with wrong password$")
public void error_message_displayed_with_wrong_password() throws Throwable {
    Assert.assertTrue(PageHelperLogger.isDisplayed(driver, errorMessage, "Error Message"), "Error message should displayed");   
}

@Given("^user clicks on registration page$")
public void user_clicks_on_registration_page() throws Throwable {
   PageHelperLogger.click(driver, registrationApp, "Register");
}

@Given("^user enters name \"(.*?)\" and \"(.*?)\"$")
public void user_enters_name_and(String arg1, String arg2) throws Throwable {
    PageHelperLogger.sendKey(driver, givenName, arg1, "Name");
    PageHelperLogger.sendKey(driver, familyName, arg2, "Name");
    PageHelperLogger.click(driver, nextButton, "next button");
}

@Given("^user enter select gender \"(.*?)\"$")
public void user_enter_select_gender(String arg1) throws Throwable {
	PageHelperLogger.selectDropdown(driver, genderField, arg1, "Gender");
    PageHelperLogger.click(driver, nextButton, "next button");
}

@Given("^user enter date of birth$")
public void user_enter_date_of_birth() throws Throwable {
	PageHelperLogger.sendKey(driver, birthdateDayField, "10", "Date");
	PageHelperLogger.selectDropdown(driver, birthdateMonthField, "March", "Month");
	PageHelperLogger.sendKey(driver, birthdateYearField, "1990", "Year");
    PageHelperLogger.click(driver, nextButton, "next button");
}

@Given("^user enter address with \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
public void user_enter_address_with_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
	PageHelperLogger.sendKey(driver, address1, arg1, "Name");
    PageHelperLogger.sendKey(driver, address2, arg2, "Name");
    PageHelperLogger.sendKey(driver, cityVillage, arg3, "Name");
    PageHelperLogger.sendKey(driver, stateProvince, arg4, "Name");
    PageHelperLogger.sendKey(driver, country, arg5, "Name");
    PageHelperLogger.sendKey(driver, postalCode, arg6, "Name");
    PageHelperLogger.click(driver, nextButton, "next button");
}

@Given("^user enter number \"(.*?)\"$")
public void user_enter_number(String arg1) throws Throwable {
	PageHelperLogger.sendKey(driver, phoneNumber, arg1, "Name");
    PageHelperLogger.click(driver, nextButton, "next button");
    PageHelperLogger.click(driver, nextButton, "next button");
    PageHelperLogger.click(driver, submit, "Submit button");
}

@Then("^patient should be registered$")
public void patient_should_be_registered() throws Throwable {
    
}

@Given("^user clicks on Home page$")
public void user_clicks_on_Home_page() throws Throwable {
	
	driver.get("https://demo.openmrs.org");
	Assert.assertTrue(PageHelperLogger.isDisplayed(driver, registrationApp, "Home"), "Home page should displayed");   
}

@Given("^user search created record with name \"(.*?)\"$")
public void user_search_created_record_with_name(String arg1) throws Throwable {
	PageHelperLogger.click(driver, search, "Search");
	PageHelperLogger.sendKey(driver, patientSearch, arg1, "Search");
	PageHelperLogger.click(driver, searchResult, "Search");
}

@Given("^delete created record with reason \"(.*?)\"$")
public void delete_created_record_with_reason(String arg1) throws Throwable {
	PageHelperLogger.click(driver, delete, "Delete");
	PageHelperLogger.sendKey(driver, deleteReason, arg1, "Delete" );
	
	driver.findElement(deleteReason).sendKeys(Keys.TAB);
	driver.findElement(deleteReason).sendKeys(Keys.ENTER);
}

@Then("^user should not be able to search record with name \"(.*?)\"$")
public void user_should_not_be_able_to_search_record_with_name(String arg1) throws Throwable {
	PageHelperLogger.sendKey(driver, patientSearch, arg1, "Search");
	Assert.assertTrue(PageHelperLogger.isDisplayed(driver, noResult, "No matching records found"), "Error message should displayed");  
}

@Then("^user logout from application$")
public void user_logout_from_application() throws Throwable {
	Thread.sleep(2000);
    PageHelperLogger.click(driver, logOut, "Log Out");
}


}
