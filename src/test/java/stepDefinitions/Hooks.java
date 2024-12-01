package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utilities.TestBase;

public class Hooks {
	TestBase testBase;

	public Hooks(TestBase testBase) {
		this.testBase = testBase;
	}

	@After
	public void afterScenario() throws IOException {
		testBase.baseTest.WebDriverManager().quit();
	}
	
	@AfterStep
	public void takeScreenShot(Scenario scenario) throws IOException {
		WebDriver driver = testBase.baseTest.WebDriverManager();
		if(scenario.isFailed()) {
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}
		
	}

}
