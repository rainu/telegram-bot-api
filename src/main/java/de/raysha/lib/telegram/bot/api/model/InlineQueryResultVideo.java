package de.raysha.lib.telegram.bot.api.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Represents link to a page containing an embedded video player or a video file.
 */
public class InlineQueryResultVideo extends InlineQueryResult {

    /**
     * A valid URL for the embedded video player or video file
     */
    private String video_url;

    /**
     * Mime type of the content of video url, “text/html” or “video/mp4”
     */
    private String mime_type;

    /**
     * Text of the message to be sent with the video, 1-512 characters
     */
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

    /**
     * Optional. Video width
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer video_width;

    /**
     * Optional. Video height
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer video_height;

    /**
     * Optional. Video duration in seconds
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer video_duration;

    /**
     * URL of the thumbnail (jpeg only) for the video
     */
    private String thumb_url;

    /**
     * Title for the result
     */
    private String title;

    /**
     * Optional. Short description of the result
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String description;

    public InlineQueryResultVideo() {
        super("video");
    }

    /**
     *
     * @param video_url A valid URL for the embedded video player or video file
     * @param mime_type Mime type of the content of video url, “text/html” or “video/mp4”
     * @param message_text Text of the message to be sent with the video, 1-512 characters
     * @param thumb_url URL of the thumbnail (jpeg only) for the video
     * @param title Title for the result
     */
    public InlineQueryResultVideo(String video_url, String mime_type, String message_text, String thumb_url, String title) {
        this();
        this.video_url = video_url;
        this.mime_type = mime_type;
        this.message_text = message_text;
        this.thumb_url = thumb_url;
        this.title = title;
    }

    /**
     *
     * @param video_url A valid URL for the embedded video player or video file
     * @param mime_type Mime type of the content of video url, “text/html” or “video/mp4”
     * @param message_text Text of the message to be sent with the video, 1-512 characters
     * @param parse_mode Optional. Send “Markdown”, if you want Telegram apps to show
     *                   <a href="https://core.telegram.org/bots/api#using-markdown">bold, italic and inline URLs</a>
     *                   in your bot's message.
     * @param disable_web_page_preview Optional. Disables link previews for links in the sent message
     * @param video_width Optional. Video width
     * @param video_height Optional. Video height
     * @param video_duration Optional. Video duration in seconds
     * @param thumb_url URL of the thumbnail (jpeg only) for the video
     * @param title Title for the result
     * @param description Optional. Short description of the result
     */
    public InlineQueryResultVideo(String video_url, String mime_type, String message_text, String parse_mode,
                                  Boolean disable_web_page_preview, Integer video_width, Integer video_height,
                                  Integer video_duration, String thumb_url, String title, String description) {
        this();
        this.video_url = video_url;
        this.mime_type = mime_type;
        this.message_text = message_text;
        this.parse_mode = parse_mode;
        this.disable_web_page_preview = disable_web_page_preview;
        this.video_width = video_width;
        this.video_height = video_height;
        this.video_duration = video_duration;
        this.thumb_url = thumb_url;
        this.title = title;
        this.description = description;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
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

    public Integer getVideo_width() {
        return video_width;
    }

    public void setVideo_width(Integer video_width) {
        this.video_width = video_width;
    }

    public Integer getVideo_height() {
        return video_height;
    }

    public void setVideo_height(Integer video_height) {
        this.video_height = video_height;
    }

    public Integer getVideo_duration() {
        return video_duration;
    }

    public void setVideo_duration(Integer video_duration) {
        this.video_duration = video_duration;
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

    @Override
    public String toString() {
        return "InlineQueryResultVideo{" +
                "video_url='" + video_url + '\'' +
                ", mime_type='" + mime_type + '\'' +
                ", message_text='" + message_text + '\'' +
                ", parse_mode='" + parse_mode + '\'' +
                ", disable_web_page_preview=" + disable_web_page_preview +
                ", video_width=" + video_width +
                ", video_height=" + video_height +
                ", video_duration=" + video_duration +
                ", thumb_url='" + thumb_url + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }
}
