package AgentuiLatest.AgentuiLatest;
import static org.testng.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class Change extends Home_page
{
    static	String name1;
	public static void ChangeLog() throws Exception
	{
		Logger loggerr=Logger.getLogger("Test_czentrix");
		PropertyConfigurator.configure("Log4j.properties");  
		loggerr.info("start add customer test case"); 
		if(isElementPresent(By.name("switchPreview")))
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.document.getElementById('progressiveMode').click()");
		}
		else
		{
			screen(driver," preview button not found ");
			System.out.println("preview button not found");
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
			screen(driver," Makecall button not found ");
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
			driver.findElement(By.name("verifierid")).clear();
			driver.findElement(By.name("verifierid")).sendKeys("yes");
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
				System.out.println("Scroll button");
			}
			else
			{
				System.out.println("Scroll not found in scroll down case");
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
				screen(driver," Disconnect button not found ");
			}
			Data();
			
			name1=Customername;
			//verifierid1=verifierid;
			System.out.println("name before update "+name1);
		//	System.out.println("varified before update"+verifierid1);
			try {
				driver.navigate().refresh();
		    	} catch (Exception e) {
				  //e.printStackTrace();
			     }  
	 //       driver.switchTo().defaultContent();
			driver.switchTo().frame("crm");
	        System.out.println("secound time make new call");
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
				System.out.println("Makenew call button not found ");
				screen(driver," Makecall button not found ");
			}
			if(isElementPresent(By.xpath(("//input[@value='Add Customer' and @type='submit']"))))
			{
	    		driver.findElement(By.xpath("//input[@value='Add Customer' and @type='submit']")).click();
				System.out.println("click on Add customer");
				Thread.sleep(1000); 
				assertTrue(closeAlertAndGetItsText().matches( "^Are you sure you want to create a Lead[\\s\\S]$"));
				Thread.sleep(1000);
				driver.findElement(By.name("name")).clear();
				driver.findElement(By.name("name")).sendKeys("Admin");
				driver.findElement(By.name("verifierid")).clear();
				driver.findElement(By.name("verifierid")).sendKeys("no");
				Select sel=new Select(driver.findElement(By.name("gender")));
	     			   sel.selectByValue("F");
				driver.findElement(By.name("phone1")).clear();
				driver.findElement(By.name("phone1")).sendKeys("9999887766");
				//scroll down
				if(isElementPresent(By.xpath(("/html/body/form/table[7]/tbody/tr/td/ul/li[1]"))))
				{
					Thread.sleep(1000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					WebElement element =driver.findElement(By.xpath("/html/body/form/table[7]/tbody/tr/td/ul/li[1]"));
					js.executeScript("arguments[0].scrollIntoView(true);", element);
					System.out.println("Scroll button");
				}
				else
				{
					System.out.println("Scroll not found in scroll down case");
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
					screen(driver," Disconnect button not found ");
				}
			}
			else
			{
				screen(driver," add customer button not found ");
			}
			Data();
			System.out.println("name after update"+Customername);
			//System.out.println("varified after update"+address);
         }
		else
		{
			screen(driver," add customer button not found ");
		}
    }
	public static void  ChangelogExtent()
	{
		Logger log=Logger.getLogger("ChangeLog test extent report");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start ChangeLog extent report method");
		if(Customername!=name1)
		{
			logger=report.createTest("ChangeLog");
        	logger.pass("Name before update "+name1);
        	logger.pass("Name after update "+Customername);

		}
		else 
		{
			logger=report.createTest("ChangeLog");
			logger.fail("Name before update "+name1);
        	logger.fail("Name after update "+Customername);
		}
	}
}
