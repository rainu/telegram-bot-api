package de.raysha.lib.telegram.bot.api.model;

import de.raysha.lib.telegram.bot.api.BotAPI;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This object represents a file ready to be downloaded.
 * The file can be downloaded via the link https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;.
 * It is guaranteed that the link will be valid for at least 1 hour. When the link expires,
 * a new one can be requested by calling {@link BotAPI#getFile}.
 */
public class File {
    /**
     * Unique identifier for this file
     */
    private String file_id;

    /**
     * Optional. File size, if known
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Integer file_size;

    /**
     * Optional. File path. Use https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt; to get the file.
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String file_path;

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public Integer getFile_size() {
        return file_size;
    }

    public void setFile_size(Integer file_size) {
        this.file_size = file_size;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public URL getDownloadUrl(String botToken){
        try {
            return new URL("https://api.telegram.org/file/bot" + botToken + "/" + getFile_path());
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Could not create URL. This should never happen!");
        }
    }

    @Override
    public String toString() {
        return "File{" +
                "file_id='" + file_id + '\'' +
                ", file_size=" + file_size +
                ", file_path='" + file_path + '\'' +
                '}';
    }
}
