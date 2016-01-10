package de.raysha.lib.telegram.bot.api;

import de.raysha.lib.telegram.bot.api.exception.BotException;
import de.raysha.lib.telegram.bot.api.model.Audio;
import de.raysha.lib.telegram.bot.api.model.ChatId;
import de.raysha.lib.telegram.bot.api.model.Document;
import de.raysha.lib.telegram.bot.api.model.ForceReply;
import de.raysha.lib.telegram.bot.api.model.InlineQueryResult;
import de.raysha.lib.telegram.bot.api.model.Message;
import de.raysha.lib.telegram.bot.api.model.ReplyKeyboardHide;
import de.raysha.lib.telegram.bot.api.model.ReplyKeyboardMarkup;
import de.raysha.lib.telegram.bot.api.model.Update;
import de.raysha.lib.telegram.bot.api.model.User;
import de.raysha.lib.telegram.bot.api.model.UserProfilePhotos;

import java.io.File;
import java.util.List;

/**
 * The BotAPI is an HTTP-based interface created for developers keen on building bots for Telegram.
 */
public interface BotAPI {

    /**
     * A simple method for testing your bot's auth token. Requires no parameters.
     * Returns basic information about the bot in form of a {@link User} object.
     *
     * @return User
     */
    public User getMe() throws BotException;

    /**
     * Use this method to receive incoming updates using long polling (<a href="http://en.wikipedia.org/wiki/Push_technology#Long_polling">wiki</a>).
     * An Array of {@link Update} objects is returned.
     * <br /><br />
     * <b>Notes</b>
     * <ul>
     * <li>This method will not work if an outgoing webhook is set up.</li>
     * <li>In order to avoid getting duplicate updates, recalculate offset after each server response.</li>
     * </ul>
     *
     * @param offset  Identifier of the first update to be returned.
     *                Must be greater by one than the highest among the identifiers
     *                of previously received updates. By default, updates starting
     *                with the earliest unconfirmed update are returned. An update
     *                is considered confirmed as soon as getUpdates is called
     *                with an offset higher than its update_id.
     * @param limit   Limits the number of updates to be retrieved.
     *                Values between 1—100 are accepted. Defaults to 100
     * @param timeout Timeout in seconds for long polling.
     *                Defaults to 0, i.e. usual short polling
     */
    public List<Update> getUpdates(Integer offset, Integer limit, Integer timeout) throws BotException;

    /**
     * Use this method to send text messages. On success, the sent {@link Message} is returned.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param text   Text of the message to be sent
     * @return
     * @throws BotException
     */
    public Message sendMessage(ChatId chatId, String text) throws BotException;

    public static enum ParseMode {
        Markdown
    }

    /**
     * Use this method to send text messages. On success, the sent {@link Message} is returned.
     *
     * @param chatId                Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param text                  Text of the message to be sent
     * @param parseMode             Send <i>Markdown</i>, if you want Telegram apps to show
     *                              <a href="https://core.telegram.org/bots/api#using-markdown">bold, italic and inline URLs</a>
     *                              in your bot's message.
     *                              For the moment, only Telegram for Android supports this.
     * @param disableWebPagePreview Disables link previews for links in this message
     * @param replyToMessageId      If the message is a reply, ID of the original message
     * @param replyMarkup           Can be
     *                              {@link ReplyKeyboardMarkup} or
     *                              {@link ReplyKeyboardHide} or
     *                              {@link ForceReply}.
     *                              Additional interface options. A JSON-serialized object for a
     *                              <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>,
     *                              instructions to hide keyboard or to force a reply from the user.
     * @return
     * @throws BotException
     */
    public Message sendMessage(ChatId chatId, String text, ParseMode parseMode, Boolean disableWebPagePreview, Integer replyToMessageId, Object replyMarkup) throws BotException;

    /**
     * Use this method to forward messages of any kind. On success, the sent {@link Message} is returned.
     *
     * @param chatId     Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param fromChatId Unique identifier for the chat where the original message was sent (or channel username in the format @channelusername)
     * @param messageId  Unique message identifier
     * @return
     */
    public Message forwardMessage(ChatId chatId, ChatId fromChatId, Integer messageId) throws BotException;

    /**
     * Use this method to send photos. On success, the sent {@link Message} is returned.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param photo  A file_id as String to resend a photo that is already on the Telegram servers
     * @return
     */
    public Message sendPhoto(ChatId chatId, String photo) throws BotException;

    /**
     * Use this method to send photos. On success, the sent {@link Message} is returned.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param photo  Photo to send.
     * @return
     */
    public Message sendPhoto(ChatId chatId, File photo) throws BotException;

    /**
     * Use this method to send photos. On success, the sent {@link Message} is returned.
     *
     * @param chatId           Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param photo            Photo to send. You can either pass a file_id as String to resend a photo that is already on the
     *                         Telegram servers, or upload a new photo using multipart/form-data.
     * @param caption          Photo caption (may also be used when resending photos by file_id).
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup      Additional interface options. A JSON-serialized object for a <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>,
     *                         instructions to hide keyboard or to force a reply from the user.
     * @return
     */
    public Message sendPhoto(ChatId chatId, Object photo, String caption, Integer replyToMessageId, Object replyMarkup) throws BotException;

    /**
     * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message.
     * For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as Document).
     * On success, the sent {@link Message} is returned. Bots can currently send audio files of up to 50 MB in size,
     * this limit may be changed in the future.
     * <br />
     * For backward compatibility, when the fields title and performer are both empty and the mime-type of the
     * file to be sent is not audio/mpeg, the file will be sent as a playable voice message. For this to work,
     * the audio must be in an .ogg file encoded with OPUS. This behavior will be phased out in the future.
     * For sending voice messages, use the sendVoice method instead.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param audio  Audio file to send. Upload a new audio file using multipart/form-data.
     * @return
     */
    public Message sendAudio(ChatId chatId, File audio) throws BotException;

    /**
     * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message.
     * For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as Document).
     * On success, the sent {@link Message} is returned. Bots can currently send audio files of up to 50 MB in size,
     * this limit may be changed in the future.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param audio  A file_id as String to resend an audio that is already on the Telegram servers.
     * @return
     */
    public Message sendAudio(ChatId chatId, String audio) throws BotException;

    /**
     * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message.
     * For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as Document).
     * On success, the sent {@link Message} is returned. Bots can currently send audio files of up to 50 MB in size,
     * this limit may be changed in the future.
     *
     * @param chatId           Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param audio            Audio file to send. You can either pass a file_id as String to resend an audio that is already
     *                         on the Telegram servers, or upload a new audio file using multipart/form-data.
     * @param duration         Duration of the audio in seconds
     * @param performer        Performer
     * @param title            Track name
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup      Additional interface options. A JSON-serialized object for a <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>,
     *                         instructions to hide keyboard or to force a reply from the user.
     * @return
     */
    public Message sendAudio(ChatId chatId, Object audio, Integer duration, String performer, String title, Integer replyToMessageId, Object replyMarkup) throws BotException;

    /**
     * Use this method to send general files. On success, the sent {@link Message} is returned.
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
     *
     * @param chatId   Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param document File to send. Upload a new file using multipart/form-data.
     * @return
     */
    public Message sendDocument(ChatId chatId, File document) throws BotException;

    /**
     * Use this method to send general files. On success, the sent {@link Message} is returned.
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
     *
     * @param chatId   Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param document A file_id as String to resend a file that is already on the Telegram servers.
     * @return
     */
    public Message sendDocument(ChatId chatId, String document) throws BotException;

    /**
     * Use this method to send general files. On success, the sent {@link Message} is returned.
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
     *
     * @param chatId           Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param document         File to send. You can either pass a file_id as String to resend a file that is
     *                         already on the Telegram servers, or upload a new file using multipart/form-data.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup      Additional interface options. A JSON-serialized object for a <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>,
     *                         instructions to hide keyboard or to force a reply from the user.
     * @return
     */
    public Message sendDocument(ChatId chatId, Object document, Integer replyToMessageId, Object replyMarkup) throws BotException;

    /**
     * Use this method to send .webp stickers. On success, the sent {@link Message} is returned.
     *
     * @param chatId  Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param sticker Sticker to send. Upload a new sticker using multipart/form-data.
     * @return
     */
    public Message sendSticker(ChatId chatId, File sticker) throws BotException;

    /**
     * Use this method to send .webp stickers. On success, the sent {@link Message} is returned.
     *
     * @param chatId  Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param sticker A file_id as String to resend a sticker that is already on the Telegram servers.
     * @return
     */
    public Message sendSticker(ChatId chatId, String sticker) throws BotException;


    /**
     * Use this method to send .webp stickers. On success, the sent {@link Message} is returned.
     *
     * @param chatId           Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param sticker          Sticker to send. You can either pass a file_id as String to resend a sticker that is already
     *                         on the Telegram servers, or upload a new sticker using multipart/form-data.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup      Additional interface options. A JSON-serialized object for a <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>,
     *                         instructions to hide keyboard or to force a reply from the user.
     * @return
     */
    public Message sendSticker(ChatId chatId, Object sticker, Integer replyToMessageId, Object replyMarkup) throws BotException;

    /**
     * Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as Document).
     * On success, the sent {@link Message} is returned. Bots can currently send video files of up to 50 MB in size,
     * this limit may be changed in the future.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param video  Video to send. Upload a new video file using multipart/form-data.
     * @return
     */
    public Message sendVideo(ChatId chatId, File video) throws BotException;

    /**
     * Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as Document).
     * On success, the sent {@link Message} is returned. Bots can currently send video files of up to 50 MB in size,
     * this limit may be changed in the future.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param video  A file_id as String to resend a video that is already on the Telegram servers.
     * @return
     */
    public Message sendVideo(ChatId chatId, String video) throws BotException;

    /**
     * Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as Document).
     * On success, the sent {@link Message} is returned. Bots can currently send video files of up to 50 MB in size,
     * this limit may be changed in the future.
     *
     * @param chatId           Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param video            Video to send. You can either pass a file_id as String to resend a video that is already on
     *                         the Telegram servers, or upload a new video file using multipart/form-data.
     * @param duration         Duration of sent video in seconds
     * @param caption          Video caption (may also be used when resending videos by file_id).
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup      Additional interface options. A JSON-serialized object for a <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>,
     *                         instructions to hide keyboard or to force a reply from the user.
     * @return
     */
    public Message sendVideo(ChatId chatId, Object video, Integer duration, String caption, Integer replyToMessageId, Object replyMarkup) throws BotException;

    /**
     * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message.
     * For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as {@link Audio} or {@link Document}).
     * On success, the sent {@link Message} is returned. Bots can currently send voice messages of up to 50 MB in size,
     * this limit may be changed in the future.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param video  Audio file to send. You can either pass a file_id as String to resend an audio that is already on the
     *               Telegram servers, or upload a new audio file using multipart/form-data.
     * @return
     * @throws BotException
     */
    public Message sendVoice(ChatId chatId, File video) throws BotException;

    /**
     * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message.
     * For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as {@link Audio} or {@link Document}).
     * On success, the sent {@link Message} is returned. Bots can currently send voice messages of up to 50 MB in size,
     * this limit may be changed in the future.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param video  Audio file to send. You can either pass a file_id as String to resend an audio that is already on the
     *               Telegram servers, or upload a new audio file using multipart/form-data.
     * @return
     * @throws BotException
     */
    public Message sendVoice(ChatId chatId, String video) throws BotException;

    /**
     * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message.
     * For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as {@link Audio} or {@link Document}).
     * On success, the sent {@link Message} is returned. Bots can currently send voice messages of up to 50 MB in size,
     * this limit may be changed in the future.
     *
     * @param chatId           Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param video            Audio file to send. You can either pass a file_id as String to resend an audio that is already on the
     *                         Telegram servers, or upload a new audio file using multipart/form-data.
     * @param duration         Duration of sent audio in seconds
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup      Additional interface options. A JSON-serialized object for a <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>,
     *                         instructions to hide keyboard or to force a reply from the user.
     * @return
     * @throws BotException
     */
    public Message sendVoice(ChatId chatId, Object video, Integer duration, Integer replyToMessageId, Object replyMarkup) throws BotException;

    /**
     * Use this method to send point on the map. On success, the sent {@link Message} is returned.
     *
     * @param chatId    Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param latitude  Latitude of location
     * @param longitude Longitude of location
     * @return
     */
    public Message sendLocation(ChatId chatId, Float latitude, Float longitude) throws BotException;


    /**
     * Use this method to send point on the map. On success, the sent {@link Message} is returned.
     *
     * @param chatId           Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param latitude         Latitude of location
     * @param longitude        Longitude of location
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup      Additional interface options. A JSON-serialized object for a <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>,
     *                         instructions to hide keyboard or to force a reply from the user.
     * @return
     */
    public Message sendLocation(ChatId chatId, Float latitude, Float longitude, Integer replyToMessageId, Object replyMarkup) throws BotException;

    /**
     * Use this method when you need to tell the user that something is happening on the bot's side.
     * The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status).
     * <br /><br />
     * <b>Example</b>: The <a href="https://telegram.me/imagebot">ImageBot</a> needs some time to process a request and upload the image.
     * Instead of sending a text message along the lines of “Retrieving image, please wait…”,
     * the bot may use sendChatAction with action = upload_photo.
     * The user will see a “sending photo” status for the bot.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param action Type of action to broadcast. Choose one, depending on what the user is about to receive:
     *               typing for text messages, upload_photo for photos, record_video or upload_video for videos,
     *               record_audio or upload_audio for audio files, upload_document for general files,
     *               find_location for location data.
     */
    public Boolean sendChatAction(ChatId chatId, String action) throws BotException;

    /**
     * This enum contains all possible chat actions.
     */
    public static enum ChatAction {
        typing, upload_photo, record_video, upload_video, record_audio,
        upload_audio, upload_document, find_location;
    }

    /**
     * Use this method when you need to tell the user that something is happening on the bot's side.
     * The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status).
     * <br /><br />
     * <b>Example</b>: The ImageBot needs some time to process a request and upload the image.
     * Instead of sending a text message along the lines of “Retrieving image, please wait…”,
     * the bot may use sendChatAction with action = upload_photo.
     * The user will see a “sending photo” status for the bot.
     *
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param action Type of action to broadcast. Choose one, depending on what the user is about to receive:
     *               typing for text messages, upload_photo for photos, record_video or upload_video for videos,
     *               record_audio or upload_audio for audio files, upload_document for general files,
     *               find_location for location data.
     */
    public Boolean sendChatAction(ChatId chatId, ChatAction action) throws BotException;

    /**
     * Use this method to get a list of profile pictures for a user. Returns a {@link UserProfilePhotos} object.
     *
     * @param userId Unique identifier of the target user
     * @return
     */
    public UserProfilePhotos getUserProfilePhotos(Integer userId) throws BotException;


    /**
     * Use this method to get a list of profile pictures for a user. Returns a {@link UserProfilePhotos} object.
     *
     * @param userId Unique identifier of the target user
     * @param offset Sequential number of the first photo to be returned. By default, all photos are returned.
     * @param limit  Limits the number of photos to be retrieved. Values between 1—100 are accepted. Defaults to 100.
     * @return
     */
    public UserProfilePhotos getUserProfilePhotos(Integer userId, Integer offset, Integer limit) throws BotException;

    /**
     * Use this method to specify a url and receive incoming updates via an outgoing webhook. Whenever there is an
     * update for the bot, we will send an HTTPS POST request to the specified url, containing a JSON-serialized Update.
     * In case of an unsuccessful request, we will give up after a reasonable amount of attempts.
     * <br />
     * If you'd like to make sure that the Webhook request comes from Telegram, we recommend using a secret path in the URL,
     * e.g. https://www.example.com/&lt;token&gt;. Since nobody else knows your bot‘s token, you can be pretty sure it’s us.
     * <br/><br/>
     * <b>Notes</b>
     * <ul>
     * <li>You will not be able to receive updates using getUpdates for as long as an outgoing webhook is set up.ǘ
     * <li>We currently do not support self-signed certificates.</li>
     * <li>Ports currently supported for Webhooks: 443, 80, 88, 8443.</li>
     * </ul>
     *
     * @param url HTTPS url to send updates to. Use an empty string to remove webhook integration
     * @return
     */
    public Boolean setWebhook(String url) throws BotException;

    /**
     * Use this method to specify a url and receive incoming updates via an outgoing webhook. Whenever there is an
     * update for the bot, we will send an HTTPS POST request to the specified url, containing a JSON-serialized Update.
     * In case of an unsuccessful request, we will give up after a reasonable amount of attempts.
     * <br />
     * If you'd like to make sure that the Webhook request comes from Telegram, we recommend using a secret path in the URL,
     * e.g. https://www.example.com/&lt;token&gt;. Since nobody else knows your bot‘s token, you can be pretty sure it’s us.
     * <br/><br/>
     * <b>Notes</b>
     * <ul>
     * <li>You will not be able to receive updates using getUpdates for as long as an outgoing webhook is set up.ǘ
     * <li>We currently do not support self-signed certificates.</li>
     * <li>Ports currently supported for Webhooks: 443, 80, 88, 8443.</li>
     * </ul>
     *
     * @param url         HTTPS url to send updates to. Use an empty string to remove webhook integration
     * @param certificate Upload your public key certificate so that the root certificate in use can be checked.
     *                    See our <a href="https://core.telegram.org/bots/self-signed">self-signed guide</a> for details.
     * @return
     */
    public Boolean setWebhook(String url, File certificate) throws BotException;

    /**
     * Use this method to get basic info about a file and prepare it for downloading.
     * For the moment, bots can download files of up to 20MB in size. On success, a {@link de.raysha.lib.telegram.bot.api.model.File} object is returned.
     * The file can then be downloaded via the link https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;,
     * where &lt;file_path&gt; is taken from the response. It is guaranteed that the link will be valid for at least 1 hour.
     * When the link expires, a new one can be requested by calling getFile again.
     *
     * @param fileId File identifier to get info about
     * @return
     */
    public de.raysha.lib.telegram.bot.api.model.File getFile(String fileId) throws BotException;

    /**
     * Use this method to send answers to an inline query. On success, True is returned.
     * No more than <b>50</b> results per query are allowed.
     *
     * @param inlineQueryId Unique identifier for the answered query
     * @param results       A JSON-serialized array of results for the inline query
     * @return
     */
    public Boolean answerInlineQuery(String inlineQueryId, List<InlineQueryResult> results) throws BotException;

    /**
     * Use this method to send answers to an inline query. On success, True is returned.
     * No more than <b>50</b> results per query are allowed.
     *
     * @param inlineQueryId Unique identifier for the answered query
     * @param results       A JSON-serialized array of results for the inline query
     * @param cacheTime     The maximum amount of time in seconds that the result of the inline query may be cached on
     *                      the server. Defaults to 300.
     * @param isPersonal    Pass <i>True</i>, if results may be cached on the server side only for the user that sent
     *                      the query. By default, results may be returned to any user who sends the same query
     * @param nextOffset    Pass the offset that a client should send in the next query with the same text to receive
     *                      more results. Pass an empty string if there are no more results or if you don‘t support
     *                      pagination. Offset length can’t exceed 64 bytes.
     * @return
     */
    public Boolean answerInlineQuery(String inlineQueryId, List<InlineQueryResult> results, Integer cacheTime,
                                     Boolean isPersonal, String nextOffset) throws BotException;
}
