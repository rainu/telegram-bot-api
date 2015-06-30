package de.raysha.telegram.bot.api.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * This object represents a phone contact.
 */
public class Contact {
    /**
     * Contact's phone number
     */
    private String phone_number;

    /**
     * Contact's first name
     */
    private String first_name;

    /**
     * Optional. Contact's last name
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String last_name;

    /**
     * Optional. Contact's user identifier in Telegram
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String user_id;

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
