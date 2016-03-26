package br.com.vitorino.seleniummaventemplate.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static junit.framework.Assert.*;


public class MySeleniumTestCase{

	private WebDriver webDriver;
	public static final String GITHUB_PAGE = "http://www.github.com/";
	public static final String GITHUB_STRING = "Github";
	public static final Integer TIMEOUT = 10;
	
	@Before
	public void setUp(){
		webDriver = new FirefoxDriver();
	}
	
	@After
	public void tearDown(){
		webDriver.quit();
		webDriver = null;
	}
	
	@Test
	public void testIfTitleContainsGithubString(){
		webDriver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		webDriver.get(GITHUB_PAGE);
		String expected = "How people build software · GitHub";
		String actual = webDriver.getTitle();
		assertEquals(expected, actual);
	}
	
}
