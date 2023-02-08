package stepdefinitions;

import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.Driverfactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private LoginPage loginPage = new LoginPage(Driverfactory.getDriver());
	String title;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		Driverfactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Login Page titile is  :" + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
		Assert.assertTrue(title.contains(string));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String string) {
		loginPage.enterUserName(string);

	}

	@When("user enters password {string}")
	public void user_enters_password(String string) {
		loginPage.enterPassword(string);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
		
	}
	
//	@Then("account page title should be {string}")
//	public void account_page_title_should_be(String string) {
//		Assert.assertTrue(title.contains(string));
//	}

}
