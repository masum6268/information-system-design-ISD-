package get;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class get {
    public static void main(String[] args) throws MalformedURLException, IOException {

        // Opening the connection to a URL webpage for GET request
        URL myUrl = new URL("https://webcode.me/");
        HttpURLConnection conn = (HttpURLConnection) myUrl.openConnection();

        // Setting the method to GET
        conn.setRequestMethod("GET");

        // Getting the response code from the connection
        int responseCode = conn.getResponseCode();
        System.out.print("Response Code: " + responseCode + "\n");

        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.print("This is the response Message from server: " + conn.getResponseMessage() + "\n");

            // Reading the content from the server response using input stream
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader buffer = new BufferedReader(in);
            StringBuffer fromServer = new StringBuffer();
            String eachLine = null;

            while ((eachLine = buffer.readLine()) != null) {
                fromServer.append(eachLine);
                fromServer.append(System.lineSeparator());
            }

            buffer.close();

            // Printing the content fetched from the URL
            System.out.print("Here is the fetched content :\n" + fromServer);
        } else {
            System.out.print("Failed to fetch the content :( ");
        }
    }
}
