package de.raysha.lib.telegram.bot.api.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * This object represents a Telegram user or bot.
 */
public class User {

    /**
     * Unique identifier for this user or bot
     */
    private Integer id;

    /**
     * User's or bot's first name
     */
    private String first_name;

    /**
     * Optional. User's or bot's last name
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String last_name;

    /**
     * Optional. User's or bot's username
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
