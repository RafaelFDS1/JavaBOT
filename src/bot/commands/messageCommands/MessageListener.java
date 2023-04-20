package bot.commands.messageCommands;

import bot.commands.messageCommands.eventsResponse.EventEmbedResponses;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageListener extends ListenerAdapter {
  private static final String prefix = "!";
  public MessageListener(){}
  @Override
  public void onMessageReceived(@NotNull MessageReceivedEvent event) {
    EventEmbedResponses events = new EventEmbedResponses(event);
    switch(event.getMessage().getContentDisplay()){
      case prefix + "github":
        events.createGitHubEmbed();
        break;
      case prefix + "help":
        break;
    }
  }
}
