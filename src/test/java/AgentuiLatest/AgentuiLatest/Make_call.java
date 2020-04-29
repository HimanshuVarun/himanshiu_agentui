
package AgentuiLatest.AgentuiLatest;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Make_call extends Home_page
{
	public static  String number1,add_agent,Disposition;
	public static int call_count_excel,f;
	public static void call() throws Exception
	{
		Logger log=Logger.getLogger("Make call test case");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start make call  test case");
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
	//	Disposition=Hs.getRow(1).getCell(2).getStringCellValue();
	//	System.out.println("DISPOSITION NAME IS ::\t"+Disposition);
		//Make a new call
		if(isElementPresent(By.name("makeNewCall")))
		{
			//Thread.sleep(1000);
			driver.findElement(By.name("makeNewCall")).click();
			System.out.println("click on makeNewCall button");
			//  String number=Hs.getRow(1).getCell(1).getStringCellValue();
			driver.findElement(By.name("manualPhoneNo")).clear();
			driver.findElement(By.name("manualPhoneNo")).sendKeys(number1);
			//driver.findElement(By.name("manualDial")).click();
			Thread.sleep(6000);	
			driver.findElement(By.cssSelector("input.phoneDialButtonBackground:nth-child(3)")).click();
		}
		else
		{
			screen(driver," Makecall button not found ");
		}

		//hold 
		if(isElementPresent(By.id("holdButton")))
		{
			Thread.sleep(1000); 
			driver.findElement(By.id("holdButton")).click();
			System.out.println("click on hold button");
			Thread.sleep(1000); 
		}
		else
		{
			screen(driver," Hold button not found ");
		}
		//  unhold   
		if(isElementPresent(By.id("holdButton")))
		{
			//   Thread.sleep(1000); 
			driver.findElement(By.id("holdButton")).click();
			System.out.println("click on holdButton button");
			Thread.sleep(500); 
		}
		else
		{
			screen(driver," Unhold button not found ");
		}
		//Add customer  
		if(isElementPresent(By.xpath(("//input[@value='Add Customer' and @type='submit']")))){

			driver.findElement(By.xpath("//input[@value='Add Customer' and @type='submit']")).click();
			System.out.println("click on Add customer");
			Thread.sleep(1000); 
			assertTrue(closeAlertAndGetItsText().matches( "^Are you sure you want to create a Lead[\\s\\S]$"));
			Data();
			Thread.sleep(1000);
			if(lead_id>0&&L_id_f_exte>0&&L_id_f_D_lookup>0&&leadIdCurrentReport==leadIdYearTime)//&&L_id_f_state>0
			{
				f=1;
			}
			else
			{
				f=0;
			}

		}
		else
		{
			screen(driver," add customer button not found ");
		}



		//scroll down
		if(isElementPresent(By.xpath(("/html/body/form/table[7]/tbody/tr/td/ul/li[1]"))))
		{
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element =driver.findElement(By.xpath("/html/body/form/table[7]/tbody/tr/td/ul/li[1]"));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		Thread.sleep(500);	
		//Enter comment
		if(isElementPresent(By.name("txt")))
		{
			driver.findElement(By.name("txt")).clear();
			driver.findElement(By.name("txt")).sendKeys("test_C_zentrix");
			Thread.sleep(500);
		}
		else
		{
			screen(driver," Comment box not visible not found ");
		}

		//Dispositions       
		Select sel=new Select(driver.findElement(By.name("custDisposition")));
		sel.selectByVisibleText(Disp);

		//save information
		if(isElementPresent(By.name("saveInfo")))
		{
			driver.findElement(By.name("saveInfo")).click();
			System.out.println("click on save information  button");
			Thread.sleep(1000);
		}
		else
		{
			screen(driver," Save information button not found ");
		}
		/*	   //Scroll up
		     JavascriptExecutor js = (JavascriptExecutor) driver;
			 WebElement element =driver.findElement(By.xpath("/html/body/form/table[7]/tbody/tr/td/ul/li[1]"));
			    js.executeScript("window.scrollTo(0, document.body.scrollHeight)",element);*/
		//disconnect call
		if(isElementPresent(By.name("disconnect")))
		{
			driver.findElement(By.name("disconnect")).click();
			System.out.println("click on disconnect button");
			Thread.sleep(2000);
		}
		else
		{
			screen(driver," Disconnect button not found ");
		}
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
			System.out.println("back button not found");
		}
	}

	public static void  MakeCallExtent()//&&phone_no.equals(number1)&&p_no_f_extended.equals(number1)&&p_f_d_lookup.equals(number1)&&p_no_F_d_state.equals(number1)
	{
		Logger log=Logger.getLogger("make_call test case extent report method");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start make_call  test case extent report method");
		if(is_hold==0)
		{
			
			logger=report.createTest("Make new call");
			//Assert.assertTrue(true);
			logger.pass("Make new call  test case is pass ");
			logger.pass("is_hold from agent_live table  before click on hold button ::\t"+is_hold);

			if(lead_id>0)
			{
				logger.pass("lead_id  from customer_"+campaign_id1+"\t table ::\t"+lead_id);
			}
			else
			{
				logger.fail(" lead_id  from customer_"+campaign_id1+"\t table ::\t"+lead_id);
			}
			if(L_id_f_exte>0)
			{
			
				logger.pass(" Lead id from extended_customer_"+campaign_id1+"\t table ::\t"+L_id_f_exte);
			}
			else
			{
				logger.fail(" Lead id from extended_customer_"+campaign_id1+"\t table ::\t"+L_id_f_exte);
			}
			if(L_id_f_D_lookup>0)
			{
				
				logger.pass(" Lead id from dial_lead_lookup_"+campaign_id1+"\t table ::\t"+L_id_f_D_lookup);
			}
			else
			{
				logger.fail(" Lead id from dial_lead_lookup_"+campaign_id1+"\t table ::\t"+L_id_f_D_lookup);
			}
			

			if(leadIdCurrentReport!=0&&leadIdYearTime!=0&&leadIdCurrentReport==leadIdYearTime)
			{
				logger.pass("Lead id from current_report table ::\t"+leadIdCurrentReport);
				logger.pass("Lead id from "+date+" table ::\t"+leadIdYearTime);
			
			}
			else
			{
				logger.fail("Customer not added lead id in current_report table ::\t"+leadIdCurrentReport);
				logger.fail("Customer not added lead id in "+date+" table ::\t"+leadIdYearTime);
				
			}
			if(f==1)
			{
				
				logger.pass("Customer added");
			}
			else
			{
				f=0;
				logger.fail("customer not add");
			}
			if(phone_no.equals(p_no_f_extended)&&phone_no.equals(p_f_d_lookup)&&phone_no.equals(CustPhNoCurrentReport)&&p_no_f_extended.equals(p_f_d_lookup)&&p_no_f_extended.equals(CustPhNoCurrentReport)&&p_f_d_lookup.equals(CustPhNoCurrentReport))
			{
				logger.pass(" phone_no  from customer_"+campaign_id1+"\t table ::\t"+phone_no);
				logger.pass(" Phone number from extended_customer_"+campaign_id1+"\t table ::\t"+p_no_f_extended);
				logger.pass(" Phone number  from dial_lead_lookup_"+campaign_id1+"\t table ::\t"+p_f_d_lookup);
				logger.pass(" Phone number  from current_report \t table ::\t"+CustPhNoCurrentReport);
			
			}
			else
			{
			//	logger.fail("Phone number  doesn't match with customer_"+campaign_id1+"\t, extended_customer_"+campaign_id1+"\t, dial_lead_lookup_"+campaign_id1+"\t  current_report table's");
				logger.fail("Phone no Mismatch phone no  in customer_"+campaign_id1+" table ::\t"+phone_no+"phone no in extended_customer_"+campaign_id1+" table ::\t"+p_no_f_extended+" phone no in dial_lead_lookup_"+campaign_id1+" table ::\t"+p_f_d_lookup+" phone no in current_report table"+CustPhNoCurrentReport);
			
			}
			if(agent_state.equals("FREE"))
			{
				logger.pass(" Disconnect Successful   agent status from agent_live table::\t"+agent_state);
			}
			else
			{
				logger.fail(" Disconnect  not Successful   agent status from agent_live table::\t"+agent_state);

			}


			if(CustDispositionCurrentReport.equals(Disp))
			{
				logger.pass("Disposition added, disposition name is ::\t"+CustDispositionCurrentReport);

			}
			else
			{ 
				logger.fail("Disposition not added, disposition name is ::\t"+CustDispositionCurrentReport);

			}


			if(AgentNameCurrentReport.equals(AgentNameYearTime))
			{
				logger.pass("Agent name from current_report table ::\t"+AgentNameCurrentReport);
				logger.pass("Agent name from "+date+" table ::\t"+AgentNameYearTime);
				
			}
			else
			{ 
				logger.fail("Agent name Mismatch Agent in current_report table ::\t"+AgentNameCurrentReport+"Agent in "+date+" table ::\t"+AgentNameYearTime);
			}
			if(CampaignNameCurrentReport.equals(CampaignNameYearTime))
			{
				logger.pass("Campaign name from current_report table ::\t"+CampaignNameCurrentReport);
				logger.pass("Campaign name from "+date+" table ::\t"+CampaignNameYearTime);
				
			}
			else
			{ 
				logger.fail("Campaign name Mismatch Campaign name in current_report table ::\t"+CampaignNameCurrentReport+"Campaign name in "+date+" table ::\t"+CampaignNameYearTime);
			}
			if(CampaignTypeCurrentReport.equals(CampaignTypeYearTime))
			{
				logger.pass("Campaign type from current_report table ::\t"+CampaignTypeCurrentReport);
				logger.pass("Campaign type from "+date+" table ::\t"+CampaignTypeYearTime);
			}
			else
			{ 
				logger.fail("Campaign type Mismatch Campaign type  in current_report table ::\t"+CampaignTypeCurrentReport+"Campaign type in "+date+" table ::\t"+CampaignTypeYearTime);
			}
			if(ListNameCurrentReport.equals(ListNameYearTime))
			{
				logger.pass("List name from current_report table ::\t"+ListNameCurrentReport);
				logger.pass("List name from "+date+" table ::\t"+ListNameYearTime);
				
			}
			else
			{ 
				logger.fail("List name Mismatch list name  in current_report table ::\t"+ListNameCurrentReport+"list name in "+date+" table ::\t"+ListNameYearTime);

			}

			if(CustPhNoCurrentReport.equals(CustPhNoYearTime))
			{
				logger.pass("Phone no from current_report table ::\t"+CustPhNoCurrentReport);
				logger.pass("Phone no from "+date+" table ::\t"+CustPhNoYearTime);
				
			}
			else
			   {
				logger.fail("Phone no Mismatch phone no  in current_report table ::\t"+CustPhNoCurrentReport+"phone no in "+date+" table ::\t"+CustPhNoYearTime);
				}
			if(CallEndDateTimeCurrentReport.equals(CallEndDateTimeYearTime))
			{
				logger.pass("Call date and time from current_report table ::\t"+CallEndDateTimeCurrentReport);
				logger.pass("Call date and time from "+date+" table ::\t"+CallEndDateTimeYearTime);
				
			}
			else
			 {
				logger.fail("Call date and time Mismatch call date and time  in current_report table ::\t"+CallEndDateTimeCurrentReport+"call date and time in "+date+" table ::\t"+CallEndDateTimeYearTime );

			 }
			if(CustDispositionCurrentReport.equals(CustDispositionYearTime))
			{
				logger.pass("Cust disposition from current_report table ::\t"+CustDispositionCurrentReport);
				logger.pass("Cust disposition from "+date+" table ::\t"+CustDispositionYearTime);
			}
			else
			 { 
				logger.fail("Cust disposition Mismatch call date and time  in current_report table ::\t"+CustDispositionCurrentReport+"cust disposition in "+date+" table ::\t"+CustDispositionYearTime);

			 }
			/* if(leadIdCurrentReport==leadIdYearTime&&lead_id==leadIdCurrentReport)
			   {
			   	logger.pass("Lead id from current_report table ::\t"+leadIdCurrentReport);
				logger.pass( "Lead id from "+date+" table ::\t"+leadIdYearTime);

	  		    
	           }
	  	     else
	  	      { 
	  	       	logger.fail( "Lead id Mismatch in current_report table ::\t"+leadIdCurrentReport+" lead id in "+date+" table ::\t"+leadIdYearTime+" lead id in customer_"+campaign_id1+" table :: "+lead_id);

	  	        }
			 */

		}
		else
		{
			logger=report.createTest("Make new call");
			//Assert.assertTrue(true);
			logger.fail("Make new call  test case is fail ");
			logger.fail(" is_hold from agent_live table  before click on hold button ::\t"+is_hold);
			if(lead_id>0)
			{
				logger.pass("lead_id  from customer_"+campaign_id1+"\t table ::\t"+lead_id);
			}
			else
			{
				logger.fail(" lead_id  from customer_"+campaign_id1+"\t table ::\t"+lead_id);
			}
			if(L_id_f_exte>0)
			{
			
				logger.pass(" Lead id from extended_customer_"+campaign_id1+"\t table ::\t"+L_id_f_exte);
			}
			else
			{
				logger.fail(" Lead id from extended_customer_"+campaign_id1+"\t table ::\t"+L_id_f_exte);
			}
			if(L_id_f_D_lookup>0)
			{
				
				logger.pass(" Lead id from dial_lead_lookup_"+campaign_id1+"\t table ::\t"+L_id_f_D_lookup);
			}
			else
			{
				logger.fail(" Lead id from dial_lead_lookup_"+campaign_id1+"\t table ::\t"+L_id_f_D_lookup);
			}
			

			if(leadIdCurrentReport!=0&&leadIdYearTime!=0&&leadIdCurrentReport==leadIdYearTime)
			{
				logger.pass("Lead id from current_report table ::\t"+leadIdCurrentReport);
				logger.pass("Lead id from "+date+" table ::\t"+leadIdYearTime);
			
			}
			else
			{
				logger.fail("Customer not added lead id in current_report table ::\t"+leadIdCurrentReport);
				logger.fail("Customer not added lead id in "+date+" table ::\t"+leadIdYearTime);
				
			}
			if(f==1)
			{
				
				logger.pass("Customer added");
			}
			else
			{
				f=0;
				logger.fail("customer not add");
			}
			if(phone_no.equals(p_no_f_extended)&&phone_no.equals(p_f_d_lookup)&&phone_no.equals(CustPhNoCurrentReport)&&p_no_f_extended.equals(p_f_d_lookup)&&p_no_f_extended.equals(CustPhNoCurrentReport)&&p_f_d_lookup.equals(CustPhNoCurrentReport))
			{
				logger.pass(" phone_no  from customer_"+campaign_id1+"\t table ::\t"+phone_no);
				logger.pass(" Phone number from extended_customer_"+campaign_id1+"\t table ::\t"+p_no_f_extended);
				logger.pass(" Phone number  from dial_lead_lookup_"+campaign_id1+"\t table ::\t"+p_f_d_lookup);
				logger.pass(" Phone number  from current_report \t table ::\t"+CustPhNoCurrentReport);
			
			}
			else
			{
			//	logger.fail("Phone number  doesn't match with customer_"+campaign_id1+"\t, extended_customer_"+campaign_id1+"\t, dial_lead_lookup_"+campaign_id1+"\t  current_report table's");
				logger.fail("Phone no Mismatch phone no  in customer_"+campaign_id1+" table ::\t"+phone_no+"phone no in extended_customer_"+campaign_id1+" table ::\t"+p_no_f_extended+" phone no in dial_lead_lookup_"+campaign_id1+" table ::\t"+p_f_d_lookup+" phone no in current_report table"+CustPhNoCurrentReport);
			
			}
			if(agent_state.equals("FREE"))
			{
				logger.pass(" Disconnect Successful   agent status from agent_live table::\t"+agent_state);
			}
			else
			{
				logger.fail(" Disconnect  not Successful   agent status from agent_live table::\t"+agent_state);

			}


			if(CustDispositionCurrentReport.equals(Disp))
			{
				logger.pass("Disposition added, disposition name is ::\t"+CustDispositionCurrentReport);

			}
			else
			{ 
				logger.fail("Disposition not added, disposition name is ::\t"+CustDispositionCurrentReport);

			}


			if(AgentNameCurrentReport.equals(AgentNameYearTime))
			{
				logger.pass("Agent name from current_report table ::\t"+AgentNameCurrentReport);
				logger.pass("Agent name from "+date+" table ::\t"+AgentNameYearTime);
				
			}
			else
			{ 
				logger.fail("Agent name Mismatch Agent in current_report table ::\t"+AgentNameCurrentReport+"Agent in "+date+" table ::\t"+AgentNameYearTime);
			}
			if(CampaignNameCurrentReport.equals(CampaignNameYearTime))
			{
				logger.pass("Campaign name from current_report table ::\t"+CampaignNameCurrentReport);
				logger.pass("Campaign name from "+date+" table ::\t"+CampaignNameYearTime);
				
			}
			else
			{ 
				logger.fail("Campaign name Mismatch Campaign name in current_report table ::\t"+CampaignNameCurrentReport+"Campaign name in "+date+" table ::\t"+CampaignNameYearTime);
			}
			if(CampaignTypeCurrentReport.equals(CampaignTypeYearTime))
			{
				logger.pass("Campaign type from current_report table ::\t"+CampaignTypeCurrentReport);
				logger.pass("Campaign type from "+date+" table ::\t"+CampaignTypeYearTime);
			}
			else
			{ 
				logger.fail("Campaign type Mismatch Campaign type  in current_report table ::\t"+CampaignTypeCurrentReport+"Campaign type in "+date+" table ::\t"+CampaignTypeYearTime);
			}
			if(ListNameCurrentReport.equals(ListNameYearTime))
			{
				logger.pass("List name from current_report table ::\t"+ListNameCurrentReport);
				logger.pass("List name from "+date+" table ::\t"+ListNameYearTime);
				
			}
			else
			{ 
				logger.fail("List name Mismatch list name  in current_report table ::\t"+ListNameCurrentReport+"list name in "+date+" table ::\t"+ListNameYearTime);

			}

			if(CustPhNoCurrentReport.equals(CustPhNoYearTime))
			{
				logger.pass("Phone no from current_report table ::\t"+CustPhNoCurrentReport);
				logger.pass("Phone no from "+date+" table ::\t"+CustPhNoYearTime);
				
			}
			else
			   {
				logger.fail("Phone no Mismatch phone no  in current_report table ::\t"+CustPhNoCurrentReport+"phone no in "+date+" table ::\t"+CustPhNoYearTime);
				}
			if(CallEndDateTimeCurrentReport.equals(CallEndDateTimeYearTime))
			{
				logger.pass("Call date and time from current_report table ::\t"+CallEndDateTimeCurrentReport);
				logger.pass("Call date and time from "+date+" table ::\t"+CallEndDateTimeYearTime);
				
			}
			else
			 {
				logger.fail("Call date and time Mismatch call date and time  in current_report table ::\t"+CallEndDateTimeCurrentReport+"call date and time in "+date+" table ::\t"+CallEndDateTimeYearTime );

			 }
			if(CustDispositionCurrentReport.equals(CustDispositionYearTime))
			{
				logger.pass("Cust disposition from current_report table ::\t"+CustDispositionCurrentReport);
				logger.pass("Cust disposition from "+date+" table ::\t"+CustDispositionYearTime);
			}
			else
			 { 
				logger.fail("Cust disposition Mismatch call date and time  in current_report table ::\t"+CustDispositionCurrentReport+"cust disposition in "+date+" table ::\t"+CustDispositionYearTime);

			 }
			/* if(leadIdCurrentReport==leadIdYearTime&&lead_id==leadIdCurrentReport)
			   {
			   	logger.pass("Lead id from current_report table ::\t"+leadIdCurrentReport);
				logger.pass( "Lead id from "+date+" table ::\t"+leadIdYearTime);

	  		    
	           }
	  	     else
	  	      { 
	  	       	logger.fail( "Lead id Mismatch in current_report table ::\t"+leadIdCurrentReport+" lead id in "+date+" table ::\t"+leadIdYearTime+" lead id in customer_"+campaign_id1+" table :: "+lead_id);

	  	        }
			 */


			System.out.println("Make new call test case is fail because some data not available in data base(some column missing in table campaign)");
		}
	}

}

