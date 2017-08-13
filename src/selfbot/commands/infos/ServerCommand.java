package selfbot.commands.infos;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import selfbot.SelfBot;
import selfbot.utils.Command;

import java.awt.*;
import java.time.format.DateTimeFormatter;

/**
 * @file ServerCommand.java
 * @author Blue
 * @version 0.1
 * @brief Gives info about the current server you are in
 */
public class ServerCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(args.length != 0) {return false;}
        else return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setAuthor("Server Info", null, "http://i.imgur.com/880AyL6.png");
        builder.setColor(Color.decode(SelfBot.getConfig().getColor()));
        builder.setThumbnail(event.getGuild().getIconUrl());
        builder.addField("Name", event.getGuild().getName(), true);
        builder.addBlankField(true);
        builder.addField("Owner", event.getGuild().getOwner().getUser().getName() + "#" + event.getGuild().getOwner().getUser().getDiscriminator() , true);
        builder.addField("Server ID", event.getGuild().getId(), true);
        builder.addField("Region", event.getGuild().getRegion().name(), true);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a");
        builder.addField("Creation Date", event.getGuild().getCreationTime().format(formatter), true);
        builder.addField("Total Members", String.valueOf(event.getGuild().getMembers().size()), true);
        int online = 0;
        for(Member member : event.getGuild().getMembers()) {
            if(!member.getOnlineStatus().equals(OnlineStatus.OFFLINE)) {
                ++online;
            }
        }
        builder.addField("Online Members", String.valueOf(online), true);

        event.getMessage().editMessage(builder.build()).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        if(!success) {
            event.getMessage().delete().queue();
        }
    }
}
