package si.assignments.si_assignment1;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RestFetching {

    public static String GetGenderByNameAndCountry(String name, String country) throws IOException, ParseException {

        URL url = new URL("https://api.genderize.io/?name=" + name + "&country_id=" + country);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //Getting the response code
        int responsecode = conn.getResponseCode();

        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {
            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }

            //Close the scanner
            scanner.close();

            JSONParser jsonParse = new JSONParser();
            JSONObject data_obj = (JSONObject) jsonParse.parse(inline);

            String gender = data_obj.get("gender").toString();
            if (gender.equals("female")){
                return "Ms.";
            } else if (gender.equals("male")){
                return "Mr.";
            } else {
                return "";
            }
        }

    }
}
