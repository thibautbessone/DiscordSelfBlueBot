package selfbot.commands.misc;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import selfbot.SelfBot;
import selfbot.utils.Command;

import java.awt.*;

/**
 * @file PollCommand.java
 * @author Blue
 * @version 0.1
 * @brief Creates a poll with user question
 */
public class PollCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(args.length == 0) {return false;}
        else return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        String query = new String();
        for (String arg : args) {
            query += arg + " ";
        }
        EmbedBuilder builder = new EmbedBuilder();
        builder.setColor(Color.decode(SelfBot.getConfig().getColor()));
        builder.setAuthor(event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator() + " created a poll", null, event.getAuthor().getAvatarUrl());
        builder.setThumbnail("http://i.imgur.com/pwVKRqD.png");
        builder.addField(":grey_question: Question :", query, false);

        event.getMessage().editMessage(builder.build()).queue();
        event.getMessage().addReaction("\uD83D\uDC4D").queue();
        event.getMessage().addReaction("\ud83d\udc4e").queue();
        event.getMessage().addReaction("\uD83E\uDD37").queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        if(!success) {
            event.getMessage().delete().queue();
        }
    }
}
