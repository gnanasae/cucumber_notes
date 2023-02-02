package com.amazon.test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners extends BaseTest implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		captureScreenshot(result.getMethod().getMethodName() + ".jpg");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		captureScreenshot(result.getMethod().getMethodName() + ".jpg");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
