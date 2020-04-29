package AgentuiLatest.AgentuiLatest;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
public class ConferenceCall extends Home_page
{
//	public static  String number1;
	public static int call_count_excel,f;
	public static void conf() throws Exception 
	{
		Logger log=Logger.getLogger("ConferenceCall test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start ConferenceCall  test case");
		Thread.sleep(2000);
		if(isElementPresent(By.name("switchPreview")))
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.document.getElementById('progressiveMode').click()");
			//  driver.findElement(By.name("recess_btn")).click();	
			System.out.println("click on break");
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
			Thread.sleep(6000);	
			driver.findElement(By.cssSelector("input.phoneDialButtonBackground:nth-child(3)")).click();
		}
		else
		{
			screen(driver," Makecall button not found ");
		}	
		if(isElementPresent(By.xpath("//img[@border='0']")))
		{	
			driver.switchTo().defaultContent();
			Thread.sleep(2000);	
			driver.switchTo().frame("call_info");
		}
		Thread.sleep(2000);	
		if(isElementPresent(By.xpath("//img[@border='0']")))
		{                       
			//driver.findElement(By.cssSelector("[name='Dialercall']"));
			//driver.findElement(By.xpath("//input[@name='Dialercall']"));

			driver.get("http://"+baseUrl+"/supervisedTransfer.php?agentid="+AgentId);
			System.out.println("Pre call");
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
			Thread.sleep(4000);
			Data();
			Thread.sleep(1000);
			if(isElementPresent(By.xpath("//input[@value='Back to Queue']")))
			{
				System.out.println("Back to queue");

				try {
					driver.findElement(By.xpath("//input[@value='Back to Queue']")).click();
					//driver.findElement(By.xpath("//input[@name='Dialercall']"));

				} 
				catch (TimeoutException e)
				{
					// TODO: handle exception
					System.out.println("Exception in back to queue button");
				}
			}

			else
			{
				System.out.println("BAck to queue button not found");
			}
		}
		else
		{
			System.out.println("conference button not found");
		}
	}
	public static void  ConferenceExtennt()
	{
		Logger log=Logger.getLogger("Conference test extent report");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start Conference extent report method");
		if(is_free==0)
		{

			logger=report.createTest("Conference");

			//Assert.assertTrue(true);

			logger.pass("is_free from agent_live table "+is_free);

			if(agent_state.equals("FREE"))
			{

				logger.pass("agent_state from agent_live table "+agent_state);


			}
			else
			{

				logger.fail("agent_state from agent_live table "+agent_state);


			}
			if(PreDayMaxRetry==0)
			{
				logger.pass("PreDayMaxRetry from agent_live table "+PreDayMaxRetry);

			}
			else
			{

				logger.fail("PreDayMaxRetry from agent_live table "+PreDayMaxRetry);

			}
			if(break_type.equals("JoinedConference"))
			{

				logger.pass("break_type from agent_live table "+break_type);


			}
			else
			{

				logger.fail("break_type from agent_live table "+break_type);

			}
			if(AgentInConf==1)
			{

				logger.pass("AgentInConf from agent_live table "+AgentInConf);
			}
			else
			{

				logger.fail("AgentInConf from agent_live table "+AgentInConf);

			}
			if(Is_SetMeFree==0)
			{

				logger.pass("Is_SetMeFree from agent_live table "+Is_SetMeFree);
			}
			else
			{
				logger.fail("Is_SetMeFree from agent_live table "+Is_SetMeFree);
			}

		}
		
	else 
	{
		logger=report.createTest("Conference");
		//Assert.assertTrue(true);

		logger.fail("is_free from agent_live table "+is_free);
		if(agent_state.equals("FREE"))
		{

			logger.pass("agent_state from agent_live table "+agent_state);


		}
		else
		{

			logger.fail("agent_state from agent_live table "+agent_state);


		}
		if(PreDayMaxRetry==0)
		{
			logger.pass("PreDayMaxRetry from agent_live table "+PreDayMaxRetry);

		}
		else
		{

			logger.fail("PreDayMaxRetry from agent_live table "+PreDayMaxRetry);

		}
		if(break_type.equals("JoinedConference"))
		{

			logger.pass("break_type from agent_live table "+break_type);


		}
		else
		{

			logger.fail("break_type from agent_live table "+break_type);

		}
		if(AgentInConf==1)
		{

			logger.pass("AgentInConf from agent_live table "+AgentInConf);
		}
		else
		{

			logger.fail("AgentInConf from agent_live table "+AgentInConf);

		}
		if(Is_SetMeFree==0)
		{

			logger.pass("Is_SetMeFree from agent_live table "+Is_SetMeFree);
		}
		else
		{
			logger.fail("Is_SetMeFree from agent_live table "+Is_SetMeFree);
		}


	}
 }
}


