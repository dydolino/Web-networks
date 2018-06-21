package Methods;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Http {

    public Http(){

    }
    public StringBuilder connection(String mail, String pass) throws Exception {

        URL url = new URL("http://smieszne-koty.herokuapp.com/oauth/token" +
                "?grant_type=password&email="+mail+"&password="+pass);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setReadTimeout(30000);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = input.readLine()) != null)
            response.append(inputLine);
        input.close();

        return response;
    }

}
