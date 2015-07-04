package de.raysha.lib.telegram.bot.api.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

/**
 * This object represents a message.
 */
public class Message {
    /**
     * Unique message identifier
     */
    private Integer message_id;

    /**
     * Sender
     */
    private User from;

    /**
     * Date the message was sent in Unix time
     */
    private Integer date;

    /**
     * User or GroupChat Conversation the message belongs to -- user in case of a private message, GroupChat in case of a group
     */
    private Object chat;

    /**
     * Optional. For forwarded messages, sender of the original message
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private User forward_from;

    /**
     * Optional. For forwarded messages, date the original message was sent in Unix time
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer forward_date;

    /**
     * Optional. For replies, the original message. Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply.
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Message reply_to_message;

    /**
     * Optional. For text messages, the actual UTF-8 text of the message
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String text;

    /**
     * Optional. Message is an audio file, information about the file
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Audio audio;

    /**
     * Optional. Message is a general file, information about the file
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Document document;

    /**
     * Optional. Message is a photo, available sizes of the photo
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private List<PhotoSize> photo;

    /**
     * Optional. Message is a sticker, information about the sticker
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Sticker sticker;

    /**
     * Optional. Message is a video, information about the video
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Video video;

    /**
     * Optional. Message is a shared contact, information about the contact
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Contact contact;

    /**
     * Optional. Message is a shared location, information about the location
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Location location;

    /**
     * Optional. A new member was added to the group, information about them (this member may be bot itself)
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private User new_chat_participant;

    /**
     * Optional. A member was removed from the group, information about them (this member may be bot itself)
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private User left_chat_participant;

    /**
     * Optional. A group title was changed to this value
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String new_chat_title;

    /**
     * Optional. A group photo was change to this value
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private List<PhotoSize> new_chat_photo;

    /**
     * Optional. Informs that the group photo was deleted
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Boolean delete_chat_photo;

    /**
     * Optional. Informs that the group has been created
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Boolean group_chat_created;

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Object getChat() {
        return chat;
    }

    public void setChat(Object chat) {
        this.chat = chat;
    }

    public User getForward_from() {
        return forward_from;
    }

    public void setForward_from(User forward_from) {
        this.forward_from = forward_from;
    }

    public Integer getForward_date() {
        return forward_date;
    }

    public void setForward_date(Integer forward_date) {
        this.forward_date = forward_date;
    }

    public Message getReply_to_message() {
        return reply_to_message;
    }

    public void setReply_to_message(Message reply_to_message) {
        this.reply_to_message = reply_to_message;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<PhotoSize> getPhoto() {
        return photo;
    }

    public void setPhoto(List<PhotoSize> photo) {
        this.photo = photo;
    }

    public Sticker getSticker() {
        return sticker;
    }

    public void setSticker(Sticker sticker) {
        this.sticker = sticker;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getNew_chat_participant() {
        return new_chat_participant;
    }

    public void setNew_chat_participant(User new_chat_participant) {
        this.new_chat_participant = new_chat_participant;
    }

    public User getLeft_chat_participant() {
        return left_chat_participant;
    }

    public void setLeft_chat_participant(User left_chat_participant) {
        this.left_chat_participant = left_chat_participant;
    }

    public String getNew_chat_title() {
        return new_chat_title;
    }

    public void setNew_chat_title(String new_chat_title) {
        this.new_chat_title = new_chat_title;
    }

    public List<PhotoSize> getNew_chat_photo() {
        return new_chat_photo;
    }

    public void setNew_chat_photo(List<PhotoSize> new_chat_photo) {
        this.new_chat_photo = new_chat_photo;
    }

    public Boolean getDelete_chat_photo() {
        return delete_chat_photo;
    }

    public void setDelete_chat_photo(Boolean delete_chat_photo) {
        this.delete_chat_photo = delete_chat_photo;
    }

    public Boolean getGroup_chat_created() {
        return group_chat_created;
    }

    public void setGroup_chat_created(Boolean group_chat_created) {
        this.group_chat_created = group_chat_created;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", from=" + from +
                ", date=" + date +
                ", chat=" + chat +
                ", forward_from=" + forward_from +
                ", forward_date=" + forward_date +
                ", reply_to_message=" + reply_to_message +
                ", text='" + text + '\'' +
                ", audio=" + audio +
                ", document=" + document +
                ", photo=" + photo +
                ", sticker=" + sticker +
                ", video=" + video +
                ", contact=" + contact +
                ", location=" + location +
                ", new_chat_participant=" + new_chat_participant +
                ", left_chat_participant=" + left_chat_participant +
                ", new_chat_title='" + new_chat_title + '\'' +
                ", new_chat_photo=" + new_chat_photo +
                ", delete_chat_photo=" + delete_chat_photo +
                ", group_chat_created=" + group_chat_created +
                '}';
    }
}
