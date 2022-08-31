package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.io.File;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports createInstance(){
        String fileName = getReportName();
        String reportDirectory = System.getProperty("user.dir") + "/reports/";
        //new File(reportDirectory).mkdirs();
        String path = reportDirectory + fileName;
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
        htmlReporter.viewConfigurer().viewOrder().as(new ViewName[]{
        ViewName.DASHBOARD,ViewName.TEST,ViewName.EXCEPTION,ViewName.CATEGORY,ViewName.LOG,ViewName.DEVICE});
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Test Case Result");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.setSystemInfo("Test Run By:","Rajan Chaudhary");
        extent.attachReporter(htmlReporter);

        return extent;
    }

    public static String getReportName(){
        Date d = new Date();
        //String fileName = "Report_" + d.toString().replace(":","_").replace(" ","_")+".html";
        String fileName = "index.html";
        return fileName;
    }

}
