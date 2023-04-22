package bot.commands.slashInteractionsResponse;

import net.dv8tion.jda.api.entities.EmbedType;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;

import java.time.OffsetDateTime;
import java.util.List;

import static bot.Main.getLogin;
import static bot.Main.prefix;

public class GenericResponse {
  private SlashCommandInteractionEvent slashEvent;
  public GenericResponse(SlashCommandInteractionEvent event){
    this.slashEvent = event;
  }

  public void helpResponse(){
    this.slashEvent.reply("Everyone needs some help \uD83D\uDE09!").queue();
    this.slashEvent.getChannel().sendMessageEmbeds(new MessageEmbed(
        null,
        "Você precisa de um help?",
        "**Aqui estou!\n\nAbaixo vou listar todos os meus comandos!**",
        EmbedType.UNKNOWN,
        OffsetDateTime.now(),
        0x8ef79f,
        new MessageEmbed.Thumbnail(getLogin().getSelfUser().getAvatarUrl(), getLogin().getSelfUser().getAvatarUrl(), 0, 0),
        null,
        new MessageEmbed.AuthorInfo("JavaBOT", null,  getLogin().getSelfUser().getAvatarUrl(), getLogin().getSelfUser().getAvatarUrl()),
        null,
        new MessageEmbed.Footer("Rafael Ferraz de Santana",
            "https://github.com/RafaelFDS1.png",
            "https://github.com/RafaelFDS1.png"),
        null,
        List.of(new MessageEmbed.Field(prefix + "github",
                "Retorna todas as informações sobre o nosso github! Siga-nos para dar suporte no desenvolvimento!",
                false),
            new MessageEmbed.Field(
                prefix + "help",
                "Retorna essa mensagem com todas as informações que você precisa!",
                false),
            new MessageEmbed.Field(
                prefix + "help+",
                "Envia todas as informações sobre o bot no dm! (Em desenvolvimento)",
                false))
    )).queue();
  }
}
