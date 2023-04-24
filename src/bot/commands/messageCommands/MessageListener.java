package bot.commands.messageCommands;

import bot.commands.eventsResponse.EventEmbedResponses;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MessageListener extends ListenerAdapter {

  private static String prefix;

  public MessageListener(){}
  @Override
  public void onMessageReceived(@NotNull MessageReceivedEvent event) {
    EventEmbedResponses events = new EventEmbedResponses(event);
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
