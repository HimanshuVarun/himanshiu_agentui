package AgentuiLatest.AgentuiLatest ;
import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class Test_Base extends Home_page
{ 
    @BeforeTest                                                   
	public void OpenBrowser() throws Exception      
	{ 
		Logger loggerr=Logger.getLogger("OpenBrowser");
		PropertyConfigurator.configure("Log4j.properties");  
		loggerr.info("Start Open Browser Test Case"); 
		ExtentHtmlReporter extent =new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Report/Agentui"+getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		Home_page.openBrowser();
		logger=report.createTest("openbrowser");
		logger.info("starting application");
		logger.pass("browser test case is pass");
		loggerr.info("Close Open Browser Test Case"); 
   	}
    @Test(priority=1) 
	public void AgentLogin() throws Exception 
	{	
      	Logger loggerr=Logger.getLogger("AgentLogin");
		PropertyConfigurator.configure("Log4j.properties");  
    	loggerr.info("Start AgentLogin Test Case"); 
		Agentlogin.login();
    	loggerr.info("Call ExtentReport In AgentLogin Test Case"); 
		Agentlogin.AgentLoginExtent();
		loggerr.info("Close AgentLogin Test Case"); 
	}
	@Test(priority=2)
	public void Ready_button() throws Exception
	{
		Logger loggerr=Logger.getLogger("Ready_button");
		PropertyConfigurator.configure("Log4j.properties");  
		loggerr.info("Start Ready_button Test Case"); 
		Ready_button.ready();
		loggerr.info("Call DataBase Method In Ready_button Test Case "); 
		Data();
    	loggerr.info("Call ExtentReport Method In AgentLogin Test Case"); 
 		Ready_button.ReadyExtent();
 		loggerr.info("Close Ready_button Test Case"); 
	}
	@Test(priority=3)
	public void AddCustomer() throws Exception
	{
		Logger loggerr=Logger.getLogger("AddCustomer");
		PropertyConfigurator.configure("Log4j.properties");  
    	loggerr.info("Start AddCustomer Test Case"); 
	    AddCustomer.addcustomer();
		loggerr.info("Call DataBase Method In AddCustomer Test Case "); 
		Data();
		loggerr.info("Call ExtentReport Method In AddCustomer "); 
		AddCustomer.CustomerInfoExtent();
 		loggerr.info("Close AddCustomer Test Case"); 
	}
	@Test(priority=3)
	public void Changelogg() throws Exception
	{
		System.out.println("start Changelog  test  case");
		Change.ChangeLog();
        System.out.println("call data base method in Chanelog test case ");
		Data();
		System.out.println("call extent report  method in Chanelog ");
		Change.ChangelogExtent();
		System.out.println("Changelog test case  is closed");
	}

	/*@Test(priority=3,retryAnalyzer=Retry.RetryFailedTest.class)
	public void preview_test() throws Exception
	{
		System.out.println("start preview button test  case");
		Preview_button.pre_();
		System.out.println("call data base method in preview button");
		Thread.sleep(1000);
		Data();
		System.out.println("call preview button extent report in preview button");
		Preview_button.PreviewExtent();
		System.out.println("close  preview button test case ");
	}
	@Test(priority=4,retryAnalyzer=Retry.RetryFailedTest.class)
	public void progressive_test() throws Exception 
	{
		System.out.println("start progressive button test  case");
		Progressive.pro();
		System.out.println("call data base method in progressive test case");
		//	Thread.sleep(1000);
		Data();
		System.out.println("call progressive button extent report in progressive button");
		Progressive.ProgeressiveExtent();
		System.out.println("close  progressive button test case");
	}
	@Test(priority=5,retryAnalyzer=Retry.RetryFailedTest.class)
	public void break_Test() throws Exception
	{
		System.out.println("start break button test  case");
		Break_and_Back.break_();
		System.out.println("call data base method in break test  case");
		Data();
		System.out.println("call extent report method in break test  case");
		Break_and_Back.BreakExtent();
	}

	@Test(priority=6,retryAnalyzer=Retry.RetryFailedTest.class)
	public void back_Test() throws Exception
	{
		System.out.println("start back button test  case");
		Break_and_Back.back();
		System.out.println("call data base method in back button test  case");
		Thread.sleep(1000);
		Data();
		System.out.println("call extent report method in back test  case");
		Break_and_Back.BackExtent();
	}
	@Test(priority=7,retryAnalyzer=Retry.RetryFailedTest.class)
	public void auto_mode() throws Exception
	{
		System.out.println("start auto button test  case");
		Switch_auto.switch_();
		System.out.println("call data base method in auto button test  case");
		Data();
		System.out.println("call extent report method in auto button test  case");
		Switch_auto.SwitchToAutoExtent();
	}
	@Test(priority=8,retryAnalyzer=Retry.RetryFailedTest.class)
	public void Reset_auto() throws Exception
	{
		System.out.println("start reset button test  case");
		Switch_auto.back_auto();
		System.out.println("call data base method in reset button test case");
		Data();
		System.out.println("call extent report method in reset button test case");
		Switch_auto.ResetAutoModeExtent();
	}

	@Test(priority=9,retryAnalyzer=Retry.RetryFailedTest.class)	
	public void Call_test() throws Exception
	{
		System.out.println("start make call button test  case");
		Make_call.call();  
		System.out.println("call data base method in make call test case");
		//Thread.sleep(1000);
		Data();
		System.out.println("call extent report method in make call test case");
		Make_call.MakeCallExtent();
	}	

	//@Test(priority=9)	
	public void parking() throws Exception
	{
		System.out.println("start parking button test  case");
		Parking.park();
		System.out.println("call data base method in parking test case");
		Data();
		System.out.println("call extent report method in parking test case");
		Parking.parkExtent();
	}	


	//@Test(priority=10)	
	public void unPark() throws Exception
	{
		System.out.println("start unPark button test  case");
		UnparkCall.unPark();
		System.out.println("call data base method in unPark test case");
		System.out.println("call extent report method in unPark test case");
		//UnparkCall.unparkExtent();
	}	
	@Test(priority=10,retryAnalyzer=Retry.RetryFailedTest.class)
	public void Redial() throws Exception
	{
		System.out.println("start Redial button test  case");
		Redial.redial();
		System.out.println("call data base method in Redial test case");
		Data();
		System.out.println("call extent report method in Redial test case");
		Redial.RedialExtent();
	}
	
	
	@Test(priority=11,retryAnalyzer=Retry.RetryFailedTest.class)
	public void Conference() throws Exception
	{ 
		System.out.println("start Conference button test  case");
		ConferenceCall.conf();
		System.out.println("call data base method in Conference button ");
		Thread.sleep(1000);
	    System.out.println("call extent report  method in Conference button");
		ConferenceCall.ConferenceExtennt();
		System.out.println("Conference test case  is closed");
	}
	@Test(priority=12,retryAnalyzer=Retry.RetryFailedTest.class)
	public void JoinConference() throws Exception
	{
		System.out.println("start JoinConference button test  case");
		JoinConference.JoinConf();
		System.out.println("call data base method in JoinConference button ");
		Thread.sleep(1000);
		Data();
		System.out.println("call extent report  method in JoinConference button");
		JoinConference.JoinConferenceExtent();
		System.out.println("JoinConference test case  is closed");
	}
	
	@Test(priority=13,retryAnalyzer=Retry.RetryFailedTest.class)
	public void BackToQueue() throws Exception
	{
		System.out.println("start BackToQueue button test  case");
		BackToQueue.queue();
		System.out.println("call data base method in BackToQueue button ");
		Thread.sleep(1000);
		Data();
		System.out.println("call extent report  method in BackToQueue button");
		BackToQueue.BackToQueueExtent();
		System.out.println("BackToQueue test case  is closed");
	}
	

	@Test(priority=14,retryAnalyzer=Retry.RetryFailedTest.class)
	public void log() throws Exception
	{
		Logout.logout();
		Thread.sleep(1000);
		Data();
		Logout.LogoutExtent();
	}
*/
 

}
