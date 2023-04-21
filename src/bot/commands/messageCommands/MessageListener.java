package bot.commands.messageCommands;

import bot.commands.messageCommands.eventsResponse.EventEmbedResponses;
import bot.commands.messageCommands.eventsResponse.MessageEventResponse;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageListener extends ListenerAdapter {
  private static final String prefix = "j!";
  public MessageListener(){}

  public static String getPrefix() {
    return prefix;
  }

  @Override
  public void onMessageReceived(@NotNull MessageReceivedEvent event) {
    EventEmbedResponses embedEvents = new EventEmbedResponses(event);
    MessageEventResponse dmEvents = new MessageEventResponse(event);
    switch(event.getMessage().getContentDisplay()){
      case prefix + "github":
        embedEvents.createGitHubEmbed();
        break;
      case prefix + "help":
        embedEvents.createHelpEmbed();
        break;
      case prefix + "help+":
//        event.getChannel().sendMessageFormat("O comando %shelp+ está em desenvolvimento! Por enquanto, utilize o %shelp", prefix, prefix).queue();
        dmEvents.helpResponse();
        break;
    }
  }
}
