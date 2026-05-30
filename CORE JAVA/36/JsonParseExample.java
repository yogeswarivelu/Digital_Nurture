import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class JsonParseExample {

    public static void main(String[] args) {

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/users/octocat"))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            // Convert JSON to Java Object
            Gson gson = new Gson();

            GitHubUser user =
                    gson.fromJson(response.body(), GitHubUser.class);

            // Print Data
            System.out.println("Login: " + user.login);
            System.out.println("ID: " + user.id);
            System.out.println("Bio: " + user.bio);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}