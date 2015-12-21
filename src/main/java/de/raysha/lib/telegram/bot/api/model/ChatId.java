package de.raysha.lib.telegram.bot.api.model;

/**
 * This object represents a chat. A chatId contains a String or an Integer as Identifier.
 */
public class ChatId {
    private String sId;
    private Integer iId;

    public ChatId(Object id) {
        checkId(id);

        if(id instanceof String){
            this.sId = (String)id;
        }else if(id instanceof Integer){
            this.iId = (Integer)id;
        }else{
            throw new IllegalArgumentException("The id must be either a String or a Intger!");
        }
    }

    public ChatId(String id) {
        checkId(id);

        this.sId = id;
        this.iId = null;
    }

    public ChatId(Integer id) {
        checkId(id);

        this.iId = id;
        this.sId = null;
    }

    private void checkId(Object id) {
        if(id == null) throw new IllegalArgumentException("The id must not be null!");
    }

    public String getsId() {
        return sId;
    }

    public Integer getiId() {
        return iId;
    }

    @Override
    public String toString() {
        if(sId != null) return sId;

        return "" + iId;
    }
}
