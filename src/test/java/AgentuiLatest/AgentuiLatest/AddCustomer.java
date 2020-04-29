package AgentuiLatest.AgentuiLatest;
import static org.testng.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class AddCustomer extends Home_page
{
	public static void addcustomer() throws Exception
	{
		Logger loggerr=Logger.getLogger("Test_czentrix");
		PropertyConfigurator.configure("Log4j.properties");  
		loggerr.info("Start Add customer Test Case"); 
		if(isElementPresent(By.name("switchPreview")))
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.document.getElementById('progressiveMode').click()");
		}
		else
		{
			screen(driver," Preview Button Not Found ");
			loggerr.info("Preview Button Not Found"); 
		}
		Hs=Hw.getSheet("Sheet1");
		number1=Hs.getRow(3).getCell(1).getStringCellValue(); 
		System.out.println("phone number from excel sheet"+number1);
		if(isElementPresent(By.name("makeNewCall")))
		{
			driver.findElement(By.name("makeNewCall")).click();
			System.out.println("click on makeNewCall button");
			driver.findElement(By.name("manualPhoneNo")).clear();
			driver.findElement(By.name("manualPhoneNo")).sendKeys(number1);
			Thread.sleep(1000);	
			driver.findElement(By.cssSelector("input.phoneDialButtonBackground:nth-child(3)")).click();
		}
		else
		{
			screen(driver," Makecall Button Not Found ");
			loggerr.info("Makecall Button Not Found "); 
		}
		if(isElementPresent(By.xpath(("//input[@value='Add Customer' and @type='submit']"))))
		{
			driver.findElement(By.xpath("//input[@value='Add Customer' and @type='submit']")).click();
			System.out.println("click on Add customer");
			Thread.sleep(1000); 
			assertTrue(closeAlertAndGetItsText().matches( "^Are you sure you want to create a Lead[\\s\\S]$"));
			Thread.sleep(1000);
			driver.findElement(By.name("name")).clear();
			driver.findElement(By.name("name")).sendKeys("Agent");
			driver.findElement(By.name("state")).clear();
			driver.findElement(By.name("state")).sendKeys("Up");
			driver.findElement(By.name("dob")).clear();
			driver.findElement(By.name("dob")).sendKeys("6-5-1998");
			driver.findElement(By.name("city")).clear();
			driver.findElement(By.name("city")).sendKeys("meerut");
			driver.findElement(By.name("pin")).clear();
			driver.findElement(By.name("pin")).sendKeys("254466");
			driver.findElement(By.name("verifierid")).clear();
			driver.findElement(By.name("verifierid")).sendKeys("yes");
			driver.findElement(By.name("address")).clear();
			driver.findElement(By.name("address")).sendKeys("Cdr_chock");
			driver.findElement(By.name("country")).clear();
			driver.findElement(By.name("country")).sendKeys("india");
			Select sel3=new Select(driver.findElement(By.name("gender")));
			sel3.selectByValue("F");
			driver.findElement(By.name("phone1")).clear();
			driver.findElement(By.name("phone1")).sendKeys("9999887766");
			//scroll down
			if(isElementPresent(By.xpath(("/html/body/form/table[7]/tbody/tr/td/ul/li[1]"))))
			{
				Thread.sleep(1000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement element =driver.findElement(By.xpath("/html/body/form/table[7]/tbody/tr/td/ul/li[1]"));
				js.executeScript("arguments[0].scrollIntoView(true);", element);
			}
			else
			{
				screen(driver," Scroll Button Not Found ");
				loggerr.info("Scroll Button Not Found "); 
			}
			//disconnect call
			if(isElementPresent(By.name("disconnect")))
			{
				driver.findElement(By.name("disconnect")).click();
				System.out.println("click on disconnect button");
				Thread.sleep(2000);
			}
			else
			{
				screen(driver," Disconnect Button Not Found ");
				loggerr.info("Disconnect Button Not Found "); 
			}
		}
		else
		{
			screen(driver,"Add Customer Button Not Found ");
			loggerr.info("Add Customer Button Not Found "); 
		}
	}
	public static void  CustomerInfoExtent()
	{
		Logger loggerr=Logger.getLogger("CustomerInfoExtent");
		PropertyConfigurator.configure("Log4j.properties");  
		loggerr.info("Start Add Customer Extent Report Method"); 
		if(Customername.equals("Agent"))
		{
			logger=report.createTest("Add Customer");
			logger.pass("name from customer_"+campaign_id1+ " table "+Customername);
			if(address.equals("Cdr_chock"))
			{		loggerr.info("Start Add Customer Extent Report Method"); 


				logger.pass("address from customer_"+campaign_id1+ " table "+address);

			}
			else
			{
				logger.fail("address from customer_"+campaign_id1+ " table "+address);
			}
			if(state.equals("Up"))
			{

				logger.pass("state from customer_"+campaign_id1+ " table "+state);

			}
			else
			{
				logger.fail("state from customer_"+campaign_id1+ " table "+state);

			}
			if(city.equals("meerut"))
			{

				logger.pass("city from customer_"+campaign_id1+ " table "+city);

			}
			else
			{
				logger.fail("city from customer_"+campaign_id1+ " table "+city);

			}
			if(country.equals("india"))
			{

				logger.pass("country from customer_"+campaign_id1+ " table "+country);

			}
			else
			{
				logger.fail("country from customer_"+campaign_id1+ " table "+country);

			}
			if(pin.equals("254466"))

			{

				logger.pass("pin from customer_"+campaign_id1+ " table "+pin);

			}
			else
			{
				logger.fail("pin from customer_"+campaign_id1+ " table "+pin);

			}





		}
		else 
		{
			logger=report.createTest("Add Customer");
			//Assert.assertTrue(true);
			logger.fail("name from customer_"+campaign_id1+ " table "+Customername);

			if(address.equals("Cdr_chock"))
			{

				logger.pass("address from customer_"+campaign_id1+ " table "+address);

			}
			else
			{
				logger.fail("address from customer_"+campaign_id1+ " table "+address);
			}
			if(state.equals("Up"))
			{

				logger.pass("state from customer_"+campaign_id1+ " table "+state);

			}
			else
			{
				logger.fail("state from customer_"+campaign_id1+ " table "+state);

			}
			if(city.equals("meerut"))
			{

				logger.pass("city from customer_"+campaign_id1+ " table "+city);

			}
			else
			{
				logger.fail("city from customer_"+campaign_id1+ " table "+city);

			}
			if(country.equals("india"))
			{

				logger.pass("country from customer_"+campaign_id1+ " table "+country);

			}
			else
			{
				logger.fail("country from customer_"+campaign_id1+ " table "+country);

			}
			if(pin.equals("254466"))

			{

				logger.pass("pin from customer_"+campaign_id1+ " table "+pin);

			}
			else
			{
				logger.fail("pin from customer_"+campaign_id1+ " table "+pin);

			}
			
		}
		loggerr.info("Close Add Customer Extent Report Method"); 

	}
}
