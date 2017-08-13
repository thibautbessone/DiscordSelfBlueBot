package selfbot.commands.misc;

import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import selfbot.SelfBot;
import selfbot.utils.Command;

/**
 * @file GameCommand.java
 * @author Blue
 * @version 0.1
 * @brief Changes your current game/activity
 */
public class GameCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(args.length == 0) {return false;}
        else return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        String text = new String();
        for(String arg : args) {
            text += arg + " ";
        }
        SelfBot.getJda().getPresence().setGame(Game.of(text));
        event.getMessage().editMessage("Current activity set to \"" + text + "\"").queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        if(!success) {
            event.getMessage().delete().queue();
        }
    }
}
