package de.raysha.lib.telegram.bot.api.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

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
     * Optional. New incoming message of any kind — text, photo, sticker, etc.
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Message message;

    /**
     * Optional. New incoming <a href="https://core.telegram.org/bots/api#inline-mode" >inline</a> query
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private InlineQuery inline_query;

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

    public InlineQuery getInline_query() {
        return inline_query;
    }

    public void setInline_query(InlineQuery inline_query) {
        this.inline_query = inline_query;
    }

    @Override
    public String toString() {
        return "Update{" +
                "update_id=" + update_id +
                ", message=" + message +
                ", inline_query=" + inline_query +
                '}';
    }
}
