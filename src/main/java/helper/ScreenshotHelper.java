package helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {

    static String filePath;

    public static String captureScreenshot(WebDriver driver, String fileName){

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            filePath = System.getProperty("user.dir") + "/reports/screenshots/"+fileName+".png";
            FileUtils.copyFile(file,new File(filePath));
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
