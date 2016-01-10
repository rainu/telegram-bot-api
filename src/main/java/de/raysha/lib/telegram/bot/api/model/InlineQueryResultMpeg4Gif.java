package de.raysha.lib.telegram.bot.api.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound). By default,
 * this animated MPEG-4 file will be sent by the user with optional caption. Alternatively,
 * you can provide message_text to send it instead of the animation.
 */
public class InlineQueryResultMpeg4Gif extends InlineQueryResult {

    /**
     * A valid URL for the MP4 file. File size must not exceed 1MB
     */
    private String mpeg4_url;

    /**
     * Optional. Video width
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer mpeg4_width;

    /**
     * Optional. Video height
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer mpeg4_height;

    /**
     * URL of the static thumbnail (jpeg or gif) for the result
     */
    private String thumb_url;

    /**
     * Optional. Title for the result
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String title;

    /**
     * Optional. Caption of the MPEG-4 file to be sent, 0-200 characters
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

    public InlineQueryResultMpeg4Gif() {
        super("mpeg4_gif");
    }

    /**
     *
     * @param mpeg4_url A valid URL for the MP4 file. File size must not exceed 1MB
     * @param thumb_url URL of the static thumbnail (jpeg or gif) for the result
     */
    public InlineQueryResultMpeg4Gif(String mpeg4_url, String thumb_url) {
        this();
        this.mpeg4_url = mpeg4_url;
        this.thumb_url = thumb_url;
    }

    /**
     *
     * @param mpeg4_url A valid URL for the MP4 file. File size must not exceed 1MB
     * @param thumb_url URL of the static thumbnail (jpeg or gif) for the result
     * @param mpeg4_width Optional. Video width
     * @param mpeg4_height Optional. Video height
     * @param title Optional. Title for the result
     * @param caption Optional. Caption of the MPEG-4 file to be sent, 0-200 characters
     * @param message_text Optional. Text of a message to be sent instead of the animation, 1-512 characters
     * @param parse_mode Optional. Send “Markdown”, if you want Telegram apps to show
     *                   <a href="https://core.telegram.org/bots/api#using-markdown">bold, italic and inline URLs</a>
     *                   in your bot's message.
     * @param disable_web_page_preview Optional. Disables link previews for links in the sent message
     */
    public InlineQueryResultMpeg4Gif(String mpeg4_url, String thumb_url, Integer mpeg4_width, Integer mpeg4_height,
                                     String title, String caption, String message_text, String parse_mode,
                                     Boolean disable_web_page_preview) {
        this();
        this.mpeg4_url = mpeg4_url;
        this.mpeg4_width = mpeg4_width;
        this.mpeg4_height = mpeg4_height;
        this.thumb_url = thumb_url;
        this.title = title;
        this.caption = caption;
        this.message_text = message_text;
        this.parse_mode = parse_mode;
        this.disable_web_page_preview = disable_web_page_preview;
    }

    public String getMpeg4_url() {
        return mpeg4_url;
    }

    public void setMpeg4_url(String mpeg4_url) {
        this.mpeg4_url = mpeg4_url;
    }

    public Integer getMpeg4_width() {
        return mpeg4_width;
    }

    public void setMpeg4_width(Integer mpeg4_width) {
        this.mpeg4_width = mpeg4_width;
    }

    public Integer getMpeg4_height() {
        return mpeg4_height;
    }

    public void setMpeg4_height(Integer mpeg4_height) {
        this.mpeg4_height = mpeg4_height;
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
        return "InlineQueryResultMpeg4Gif{" +
                "mpeg4_url='" + mpeg4_url + '\'' +
                ", mpeg4_width=" + mpeg4_width +
                ", mpeg4_height=" + mpeg4_height +
                ", thumb_url='" + thumb_url + '\'' +
                ", title='" + title + '\'' +
                ", caption='" + caption + '\'' +
                ", message_text='" + message_text + '\'' +
                ", parse_mode='" + parse_mode + '\'' +
                ", disable_web_page_preview=" + disable_web_page_preview +
                "} " + super.toString();
    }
}
