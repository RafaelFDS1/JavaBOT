package bot.commands.messageRecievedResponse;

import net.dv8tion.jda.api.entities.EmbedType;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import java.time.OffsetDateTime;
import java.util.List;
import static bot.Main.*;

public class MessageEventResponse {
  private MessageReceivedEvent event = null;
  public MessageEventResponse(MessageReceivedEvent event){
    this.event = event;
  }
  public MessageReceivedEvent getEvent() {
    return this.event;
  }

  public void helpResponse(){
    this.event.getChannel().sendMessageFormat("Dá uma olhadinha no seu dm %s \uD83D\uDE09", this.event.getAuthor()).queue();
    this.event.getAuthor().openPrivateChannel().queue(channel -> {
      channel.sendMessage("Oi oi! Precisa de ajuda? Segue aqui tudo o que eu posso fazer!").queue();
      channel.sendMessageEmbeds(new MessageEmbed(
          null,
          "Precisa de uma ajuda mais detalhada?",
          "Então aqui vai tudo o que eu consigo fazer!",
          EmbedType.UNKNOWN,
          OffsetDateTime.now(),
          0x19f500,
          new MessageEmbed.Thumbnail(getLogin().getSelfUser().getAvatarUrl(),
              "", 0, 0),
          null,
          new MessageEmbed.AuthorInfo("JavaBOT", null, null, null),
          null,
          new MessageEmbed.Footer("Rafael Ferraz de Santana",
              "https://github.com/RafaelFDS1.png",
              "https://github.com/RafaelFDS1.png"),
          null,
          List.of(new MessageEmbed.Field(prefix + "github",
                  "Esse comando te recomenda seguir nosso mestre no nosso [github!](https://github.com/RafaelFDS1)",
                  false)
//              new MessageEmbed.Field(
//                  "Crie um JavaBOT pelo nosso Repositório!",
//                  "Faça você mesmo um JavaBOT!\n\nAcesse nosso repositório no github clicando [aqui](https://github.com/RafaelFDS1/JavaBOT)!.",
//                  false)))
          ))).queue();
      channel.sendMessage("Espero ter ajudado \uD83E\uDD17!\nLembra de ir lá no nosso github viu? \uD83D\uDE09 https://github.com/RafaelFDS1").queue();
    });
  }

}
