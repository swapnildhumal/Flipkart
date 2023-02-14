package Project;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.event.MenuKeyEvent;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	WebDriver driver;
	String url="https://www.flipkart.com/";
	
	@BeforeTest
	public void tc1() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get(url);
	}
	@Test
	public void tc2() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		Thread.sleep(3000);
		//close login window	
	}
	@Test(enabled = true,priority = 1)
	public void tc3() throws InterruptedException, AWTException {
		WebElement web= driver.findElement(By.xpath("//input[@type='text']"));		
		web.sendKeys("redmi note 12 5g");
		Thread.sleep(3000);
		web.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[@class='_4rR01T']")).click();
		Thread.sleep(5000);
		ArrayList<String> tab1=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab1.get(1));
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		Thread.sleep(5000);
		driver.close();
		Thread.sleep(5000);
		ArrayList<String> tab=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
		Thread.sleep(5000);
		Actions action=new Actions(driver);
		action.contextClick().build().perform();
		Thread.sleep(5000);
		Robot rc=new Robot();
		rc.keyPress(MenuKeyEvent.VK_DOWN);
		rc.keyPress(MenuKeyEvent.VK_ENTER);
		
	}
	@Test
	public void tc4() throws IOException, InterruptedException {
		File swapnil=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Thread.sleep(5000);
		FileUtils.copyFile(swapnil, new File("C:/Users/Akshay/OneDrive/Desktop/seleniumScreenshot/sh.png"));
	}
	
		
		

}
