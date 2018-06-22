package Methods;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Http {


    public static JSONObject connection(String mail, String pass) throws Exception {

        URL url = new URL("http://smieszne-koty.herokuapp.com/oauth/token" +
                "?grant_type=password&email=" + mail + "&password=" + pass);
        HttpURLConnection connection;
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


        return autoryzacja;
    }

    public JSONArray getObjects(JSONObject jsonObject) throws Exception {
        String token = jsonObject.getString("access_token");
        URL url = new URL("http://smieszne-koty.herokuapp.com/api/kittens" +
                "?access_token=" + token);
        HttpURLConnection connection;
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

    public static List<Cat> getCats(JSONObject jsonObject) throws Exception {
        String token = jsonObject.getString("access_token");
        URL url = new URL("http://smieszne-koty.herokuapp.com/api/kittens" +
                "?access_token=" + token);
        HttpURLConnection connection;

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
        List<Cat> cats = new ArrayList<>();

        for (int i = 0; i < kotki.length(); i++) {

            JSONObject kotek = kotki.getJSONObject(i);
            Cat cat = new Cat();
            cat.setName(kotek.getString("name"));
            cat.setURL(kotek.getString("url"));
            cat.setVotes(kotek.getInt("vote_count"));
            cats.add(cat);

        }

        return cats;

    }


}
