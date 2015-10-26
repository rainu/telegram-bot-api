package de.raysha.lib.telegram.bot.api.exception;

/**
 * Error returned by Telegram Bot API.
 *
 * See https://core.telegram.org/api/errors
 */
public class BotApiException extends BotException {

    /**
     * Similar to HTTP status. Contains information on the type of error that occurred: for example,
     * a data input error, privacy error, or server error.
     */
    private int errorCode;

    /**
     * A string literal in the form of /[A-Z_0-9]+/, which summarizes the problem. For example, AUTH_KEY_UNREGISTERED.
     *
     * Optional, could be null
     */
    private String errorType;

    /**
     * May contain more detailed information on the error and how to resolve it, for example: authorization required,
     * use auth.* methods. Please note that the description text is subject to change, one should avoid tying
     * application logic to these messages.
     *
     * Optional, could be null
     */
    private String description;

    public BotApiException(int errorCode, String errorType, String description, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.description = description;
    }

    public BotApiException(int errorCode, String errorType, String description) {
        super();
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.description = description;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getMessage() {
        StringBuilder buf = new StringBuilder();
        buf.append(errorCode);
        if (errorType != null) {
            buf.append(' ').append(errorType);
        }
        if (description != null) {
            buf.append(" '").append(description).append('\'');
        }
        return buf.toString();
    }
}
