# telegram-bot-api
This is an api-project for the telegram bot (HTTPS) api. For additional informations see the official [telegram bot api documentation](https://core.telegram.org/bots/api).

Usage
-----

```java
import de.raysha.lib.telegram.bot.api.BotAPI;
import de.raysha.lib.telegram.bot.api.TelegramBot;
import de.raysha.lib.telegram.bot.api.model.User;

...

final String botToken = "11111-aaaabbbbbccccddddeeeeffff";
final BotAPI telegramBot = new TelegramBot(botToken);

try{
  User user = telegramBot.getMe();
}catch(BotException e){
  System.err.println("Could not get me!");
}

```

License
-------

This Bot-API is distributed under the [MIT-License](http://www.opensource.org/licenses/mit-license.php).

Maven Usage
--------

If you want to add ___telegram-bot-api___ to your maven project, you can add the following dependency in your __pom.xml__:

```xml
  <dependency>
    <groupId>de.raysha.lib.telegram</groupId>
    <artifactId>bot-api</artifactId>
    <version>1.0.1</version>
  </dependency>
```

