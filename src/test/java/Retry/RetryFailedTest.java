package Retry;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryFailedTest implements IRetryAnalyzer {
	 
	  private int retryCount = 0;
	  private static final int maxRetryCount = 4;
	 
	  public boolean retry(ITestResult result) {
	    if (retryCount < maxRetryCount) {
	      retryCount++;
	      return true;
	    }
	    return false;
	  }
	  
	}
/*
  @Test(priority=2,retryAnalyzer=Retry.RetryFailedTest.class)
	public void m1()
	{
    	
		System.out.println("you are in m1");
	}
	@Test(priority=1,retryAnalyzer=Retry.RetryFailedTest.class)
	public void m2()
	{
		System.out.println("you are in m2");
	}
	@Test(priority=3,retryAnalyzer=Retry.RetryFailedTest.class)
	public void m3()
	{
		System.out.println("you are in m3");
		Assert.assertTrue(false);
	}
	@Test(priority=4,retryAnalyzer=Retry.RetryFailedTest.class)
	public void m4()
	{
		System.out.println("you are in m4");
	}
*/