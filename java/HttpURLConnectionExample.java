import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.JSONObject;

public class HttpURLConnectionExample {
 
    private final String USER_AGENT = "Mozilla/5.0";
 
    public static void main(String[] args) throws Exception {
 
        HttpURLConnectionExample http = new HttpURLConnectionExample();
 
        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();
        System.out.println("Testing 1 - Done !");
        
        System.out.println("\nTesting 2 - Send Http POST request");
        http.sendPost();
        System.out.println("Testing 2 - Done !");
        
    }
 
    // HTTP GET request
    private void sendGet() throws Exception {
 
        String url = "http://10.1.1.89:8000/tv/api/client/v1/settopboxprogramschedule/?format=json";
 
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
        con.setRequestMethod("GET");
        con.setRequestProperty("api_key", "e63ddefd649814b0d9af360e7bf4e1166fd2f231");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
 
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
 
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
 
        System.out.println(response.toString());
 
    }
 
    // HTTP POST request
    private void sendPost() throws Exception {
 
        String url = "http://10.1.1.89:8000/tv/api/client/v1/settopboxprogramschedule/";
         
        URL obj = new URL(url);
        URLConnection conn = obj.openConnection();
        HttpURLConnection con = (HttpURLConnection) conn;

        //add request header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("api_key", "e63ddefd649814b0d9af360e7bf4e1166fd2f231");
 
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        
        JSONObject data = new JSONObject();
        data.put("schedule_date","1388657410");
        data.put("url", "/tv/api/tv/v1/channel/42/");
        data.put("message", "Agendamento realizado com sucesso!");
        data.put("channel", "51");

        con.setDoOutput(true);
        OutputStreamWriter wr2= new OutputStreamWriter(con.getOutputStream());
        wr2.write(data.toString());
        wr2.flush();
        wr2.close();
 
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
 
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
 
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        
        System.out.println(response.toString());
 
    }
 
}

