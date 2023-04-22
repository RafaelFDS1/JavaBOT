package bot;

import bot.commands.EventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
  public static final String prefix = "j!";
  private static JDA login;
  private static JDABuilder builder;
  public static JDA getLogin(){
    return login;
  }
  public static void main(String[] args) {
    if(args.length < 1) {
      System.out.println("Se esqueceu de incluir o TOKEN como argumento!");
      System.exit(1);
    }

    try {
      builder = JDABuilder.createDefault(args[0])
          .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MEMBERS);
      builder.setActivity(Activity.listening(prefix + "help"));
      login = builder.build().awaitReady();
      login.addEventListener(new EventListener());
      login.updateCommands().addCommands(
          Commands.slash("help","Sometimes we need some help"),
          Commands.slash("ping", "Pong! It brings a info about my ping!")
      ).queue();
    } catch(Exception ex) {
      ex.printStackTrace();
      login.shutdownNow();
    }
  }
}
