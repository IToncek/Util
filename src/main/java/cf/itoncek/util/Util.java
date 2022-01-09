package cf.itoncek.util;

import com.sun.istack.Nullable;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Util {
    public static String request(String url, @Nullable String content) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response;
        try {
            HttpPost request = new HttpPost(url);
            StringEntity params = new StringEntity(content);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            response = httpClient.execute(request);
            return response.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
    }

    public static String erqst(String url) {
        try {
            URL conn = new URL(url);
            URLConnection urlcon = conn.openConnection();
            BufferedReader out = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
            return out.readLine();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
