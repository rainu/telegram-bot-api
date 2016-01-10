package de.raysha.lib.telegram.bot.api.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Represents a link to an article or web page.
 */
public class InlineQueryResultArticle extends InlineQueryResult {

    /**
     * Title of the result
     */
    private String title;

    /**
     * Text of the message to be sent
     */
    private String message_text;

    /**
     * Optional. Send “Markdown”, if you want Telegram apps to show bold, italic and inline URLs in your bot's message.
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String parse_mode;

    /**
     * Optional. Disables link previews for links in the sent message
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Boolean disable_web_page_preview;

    /**
     * Optional. URL of the result
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String url;

    /**
     * Optional. Pass True, if you don't want the URL to be shown in the message
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Boolean hide_url;

    /**
     * Optional. Short description of the result
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String description;

    /**
     * Optional. Url of the thumbnail for the result
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String thumb_url;

    /**
     * Optional. Thumbnail width
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer thumb_width;

    /**
     * Optional. Thumbnail height
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer thumb_height;

    public InlineQueryResultArticle() {
        super("article");
    }

    /**
     *
     * @param title Title of the result
     * @param message_text Text of the message to be sent
     */
    public InlineQueryResultArticle(String title, String message_text) {
        this();
        this.title = title;
        this.message_text = message_text;
    }

    /**
     *
     * @param title Title of the result
     * @param message_text Text of the message to be sent
     * @param parse_mode Optional. Send “Markdown”, if you want Telegram apps to show bold, italic and inline URLs in your bot's message.
     * @param disable_web_page_preview Optional. Disables link previews for links in the sent message
     * @param url Optional. URL of the result
     * @param hide_url Optional. Pass True, if you don't want the URL to be shown in the message
     * @param description Optional. Short description of the result
     * @param thumb_url Optional. Url of the thumbnail for the result
     * @param thumb_width Optional. Thumbnail width
     * @param thumb_height Optional. Thumbnail height
     */
    public InlineQueryResultArticle(String title, String message_text, String parse_mode,
                                    Boolean disable_web_page_preview, String url, Boolean hide_url, String description,
                                    String thumb_url, Integer thumb_width, Integer thumb_height) {
        this();
        this.title = title;
        this.message_text = message_text;
        this.parse_mode = parse_mode;
        this.disable_web_page_preview = disable_web_page_preview;
        this.url = url;
        this.hide_url = hide_url;
        this.description = description;
        this.thumb_url = thumb_url;
        this.thumb_width = thumb_width;
        this.thumb_height = thumb_height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getHide_url() {
        return hide_url;
    }

    public void setHide_url(Boolean hide_url) {
        this.hide_url = hide_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public Integer getThumb_width() {
        return thumb_width;
    }

    public void setThumb_width(Integer thumb_width) {
        this.thumb_width = thumb_width;
    }

    public Integer getThumb_height() {
        return thumb_height;
    }

    public void setThumb_height(Integer thumb_height) {
        this.thumb_height = thumb_height;
    }

    @Override
    public String toString() {
        return "InlineQueryResultArticle{" +
                "title='" + title + '\'' +
                ", message_text='" + message_text + '\'' +
                ", parse_mode='" + parse_mode + '\'' +
                ", disable_web_page_preview=" + disable_web_page_preview +
                ", url='" + url + '\'' +
                ", hide_url=" + hide_url +
                ", description='" + description + '\'' +
                ", thumb_url='" + thumb_url + '\'' +
                ", thumb_width=" + thumb_width +
                ", thumb_height=" + thumb_height +
                "} " + super.toString();
    }
}
