package bot.commands.messageRecievedResponse;

import net.dv8tion.jda.api.entities.EmbedType;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.time.OffsetDateTime;
import java.util.List;
import static bot.Main.getLogin;
import static bot.Main.prefix;

public class GuildMessageResponse {
  private MessageReceivedEvent messageReceivedEvent = null;
  public GuildMessageResponse(MessageReceivedEvent event){
    this.messageReceivedEvent = event;
  }
  public MessageReceivedEvent getEvent() {
    return this.messageReceivedEvent;
  }

  public void createGitHubEmbed() {
    this.messageReceivedEvent.getChannel().sendMessageEmbeds(new MessageEmbed(
        "https://github.com/RafaelFDS1",
        "Nosso Github!",
        "Siga o nosso mestre **Rafael F.** no Github!",
        EmbedType.UNKNOWN,
        OffsetDateTime.now(),
        0x19f500,
        new MessageEmbed.Thumbnail("https://github.com/RafaelFDS1.png",
            "https://github.com/RafaelFDS1.png", 0, 0),
        null,
        new MessageEmbed.AuthorInfo("JavaBOT", null, null, null),
        null,
        new MessageEmbed.Footer("Rafael Ferraz de Santana",
            "https://github.com/RafaelFDS1.png",
            "https://github.com/RafaelFDS1.png"),
        null,
        List.of(new MessageEmbed.Field("Github!",
                "Clique no [link](https://github.com/RafaelFDS1) para ser direcionado ao nosso github!",
                false),
            new MessageEmbed.Field(
                "Crie um JavaBOT pelo nosso Repositório!",
                "Faça você mesmo um JavaBOT!\n\nAcesse nosso repositório no github clicando [aqui](https://github.com/RafaelFDS1/JavaBOT)!.",
                false))
    )).queue();
  }
  public void createHelpEmbed(){
    this.messageReceivedEvent.getChannel().sendMessageEmbeds(new MessageEmbed(
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
                "Retorna essa mesnagem com todas as informações que você precisa!",
                false),
            new MessageEmbed.Field(
                prefix + "help+",
                "Envia todas as informações sobre o bot no dm! (Em desenvolvimento)",
                false))
    )).queue();
    this.messageReceivedEvent.getChannel().sendMessageFormat("Espero ter ajudado %s \uD83E\uDD17", this.messageReceivedEvent.getMember()).queue();
  }
}
