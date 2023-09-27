/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3hge;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.util.Date;
import modular.OpapJokerDraws;



public class LastResultPull {
    


     public OpapJokerDraws DrawByID(int drawId, int gameId) throws ParseException, IOException {

        String urlWithGameId = "https://api.opap.gr/draws/v3.0/" + gameId + "/" + String.valueOf(drawId);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(urlWithGameId).build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseString = response.body().string();
                JSONParser jsonparser = new JSONParser();
                Object mainObj = jsonparser.parse(responseString);
                JSONObject mainJSONObj = (JSONObject) mainObj;
                JSONObject winningNumbersObj = (JSONObject) mainJSONObj.get("winningNumbers");
                Long drawTime = (Long) mainJSONObj.get("drawTime");
                JSONArray winningNumbersArray = (JSONArray) winningNumbersObj.get("list");
                JSONArray bonusArray = (JSONArray) winningNumbersObj.get("bonus");
                Long bonusNumberLong = (Long) bonusArray.get(0);
                JSONObject wagerstats = (JSONObject) mainJSONObj.get("wagerStatistics");
                

                int bonusNumber = bonusNumberLong.intValue();

                String winningNumbersString = "";
                for (Object winningNumber : winningNumbersArray) {
                    winningNumbersString += winningNumber + ",";
                }

                winningNumbersString = winningNumbersString.substring(0, winningNumbersString.length() - 1);


                JSONArray prizeCategories = (JSONArray) mainJSONObj.get("prizeCategories");

                

                String winnerString = "";
                String distributedString = "";
                String dividentString = "";
                String jackpotString = "";
                
                for (Object object : prizeCategories) {
                    JSONObject jsonObject = (JSONObject) object;
        
                    Long winners = (Long) jsonObject.get("winners");
                    Double distributed = (Double) jsonObject.get("distributed");
                    Double divident = (Double) jsonObject.get("divident");
                    Double jackpot = (Double) jsonObject.get("jackpot");

                    winnerString += winners.toString() + ",";
                    distributedString += distributed.toString() + ",";
                    dividentString += divident.toString() + ",";
                    jackpotString += jackpot.toString() + ",";
                    
                    
                }
                
                
                winnerString = winnerString.substring(0, winnerString.length() - 1);
                distributedString = distributedString.substring(0, distributedString.length() - 1);
                dividentString = dividentString.substring(0, dividentString.length() - 1);
                jackpotString = jackpotString.substring(0, jackpotString.length() - 1);

                Date startDate = new Date(drawTime);

                OpapJokerDraws singleres = new OpapJokerDraws(null, gameId, drawId, startDate,
                        winningNumbersString, bonusNumber, winnerString,
                        dividentString, distributedString, jackpotString       
                );

                return singleres;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    
}
