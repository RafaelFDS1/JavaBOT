package bot.commands.messageCommands;

import bot.commands.messageRecievedResponse.GuildMessageResponse;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static bot.Main.prefix;

public class MessageListener extends ListenerAdapter {

  public MessageListener(){}
  @Override
  public void onMessageReceived(@NotNull MessageReceivedEvent event) {
    GuildMessageResponse events = new GuildMessageResponse(event);
    switch(event.getMessage().getContentDisplay()){
      case prefix + "github":
        events.createGitHubEmbed();
        break;
      case prefix + "prefix":
        event.getChannel().sendMessageFormat("The actual prefix is: %s%n%nTo change, use !changePrefix",prefix).queue();
        break;
      case prefix + "changePrefix":
        break;
      default:
    }
  }
}
