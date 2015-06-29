package de.raysha.telegram.bot.api.model;

/**
 * This object represents a general file (as opposed to photos and audio files).
 */
public class Document {
    /**
     * Unique file identifier
     */
    private String file_id;

    /**
     * Document thumbnail as defined by sender
     */
    private PhotoSize thumb;

    /**
     * Optional. Original filename as defined by sender
     */
    private String file_name;

    /**
     * Optional. MIME type of the file as defined by sender
     */
    private String mime_type;

    /**
     * Optional. File size
     */
    private Integer file_size;

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(PhotoSize thumb) {
        this.thumb = thumb;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
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
}
