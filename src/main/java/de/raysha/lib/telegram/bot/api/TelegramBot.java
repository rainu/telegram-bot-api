package de.raysha.lib.telegram.bot.api;

import de.raysha.lib.telegram.bot.api.exception.BotException;
import de.raysha.lib.telegram.bot.api.model.ChatId;
import de.raysha.lib.telegram.bot.api.model.ForceReply;
import de.raysha.lib.telegram.bot.api.model.Message;
import de.raysha.lib.telegram.bot.api.model.ReplyKeyboardHide;
import de.raysha.lib.telegram.bot.api.model.ReplyKeyboardMarkup;
import de.raysha.lib.telegram.bot.api.model.Update;
import de.raysha.lib.telegram.bot.api.model.User;
import de.raysha.lib.telegram.bot.api.model.UserProfilePhotos;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
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

    @Override
    public User getMe() throws BotException {
        final String resultBody = requestExecutor.get("getMe", null);

        try {
            return mapper.readValue(resultBody, User.class);
        } catch (IOException e) {
            throw new BotException("Could not deserialize response! ResultBody:\n" + resultBody, e);
        }
    }

    @Override
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
            throw new BotException("Could not deserialize response! ResultBody:\n" + resultBody, e);
        }
    }

    @Override
    public Message sendMessage(ChatId chatId, String text) throws BotException {
        return sendMessage(chatId, text, null, null, null, null);
    }


    @Override
    public Message sendMessage(ChatId chatId, String text, ParseMode parseMode,
                               Boolean disableWebPagePreview, Integer replyToMessageId, Object replyMarkup) throws BotException {

        checkReply(replyMarkup);

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId.getId());
        parameters.put("text", text);
        if(parseMode != null) parameters.put("parse_mode", parseMode.name());
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
            throw new BotException("Could not deserialize response! ResultBody:\n" + resultBody, e);
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

    @Override
    public Message forwardMessage(ChatId chatId, ChatId fromChatId, Integer messageId) throws BotException {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId.getId());
        parameters.put("from_chat_id", fromChatId.getId());
        parameters.put("message_id", messageId);

        final String resultBody = requestExecutor.get("forwardMessage", parameters);

        try {
            return mapper.readValue(resultBody, Message.class);
        } catch (IOException e) {
            throw new BotException("Could not deserialize response! ResultBody:\n" + resultBody, e);
        }
    }

    @Override
    public Message sendPhoto(ChatId chatId, String photo) throws BotException {
        return sendPhoto(chatId, photo, null, null, null);
    }

    @Override
    public Message sendPhoto(ChatId chatId, File photo) throws BotException {
        return sendPhoto(chatId, photo, null, null, null);
    }

    @Override
    public Message sendPhoto(ChatId chatId, Object photo, String caption, Integer replyToMessageId, Object replyMarkup) throws BotException {
        checkReply(replyMarkup);

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId.getId());

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
            throw new BotException("Could not deserialize response! ResultBody:\n" + resultBody, e);
        }
    }

    @Override
    public Message sendAudio(ChatId chatId, File audio) throws BotException {
        return sendAudio(chatId, audio, null, null, null, null, null);
    }

    @Override
    public Message sendAudio(ChatId chatId, String audio) throws BotException {
        return sendAudio(chatId, audio, null, null, null, null, null);
    }

    public Message sendAudio(ChatId chatId, Object audio, Integer duration,
                             String performer, String title, Integer replyToMessageId,
                             Object replyMarkup) throws BotException {
        checkReply(replyMarkup);

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId.getId());

        if(duration != null) parameters.put("duration", duration);
        if(performer != null) parameters.put("performer", performer);
        if(title != null) parameters.put("title", title);
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
            throw new BotException("Could not deserialize response! ResultBody:\n" + resultBody, e);
        }
    }

    public Message sendDocument(ChatId chatId, File document) throws BotException {
        return sendDocument(chatId, document, null, null);
    }

    @Override
    public Message sendDocument(ChatId chatId, String document) throws BotException {
        return sendDocument(chatId, document, null, null);
    }

    @Override
    public Message sendDocument(ChatId chatId, Object document, Integer replyToMessageId, Object replyMarkup) throws BotException {
        checkReply(replyMarkup);

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId.getId());

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
            throw new BotException("Could not deserialize response! ResultBody:\n" + resultBody, e);
        }
    }

    @Override
    public Message sendSticker(ChatId chatId, File sticker) throws BotException {
        return sendSticker(chatId, sticker, null, null);
    }

    @Override
    public Message sendSticker(ChatId chatId, String sticker) throws BotException {
        return sendSticker(chatId, sticker, null, null);
    }

    @Override
    public Message sendSticker(ChatId chatId, Object sticker, Integer replyToMessageId, Object replyMarkup) throws BotException {
        checkReply(replyMarkup);

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId.getId());

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
            throw new BotException("Could not deserialize response! ResultBody:\n" + resultBody, e);
        }
    }

    @Override
    public Message sendVoice(ChatId chatId, File voice) throws BotException {
        return sendVoice(chatId, voice, null, null, null);
    }

    @Override
    public Message sendVoice(ChatId chatId, String voice) throws BotException {
        return sendVoice(chatId, voice, null, null, null);
    }

    @Override
    public Message sendVoice(ChatId chatId, Object voice, Integer duration, Integer replyToMessageId, Object replyMarkup) throws BotException {
        checkReply(replyMarkup);

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId.getId());

        if(duration != null) parameters.put("duration", duration);
        if(replyToMessageId != null) parameters.put("reply_to_message_id", replyToMessageId);

        if(replyMarkup != null) {
            try {
                parameters.put("reply_markup", mapper.writeValueAsString(replyMarkup));
            } catch (IOException e) {
                throw new BotException("Could not serialize reply markup!", e);
            }
        }

        final String resultBody;

        if(voice instanceof String) {
            parameters.put("voice", voice);

            resultBody = requestExecutor.post("sendVoice", parameters);
        }else if(voice instanceof File){
            resultBody = requestExecutor.post("sendVoice", parameters, "voice", (File) voice);

        }else{
            throw new IllegalArgumentException("The voice must be a string or a file!");
        }

        try {
            return mapper.readValue(resultBody, Message.class);
        } catch (IOException e) {
            throw new BotException("Could not deserialize response! ResultBody:\n" + resultBody, e);
        }
    }

    @Override
    public Message sendVideo(ChatId chatId, File video) throws BotException {
        return sendVideo(chatId, video, null, null, null, null);
    }

    @Override
    public Message sendVideo(ChatId chatId, String video) throws BotException {
        return sendVideo(chatId, video, null, null, null, null);
    }

    public Message sendVideo(ChatId chatId, Object video, Integer duration, String caption, Integer replyToMessageId, Object replyMarkup) throws BotException {
        checkReply(replyMarkup);

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId.getId());

        if(duration != null) parameters.put("duration", duration);
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
            throw new BotException("Could not deserialize response! ResultBody:\n" + resultBody, e);
        }
    }

    @Override
    public Message sendLocation(ChatId chatId, Float latitude, Float longitude) throws BotException {
        return sendLocation(chatId, latitude, longitude, null, null);
    }

    @Override
    public Message sendLocation(ChatId chatId, Float latitude, Float longitude, Integer replyToMessageId, Object replyMarkup) throws BotException {
        checkReply(replyMarkup);

        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId.getId());
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
            throw new BotException("Could not deserialize response! ResultBody:\n" + resultBody, e);
        }
    }

    @Override
    public Boolean sendChatAction(ChatId chatId, ChatAction action) throws BotException {
        return sendChatAction(chatId, action.name());
    }

    @Override
    public UserProfilePhotos getUserProfilePhotos(Integer userId) throws BotException {
        return getUserProfilePhotos(userId, null, null);
    }

    @Override
    public UserProfilePhotos getUserProfilePhotos(Integer userId, Integer offset, Integer limit) throws BotException {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("user_id", userId);
        if(offset != null) parameters.put("offset", offset);
        if(limit != null) parameters.put("limit", limit);

        final String resultBody = requestExecutor.get("getUserProfilePhotos", parameters);

        try {
            return mapper.readValue(resultBody, UserProfilePhotos.class);
        } catch (IOException e) {
            throw new BotException("Could not deserialize response! ResultBody:\n" + resultBody, e);
        }
    }

    @Override
    public Boolean sendChatAction(ChatId chatId, String action) throws BotException {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chat_id", chatId.getId());
        parameters.put("action", action);

        final String resultBody = requestExecutor.get("sendChatAction", parameters);

        return "True".equalsIgnoreCase(resultBody);
    }

    @Override
    public Boolean setWebhook(String url) throws BotException {
        return setWebhook(url, null);
    }

    @Override
    public Boolean setWebhook(String url, File certificate) throws BotException {
        final Map<String, Object> parameters = new HashMap<String, Object>();

        if(url != null) parameters.put("url", url);

        final String resultBody;

        if(certificate == null) {
            resultBody = requestExecutor.get("setWebhook", parameters);
        }else{
            resultBody = requestExecutor.post("setWebhook", parameters, "certificate", certificate);
        }

        return "True".equalsIgnoreCase(resultBody);
    }

    @Override
    public de.raysha.lib.telegram.bot.api.model.File getFile(String fileId) throws BotException {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("file_id", fileId);

        final String resultBody = requestExecutor.get("getFile", parameters);

        try {
            return mapper.readValue(resultBody, de.raysha.lib.telegram.bot.api.model.File.class);
        } catch (IOException e) {
            throw new BotException("Could not deserialize response! ResultBody:\n" + resultBody, e);
        }
    }
}
