package AgentuiLatest.AgentuiLatest ;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
public class Home_page //implements IRetryAnalyzer
{ 
	public static ResultSet rs=null; 
	public static  Statement st=null;
	public static String sql,agent_live,campaign_id1,customer_table,phone_no,L_id_f_extended,dial_lead_look,p_f_d_lookup,L_id_F_d_state,p_no_F_d_state,agent_status, call_park_f_campaign,callPark,Disp,Agentid,phone1,currentReport,AgentNameCurrentReport,CampaignNameCurrentReport,CampaignTypeCurrentReport, ListNameCurrentReport,CustPhNoCurrentReport,CallEndDateTimeCurrentReport,CustDispositionCurrentReport,YearTime,AgentNameYearTime,CampaignNameYearTime,CampaignTypeYearTime,ListNameYearTime,CustPhNoYearTime,CallEndDateTimeYearTime,CustDispositionYearTime,UpdateIp,AddCustome;  // for query
	public static String  dialer_type,agent_state,campaign_id,break_type,is_paused,p_no_f_dial,p_no_f_extended,agent_state_before_login,dialer_type_before_pre;
	public static String baseUrl,AgentId,date,MachineIp,number1,Customername,address,city,state,country,pin,verifierid; //for url
	public static int  total_frame,call_count,pause_duration,break_count,autoMode,automode1,is_hold,lead_id,lead_i_f_dial,L_id_f_exte,L_id_f_D_lookup,L_id_f_state,re_d_flag,rd_flag,Agent_name_F_agent_live,agent_live_flag,leadIdCurrentReport,leadIdYearTime,PreDayMaxRetry,AgentInConf,is_free,agent_in_conf,Is_SetMeFree;
	public static  WebDriver driver;
	public static   FileInputStream f2;
	public static   HSSFWorkbook Hw;
	public static   HSSFSheet Hs; 
	public static ExtentReports report;
	public static  ExtentTest   logger; 
	public static  SoftAssert assertion= new SoftAssert();
	public static void openBrowser() throws IOException, Exception 
	{
		Logger loggerr=Logger.getLogger("OpenBrowserMethod");
		PropertyConfigurator.configure("Log4j.properties");  
		loggerr.info("Start Open Browser Method"); 
		f2=new FileInputStream("/home/himanshu/eclipse-workspace/AgentuiLatest2/TestData/agentui1.xls");
		Hw=new HSSFWorkbook(f2);
		Hs=Hw.getSheet("Sheet1");
		System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");
		driver = new FirefoxDriver();
		Hs=Hw.getSheet("Sheet1");
		baseUrl=Hs.getRow(1).getCell(0).getStringCellValue();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	//	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://"+baseUrl+"/agentui.php?");// + "agentui.php"	
		ConnectToDataBase();
		total_frame=driver.findElements(By.tagName("iframe")).size();
		System.out.println("total frame is\t"+total_frame);
		loggerr.info("Close Open Browser Method"); 
	 }
    // ScreenShot method
	public static  void screen(WebDriver driver,String Screenshotname)
	{    
		Logger log=Logger.getLogger("Screen shot method");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start screen shot method");
		System.out.println("start screen shot method start");
		try {
			TakesScreenshot ts= (TakesScreenshot)driver;
			File source= ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshot1/"+Screenshotname+".png"));
			System.out.println("taken");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Exception while taking screen shot"+e.getMessage());
		} 
		System.out.println("close screen shot method");
	}
	//database
	public static void ConnectToDataBase() throws Exception
	{
		Logger loggerr=Logger.getLogger("ConnectToDataBase");
		PropertyConfigurator.configure("Log4j.properties");  
		loggerr.info("Start ConnectToDataBase  Method"); 
		System.out.println("ConnectToDataBase method"+baseUrl);
		Connection con=null;
		try 
		{
			loggerr.info("Start Try Block In ConnectToDataBase Method"); 
			Class.forName("com.mysql.jdbc.Driver");//.newInstance();
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
			loggerr.info("There Is Exception in In ConnectToDataBase Method"); 

		}
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded"+baseUrl);
		con=DriverManager.getConnection("jdbc:mysql://"+baseUrl+"/czentrix_campaign_manager","root","sqladmin");
		if(con!=null) {
			System.out.println("Connected to the database");
			loggerr.info("Connected To The Database"); 

		}else {
			System.out.println("Failed to connect to  database");
			loggerr.info("Failed To Connect From  Database"); 

		}
		st=con.createStatement();
		//MachineIp=Hs.getRow(1).getCell(4).getStringCellValue();
		//System.out.println("IP from excel "+MachineIp);
		//UpdateIp="update agent_live set ip="+MachineIp+" where agent_id="+AgentId;
		//UpdateIp="update agent_live set ip='172.16.2.60' where agent_id="+AgentId;
		//UpdateIp="update agent_live set ip='172.16.2.60' where agent_id='AgentId'";
	//	UpdateIp="update agent_live set ip='172.16.2.60' where agent_id='2020'";
	//	st.executeUpdate(UpdateIp);
	//  loggerr.info("Updated IP"); 
		loggerr.info("Close ConnectToDataBase Method"); 
	}
	public static void Data() throws Exception
	{
		Logger loggerr=Logger.getLogger("Data");
		PropertyConfigurator.configure("Log4j.properties");  
		loggerr.info("Start DataBase  Method"); 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM");
		LocalDate localDate = LocalDate.now();
		date=dtf.format(localDate);
		System.out.println(date);
		String num;//camp_id="2042";
		Hs=Hw.getSheet("Sheet1");
		num=Hs.getRow(1).getCell(1).getStringCellValue();
		System.out.println("number from excel"+num);
		campaign_id1="select campaign_id from agent where agent_id="+AgentId;
		rs=st.executeQuery(campaign_id1);
		if(rs.next())
		{
			campaign_id1 =rs.getString(1);
			System.out.println("campaign_id from agent table  is::"+campaign_id1);
		}
		AddCustome="select * from customer_"+campaign_id1+" order by agentid desc limit 1";
		currentReport="select * from current_report order by report_id desc limit 1";
		YearTime="select * from "+date+" order by report_id desc limit 1";
		Disp="select * from cust_disp_"+campaign_id1+" where id='1'";
		sql= "select count(*) from current_report";
		agent_status="select * from agent_live where agent_id="+AgentId;
		agent_live="select * from agent_live";
		customer_table="select lead_id from customer_"+campaign_id1+" where phone1="+num;
		phone_no="select phone1 from customer_"+campaign_id1+" where phone1="+num;
		phone1="select phone1 from customer where phone1="+num;
		L_id_f_extended="select lead_id from extended_customer_"+campaign_id1+" where phone1="+num;
		p_no_f_extended="select phone1 from extended_customer_"+campaign_id1+" where phone1="+num;
		dial_lead_look="select lead_id from dial_Lead_lookup_"+campaign_id1+" where phone="+num;
		p_f_d_lookup="select phone from dial_Lead_lookup_"+campaign_id1+" where phone="+num;
		L_id_F_d_state="select lead_id from dial_state_"+campaign_id1+" where phone_no_0="+num;
		p_no_F_d_state="select phone_no_0 from dial_state_"+campaign_id1+" where phone_no_0="+num;
		//  current_report="select cust_disposition from current_report where cust_ph_no="+num;
		call_park_f_campaign=" select * from campaign where campaign_id="+campaign_id1;
		callPark="select * from call_park where campaign_id="+campaign_id1;                  //campaign_name='User1'";
		rs=st.executeQuery(AddCustome);
		if(rs.next())
		{
			Customername =rs.getString(2);
			System.out.println("name   is::"+Customername);
			address =rs.getString(3);
			System.out.println("address   is::"+address);
			city =rs.getString(4);
			System.out.println("city   is::"+city);
			state =rs.getString(5);
			System.out.println("state   is::"+state);
			country =rs.getString(6);
			System.out.println("country   is::"+country);
			pin =rs.getString(7);
			System.out.println("pin   is::"+pin);
			verifierid=rs.getString(25);
			System.out.println("verifierid   is::"+verifierid);
		}
		rs=st.executeQuery(agent_status);
		if(rs.next())
		{
			Agentid =rs.getString(1);
			System.out.println("agent_ID   is::"+Agentid);
			agent_state =rs.getString(4);
			System.out.println("agent_state   is::"+agent_state);
			dialer_type =rs.getString(9);
			System.out.println("dialer_type   is::"+dialer_type);	
			is_paused =rs.getString(12);
			System.out.println("is_paused   is::"+is_paused);
			is_free =rs.getInt(15);
			System.out.println("is_free   is::"+is_free);
			break_type=rs.getString(22);
			System.out.println("brak_type   is::"+break_type);
			pause_duration=rs.getInt(23);
			System.out.println("pause_duration   is::"+pause_duration);
			campaign_id =rs.getString(24);
			System.out.println("campaign_id   is::"+campaign_id);
			autoMode=rs.getInt(25);
			System.out.println("autoMode   is::"+autoMode);
			is_hold =rs.getInt(33);
			System.out.println("is_hold   is::"+is_hold);
			rd_flag=rs.getInt(39);
			System.out.println("rd_flag   is::"+rd_flag);
			Is_SetMeFree=rs.getInt(47);
			System.out.println("Is_SetMeFree   is::"+Is_SetMeFree);
			AgentInConf=rs.getInt(50);
			System.out.println("AgentInConf   is::"+AgentInConf);
			break_count=rs.getInt(60);
			System.out.println("break_count   is::"+break_count);
			PreDayMaxRetry=rs.getInt(61);
			System.out.println("PreDayMaxRetry   is::"+PreDayMaxRetry);
			
		}	
		rs=st.executeQuery(Disp);
		if(rs.next())
		{
			Disp =rs.getString(3);
			System.out.println(" Disposition name from cust_disp_"+campaign_id1+" is::"+Disp);
		}

		rs=st.executeQuery(sql);
		// System.out.println("database table row is\t"+rs.getRow()); 
		if(rs.next())
		{
			call_count =rs.getInt(1);
			System.out.println(" call count  is::"+call_count);
		}


		try {
			rs=st.executeQuery(customer_table);
		}
		catch(Exception e)
		{
			rs=st.executeQuery(L_id_f_extended);
		}
		if(rs.next())
		{
			lead_id =rs.getInt(1);
			System.out.println("lead_id   is::"+lead_id);
		}
		try {
			rs=st.executeQuery(phone_no);
		}
		catch(Exception e)
		{
			rs=st.executeQuery(phone1);
		}
		if(rs.next())
		{
			phone_no =rs.getString(1);
			System.out.println("phone_no   is::"+phone_no);
		}
		rs=st.executeQuery(L_id_f_extended);
		if(rs.next())
		{
			L_id_f_exte =rs.getInt(1);
			System.out.println("L_id_f_extended   is::"+L_id_f_exte);
		}
		rs=st.executeQuery(p_no_f_extended);
		if(rs.next())
		{
			p_no_f_extended =rs.getString(1);
			System.out.println("p_no_f_extended   is::"+p_no_f_extended);
		}
		rs=st.executeQuery(dial_lead_look);
		if(rs.next())
		{
			L_id_f_D_lookup =rs.getInt(1);
			System.out.println("L_id_f_D_lookup   is::"+L_id_f_D_lookup);
		}
		rs=st.executeQuery(p_f_d_lookup);
		if(rs.next())
		{
			p_f_d_lookup =rs.getString(1);
			System.out.println("p_f_d_lookup   is::"+p_f_d_lookup);
		}
		rs=st.executeQuery(currentReport);
		if(rs.next())
		{
			AgentNameCurrentReport=rs.getString(4);
			System.out.println("agent_name from current_report  is::"+AgentNameCurrentReport);
			CampaignNameCurrentReport=rs.getString(6);
			System.out.println("campaign_name  from current_report  is::"+CampaignNameCurrentReport);
			CampaignTypeCurrentReport=rs.getString(7);
			System.out.println("campaign_type  from current_report  is::"+CampaignTypeCurrentReport);
			ListNameCurrentReport=rs.getString(10);
			System.out.println(" list_name from current_report   is::"+ ListNameCurrentReport);
			CustPhNoCurrentReport=rs.getString(11);
			System.out.println(" cust_ph_no from current_report  is::"+ CustPhNoCurrentReport);
			CallEndDateTimeCurrentReport=rs.getString(14);
			System.out.println(" call_end_date_time from current_report  is::"+ CallEndDateTimeCurrentReport);
			CustDispositionCurrentReport=rs.getString(23);
			System.out.println(" cust_disposition from current_report  is::"+ CustDispositionCurrentReport);
			leadIdCurrentReport=rs.getInt(34);
			System.out.println(" lead_id from current_report  is::"+ leadIdCurrentReport);

		}
		rs=st.executeQuery(YearTime);
		if(rs.next())
		{
			AgentNameYearTime=rs.getString(4);
			System.out.println("agent_name from"+date+"is::"+AgentNameYearTime);
			CampaignNameYearTime=rs.getString(6);
			System.out.println("campaign_name  from"+date+"is::"+CampaignNameYearTime);
			CampaignTypeYearTime=rs.getString(7);
			System.out.println("campaign_type  from"+date+"is::"+CampaignTypeYearTime);
			ListNameYearTime=rs.getString(10);
			System.out.println(" list_name from"+date+"is::"+ ListNameYearTime);
			CustPhNoYearTime=rs.getString(11);
			System.out.println(" cust_ph_no from"+date+"is::"+ CustPhNoYearTime);
			CallEndDateTimeYearTime=rs.getString(14);
			System.out.println(" call_end_date_time from"+date+"is::"+ CallEndDateTimeYearTime);
			CustDispositionYearTime=rs.getString(23);
			System.out.println(" cust_disposition from"+date+"is::"+ CustDispositionYearTime);
			leadIdYearTime=rs.getInt(34);
			System.out.println(" lead_id from"+date+"is::"+ leadIdYearTime);

		}
	

		rs=st.executeQuery(agent_status);
		if(rs.next())
		{

			Agent_name_F_agent_live =rs.getInt(1);
			System.out.println("agent count from agent_live table   is::"+Agent_name_F_agent_live);
			agent_live_flag=1;
		}
		else
		{
			System.out.println("agent data not found");
			agent_live_flag=0;
		}
			loggerr.info("Close DataBase  Method"); 
	}	 
	public static   boolean isElementPresent(By by)
	{
		try {
			driver.findElement(by);
			return true;                                           
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	// Alert method
	public static boolean isAlertPresent() {
		Logger loggerr=Logger.getLogger("isAlertPresent");
		PropertyConfigurator.configure("Log4j.properties");  
		loggerr.info("Start Alert Present  Method"); 
	try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			loggerr.info("Exception In Alert Present  Method"); 
			return false;
		}
    	
	}

	public static String closeAlertAndGetItsText() {
		boolean acceptNextAlert = true;
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
	public static String getCurrentDateTime()
	{
		DateFormat customFormat =new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
	}
	public static String captureScreenshot(WebDriver driver)//,String Screenshotname
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/Agentui"+getCurrentDateTime()+".png";
		try {
			  FileHandler.copy(src, new File(screenshotPath));
			  System.out.println("Screenshot Captured");
    		}
		catch(IOException e)
		{
			System.out.println("Unable To Capture Screenshot "+e.getMessage());
		}
		return screenshotPath;
	}
	//extent report
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{     
		Logger log=Logger.getLogger("get result method");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start get result  method");
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			
			//logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(driver)).build());
		}
		report.flush();
	}

}
