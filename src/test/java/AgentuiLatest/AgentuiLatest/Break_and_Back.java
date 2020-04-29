package AgentuiLatest.AgentuiLatest ;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;




public class Break_and_Back extends Home_page
{
	public static void break_() throws Exception
	{
		Logger log=Logger.getLogger("Break test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start break test case");
		Thread.sleep(2000);
		//BREAK 
		if( isElementPresent(By.name("recess_btn")))
		{
			log.info("in  break condtion");
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.document.getElementById('takeBreak').click()");
			//  driver.findElement(By.name("recess_btn")).click();	
			System.out.println("click on break");
			log.info("Cliclk on break button ");
			Thread.sleep(500);
		}
		else
		{
			log.info("Break button not found");
			screen(driver," Break button not found ");
			System.out.println("Break button not found");
		}
	}
	public static void  BreakExtent()
	{

		Logger log=Logger.getLogger(" extent report Break test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start brak test case extent report method");
		if(break_type.equals("BREAK"))
		{
			
			logger=report.createTest("Break");
			//Assert.assertTrue(true);
			logger.pass("Break  test case is pass ");
			logger.pass(" break_type from agen_live table  ::\t"+break_type);
			
			if(is_paused.equals("1"))
			{
				logger.pass(" is_paused from agent_live table ::\t"+is_paused);
			//	logger.pass("pause_duration from agent_live table ::\t"+pause_duration);
				
			}
			else
			{

				logger.fail(" is_paused from agent_live table ::\t"+is_paused);
				//	logger.fail("pause_duration from agent_live table ::\t"+pause_duration);
			}

		}
		else
		{
			logger=report.createTest("Break");
			//Assert.assertTrue(true);
			logger.fail("Break  test case is fail ");
			logger.fail(" break_type from agen_live table  ::\t"+break_type);
			if(is_paused.equals("1"))
			{
				logger.pass(" is_paused from agent_live table ::\t"+is_paused);
			//	logger.pass("pause_duration from agent_live table ::\t"+pause_duration);
				
			}
			else
			{

				logger.fail(" is_paused from agent_live table ::\t"+is_paused);
				//	logger.fail("pause_duration from agent_live table ::\t"+pause_duration);
			}

			System.out.println("Break  test case is fail because some data not available in data base(some column missing in table campaign)");
		}
	}
	public static void back() throws Exception
	{

		Logger log=Logger.getLogger("Back test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start back test case");
		Thread.sleep(2000);
		if( isElementPresent(By.name("back_btn")))
		{ 
			JavascriptExecutor js1=(JavascriptExecutor)driver;
			js1.executeScript("window.document.getElementById('backBreak').click()");
			// driver.findElement(By.name("back_btn")).click();	
			System.out.println("Back from break");
		}
		else
		{
			screen(driver," Back button not found ");
			System.out.println("Back button not found");
		}
	}
	public static void  BackExtent()
	{
		Logger log=Logger.getLogger(" extent report Break test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start back test case extent report method");
		if(pause_duration>0)//&&break_count>0
		{
			
			logger=report.createTest("Back_from_break");

			//Assert.assertTrue(true);
			logger.pass("Back _from_break test case is pass ");
			logger.pass("pause_duration from agent_live table ::\t"+pause_duration);
			
			if(is_paused.equals("0"))
			{
				logger.pass(" is_paused from agent_live table ::\t"+is_paused);
				logger.pass("break_count from agent_live table ::\t"+break_count);
			
			}
			else
			{
				logger.fail(" is_paused from agent_live table ::\t"+is_paused);
			}
			if(break_type.equals(""))
			{
				logger.pass(" break_type from agent_live table  ::\t"+break_type);
			}
			else
			{
				logger.fail(" break_type from agent_live table  ::\t"+break_type);

			}
		}
		else
		{
			
			logger=report.createTest("Back_from_break");
			//Assert.assertTrue(true);
			logger.fail("Back_from_break  test case is fail ");
			logger.fail("pause_duration from agent_live table ::\t"+pause_duration);
		//	logger.fail("break_count from agent_live table ::\t"+break_count);

		
			if(is_paused.equals("0"))
			{
				logger.pass(" is_paused from agent_live table ::\t"+is_paused);
				logger.pass("break_count from agent_live table ::\t"+break_count);
			
			}
			else
			{
				logger.fail(" is_paused from agent_live table ::\t"+is_paused);
			}
			if(break_type.equals(""))
			{
				logger.pass(" break_type from agent_live table  ::\t"+break_type);
			}
			else
			{
				logger.fail(" break_type from agent_live table  ::\t"+break_type);

			}
		}
	}
}
