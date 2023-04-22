package bot.commands;

import bot.commands.eventsResponse.EventEmbedResponses;
import bot.commands.eventsResponse.MessageEventResponse;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static bot.Main.prefix;

public class EventListener extends ListenerAdapter {
  private EventEmbedResponses embedEvents = null;
  private MessageEventResponse dmEvents = null;
  public EventListener(){}
  @Override
  public void onMessageReceived(@NotNull MessageReceivedEvent event) {
    embedEvents = new EventEmbedResponses(event);
    dmEvents = new MessageEventResponse(event);
    switch (event.getMessage().getContentDisplay()) {
      case prefix + "github" -> embedEvents.createGitHubEmbed();
      case prefix + "help" -> embedEvents.createHelpEmbed();
      case prefix + "help+" -> dmEvents.helpResponse();
    }
  }

  @Override
  public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    switch(event.getName()) {
      case "help" -> event.reply("Wait a minute, I'll bring my help for you!").queue();
    }
  }
}
