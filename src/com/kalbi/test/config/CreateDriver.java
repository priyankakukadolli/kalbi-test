package com.kalbi.test.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.kalbi.lib.util.DataHandlers;

public class CreateDriver {
	public static WebDriver getDriverInstance() {
		WebDriver driver = null;
		String browser = DataHandlers.getDataFromProperties("configuration", "browser");
		String url = DataHandlers.getDataFromProperties("configuration", "env");
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./browser-servers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.gecko.driver", "./browser-servers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./browser-servers/internetexplorer.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("!!!!! ----- Invalid browser option please check , configuration.propereties file ---!!!!");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if(url.equalsIgnoreCase("prod")) {
			driver.get("https://demo.actitime.com/");
		}else {
			driver.get("https://localhost");
		}
		return driver;
	}
}
