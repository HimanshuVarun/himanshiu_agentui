package AgentuiLatest.AgentuiLatest ;
//import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Preview_button extends Home_page
{
	public static void pre_() throws Exception
	{
		Logger log=Logger.getLogger("Preview button test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start preview button   test case");
		Thread.sleep(2000);
		//	ArrayList list=new ArrayList();
		Object o=new  Object();
		o=driver.findElements(By.tagName("iframe")).isEmpty();
		if(o.equals(false))
		{
			System.out.println("you are in frame");
		}
		else
		{
			System.out.println("you are not in frame");
			driver.switchTo().frame("crm");

		}

		if(isElementPresent(By.name("switchPreview")))
		{

			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.document.getElementById('progressiveMode').click()");
			//  driver.findElement(By.name("recess_btn")).click();	
			System.out.println("click on preview");
		}
		else
		{
			screen(driver," Preview button not found ");
			System.out.println("Preview button not found");
		}
	}


	public static void  PreviewExtent()
	{
		Logger log=Logger.getLogger("Preview button test case extent report method");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start preview button   test case extent report");
		if(dialer_type.equals("PREVIEW"))
		{
			logger=report.createTest("Preview");
			//Assert.assertTrue(true);
			logger.pass("Preview  test case is pass ");
			logger.pass(" dialer_type from agent live table  before click on preview button ::\t"+dialer_type_before_pre);
			logger.pass(" dialer_type from agent live table  after click on preview button::\t"+dialer_type);
			logger.pass(" Campaign id from agent table ::\t"+campaign_id1);
			logger.pass(" Campaign id from agent_live table ::\t"+campaign_id);


		}
		else
		{
			logger=report.createTest("Preview");
			//Assert.assertTrue(true);
			logger.fail(" dialer_type from agent live table  before click on preview button ::\t"+dialer_type_before_pre);
			logger.fail(" dialer_type from agent live table  after click on preview button::\t"+dialer_type);       
			System.out.println("Ready_button  test case is fail because some data not available in data base(some column missing in table campaign)");
		}
	}
}


