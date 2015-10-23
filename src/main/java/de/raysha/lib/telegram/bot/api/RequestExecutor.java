package de.raysha.lib.telegram.bot.api;

import de.raysha.lib.telegram.bot.api.exception.BotException;

import java.io.File;
import java.util.Map;

/**
 * Executes requests to Telegram Bot API
 */
public interface RequestExecutor {

    String get(String action, Map<String, Object> parameters) throws BotException;

    String post(String action, Map<String, Object> parameters) throws BotException;

    String post(String action, Map<String, Object> parameters, String fileName, File file) throws BotException;

}
