package de.raysha.lib.telegram.bot.api.model;

/**
 * This object represents an incoming update.
 */
public class Update {

    /**
     * The update‘s unique identifier. Update identifiers start from a certain positive number and increase
     * sequentially. This ID becomes especially handy if you’re using Webhooks, since it allows you to ignore
     * repeated updates or to restore the correct update sequence, should they get out of order.
     */
    private Integer update_id;

    /**
     * New incoming message of any kind — text, photo, sticker, etc.
     */
    private Message message;

    public Integer getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(Integer update_id) {
        this.update_id = update_id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Update{" +
                "update_id=" + update_id +
                ", message=" + message +
                '}';
    }
}
