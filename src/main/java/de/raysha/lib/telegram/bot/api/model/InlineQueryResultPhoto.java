package de.raysha.lib.telegram.bot.api.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Represents a link to a photo.
 * By default, this photo will be sent by the user with optional caption.
 * Alternatively, you can provide <i>message_text</i> to send it instead of photo.
 */
public class InlineQueryResultPhoto extends InlineQueryResult {

    /**
     * A valid URL of the photo. Photo must be in <b>jpeg</b> format. Photo size must not exceed 5MB
     */
    private String photo_url;

    /**
     * Optional. Width of the photo
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer photo_width;

    /**
     * Optional. Height of the photo
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer photo_height;

    /**
     * URL of the thumbnail for the photo
     */
    private String thumb_url;

    /**
     * Optional. Title for the result
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String title;

    /**
     * Optional. Short description of the result
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String description;

    /**
     * Optional. Caption of the photo to be sent, 0-200 characters
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String caption;

    /**
     * Optional. Text of a message to be sent instead of the photo, 1-512 characters
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String message_text;

    /**
     * Optional. Send “Markdown”, if you want Telegram apps to show
     * <a href="https://core.telegram.org/bots/api#using-markdown">bold, italic and inline URLs</a>
     * in your bot's message.
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String parse_mode;

    public InlineQueryResultPhoto() {
        super("photo");
    }

    /**
     *
     * @param photo_url A valid URL of the photo. Photo must be in <b>jpeg</b> format. Photo size must not exceed 5MB
     * @param thumb_url URL of the thumbnail for the photo
     */
    public InlineQueryResultPhoto(String photo_url, String thumb_url) {
        this();
        this.photo_url = photo_url;
        this.thumb_url = thumb_url;
    }

    /**
     *
     * @param photo_url A valid URL of the photo. Photo must be in <b>jpeg</b> format. Photo size must not exceed 5MB
     * @param thumb_url URL of the thumbnail for the photo
     * @param photo_width Optional. Width of the photo
     * @param photo_height Optional. Height of the photo
     * @param title Optional. Title for the result
     * @param description Optional. Short description of the result
     * @param caption Optional. Caption of the photo to be sent, 0-200 characters
     * @param message_text Optional. Text of a message to be sent instead of the photo, 1-512 characters
     * @param parse_mode Optional. Send “Markdown”, if you want Telegram apps to show
     *                   <a href="https://core.telegram.org/bots/api#using-markdown">bold, italic and inline URLs</a>
     *                   in your bot's message.
     */
    public InlineQueryResultPhoto(String photo_url, String thumb_url, Integer photo_width, Integer photo_height,
                                  String title, String description, String caption, String message_text,
                                  String parse_mode) {
        this();
        this.photo_url = photo_url;
        this.photo_width = photo_width;
        this.photo_height = photo_height;
        this.thumb_url = thumb_url;
        this.title = title;
        this.description = description;
        this.caption = caption;
        this.message_text = message_text;
        this.parse_mode = parse_mode;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public Integer getPhoto_width() {
        return photo_width;
    }

    public void setPhoto_width(Integer photo_width) {
        this.photo_width = photo_width;
    }

    public Integer getPhoto_height() {
        return photo_height;
    }

    public void setPhoto_height(Integer photo_height) {
        this.photo_height = photo_height;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getMessage_text() {
        return message_text;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }

    public String getParse_mode() {
        return parse_mode;
    }

    public void setParse_mode(String parse_mode) {
        this.parse_mode = parse_mode;
    }

    @Override
    public String toString() {
        return "InlineQueryResultPhoto{" +
                "photo_url='" + photo_url + '\'' +
                ", photo_width=" + photo_width +
                ", photo_height=" + photo_height +
                ", thumb_url='" + thumb_url + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", caption='" + caption + '\'' +
                ", message_text='" + message_text + '\'' +
                ", parse_mode='" + parse_mode + '\'' +
                "} " + super.toString();
    }
}
