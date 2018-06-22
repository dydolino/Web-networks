package Methods;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http {


    private JSONObject access;
    private HttpURLConnection connection;

    public Http() {

    }

    public JSONObject connection(String mail, String pass) throws Exception {

        URL url = new URL("http://smieszne-koty.herokuapp.com/oauth/token" +
                "?grant_type=password&email=" + mail + "&password=" + pass);
        connection = (HttpURLConnection) url.openConnection();
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

        JSONObject autoryzacja = new JSONObject(response.toString());
        this.access = autoryzacja;

        return autoryzacja;
    }

    public JSONArray getObjects() throws Exception {
        String token = access.getString("access_token");
        URL url = new URL("http://smieszne-koty.herokuapp.com/api/kittens" +
                "?access_token=" + token);

        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setReadTimeout(30000);

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = input.readLine()) != null)
            response.append(inputLine);
        input.close();
        System.out.println(response);

        JSONArray kotki = new JSONArray(response.toString());

        return kotki;

    }


}
