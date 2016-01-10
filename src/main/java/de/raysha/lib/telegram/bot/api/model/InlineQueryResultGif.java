package de.raysha.lib.telegram.bot.api.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user with optional
 * caption. Alternatively, you can provide <i>message_text</i> to send it instead of the animation.
 */
public class InlineQueryResultGif extends InlineQueryResult {

    /**
     * A valid URL for the GIF file. File size must not exceed 1MB
     */
    private String gif_url;

    /**
     * Optional. Width of the GIF
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer gif_width;

    /**
     * Optional. Height of the GIF
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer gif_height;

    /**
     * URL of the static thumbnail for the result (jpeg or gif)
     */
    private String thumb_url;

    /**
     * Optional. Title for the result
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String title;

    /**
     * Optional. Caption of the GIF file to be sent, 0-200 characters
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String caption;

    /**
     * Optional. Text of a message to be sent instead of the animation, 1-512 characters
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String message_text;

    /**
     * Optional. Send “Markdown”, if you want Telegram apps to show
     * <a href="https://core.telegram.org/bots/api#using-markdown">bold, italic and inline URLs</a> in your bot's message.
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String parse_mode;

    /**
     * Optional. Disables link previews for links in the sent message
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Boolean disable_web_page_preview;

    public InlineQueryResultGif() {
        super("gif");
    }

    /**
     *
     * @param gif_url A valid URL for the GIF file. File size must not exceed 1MB
     * @param thumb_url URL of the static thumbnail for the result (jpeg or gif)
     */
    public InlineQueryResultGif(String gif_url, String thumb_url) {
        this();
        this.gif_url = gif_url;
        this.thumb_url = thumb_url;
    }

    /**
     *
     * @param gif_url A valid URL for the GIF file. File size must not exceed 1MB
     * @param thumb_url URL of the static thumbnail for the result (jpeg or gif)
     * @param gif_width Optional. Width of the GIF
     * @param gif_height Optional. Height of the GIF
     * @param title Optional. Title for the result
     * @param caption Optional. Caption of the GIF file to be sent, 0-200 characters
     * @param message_text Optional. Text of a message to be sent instead of the animation, 1-512 characters
     * @param parse_mode Optional. Send “Markdown”, if you want Telegram apps to show
     *                   <a href="https://core.telegram.org/bots/api#using-markdown">bold, italic and inline URLs</a>
     *                   in your bot's message.
     * @param disable_web_page_preview Optional. Disables link previews for links in the sent message
     */
    public InlineQueryResultGif(String gif_url, String thumb_url, Integer gif_width, Integer gif_height, String title,
                                String caption, String message_text, String parse_mode, Boolean disable_web_page_preview) {
        this();
        this.gif_url = gif_url;
        this.gif_width = gif_width;
        this.gif_height = gif_height;
        this.thumb_url = thumb_url;
        this.title = title;
        this.caption = caption;
        this.message_text = message_text;
        this.parse_mode = parse_mode;
        this.disable_web_page_preview = disable_web_page_preview;
    }

    public String getGif_url() {
        return gif_url;
    }

    public void setGif_url(String gif_url) {
        this.gif_url = gif_url;
    }

    public Integer getGif_width() {
        return gif_width;
    }

    public void setGif_width(Integer gif_width) {
        this.gif_width = gif_width;
    }

    public Integer getGif_height() {
        return gif_height;
    }

    public void setGif_height(Integer gif_height) {
        this.gif_height = gif_height;
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

    public Boolean getDisable_web_page_preview() {
        return disable_web_page_preview;
    }

    public void setDisable_web_page_preview(Boolean disable_web_page_preview) {
        this.disable_web_page_preview = disable_web_page_preview;
    }

    @Override
    public String toString() {
        return "InlineQueryResultGif{" +
                "gif_url='" + gif_url + '\'' +
                ", gif_width=" + gif_width +
                ", gif_height=" + gif_height +
                ", thumb_url='" + thumb_url + '\'' +
                ", title='" + title + '\'' +
                ", caption='" + caption + '\'' +
                ", message_text='" + message_text + '\'' +
                ", parse_mode='" + parse_mode + '\'' +
                ", disable_web_page_preview=" + disable_web_page_preview +
                "} " + super.toString();
    }
}
