package de.raysha.lib.telegram.bot.api;

import de.raysha.lib.telegram.bot.api.exception.BotException;
import de.raysha.lib.telegram.bot.api.model.*;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelegramBot implements BotAPI {
    private final ObjectMapper mapper = new ObjectMapper();
    private final RequestExecutor requestExecutor;

    public TelegramBot(String token) {
        this(new UnirestRequestExecutor("https://api.telegram.org/bot" + token + "/"));
    }

    public TelegramBot(RequestExecutor requestExecutor) {
        this.requestExecutor = requestExecutor;
    }

    public User getMe() throws BotException {
        final String resultBody = requestExecutor.get("getMe", null);

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

        final String resultBody = requestExecutor.get("getUpdates", parameters);

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

        checkReply(replyMarkup);

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

        final String resultBody = requestExecutor.post("sendMessage", parameters);

        try {
            return mapper.readValue(resultBody, Message.class);
        } catch (IOException e) {
            throw new BotException("Could not deserialize response!", e);
        }
    }

    private void checkReply(Object replyMarkup) {
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
    }

    public Message forwardMessage(Integer chatId, Integer fromChatId, Integer messageId) throws BotException {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId);
        parameters.put("from_chat_id", fromChatId);
        parameters.put("message_id", messageId);

        final String resultBody = requestExecutor.get("forwardMessage", parameters);

        try {
            return mapper.readValue(resultBody, Message.class);
        } catch (IOException e) {
            throw new BotException("Could not deserialize response!", e);
        }
    }

    public Message sendPhoto(Integer chatId, String photo) throws BotException {
        return sendPhoto(chatId, photo, null, null, null);
    }

    public Message sendPhoto(Integer chatId, File photo) throws BotException {
        return sendPhoto(chatId, photo, null, null, null);
    }

    public Message sendPhoto(Integer chatId, Object photo, String caption, Integer replyToMessageId, Object replyMarkup) throws BotException {
        checkReply(replyMarkup);

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId);

        if(caption != null) parameters.put("caption", caption);
        if(replyToMessageId != null) parameters.put("reply_to_message_id", replyToMessageId);

        if(replyMarkup != null) {
            try {
                parameters.put("reply_markup", mapper.writeValueAsString(replyMarkup));
            } catch (IOException e) {
                throw new BotException("Could not serialize reply markup!", e);
            }
        }

        final String resultBody;

        if(photo instanceof String) {
            parameters.put("photo", photo);

            resultBody = requestExecutor.post("sendPhoto", parameters);
        }else if(photo instanceof File){
            resultBody = requestExecutor.post("sendPhoto", parameters, "photo", (File) photo);

        }else{
            throw new IllegalArgumentException("The photo must be a string or a file!");
        }

        try {
            return mapper.readValue(resultBody, Message.class);
        } catch (IOException e) {
            throw new BotException("Could not deserialize response!", e);
        }
    }

    public Message sendAudio(Integer chatId, File audio) throws BotException {
        return sendAudio(chatId, audio, null, null);
    }

    public Message sendAudio(Integer chatId, String audio) throws BotException {
        return sendAudio(chatId, audio, null, null);
    }

    public Message sendAudio(Integer chatId, Object audio, Integer replyToMessageId, Object replyMarkup) throws BotException {
        checkReply(replyMarkup);

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId);

        if(replyToMessageId != null) parameters.put("reply_to_message_id", replyToMessageId);

        if(replyMarkup != null) {
            try {
                parameters.put("reply_markup", mapper.writeValueAsString(replyMarkup));
            } catch (IOException e) {
                throw new BotException("Could not serialize reply markup!", e);
            }
        }

        final String resultBody;

        if(audio instanceof String) {
            parameters.put("audio", audio);

            resultBody = requestExecutor.post("sendAudio", parameters);
        }else if(audio instanceof File){
            resultBody = requestExecutor.post("sendAudio", parameters, "audio", (File) audio);

        }else{
            throw new IllegalArgumentException("The audio must be a string or a file!");
        }

        try {
            return mapper.readValue(resultBody, Message.class);
        } catch (IOException e) {
            throw new BotException("Could not deserialize response!", e);
        }
    }

    public Message sendDocument(Integer chatId, File document) throws BotException {
        return sendDocument(chatId, document, null, null);
    }

    public Message sendDocument(Integer chatId, String document) throws BotException {
        return sendDocument(chatId, document, null, null);
    }

    public Message sendDocument(Integer chatId, Object document, Integer replyToMessageId, Object replyMarkup) throws BotException {
        checkReply(replyMarkup);

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId);

        if(replyToMessageId != null) parameters.put("reply_to_message_id", replyToMessageId);

        if(replyMarkup != null) {
            try {
                parameters.put("reply_markup", mapper.writeValueAsString(replyMarkup));
            } catch (IOException e) {
                throw new BotException("Could not serialize reply markup!", e);
            }
        }

        final String resultBody;

        if(document instanceof String) {
            parameters.put("document", document);

            resultBody = requestExecutor.post("sendDocument", parameters);
        }else if(document instanceof File){
            resultBody = requestExecutor.post("sendDocument", parameters, "document", (File) document);

        }else{
            throw new IllegalArgumentException("The document must be a string or a file!");
        }

        try {
            return mapper.readValue(resultBody, Message.class);
        } catch (IOException e) {
            throw new BotException("Could not deserialize response!", e);
        }
    }

    public Message sendSticker(Integer chatId, File sticker) throws BotException {
        return sendSticker(chatId, sticker, null, null);
    }

    public Message sendSticker(Integer chatId, String sticker) throws BotException {
        return sendSticker(chatId, sticker, null, null);
    }

    public Message sendSticker(Integer chatId, Object sticker, Integer replyToMessageId, Object replyMarkup) throws BotException {
        checkReply(replyMarkup);

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId);

        if(replyToMessageId != null) parameters.put("reply_to_message_id", replyToMessageId);

        if(replyMarkup != null) {
            try {
                parameters.put("reply_markup", mapper.writeValueAsString(replyMarkup));
            } catch (IOException e) {
                throw new BotException("Could not serialize reply markup!", e);
            }
        }

        final String resultBody;

        if(sticker instanceof String) {
            parameters.put("sticker", sticker);

            resultBody = requestExecutor.post("sendSticker", parameters);
        }else if(sticker instanceof File){
            resultBody = requestExecutor.post("sendSticker", parameters, "sticker", (File) sticker);

        }else{
            throw new IllegalArgumentException("The sticker must be a string or a file!");
        }

        try {
            return mapper.readValue(resultBody, Message.class);
        } catch (IOException e) {
            throw new BotException("Could not deserialize response!", e);
        }
    }

    public Message sendVideo(Integer chatId, File video) throws BotException {
        return sendVideo(chatId, video, null, null);
    }

    public Message sendVideo(Integer chatId, String video) throws BotException {
        return sendVideo(chatId, video, null, null);
    }

    public Message sendVideo(Integer chatId, Object video, Integer replyToMessageId, Object replyMarkup) throws BotException {
        checkReply(replyMarkup);

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId);

        if(replyToMessageId != null) parameters.put("reply_to_message_id", replyToMessageId);

        if(replyMarkup != null) {
            try {
                parameters.put("reply_markup", mapper.writeValueAsString(replyMarkup));
            } catch (IOException e) {
                throw new BotException("Could not serialize reply markup!", e);
            }
        }

        final String resultBody;

        if(video instanceof String) {
            parameters.put("video", video);

            resultBody = requestExecutor.post("sendVideo", parameters);
        }else if(video instanceof File){
            resultBody = requestExecutor.post("sendVideo", parameters, "video", (File) video);

        }else{
            throw new IllegalArgumentException("The video must be a string or a file!");
        }

        try {
            return mapper.readValue(resultBody, Message.class);
        } catch (IOException e) {
            throw new BotException("Could not deserialize response!", e);
        }
    }

    public Message sendLocation(Integer chatId, Float latitude, Float longitude) throws BotException {
        return sendLocation(chatId, latitude, longitude, null, null);
    }

    public Message sendLocation(Integer chatId, Float latitude, Float longitude, Integer replyToMessageId, Object replyMarkup) throws BotException {
        checkReply(replyMarkup);

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId);
        parameters.put("latitude", latitude);
        parameters.put("longitude", longitude);
        if(replyToMessageId != null) parameters.put("reply_to_message_id", replyToMessageId);
        if(replyMarkup != null) {
            try {
                parameters.put("reply_markup", mapper.writeValueAsString(replyMarkup));
            } catch (IOException e) {
                throw new BotException("Could not serialize reply markup!", e);
            }
        }

        final String resultBody = requestExecutor.post("sendLocation", parameters);

        try {
            return mapper.readValue(resultBody, Message.class);
        } catch (IOException e) {
            throw new BotException("Could not deserialize response!", e);
        }
    }

    public Boolean sendChatAction(Integer chatId, ChatAction action) throws BotException {
        return sendChatAction(chatId, action.name());
    }

    public UserProfilePhotos getUserProfilePhotos(Integer userId) throws BotException {
        return getUserProfilePhotos(userId, null, null);
    }

    public UserProfilePhotos getUserProfilePhotos(Integer userId, Integer offset, Integer limit) throws BotException {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("user_id", userId);
        if(offset != null) parameters.put("offset", offset);
        if(limit != null) parameters.put("limit", limit);

        final String resultBody = requestExecutor.get("getUserProfilePhotos", parameters);

        try {
            return mapper.readValue(resultBody, UserProfilePhotos.class);
        } catch (IOException e) {
            throw new BotException("Could not deserialize response!", e);
        }
    }

    public Boolean sendChatAction(Integer chatId, String action) throws BotException {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId);
        parameters.put("action", action);

        final String resultBody = requestExecutor.get("sendChatAction", parameters);

        return "True".equalsIgnoreCase(resultBody);
    }

    public Boolean setWebhook(String url) throws BotException {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        if(url != null) parameters.put("url", url);

        final String resultBody = requestExecutor.get("setWebhook", parameters);

        System.out.println(resultBody);
        return "True".equalsIgnoreCase(resultBody);
    }

}
