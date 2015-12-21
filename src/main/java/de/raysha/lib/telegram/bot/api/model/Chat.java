package de.raysha.lib.telegram.bot.api.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * This object represents a chat.
 */
public class Chat {

    /**
     * Unique identifier for this chat, not exceeding 1e13 by absolute value
     */
    private Integer id;

    /**
     * Type of chat, can be either "private", "group", "supergroup" or "channel"
     */
    private String type;

    /**
     * Optional. Title, for channels and group chats
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String title;

    /**
     * Optional. Username, for private chats and channels if available
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String username;

    /**
     * Optional. First name of the other party in a private chat
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String first_name;

    /**
     * Optional. Last name of the other party in a private chat
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String last_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
