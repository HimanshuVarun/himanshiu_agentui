package AgentuiLatest.AgentuiLatest ;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;




public class Ready_button extends Home_page
{
	static String Readybutton="";
	public static void ready() throws Exception
	{
		Logger log=Logger.getLogger("Ready button test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start ready button   test case");
		driver.switchTo().frame("crm");
		System.out.println("enter in frame");
		Thread.sleep(1000);
		//Ready the agent
		if(isElementPresent(By.name("readyMode")))
		{
			driver.findElement(By.name("readyMode")).click();
			System.out.println("click on ready button");
			Readybutton="Ready";
		}
		else
		{
			screen(driver," Ready button not found ");
			System.out.println("ready button not found");

		}

	}

	public static void ReadyExtent()
	{
		Logger log=Logger.getLogger("Ready button test case extent report");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start ready button   test case extent report method ");
		if(Readybutton.equals("Ready"))
		{
			logger=report.createTest("Ready_button");
			//Assert.assertTrue(true);
			logger.pass("Ready_button  test case is pass");
			if(agent_state.equals("FREE"))
			{
				logger.pass(" agent_state from data base Before click on ready Button::\t"+agent_state_before_login);
				logger.pass(" agent_state from data base After click on ready Button ::\t"+agent_state);
			}
			else
			{
				logger.fail(" agent_state from data base Before click on ready Button::\t"+agent_state_before_login);
				logger.fail(" agent_state from data base After click on ready Button ::\t"+agent_state);
			}
			if(dialer_type.equals("PROGRESSIVE")||dialer_type.equals("PREVIEW"))
			{
				logger.pass(" dialer_type from data base ::\t"+dialer_type);
			}
			else
			{
				logger.fail(" dialer_type from data base ::\t"+dialer_type);
			}
			if(campaign_id1.equals(campaign_id))
			{
				logger.pass(" Campaign id from agent table ::\t"+campaign_id1);
				logger.pass(" Campaign id from agent_live table ::\t"+campaign_id);
			}
			else
			{
				logger.pass(" Campaign id from agent table ::\t"+campaign_id1);
				logger.pass(" Campaign id from agent_live table ::\t"+campaign_id);
			}
		}
		else
		{
			logger=report.createTest("Ready_button");
			//Assert.assertTrue(true);
			logger.fail("Ready_button not found ");

			if(Readybutton.equals("Ready"))
			{
				logger=report.createTest("Ready_button");
				//Assert.assertTrue(true);
				logger.pass("Ready_button  test case is pass");
				if(agent_state.equals("FREE"))
				{
					logger.pass(" agent_state from data base Before click on ready Button::\t"+agent_state_before_login);
					logger.pass(" agent_state from data base After click on ready Button ::\t"+agent_state);
				}
				else
				{
					logger.fail(" agent_state from data base Before click on ready Button::\t"+agent_state_before_login);
					logger.fail(" agent_state from data base After click on ready Button ::\t"+agent_state);
				}
				if(dialer_type.equals("PROGRESSIVE")||dialer_type.equals("PREVIEW"))
				{
					logger.pass(" dialer_type from data base ::\t"+dialer_type);
				}
				else
				{
					logger.fail(" dialer_type from data base ::\t"+dialer_type);
				}
				if(campaign_id1.equals(campaign_id))
				{
					logger.pass(" Campaign id from agent table ::\t"+campaign_id1);
					logger.pass(" Campaign id from agent_live table ::\t"+campaign_id);
				}
				else
				{
					logger.pass(" Campaign id from agent table ::\t"+campaign_id1);
					logger.pass(" Campaign id from agent_live table ::\t"+campaign_id);
				}
			}

		}

	}
}
