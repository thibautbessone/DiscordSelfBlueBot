package selfbot.commands.fun;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import selfbot.utils.Command;

/**
 * Created by Thibaut on 13/08/2017.
 */
public class IdgfCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(args.length != 0) {return false;}
        else return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getMessage().editMessage("https://www.youtube.com/watch?v=vsa1ZvzFgvU");
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
