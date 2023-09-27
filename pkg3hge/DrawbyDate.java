/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3hge;

import java.io.IOException;
import java.util.ArrayList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import modular.OpapJokerDraws;


 
public class DrawbyDate {
    
    LastResultPull singlepull = new LastResultPull();
    OpapJokerDraws pull;
   
    
   
    public ArrayList<OpapJokerDraws> DrawbyDate (String sd, String ed, int gameId) throws ParseException, IOException { //Όπου sd start date, ed end date.

        String gamesindate = "https://api.opap.gr/draws/v3.0/" + gameId + "/draw-date/" + sd + "/" + ed + "/draw-id";
  

            
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(gamesindate).build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseString = response.body().string();
                JSONParser jsonparser = new JSONParser();
                Object mainObj = jsonparser.parse(responseString);
                JSONArray drawsIdArray = (JSONArray) mainObj;
                ArrayList<OpapJokerDraws> alldates = new ArrayList<>();

                for (Object drawId : drawsIdArray) {
                    Long temp = (Long) drawId;
                    pull =  singlepull.DrawByID(temp.intValue(), gameId);
                   
                    alldates.add(pull);
                }

                return alldates;
                
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }

    
    
    
    
    
}
