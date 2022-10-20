package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import page.BasePage;
import utils.BaseTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestListeners implements ITestListener {

    private static ExtentReports extent = ExtentReportManager.createInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result){
        ExtentTest test = extent.createTest(result.getMethod().getMethodName()+" | " + result.getTestClass().getName()+" | " + result.getMethod().getDescription());
        extentTest.set(test);
        extentTest.get().assignCategory(result.getMethod().getGroups());
        BasePage.setLogger(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result){
        String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Successful</b>";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        extentTest.get().log(Status.PASS,markup);
    }

    @Override
    public void onTestSkipped(ITestResult result){
        String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Skipped</b>";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.AMBER);
        extentTest.get().log(Status.SKIP,markup);
    }

    @Override
    public void onTestFailure(ITestResult result){
        String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Failed</b>";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
        extentTest.get().log(Status.FAIL, markup);
        ScreenshotHelper.captureScreenshot(((BaseTest)result.getInstance()).getDriver(),result.getMethod().getMethodName());
        extentTest.get().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath("screenshots/"+result.getMethod().getMethodName()+".png").build());
        extentTest.get().log(Status.INFO, result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        if(extent!=null){
            extent.flush();
        }
    }

}