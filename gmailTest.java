import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class gmailTest {

	public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anonymous\\eclipse-workspace\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver,120);

			String BaseUrl = "https://www.gmail.com/";
			
			driver.get(BaseUrl);
			
			//login steps
		
			driver.findElement(By.id("identifierId")).sendKeys("AutomationTest985@gmail.com");
			WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']")));
			next.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.name("password")).click();
			driver.findElement(By.name("password")).sendKeys("Pak123pk");
			driver.findElement(By.xpath("//span[text()='Next']")).click();
		/*
		 * driver.findElement(By.id("Email")).sendKeys("nasirsultan985@gmail.com");
		 * driver.findElement(By.id("next")).click();
		 * driver.findElement(By.id("password")).sendKeys("admin123");
		 * driver.findElement(By.id("submit")).click();
		 */
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			//Gmail Inbox Page
			//Compose Email
			
			WebElement compose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div")));
			compose.click();
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
			
			WebElement emailto = driver.findElement(By.name("to"));
			WebElement subject = driver.findElement(By.name("subjectbox"));
			WebElement body = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
		
			emailto.sendKeys("automationtest985@gmail.com");
			
			subject.sendKeys("Test Subject");
			String ExpectedSubject = driver.findElement(By.xpath("//input[@value='Test Subject']")).getAttribute("value").toString();
			System.out.println("Expected Subject: "+ ExpectedSubject);
			
			body.sendKeys("This is the body of test email");
			String ExpectedBody = body.getText();
			System.out.println("Expected body: "+ ExpectedBody);
			
			//Social label
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			//WebElement moreoptions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-tooltip='More options']")));
			//moreoptions.click();
			driver.findElement(By.xpath("//div[@data-tooltip='More options']")).click();
			driver.findElement(By.xpath("//div[text()='Label']")).click();
			driver.findElement(By.xpath("(//div[text()='Social'])[last()]")).click();
			
			//send email
			driver.findElement(By.xpath("//div[text()='Send']")).click();
			Thread.sleep(30000);
			
			//social tab click
			driver.findElement(By.xpath("//div[@aria-label='Social']")).click();
			
			//code for starred
			//driver.findElement(By.xpath("(//span[text()='Test Subject']/../../../../../..//td[3]//span[@title='Not starred'])[2]")).click();
			Thread.sleep(5000);
			//code of opening email recieved
			driver.findElement(By.xpath("(//span[text()='Test Subject'])[2]")).click();
			
			Thread.sleep(5000);
			
			String ActualEmail = driver.findElement(By.xpath("//span[text()='automationtest985@gmail.com']")).getText();
			String ActualSubject = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[1]/div[2]/div[1]/h2")).getText();
			String ActualBody = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[3]/div[3]/div/div[1]")).getText();
			
			//conditials to verify
			
		
			
			if(ActualSubject.contentEquals(ExpectedSubject))
			{
				System.out.println("Subject Matched Sucessfully!");
			}
			else
			{
				System.out.println(ActualSubject + " Doesn't Matches the expected subject which is: " + ExpectedSubject);
			}
			
			
			if(ActualBody.contentEquals(ExpectedBody))
			{
				System.out.println("Email Body Matched Sucessfully!");
			}
			else
			{
				System.out.println(ActualBody + " | Doesn't Matches the expected body which is: " + ExpectedBody);
			}
			
			
			driver.close();
	}

}
