package helper;

import org.testng.ITestContext;

import java.io.IOException;
import java.util.ArrayList;

public class SlackHelper {

    static ArrayList<String> failedTestList = new ArrayList<>();//Populating the list from onTestFailure TestListeners

    public static String testResultOutputAndReturnLongOP(){
        String jsonString = "";
        for (String str : failedTestList) {
            jsonString = jsonString + str + "\\n";// New line added after each test method name.
        }
        return jsonString;
    }

    public static int totalFailedCount(){
        return failedTestList.size();
    }

    public static void sendMessageToSlack(long min, long sec, long total, long fail){
        if(SlackHelper.totalFailedCount()>=1){
            HttpHandler.makePostRequestWithBody(System.getenv("SLACK_WEBHOOK_URL")
                    ,"{\"text\":\""
                            +"---------------------------------------------------------------------"
                            +"\\n"+"Total Test Run: "+total+" | Failures: " +fail
                            +" | Execution Time: "+ min+"min "+sec+"sec "
                            +"\\n"+"---------------------------------------------------------------------"
                            +"\\n"+ SlackHelper.testResultOutputAndReturnLongOP()
                            +"\\n"+"---------------------------------------------------------------------"
                            +"\"}"
            );
        }
    }

}
