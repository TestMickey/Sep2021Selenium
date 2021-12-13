package com.qa.opencart.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	
	private int count = 0;
	private static int maxTry =3;
	
	@Override
	public boolean retry(ITestResult iTestResult) {
		if(!iTestResult.isSuccess()) {// check if test not successed
			if(count < maxTry ) {// check if maxtry count is reached
				count ++;//Increase the max try count by 1
				iTestResult.setStatus(ITestResult.FAILURE);// mark test as failed
				return true;//tells testng to re run
			}else {
				iTestResult.setStatus(ITestResult.FAILURE);//if max count reached , test marked as fail
			}
		}else {
			iTestResult.setStatus(ITestResult.SUCCESS);// if test passes testng marks it as pass
		}
		return false;
	}

}
