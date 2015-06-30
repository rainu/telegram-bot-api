package de.raysha.telegram.bot.api.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

/**
 * This object represents a custom keyboard with reply options (see Introduction to bots for details and examples).
 *
 * Example: A user requests to change the bot's language, bot replies to the request with a
 * keyboard to select the new language. Other users in the group don't see the keyboard.
 */
public class ReplyKeyboardMarkup {

    /**
     * Array of button rows, each represented by an Array of Strings
     */
    private List<List<String>> keyboard;

    /**
     * Optional. Requests clients to resize the keyboard vertically for optimal fit
     * (e.g., make the keyboard smaller if there are just two rows of buttons).
     * Defaults to false, in which case the custom keyboard is always of the same
     * height as the app's standard keyboard.
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Boolean resize_keyboard;

    /**
     * Optional. Requests clients to hide the keyboard as soon as it's been used. Defaults to false.
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Boolean one_time_keyboard;

    /**
     * Optional. Use this parameter if you want to show the keyboard to specific users only. Targets: 1)
     * users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply
     * (has reply_to_message_id), sender of the original message.
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Boolean selective;

    public List<List<String>> getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(List<List<String>> keyboard) {
        this.keyboard = keyboard;
    }

    public Boolean getResize_keyboard() {
        return resize_keyboard;
    }

    public void setResize_keyboard(Boolean resize_keyboard) {
        this.resize_keyboard = resize_keyboard;
    }

    public Boolean getOne_time_keyboard() {
        return one_time_keyboard;
    }

    public void setOne_time_keyboard(Boolean one_time_keyboard) {
        this.one_time_keyboard = one_time_keyboard;
    }

    public Boolean getSelective() {
        return selective;
    }

    public void setSelective(Boolean selective) {
        this.selective = selective;
    }

    @Override
    public String toString() {
        return "ReplyKeyboardMarkup{" +
                "keyboard=" + keyboard +
                ", resize_keyboard=" + resize_keyboard +
                ", one_time_keyboard=" + one_time_keyboard +
                ", selective=" + selective +
                '}';
    }
}
