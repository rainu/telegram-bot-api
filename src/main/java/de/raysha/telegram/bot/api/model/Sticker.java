package de.raysha.telegram.bot.api.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * This object represents a sticker.
 */
public class Sticker {
    /**
     * Unique identifier for this file
     */
    private String file_id;

    /**
     * Sticker width
     */
    private Integer width;

    /**
     * Sticker height
     */
    private Integer height;

    /**
     * Sticker thumbnail in .webp or .jpg format
     */
    private PhotoSize thumb;

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

    public PhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(PhotoSize thumb) {
        this.thumb = thumb;
    }

    public Integer getFile_size() {
        return file_size;
    }

    public void setFile_size(Integer file_size) {
        this.file_size = file_size;
    }

    @Override
    public String toString() {
        return "Sticker{" +
                "file_id='" + file_id + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", thumb=" + thumb +
                ", file_size=" + file_size +
                '}';
    }
}
