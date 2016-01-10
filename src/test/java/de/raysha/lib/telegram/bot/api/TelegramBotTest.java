package de.raysha.lib.telegram.bot.api;

import de.raysha.lib.telegram.bot.api.exception.BotException;
import de.raysha.lib.telegram.bot.api.model.ChatId;
import de.raysha.lib.telegram.bot.api.model.Message;
import de.raysha.lib.telegram.bot.api.model.ReplyKeyboardMarkup;
import de.raysha.lib.telegram.bot.api.model.User;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TelegramBotTest {
    private static String BOT_TOKEN;
    private static ChatId CHAT_ID;
    private TelegramBot bot;

    @BeforeClass
    public static void readProperties() throws IOException {
        InputStream in = TelegramBotTest.class.getResourceAsStream("/test.properties");
        try {
            Properties configProperties = new Properties();
            configProperties.load(in);

            BOT_TOKEN = configProperties.getProperty("bot.token");
            CHAT_ID = new ChatId(Integer.parseInt(configProperties.getProperty("bot.chat.id")));
        } finally {
            try {
                in.close();
            } catch (IOException e) {
            }
        }
    }

    @Before
    public void setup() throws BotException {
        bot = new TelegramBot(BOT_TOKEN);
        System.out.println("Updates: \n" + bot.getUpdates(null, null, null));
    }

    @Test
    public void getMe() throws BotException {
        User user = bot.getMe();

        assertNotNull(user);
    }

    @Test
    public void sendChatAction() throws BotException {
        for(BotAPI.ChatAction action : BotAPI.ChatAction.values()) {
            assertTrue(bot.sendChatAction(CHAT_ID, action));
        }
    }

    @Test
    public void sendMessage() throws BotException {
        ReplyKeyboardMarkup keyboardMarkup = buildReplyKeyboardMarkup();
        String text = "Test sendMessage: *bold* _italic_ [url](http://www.example.org)!";

        Message result = bot.sendMessage(CHAT_ID, text, null, true, null, keyboardMarkup);

        assertNotNull(result.getMessage_id());
        assertNotNull(result.getDate());
        assertEquals(text, result.getText());
    }

    @Test
    public void sendMessageMarkdown() throws BotException {
        ReplyKeyboardMarkup keyboardMarkup = buildReplyKeyboardMarkup();
        String text = "Test sendMessageMarkdown: *bold* _italic_ [url](http://www.example.org)!";

        Message result = bot.sendMessage(CHAT_ID, text, BotAPI.ParseMode.Markdown, true, null, keyboardMarkup);

        assertNotNull(result.getMessage_id());
        assertNotNull(result.getDate());
        assertEquals("Test sendMessageMarkdown: bold italic url!", result.getText());
    }

    @Test
    public void forwardMessage() throws BotException {
        Message message = bot.sendMessage(CHAT_ID, "Test forwardMessage");

        Message result = bot.forwardMessage(CHAT_ID, CHAT_ID, message.getMessage_id());

        assertNotNull(result.getMessage_id());
        assertNotNull(result.getDate());
        assertEquals(message.getText(), result.getText());
    }

    @Test
    public void sendPhoto() throws URISyntaxException, BotException {
        File testPic = new File(TelegramBotTest.class.getResource("/test-pic.jpg").toURI());

        String caption = "Test sendPhoto";
        Message result = bot.sendPhoto(CHAT_ID, testPic, caption, null, null);

        assertNotNull(result);
        assertEquals(caption, result.getCaption());
        assertNotNull(result.getPhoto());
        assertTrue(result.getPhoto().size() >= 1);
        assertNotNull(result.getPhoto().get(0).getFile_id());

        //send already uploaded photo
        caption += "2";
        result = bot.sendPhoto(CHAT_ID, result.getPhoto().get(0).getFile_id(), caption, null, null);

        assertNotNull(result);
        assertEquals(caption, result.getCaption());
        assertNotNull(result.getPhoto());
        assertTrue(result.getPhoto().size() >= 1);
        assertNotNull(result.getPhoto().get(0).getFile_id());
    }

    @Test
    public void sendAudio() throws URISyntaxException, BotException {
        File testAudio = new File(TelegramBotTest.class.getResource("/test-audio.mp3").toURI());

        String performer = "T J McKenzie, http://en.wikipedia.org/wiki/User:T_J_McKenzie";
        String title = "TestAudio";
        Integer duration = 120;
        Message result = bot.sendAudio(CHAT_ID, testAudio, duration, performer, title, null, null);

        assertNotNull(result);
        assertNotNull(result.getAudio());
        assertNotNull(result.getAudio().getFile_id());
        assertEquals(performer, result.getAudio().getPerformer());
        assertEquals(duration, result.getAudio().getDuration());
        assertEquals(title, result.getAudio().getTitle());

        result = bot.sendAudio(CHAT_ID, result.getAudio().getFile_id());

        assertNotNull(result);
        assertNotNull(result.getAudio());
        assertNotNull(result.getAudio().getFile_id());
        assertEquals(performer, result.getAudio().getPerformer());
        assertEquals(duration, result.getAudio().getDuration());
        assertEquals(title, result.getAudio().getTitle());
    }

    @Test
    public void sendVoice() throws URISyntaxException, BotException {
        File testVoice = new File(TelegramBotTest.class.getResource("/test-voice.ogg").toURI());

        Integer duration = 120;
        Message result = bot.sendVoice(CHAT_ID, testVoice, duration, null, null);

        assertNotNull(result);
        assertNotNull(result.getVoice());
        assertNotNull(result.getVoice().getFile_id());
        assertEquals(duration, result.getVoice().getDuration());

        result = bot.sendVoice(CHAT_ID, result.getVoice().getFile_id());

        assertNotNull(result);
        assertNotNull(result.getVoice());
        assertNotNull(result.getVoice().getFile_id());
        assertEquals(duration, result.getVoice().getDuration());
    }

    @Test
    public void sendDocument() throws URISyntaxException, BotException {
        File testDocument = new File(TelegramBotTest.class.getResource("/test-doc.txt").toURI());

        Message result = bot.sendDocument(CHAT_ID, testDocument);

        assertNotNull(result);
        assertNotNull(result.getDocument());
        assertNotNull(result.getDocument().getFile_id());

        result = bot.sendDocument(CHAT_ID, result.getDocument().getFile_id());

        assertNotNull(result);
        assertNotNull(result.getDocument());
        assertNotNull(result.getDocument().getFile_id());
    }

    @Test
    public void sendSticker() throws URISyntaxException, BotException {
        File testSticker = new File(TelegramBotTest.class.getResource("/test-sticker.webp").toURI());

        Message result = bot.sendSticker(CHAT_ID, testSticker);

        assertNotNull(result);
        assertNotNull(result.getSticker());
        assertNotNull(result.getSticker().getFile_id());

        result = bot.sendSticker(CHAT_ID, result.getSticker().getFile_id());

        assertNotNull(result);
        assertNotNull(result.getSticker());
        assertNotNull(result.getSticker().getFile_id());
    }

    @Test
    public void sendVideo() throws URISyntaxException, BotException {
        File testVideo = new File(TelegramBotTest.class.getResource("/test-vid.mp4").toURI());

        String caption = "Test sendVideo";
        Integer duration = 5;
        Message result = bot.sendVideo(CHAT_ID, testVideo, duration, caption, null, null);

        System.out.println(result);

        assertNotNull(result);
        assertNotNull(result.getVideo());
        assertNotNull(result.getVideo().getFile_id());
        assertEquals(duration, result.getVideo().getDuration());
        assertEquals(caption, result.getCaption());

        result = bot.sendVideo(CHAT_ID, result.getVideo().getFile_id());

        assertNotNull(result);
        assertNotNull(result.getVideo());
        assertNotNull(result.getVideo().getFile_id());
        assertEquals(duration, result.getVideo().getDuration());
    }

    @Test
    public void sendLocation() throws URISyntaxException, BotException {
        float latitude = 13.12f;
        float longitude = 12.13f;

        Message result = bot.sendLocation(CHAT_ID, latitude, longitude);

        assertNotNull(result);
        assertNotNull(result.getLocation());
    }

    @Test
    public void getFile() throws BotException, URISyntaxException {
        File testDocument = new File(TelegramBotTest.class.getResource("/test-doc.txt").toURI());

        Message result = bot.sendDocument(CHAT_ID, testDocument);

        de.raysha.lib.telegram.bot.api.model.File file = bot.getFile(result.getDocument().getFile_id());

        assertNotNull(file);
        assertTrue(file.getFile_size() > 0);

        assertNotNull(file.getDownloadUrl(BOT_TOKEN));
    }

    @Test
    public void setWebhook() throws BotException {
        assertTrue(bot.setWebhook("https://raysha.de/bot"));
        assertTrue(bot.setWebhook(null));
    }

    private ReplyKeyboardMarkup buildReplyKeyboardMarkup() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setKeyboard(new ArrayList<List<String>>());
        keyboardMarkup.getKeyboard().add(new ArrayList<String>());
        keyboardMarkup.getKeyboard().get(0).add("Hallo!");
        return keyboardMarkup;
    }

}
