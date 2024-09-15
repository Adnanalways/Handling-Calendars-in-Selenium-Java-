package handle_calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcalendar {
	public static void main(String[] args) {
		String expectedMonth = "March";
		String expectedYear= "2026";
		String expectedDay="13";
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
	    
		
		driver.findElement(By.id("datepicker")).click();
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
		
		String currentMonth= driver.findElement(By.className("ui-datepicker-month")).getText(); 
		String currentYear= driver.findElement(By.className("ui-datepicker-year")).getText();
		
		while(!(currentMonth.equals(expectedMonth) && currentYear.equals(expectedYear))) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			currentMonth= driver.findElement(By.className("ui-datepicker-month")).getText(); 
			currentYear= driver.findElement(By.className("ui-datepicker-year")).getText();
			
			
			
			
			
		}
		String dayXpath ="//td[@*='selectDay']/a[text]='"+expectedDay+"']";
		driver.findElement(By.xpath(dayXpath)).click();
	
	}

}



