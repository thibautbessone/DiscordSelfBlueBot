package selfbot.commands.infos;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import selfbot.SelfBot;
import selfbot.utils.Command;

import java.awt.*;

/**
 * @file InfoCommand.java
 * @author Blue
 * @version 0.1
 * @brief Gives info about yourself
 */
public class InfoCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(args.length != 0) {return false;}
        else return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setAuthor("Information about " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator(), null, "http://i.imgur.com/880AyL6.png");
        builder.setColor(Color.decode(SelfBot.getConfig().getColor()));
        builder.setThumbnail(event.getAuthor().getAvatarUrl());
        builder.setTitle(SelfBot.getConfig().getTitle());
        builder.setDescription(SelfBot.getConfig().getDescription());
        builder.addField(SelfBot.getConfig().getMainTextTitle(), SelfBot.getConfig().getMainText(), false);
        builder.setFooter(SelfBot.getConfig().getFooter(), null);

        event.getMessage().editMessage(builder.build()).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        if(!success) {
            event.getMessage().delete().queue();
        }
    }
}
