package bot;

import bot.commands.messageCommands.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
  private static JDA login;
  public static void main(String[] args) {
    try {
      login = JDABuilder.createDefault(args[0])
          .enableIntents(GatewayIntent.MESSAGE_CONTENT,
              GatewayIntent.GUILD_PRESENCES,
              GatewayIntent.GUILD_MEMBERS)
          .build()
          .awaitReady();
      login.addEventListener(new MessageListener());
    } catch(Exception ex) {
      ex.printStackTrace();
      login.shutdownNow();
    }
  }
}
