package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources\\com\\Appfeatures\\AccountsPage.feature" },

		glue = { "stepdefinitions", "appsHooks" }, 
		monochrome = true, 
		plugin = { "pretty" })
public class TestRunners {

}
