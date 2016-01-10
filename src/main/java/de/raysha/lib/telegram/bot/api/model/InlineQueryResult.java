package de.raysha.lib.telegram.bot.api.model;

import java.util.UUID;

/**
 * This object represents one result of an inline query.
 * Telegram clients currently support results of the following 5 types:
 * <ul>
 * <li>{@link InlineQueryResultArticle}</li>
 * <li>{@link InlineQueryResultPhoto}</li>
 * <li>{@link InlineQueryResultGif}</li>
 * <li>{@link InlineQueryResultMpeg4Gif}</li>
 * <li>{@link InlineQueryResultVideo}</li>
 * </ul>
 */
public abstract class InlineQueryResult {

    /**
     * Type of the result
     */
    protected final String type;

    /**
     * Unique identifier for this result, 1-64 Bytes
     */
    protected String id;

    public InlineQueryResult(String type) {
        this.type = type;
        this.id = UUID.randomUUID().toString().replace("-", "") + UUID.randomUUID().toString().replace("-", "");
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "InlineQueryResult{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
