package helper;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class HttpHandler {

    static HttpResponse<String> response;
    static Map<String, String> attributes = new HashMap<>();
    static HttpClient client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build();

    public static String makeGETRequest(String url) {
        HttpRequest request = HttpRequest.newBuilder().GET().header("accept", "application/json")
                .uri(URI.create(url)).build();
        {
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
                return response.body();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return response.body();
    }

    public static void makePostRequestWithBody(String URL ,String payload) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(URL);
        StringEntity entity = new StringEntity(payload);
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-type", "application/json");
        try {
            client.execute(httpPost);
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setTestDataFromSheet(String sheetURL) {
        String responseBody = makeGETRequest("https://docs.google.com/spreadsheets/d/"+sheetURL+"/gviz/tq?tqx=out:csv");
        String[] configLines = responseBody.split("\\r?\\n");
        for (String p : configLines) {
            String[] key = p.split(",");
            key[0] = key[0].replace("\"", "");
            key[1] = key[1].replace("\"", "");
            attributes.put(key[0], key[1]);
        }
    }

    public static String getTestDataFromSheet(String keyName){
        return attributes.get(keyName);
    }

}
