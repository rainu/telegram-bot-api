package de.raysha.telegram.bot.api;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.BaseRequest;
import de.raysha.telegram.bot.api.exception.BotException;
import de.raysha.telegram.bot.api.model.*;
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

        try {
            return mapper.readValue(resultBody,
                    mapper.getTypeFactory().constructCollectionType(List.class, Update.class));
        } catch (IOException e) {
            throw new BotException("Could not deserialize response!", e);
        }
    }

    public Message sendMessage(Integer chatId, String text) throws BotException {
        return sendMessage(chatId, text, null, null, null);
    }


    public Message sendMessage(Integer chatId, String text, Boolean disableWebPagePreview,
                               Integer replyToMessageId, Object replyMarkup) throws BotException {

        if(replyMarkup != null){
            if(!(   replyMarkup instanceof ReplyKeyboardHide ||
                    replyMarkup instanceof ReplyKeyboardMarkup ||
                    replyMarkup instanceof ForceReply)){

                throw new IllegalStateException("The replyMarkup must be on of the following classes: " +
                    ReplyKeyboardHide.class.getName() + ", " +
                    ReplyKeyboardMarkup.class.getName() + ", " +
                    ForceReply.class.getName());
            }
        }

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId);
        parameters.put("text", text);
        if(disableWebPagePreview != null) parameters.put("disable_web_page_preview", disableWebPagePreview);
        if(replyToMessageId != null) parameters.put("reply_to_message_id", replyToMessageId);
        if(replyMarkup != null) {
            try {
                parameters.put("reply_markup", mapper.writeValueAsString(replyMarkup));
            } catch (IOException e) {
                throw new BotException("Could not serialize reply markup!", e);
            }
        }

        final String resultBody = sendAndHandleRequest(
                Unirest.post(baseUrl + "sendMessage")
                        .fields(parameters));

        try {
            return mapper.readValue(resultBody, Message.class);
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
