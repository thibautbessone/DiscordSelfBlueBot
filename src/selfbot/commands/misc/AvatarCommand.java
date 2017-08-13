package selfbot.commands.misc;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import selfbot.SelfBot;
import selfbot.commands.commandUtils.AvatarsThread;
import selfbot.utils.Command;

/**
 * @file AvatarCommand.java
 * @author Blue
 * @version 0.1
 * @brief Changes your current game/activity
 */
public class AvatarCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(args.length != 0) {return false;}
        else return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (!SelfBot.isAvatarsRunning()) {
            AvatarsThread thread = new AvatarsThread();
            thread.run();
            SelfBot.setAvatarsRunning(true);
            event.getMessage().editMessage("Avatars thread started.").queue();
        } else {
            event.getMessage().editMessage("Avatars thread already running.").queue();
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        if(!success) {
            event.getMessage().delete().queue();
        }
    }
}
