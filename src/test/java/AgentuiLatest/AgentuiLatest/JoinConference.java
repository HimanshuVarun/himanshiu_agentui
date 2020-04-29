package AgentuiLatest.AgentuiLatest;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
public class JoinConference extends Home_page 
{
//	public static  String number1;
	public static int call_count_excel,f;
	public static void JoinConf() throws InterruptedException
	{
		Logger log=Logger.getLogger("ConferenceCall test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start ConferenceCall  test case");
		Thread.sleep(2000);
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
		call_count_excel=Hs.getLastRowNum();
		System.out.println("total number in excel\t "+call_count_excel);
		number1=Hs.getRow(1).getCell(1).getStringCellValue(); 
		System.out.println("phone number from excel sheet"+number1);
		//Make a new call
		if(isElementPresent(By.name("makeNewCall")))
		{
			driver.findElement(By.name("makeNewCall")).click();
			System.out.println("click on makeNewCall button");
			driver.findElement(By.name("manualPhoneNo")).clear();
			driver.findElement(By.name("manualPhoneNo")).sendKeys(number1);
			Thread.sleep(2000);	
			driver.findElement(By.cssSelector("input.phoneDialButtonBackground:nth-child(3)")).click();
		}
		else
		{
			screen(driver," Makecall button not found ");
			System.out.println("Makenew call button not found ");
		}	
		driver.switchTo().defaultContent();
		Thread.sleep(1000);	
		driver.switchTo().frame("call_info");
		Thread.sleep(1000);	
		if(isElementPresent(By.xpath("//img[@border='0']")))
		{                            
			driver.get("http://"+baseUrl+"/supervisedTransfer.php?agentid="+AgentId);
			if(isElementPresent(By.id("transfer_supervisor")))
			{	
				driver.findElement(By.id("transfer_supervisor")).click();
			}
			else
			{
				System.out.println("Transfer button not found");
			}
			number1=Hs.getRow(2).getCell(1).getStringCellValue(); 
			System.out.println("phone number from excel sheet"+number1);
			if(isElementPresent(By.name("txt_cust_ph")))
			{	
				driver.findElement(By.name("txt_cust_ph")).sendKeys(number1);
			}
			else
			{
				System.out.println("conference text box not found ");
			}
			Thread.sleep(2000);	
			if(isElementPresent(By.name("dial")))
			{
				driver.findElement(By.name("dial")).click();
			}
			else
			{
				System.out.println("Dial button not found");
			}
			if(isElementPresent(By.xpath("/html/body/form[1]/input[3]")))
			{
				driver.findElement(By.xpath("/html/body/form[1]/input[3]")).click();
			}
			else
			{
				System.out.println("TransferBoth button not found");
			}
			Thread.sleep(1000);
			if(isElementPresent(By.xpath("//input[@value='Back to Queue']")))
			{
				System.out.println("Back to queue111111111111111111");

				try {
					driver.findElement(By.xpath("//input[@value='Back to Queue']")).click();//there is exception
					//driver.findElement(By.xpath("//input[@name='Dialercall']"));
					System.out.println("Back to queue22222222222222222");
				} 
				catch (Exception e)
				{
					System.out.println("Exception in Back to queue button");
				}
				System.out.println("Exception in Back to queue button1111111");
			}

			else
			{
				System.out.println("BAck to queue button not found");
			}
			Thread.sleep(2000);
			if(isElementPresent(By.xpath("//input[@value='Join conference']")))
			{
				//driver.get("http://"+baseUrl+"/supervisedTransfer.php?agentid="+AgentId);

			}
			else
			{
				driver.get("http://"+baseUrl+"/supervisedTransfer.php?agentid="+AgentId);

			}
			System.out.println("Exception in Back to queue button2222222222444444444");
			Thread.sleep(2000);
			if(isElementPresent(By.xpath("//input[@value='Join conference']")))
			{
				driver.findElement(By.xpath("//input[@value='Join conference']")).click();
				System.out.println("Click on join conference button");
			}
			else
			{
				System.out.println("join conference button not found");
			}
		}
		else
		{
			System.out.println("conference button not found");
		}
	}
	public static void  JoinConferenceExtent()
	{
		Logger log=Logger.getLogger("Conference test extent report");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start Conference extent report method");
		if(is_paused.equals("1"))
		{
			
			logger=report.createTest("JoinConference");
			//Assert.assertTrue(true);
		
			logger.pass("is_paused from agent_live table "+is_paused);

			if(AgentInConf==1)
			{
			
				logger.pass("AgentInConf from agent_live table "+AgentInConf);

			}
			else
			{
			
				logger.fail("AgentInConf from agent_live table "+AgentInConf);

			}

			if(break_type.equals("JoinedConference"))
			{
			
				logger.pass("break_type from agent_live table "+break_type);

			}
			else
			{
			
				logger.fail("break_type from agent_live table "+break_type);


			}

		}
		else 
		{
			
			logger=report.createTest("JoinConference");
			//Assert.assertTrue(true);
		
			logger.fail("is_paused from agent_live table "+is_paused);
			if(AgentInConf==1)
			{
			
				logger.pass("AgentInConf from agent_live table "+AgentInConf);

			}
			else
			{
			
				logger.fail("AgentInConf from agent_live table "+AgentInConf);

			}

			if(break_type.equals("JoinedConference"))
			{
				
				logger.pass("break_type from agent_live table "+break_type);

			}
			else
			{
				
				logger.fail("break_type from agent_live table "+break_type);

			}

		}
	}


}
