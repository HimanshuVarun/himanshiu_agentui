package AgentuiLatest.AgentuiLatest ;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;



public class Logout extends Home_page
{

	public static void logout() throws Exception
	{
		Logger log=Logger.getLogger("Logout test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start logout  method");
		System.out.println("in logout method");
		//	driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		System.out.println(" exit frame");
		if(isElementPresent(By.cssSelector(".logoutButtonBackground")))
		{
			driver.findElement(By.cssSelector(".logoutButtonBackground")).click();
			System.out.println("click on logout ");
			closeAlertAndGetItsText();
		}
		else
		{
			screen(driver,"logout button not found ");
			System.out.println("log out button not found");
		}
		System.out.println("agent logout");
	}
	public static void  LogoutExtent()
	{
		Logger log=Logger.getLogger("Logout test extent report");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start logout extent report method");
		if(agent_live_flag==0)
		{
			
			logger=report.createTest("Logout");

			//Assert.assertTrue(true);
			logger.pass("Logout  test case is pass ");
			logger.pass(" Agent detail not Available in agent_live table after logout");


		}
		else if(agent_live_flag==1)
		{
			logger=report.createTest("Logout");
			//Assert.assertTrue(true);
			logger.fail("Logout  test case is Fail ");
			logger.fail("Agent detail  Available in agent_live table after logout"+Agent_name_F_agent_live);
		
		}
	}


}
