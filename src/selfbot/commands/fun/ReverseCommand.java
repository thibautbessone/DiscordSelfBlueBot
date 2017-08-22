package selfbot.commands.fun;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import selfbot.utils.Command;

/**
 * @file ReverseCommand.java
 * @author Blue
 * @version 0.1
 * @brief Revert the given text
 */
public class ReverseCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(args.length == 0) {return false;}
        else return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        String text = new String();
        String reversed = new String("```");

        for(String arg : args) {
            text += arg + " ";
        }
        reversed = new StringBuilder(text).reverse().toString();
        event.getMessage().editMessage(reversed).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        if(!success) {
            event.getMessage().delete().queue();
        }
    }
}
