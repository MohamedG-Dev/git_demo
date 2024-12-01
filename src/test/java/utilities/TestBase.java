package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjectsRepository.PageObjectManager;

public class TestBase {
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public BaseTest baseTest;
	public GenericUtils genericUtils;

	public TestBase() throws IOException {
		baseTest = new BaseTest();
		pageObjectManager = new PageObjectManager(baseTest.WebDriverManager());
		genericUtils = new GenericUtils(baseTest.WebDriverManager());
	}
}
