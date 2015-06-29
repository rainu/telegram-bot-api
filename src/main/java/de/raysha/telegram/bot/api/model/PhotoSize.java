package de.raysha.telegram.bot.api.model;

/**
 * This object represents one size of a photo or a file / sticker thumbnail.
 *
 * A missing thumbnail for a file (or sticker) is presented as an empty object.
 */
public class PhotoSize {
    /**
     * Unique identifier for this file
     */
    private String file_id;

    /**
     * Photo width
     */
    private Integer width;

    /**
     * Photo height
     */
    private Integer height;

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

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getFile_size() {
        return file_size;
    }

    public void setFile_size(Integer file_size) {
        this.file_size = file_size;
    }
}
