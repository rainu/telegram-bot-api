package de.raysha.lib.telegram.bot.api;

import de.raysha.lib.telegram.bot.api.exception.BotException;

import java.io.File;
import java.util.Map;

/**
 * Executes requests to Telegram Bot API
 */
public interface RequestExecutor {

    /**
     * Make GET request to the API
     *
     * @param action API method name (/bot%TOKEN%/%ACTION%)
     * @param parameters query parameters
     * @return value of 'result' field
     * @throws BotException on internal exception (IO, invalid response, etc
     */
    String get(String action, Map<String, Object> parameters) throws BotException;

    /**
     * Make POST request to the API
     *
     * @param action API method name (/bot%TOKEN%/%ACTION%)
     * @param parameters query parameters
     * @return value of 'result' field
     * @throws BotException on internal exception (IO, invalid response, etc
     */
    String post(String action, Map<String, Object> parameters) throws BotException;

    /**
     * Make POST request to the API, with a file
     *
     * @param action API method name (/bot%TOKEN%/%ACTION%)
     * @param parameters query parameters
     * @param fileName a parameter name for the file ('photo', 'sticker', etc)
     * @param file file to upload
     * @return value of 'result' field
     * @throws BotException on internal exception (IO, invalid response, etc
     */
    String post(String action, Map<String, Object> parameters, String fileName, File file) throws BotException;

}
