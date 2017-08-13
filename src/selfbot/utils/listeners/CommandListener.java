package selfbot.utils.listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import selfbot.SelfBot;

/**
 * @file CommandListener.java
 * @author Blue
 * @version 0.1
 * @brief Listen to commands
 */
public class CommandListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().getId().equals(SelfBot.getClientID())) {
            if(event.getMessage().getContent().startsWith(SelfBot.getPrefix())) {
                SelfBot.handleCommand(SelfBot.parser.parse(event.getMessage().getContent(), event));
            }
        }
    }

}
