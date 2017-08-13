package selfbot.commands.fun;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import selfbot.utils.Command;

/**
 * @file LennyCommand.java
 * @author Blue
 * @version 0.1
 * @brief Edits the message with the Lenny face
 */
public class LennyCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(args.length != 0) {return false;}
        else return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getMessage().editMessage("( ͡° ͜ʖ ͡°)").queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        if(!success) {
            event.getMessage().delete().queue();
        }
    }
}
