package AgentuiLatest.AgentuiLatest;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
public class Agentlogin extends Home_page
{
	public static void login() throws Exception
	{
		Logger loggerr=Logger.getLogger("Login");
		PropertyConfigurator.configure("Log4j.properties");  
    	loggerr.info("Start Login Method"); 
		try {
			AgentId=Hs.getRow(1).getCell(3).getStringCellValue();
			driver.findElement(By.name("agent_id")).clear();
			driver.findElement(By.name("agent_id")).sendKeys(AgentId);	
		    //Thread.sleep(2000);
			if(isElementPresent(By.name("updateIP")))
			{
				driver.findElement(By.name("updateIP")).click();
			}
			else
			{
				loggerr.info("Submit Button Not Found"); 
			}
		}
		catch(TimeoutException e)
		{
			//System.out.println("time out exception "+e.getMessage());
			//System.out.println("time out exception in agent login try block");
			//	e.printStackTrace();
		}
		Thread.sleep(5000);
		// driver.navigate().refresh();
		loggerr.info("Call DataBase Method In Login Method"); 
		Data();
		agent_state_before_login=agent_state;
		dialer_type_before_pre=dialer_type;
		automode1=autoMode;
		loggerr.info("Close Login Method");
	}

	public static void AgentLoginExtent()
	{
		Logger loggerr=Logger.getLogger("AgentLoginExtentReport");
		PropertyConfigurator.configure("Log4j.properties");  
    	loggerr.info("Start AgentLoginExtent Method"); 
		if(AgentId.equals(Agentid))
		{
			logger=report.createTest("AgentLogin");
			logger.pass("Agent login  test case is pass");
			logger.pass("Agent_Id From excel is ::\t"+AgentId);
			logger.pass("Agent_Id From Data base is ::\t"+Agentid);
			if(dialer_type.equals("PROGRESSIVE"))
			{			
				logger.pass(" dialer_type from data base ::\t"+dialer_type);
			}
			else
			{
				logger.fail(" dialer_type from data base ::\t"+dialer_type);
			}
			if(agent_state.equals("CLOSURE"))
			{
				logger.pass("agent_state from data base  ::\t"+agent_state);
			}
			else
			{

				logger.fail(" agent_state from data base ::\t"+agent_state);
			}
			if(campaign_id1.equals(campaign_id))
			{
				logger.pass(" Campaign_id from Agent_live table ::\t"+campaign_id);
				logger.pass(" Campaign_id from Agent table ::\t"+campaign_id1);

			}
			else
			{
				logger.fail(" Campaign_id from Agent_live table ::\t"+campaign_id);
				logger.fail(" Campaign_id from Agent table ::\t"+campaign_id1);
			}
		}
		else
		{
			logger=report.createTest("AgentLogin");
			logger.fail("Agent not successfully Login");
			logger.fail("Agent_Id From excel is ::\t"+AgentId);
			logger.fail("Agent_Id From Data base is ::\t"+Agentid);
			if(dialer_type.equals("PROGRESSIVE"))
			{			
				logger.pass(" dialer_type from data base ::\t"+dialer_type);
			}
			else
			{
				logger.fail(" dialer_type from data base ::\t"+dialer_type);
			}
			if(agent_state.equals("CLOSURE"))
			{
				logger.pass("agent_state from data base  ::\t"+agent_state);
			}
			else
			{
				logger.fail(" agent_state from data base ::\t"+agent_state);
			}
			if(campaign_id1.equals(campaign_id))
			{
				logger.pass(" Campaign_id from Agent_live table ::\t"+campaign_id);
				logger.pass(" Campaign_id from Agent table ::\t"+campaign_id1);
			}
			else
			{
				logger.fail(" Campaign_id from Agent_live table ::\t"+campaign_id);
				logger.fail(" Campaign_id from Agent table ::\t"+campaign_id1);
			}
			loggerr.info("Close AgentLoginExtent Method"); 
		}
	}
}
