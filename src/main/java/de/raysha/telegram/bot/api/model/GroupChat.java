package de.raysha.telegram.bot.api.model;

/**
 * This object represents a group chat.
 */
public class GroupChat {

    /**
     * Unique identifier for this group chat
     */
    private Integer id;

    /**
     * Group name
     */
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
