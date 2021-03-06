package de.raysha.lib.telegram.bot.api.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * This object represents an audio file (voice note).
 */
public class Audio {

    /**
     * Unique identifier for this file
     */
    private String file_id;

    /**
     * Duration of the audio in seconds as defined by sender
     */
    private Integer duration;

    /**
     * Optional. Performer of the audio as defined by sender or by audio tags
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String performer;

    /**
     * Optional. Title of the audio as defined by sender or by audio tags
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String title;

    /**
     * Optional. MIME type of the file as defined by sender
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String mime_type;

    /**
     * Optional. File size
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer file_size;

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }

    public Integer getFile_size() {
        return file_size;
    }

    public void setFile_size(Integer file_size) {
        this.file_size = file_size;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "file_id='" + file_id + '\'' +
                ", duration=" + duration +
                ", performer='" + performer + '\'' +
                ", title='" + title + '\'' +
                ", mime_type='" + mime_type + '\'' +
                ", file_size=" + file_size +
                '}';
    }
}
