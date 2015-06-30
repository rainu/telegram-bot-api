package de.raysha.telegram.bot.api;

import de.raysha.telegram.bot.api.exception.BotException;
import de.raysha.telegram.bot.api.model.Message;
import de.raysha.telegram.bot.api.model.Update;
import de.raysha.telegram.bot.api.model.User;

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

}
