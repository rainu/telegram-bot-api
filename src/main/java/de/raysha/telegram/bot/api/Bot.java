package de.raysha.telegram.bot.api;

import de.raysha.telegram.bot.api.exception.BotException;
import de.raysha.telegram.bot.api.model.Message;
import de.raysha.telegram.bot.api.model.Update;
import de.raysha.telegram.bot.api.model.User;
import de.raysha.telegram.bot.api.model.UserProfilePhotos;

import java.io.File;
import java.util.List;

/**
 * The Bot API is an HTTP-based interface created for developers keen on building bots for Telegram.
 */
public interface Bot {

    /**
     * A simple method for testing your bot's auth token. Requires no parameters.
     * Returns basic information about the bot in form of a {@link User} object.
     *
     * @return User
     */
    public User getMe() throws BotException;

    /**
     * Use this method to receive incoming updates using long polling. An Array of Update objects is returned.
     * <br /><br />
     * <b>Notes</b>
     * <ul>
     * <li>This method will not work if an outgoing webhook is set up.</li>
     * <li>In order to avoid getting duplicate updates, recalculate offset after each server response.</li>
     * </ul>
     *
     * @param offset Identifier of the first update to be returned.
     *               Must be greater by one than the highest among the identifiers
     *               of previously received updates. By default, updates starting
     *               with the earliest unconfirmed update are returned. An update
     *               is considered confirmed as soon as getUpdates is called
     *               with an offset higher than its update_id.
     * @param limit Limits the number of updates to be retrieved.
     *              Values between 1—100 are accepted. Defaults to 100
     * @param timeout   Timeout in seconds for long polling.
     *                  Defaults to 0, i.e. usual short polling
     */
    public List<Update> getUpdates(Integer offset, Integer limit, Integer timeout) throws BotException;

    /**
     * Use this method to send text messages. On success, the sent Message is returned.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param text Text of the message to be sent
     * @return
     * @throws BotException
     */
    public Message sendMessage(Integer chatId, String text) throws BotException;


    /**
     * Use this method to send text messages. On success, the sent Message is returned.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param text Text of the message to be sent
     * @param disableWebPagePreview <i>Optional</i> Disables link previews for links in this message
     * @param replyToMessageId <i>Optional</i> If the message is a reply, ID of the original message
     * @param replyMarkup <i>Optional</i> Can be
     *                      {@link de.raysha.telegram.bot.api.model.ReplyKeyboardMarkup} or
     *                      {@link de.raysha.telegram.bot.api.model.ReplyKeyboardHide} or
     *                      {@link de.raysha.telegram.bot.api.model.ForceReply}.
     *                      Additional interface options. A JSON-serialized object for a custom reply keyboard,
     *                     instructions to hide keyboard or to force a reply from the user.
     * @return
     * @throws BotException
     */
    public Message sendMessage(Integer chatId, String text, Boolean disableWebPagePreview, Integer replyToMessageId, Object replyMarkup) throws BotException;

    /**
     * Use this method to forward messages of any kind. On success, the sent Message is returned.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param fromChatId Unique identifier for the chat where the original message was sent — User or GroupChat id
     * @param messageId Unique message identifier
     * @return
     */
    public Message forwardMessage(Integer chatId, Integer fromChatId, Integer messageId) throws BotException;

    /**
     * Use this method to send photos. On success, the sent Message is returned.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param photo A file_id as String to resend a photo that is already on the Telegram servers
     * @return
     */
    public Message sendPhoto(Integer chatId, String photo) throws BotException;

    /**
     * Use this method to send photos. On success, the sent Message is returned.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param photo Photo to send.
     * @return
     */
    public Message sendPhoto(Integer chatId, File photo) throws BotException;

    /**
     * Use this method to send photos. On success, the sent Message is returned.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param photo Photo to send. You can either pass a file_id as String to resend a photo that is already on the
     *              Telegram servers, or upload a new photo using multipart/form-data.
     * @param caption Photo caption (may also be used when resending photos by file_id).
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for a custom reply keyboard,
     *                    instructions to hide keyboard or to force a reply from the user.
     * @return
     */
    public Message sendPhoto(Integer chatId, Object photo, String caption, Integer replyToMessageId, Object replyMarkup) throws BotException;

    /**
     * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message.
     * For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as Document).
     * On success, the sent Message is returned. Bots can currently send audio files of up to 50 MB in size,
     * this limit may be changed in the future.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param audio Audio file to send. Upload a new audio file using multipart/form-data.
     * @return
     */
    public Message sendAudio(Integer chatId, File audio) throws BotException;

    /**
     * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message.
     * For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as Document).
     * On success, the sent Message is returned. Bots can currently send audio files of up to 50 MB in size,
     * this limit may be changed in the future.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param audio A file_id as String to resend an audio that is already on the Telegram servers.
     * @return
     */
    public Message sendAudio(Integer chatId, String audio) throws BotException;

    /**
     * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message.
     * For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as Document).
     * On success, the sent Message is returned. Bots can currently send audio files of up to 50 MB in size,
     * this limit may be changed in the future.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param audio Audio file to send. You can either pass a file_id as String to resend an audio that is already
     *              on the Telegram servers, or upload a new audio file using multipart/form-data.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for a custom reply keyboard,
     *                    instructions to hide keyboard or to force a reply from the user.
     * @return
     */
    public Message sendAudio(Integer chatId, Object audio, Integer replyToMessageId, Object replyMarkup) throws BotException;

    /**
     * Use this method to send general files. On success, the sent Message is returned.
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param document File to send. Upload a new file using multipart/form-data.
     * @return
     */
    public Message sendDocument(Integer chatId, File document) throws BotException;

    /**
     * Use this method to send general files. On success, the sent Message is returned.
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param document A file_id as String to resend a file that is already on the Telegram servers.
     * @return
     */
    public Message sendDocument(Integer chatId, String document) throws BotException;

    /**
     * Use this method to send general files. On success, the sent Message is returned.
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param document File to send. You can either pass a file_id as String to resend a file that is
     *                 already on the Telegram servers, or upload a new file using multipart/form-data.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for a custom reply keyboard,
     *                    instructions to hide keyboard or to force a reply from the user.
     * @return
     */
    public Message sendDocument(Integer chatId, Object document, Integer replyToMessageId, Object replyMarkup) throws BotException;

    /**
     * Use this method to send .webp stickers. On success, the sent Message is returned.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param sticker Sticker to send. Upload a new sticker using multipart/form-data.
     * @return
     */
    public Message sendSticker(Integer chatId, File sticker) throws BotException;

    /**
     * Use this method to send .webp stickers. On success, the sent Message is returned.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param sticker A file_id as String to resend a sticker that is already on the Telegram servers.
     * @return
     */
    public Message sendSticker(Integer chatId, String sticker) throws BotException;


    /**
     * Use this method to send .webp stickers. On success, the sent Message is returned.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param sticker Sticker to send. You can either pass a file_id as String to resend a sticker that is already
     *                on the Telegram servers, or upload a new sticker using multipart/form-data.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for a custom reply keyboard,
     *                    instructions to hide keyboard or to force a reply from the user.
     * @return
     */
    public Message sendSticker(Integer chatId, Object sticker, Integer replyToMessageId, Object replyMarkup) throws BotException;

    /**
     * Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as Document).
     * On success, the sent Message is returned. Bots can currently send video files of up to 50 MB in size,
     * this limit may be changed in the future.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param video Video to send. Upload a new video file using multipart/form-data.
     * @return
     */
    public Message sendVideo(Integer chatId, File video) throws BotException;

    /**
     * Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as Document).
     * On success, the sent Message is returned. Bots can currently send video files of up to 50 MB in size,
     * this limit may be changed in the future.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param video A file_id as String to resend a video that is already on the Telegram servers.
     * @return
     */
    public Message sendVideo(Integer chatId, String video) throws BotException;

    /**
     * Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as Document).
     * On success, the sent Message is returned. Bots can currently send video files of up to 50 MB in size,
     * this limit may be changed in the future.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param video Video to send. You can either pass a file_id as String to resend a video that is already on
     *              the Telegram servers, or upload a new video file using multipart/form-data.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for a custom reply keyboard,
     *                    instructions to hide keyboard or to force a reply from the user.
     * @return
     */
    public Message sendVideo(Integer chatId, Object video, Integer replyToMessageId, Object replyMarkup) throws BotException;

    /**
     * Use this method to send point on the map. On success, the sent Message is returned.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param latitude Latitude of location
     * @param longitude Longitude of location
     * @return
     */
    public Message sendLocation(Integer chatId, Float latitude, Float longitude) throws BotException;


    /**
     * Use this method to send point on the map. On success, the sent Message is returned.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param latitude Latitude of location
     * @param longitude Longitude of location
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for a custom reply keyboard,
     *                    instructions to hide keyboard or to force a reply from the user.
     * @return
     */
    public Message sendLocation(Integer chatId, Float latitude, Float longitude, Integer replyToMessageId, Object replyMarkup) throws BotException;

    /**
     * Use this method when you need to tell the user that something is happening on the bot's side.
     * The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status).
     * <br /><br />
     * <b>Example</b>: The ImageBot needs some time to process a request and upload the image.
     * Instead of sending a text message along the lines of “Retrieving image, please wait…”,
     * the bot may use sendChatAction with action = upload_photo.
     * The user will see a “sending photo” status for the bot.
     *
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param action Type of action to broadcast. Choose one, depending on what the user is about to receive:
     *               typing for text messages, upload_photo for photos, record_video or upload_video for videos,
     *               record_audio or upload_audio for audio files, upload_document for general files,
     *               find_location for location data.
     */
    public Boolean sendChatAction(Integer chatId, String action) throws BotException;

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
     * @param chatId Unique identifier for the message recipient — User or GroupChat id
     * @param action Type of action to broadcast. Choose one, depending on what the user is about to receive:
     *               typing for text messages, upload_photo for photos, record_video or upload_video for videos,
     *               record_audio or upload_audio for audio files, upload_document for general files,
     *               find_location for location data.
     */
    public Boolean sendChatAction(Integer chatId, ChatAction action) throws BotException;

    /**
     * Use this method to get a list of profile pictures for a user. Returns a UserProfilePhotos object.
     *
     * @param userId Unique identifier of the target user
     * @return
     */
    public UserProfilePhotos getUserProfilePhotos(Integer userId) throws BotException;


    /**
     * Use this method to get a list of profile pictures for a user. Returns a UserProfilePhotos object.
     *
     * @param userId Unique identifier of the target user
     * @param offset Sequential number of the first photo to be returned. By default, all photos are returned.
     * @param limit Limits the number of photos to be retrieved. Values between 1—100 are accepted. Defaults to 100.
     * @return
     */
    public UserProfilePhotos getUserProfilePhotos(Integer userId, Integer offset, Integer limit) throws BotException;
}
