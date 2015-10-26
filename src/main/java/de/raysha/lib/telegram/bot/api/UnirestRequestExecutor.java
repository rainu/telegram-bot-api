package de.raysha.lib.telegram.bot.api;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.BaseRequest;
import de.raysha.lib.telegram.bot.api.exception.BotApiException;
import de.raysha.lib.telegram.bot.api.exception.BotException;
import org.json.JSONObject;

import java.io.File;
import java.util.Map;

/**
 * Uses Unirest lib for making http requests
 */
public class UnirestRequestExecutor implements RequestExecutor {

    private final String baseUrl;

    public UnirestRequestExecutor(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String get(String action, Map<String, Object> parameters) throws BotException {
        return sendAndHandleRequest(
                Unirest.get(baseUrl + action)
                        .queryString(parameters));
    }

    @Override
    public String post(String action, Map<String, Object> parameters) throws BotException {
        return sendAndHandleRequest(
                Unirest.post(baseUrl + action)
                        .fields(parameters));
    }

    @Override
    public String post(String action, Map<String, Object> parameters, String fileName, File file) throws BotException {
        return sendAndHandleRequest(
                Unirest.post(baseUrl + action)
                        .queryString(parameters)
                        .field(fileName, file));
    }

    private String sendAndHandleRequest(BaseRequest request) throws BotException {
        JSONObject jsonResult;
        try {
            jsonResult = request
                    .asJson().getBody().getObject();
        } catch (UnirestException e) {
            throw new BotException("Could not get a response.", e);
        }

        if(jsonResult.get("ok").equals(false)){
            throw new BotApiException(
                    jsonResult.optInt("error_code", -1),
                    jsonResult.optString("error_type"),
                    jsonResult.optString("description"));
        }

        return jsonResult.get("result").toString();
    }

}
