package com.fitpeo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import dev.failsafe.internal.util.Assert;

public class Fitpeo {
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Scenario 1
		driver.get("https://www.fitpeo.com/");
		
		// Scenario 2
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement revenue = driver.findElement(By.xpath("//div[text()='Revenue Calculator']"));
		revenue.click();
		
		// Scenario 3
		WebElement ScrollDown = driver.findElement(By.xpath("//h4[text()='Medicare Eligible Patients']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", ScrollDown );
		
		// Scenario 4
		Actions ac = new Actions(driver);
		
		WebElement slider = driver.findElement(By.xpath("//*[@data-index='0']"));
		
		ac.dragAndDropBy(slider, 94, 0).perform();
		
		// Scenario 5 
		WebElement value = driver.findElement(By.xpath("//input[@type='number']"));
		value.click();
		Thread.sleep(6000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_BACK_SPACE);
		rb.keyPress(KeyEvent.VK_BACK_SPACE);
		rb.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(6000);
		value.sendKeys("560");
		// Scenario 6
		
		WebElement checkbox = driver.findElement(By.xpath("//*[text()='57']//preceding::input[@data-indeterminate='false']"));
		checkbox.click();
		
		WebElement checkbox1 = driver.findElement(By.xpath("(//*[text()='19.19']//preceding::input[@type=\"checkbox\"])[2]"));
		checkbox1.click();
		
		
		WebElement checkbox2 = driver.findElement(By.xpath("(//*[text()='63']//preceding::input[@data-indeterminate='false'])[3]"));
		checkbox2.click();
		
		WebElement checkbox3 = driver.findElement(By.xpath("(//*[text()='15']//preceding::input[@data-indeterminate='false'])[8]"));
		checkbox3.click();
		
		js.executeScript("arguments[0].scrollIntoView()", ScrollDown );
		// Scenario 7 
		value.click();
		Thread.sleep(6000);
		rb.keyPress(KeyEvent.VK_BACK_SPACE);
		rb.keyPress(KeyEvent.VK_BACK_SPACE);
		rb.keyPress(KeyEvent.VK_BACK_SPACE);
		
		Thread.sleep(6000);
		value.sendKeys("820");
		// Scenario 8 
		WebElement element = driver.findElement(By.xpath("//p[text()='CPT-99453']"));
		js.executeScript("arguments[0].scrollIntoView()", element );
		
		String text = driver.findElement(By.xpath("//p[text()='110700']")).getText();
		System.out.println(text);
		
		// Scenario 9
		org.testng.Assert.assertEquals(text, "$110700");
		
		driver.quit();
		

		
		
		
	}
	
	
	

}
