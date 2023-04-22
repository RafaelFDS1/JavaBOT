package bot.commands;

import bot.commands.messageRecievedResponse.GuildMessageResponse;
import bot.commands.messageRecievedResponse.MessageEventResponse;
import bot.commands.slashInteractionsResponse.GenericResponse;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static bot.Main.prefix;

public class EventListener extends ListenerAdapter {
  public EventListener(){}
  @Override
  public void onMessageReceived(@NotNull MessageReceivedEvent event) {
    GuildMessageResponse embedEvents = new GuildMessageResponse(event);
    MessageEventResponse dmEvents = new MessageEventResponse(event);
    switch (event.getMessage().getContentDisplay()) {
      case prefix + "github" -> embedEvents.createGitHubEmbed();
      case prefix + "help" -> embedEvents.createHelpEmbed();
      case prefix + "help+" -> dmEvents.helpResponse();
    }
  }

  @Override
  public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    GenericResponse embedEvent = new GenericResponse(event);
    switch(event.getName()) {
      case "help" -> embedEvent.helpResponse();
    }
  }
}
