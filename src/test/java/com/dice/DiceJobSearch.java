package com.dice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {

	public static void main(String[] args) {
		//set up chrome driver path
		WebDriverManager.chromedriver().setup();//instead of setProperty.
		WebDriver driver =  new ChromeDriver();//invoking selenium driver
		
		
		driver.manage().window();//fullscreen
		//also set universal wait time in case webpage is slow
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*
		 * step1. launch browser and navigate to https://dice.com
		 * expected: dice home page should be displayed
		 */
		
	String url ="https://dice.com";
	driver.get(url);
	
	String actualTitle = driver.getTitle();
	String expectedTitle = "Job Search for Technology Professionals | Dice.com";
	
	if(actualTitle.equals(expectedTitle)) {
		System.out.println("Dice homepage successfully loaded");
	}else {
		System.out.println("Step fail.Dice homepage didnot load successfully");
		throw new RuntimeException("Step fail.Dice homepage didnot load successfully");
	}
	
	String keyword = "java developer";
	driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);//where webelement  and what you wanna do with it?
		
		String location = "60625";
		driver.findElement(By.name("l")).clear();
		driver.findElement(By.name("l")).sendKeys(location);
		driver.findElement(By.id("findTechJobs")).click();
		
		String count = driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		
		//ensure count is more than 0
		int countResult  = Integer.parseInt(count.replace(",", ""));
		
		
		
		
		
		
		
		
		
		
		
		if(countResult>0) {
			System.out.println("step pass: keyword: "+keyword+ " search returned "
					+ ""+ countResult+" results in "+location);
		}else {
			System.out.println("step fail: keyword: "+keyword+ " search returned "
					+ ""+ countResult+" results in "+location);
		}
		driver.close();
		System.out.println("test is completed "+ LocalDateTime.now());//NZ
	}
}
