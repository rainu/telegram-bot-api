package de.raysha.telegram.bot.api;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.BaseRequest;
import de.raysha.telegram.bot.api.exception.BotException;
import de.raysha.telegram.bot.api.model.Update;
import de.raysha.telegram.bot.api.model.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelegramBot implements Bot {
    private final ObjectMapper mapper = new ObjectMapper();
    private final String baseUrl;

    public TelegramBot(String token){
        this.baseUrl = "https://api.telegram.org/bot" + token + "/";
    }

    public User getMe() throws BotException {
        final String resultBody = sendAndHandleRequest(Unirest.get(baseUrl + "getMe"));

        try {
            return mapper.readValue(resultBody, User.class);
        } catch (IOException e) {
            throw new BotException("Could not deserialize response!", e);
        }
    }

    public List<Update> getUpdates(Integer offset, Integer limit, Integer timeout) throws BotException {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        if(offset != null) parameters.put("offset", offset);
        if(limit != null) parameters.put("limit", limit);
        if(timeout != null) parameters.put("timeout", timeout);

        final String resultBody = sendAndHandleRequest(
                Unirest.get(baseUrl + "getUpdates")
                    .queryString(parameters));

        System.out.println(resultBody);
        try {
            return mapper.readValue(resultBody,
                    mapper.getTypeFactory().constructCollectionType(List.class, Update.class));
        } catch (IOException e) {
            throw new BotException("Could not deserialize response!", e);
        }
    }

    private String sendAndHandleRequest(BaseRequest request) throws BotException {
        JSONObject jsonResult = null;
        try {
            jsonResult = request
                    .asJson().getBody().getObject();
        } catch (UnirestException e) {
            throw new BotException("Could not get a response.", e);
        }

        if(jsonResult.get("ok").equals(false)){
            throw new BotException(jsonResult.getString("description"));
        }

        return jsonResult.get("result").toString();
    }
}
