package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.Driverfactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {

	private LoginPage loginPage = new LoginPage(Driverfactory.getDriver());
	private AccountsPage accountPage;

	@Given("User has already logged in ti the application")
	public void user_has_already_logged_in_ti_the_application(DataTable dataTable) {
		List<Map<String, String>> credList = dataTable.asMaps();
		String userName = credList.get(0).get("username");
		String passWord = credList.get(0).get("password");
		accountPage = loginPage.doLogin(userName, passWord);
	}

	@Given("user is on accounts page")
	public void user_is_on_accounts_page() {
		accountPage.getAccountPageTitle();
	}

	@Then("user gets accoubts section")
	public void user_gets_accoubts_section(DataTable sectionsTable) {
		List<String> expAccSecList=sectionsTable.asList();
		System.out.println("expected account section List :"+expAccSecList);
		List<String> actAccSecList=accountPage.accountPageSectionList();
		System.out.println("expected account section List :"+actAccSecList);
		Assert.assertTrue(expAccSecList.containsAll(actAccSecList));

	}

	@Then("account section should be {int}")
	public void account_section_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountPage.accountSectionCount()==expectedSectionCount);
	}

}
