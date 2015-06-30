package de.raysha.telegram.bot.api.model;

import java.util.List;

/**
 * This object represent a user's profile pictures.
 */
public class UserProfilePhotos {

    /**
     * Total number of profile pictures the target user has
     */
    private Integer total_count;

    /**
     * Requested profile pictures (in up to 4 sizes each)
     */
    private List<List<PhotoSize>> photos;

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public List<List<PhotoSize>> getPhotos() {
        return photos;
    }

    public void setPhotos(List<List<PhotoSize>> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "UserProfilePhotos{" +
                "total_count=" + total_count +
                ", photos=" + photos +
                '}';
    }
}
