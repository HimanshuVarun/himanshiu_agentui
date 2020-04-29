package AgentuiLatest.AgentuiLatest;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;

public class BackToQueue extends Home_page
{
//	public static  String number1;
	public static int call_count_excel,f;
	public static void queue() throws InterruptedException
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
			System.out.println("click on preview button");
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
			System.out.println("make new call button not found");
		}	
	//	driver.switchTo().defaultContent();
		Thread.sleep(2000);	
	//	driver.switchTo().frame("call_info");
		Thread.sleep(2000);	
		if(isElementPresent(By.xpath("//img[@border='0']")))
		{                       
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

			Thread.sleep(1000);
			if(isElementPresent(By.xpath("//input[@value='Back to Queue']")))
			{

				try {
					driver.findElement(By.xpath("//input[@value='Back to Queue']")).click();
					System.out.println("Click on Back to queue");



				} 
				catch (TimeoutException e)
				{
					// TODO: handle exception
				}
			}

			else
			{
				System.out.println("BackToQueue button not found");
			}
		}
		else
		{
			System.out.println("conference button not foundd");
			Thread.sleep(1000);
		
			if(isElementPresent(By.xpath("//input[@value='Back to Queue']")))
			{
				

				try {
					driver.findElement(By.xpath("//input[@value='Back to Queue']")).click();
					System.out.println("Click on Back to queue");

				} 
				catch (TimeoutException e)
				{
					// TODO: handle exception
				}
			}

			else
			{
				System.out.println("BackToQueue button not found");
			}
		}
	}
	public static void  BackToQueueExtent()
	{
		Logger log=Logger.getLogger("BackToQueue test extent report");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start BackToQueue extent report method");
		if(is_paused.equals("0"))
		{

			logger=report.createTest("BackToQueue");

			//Assert.assertTrue(true);

			logger.pass("is_paused from agent_live table "+is_paused);
			if(AgentInConf==0)
			{

				logger.pass("AgentInConf from agent_live table "+AgentInConf);

			}
			else
			{
				logger.fail("AgentInConf from agent_live table "+AgentInConf);

			}

			if(break_type.equals(""))
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
			logger=report.createTest("BackToQueue");
			//Assert.assertTrue(true);

			logger.fail("is_paused from agent_live table "+is_paused);
			if(AgentInConf==0)
			{

				logger.pass("AgentInConf from agent_live table "+AgentInConf);

			}
			else
			{
				logger.fail("AgentInConf from agent_live table "+AgentInConf);

			}

			if(break_type.equals(""))
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
