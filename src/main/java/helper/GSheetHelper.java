package helper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class GSheetHelper {

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
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return response.body();
    }

    public static String fetchTestDataFromSheet(String keyName) {
        String responseBody = makeGETRequest("https://docs.google.com/spreadsheets/d/1rGhZhL3LvvRRb4Nijyn2qtwRQvOwLVd6MnyB5Q1j6OQ/gviz/tq?tqx=out:csv");
        String configLines[] = responseBody.split("\\r?\\n");
        for (String p : configLines) {
            String[] key = p.split(",");
            key[0] = key[0].replace("\"", "");
            key[1] = key[1].replace("\"", "");
            attributes.put(key[0], key[1]);
        }
        return attributes.get(keyName);
    }

}
