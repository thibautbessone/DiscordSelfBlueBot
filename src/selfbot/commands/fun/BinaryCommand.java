package selfbot.commands.fun;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import selfbot.utils.Command;

import java.io.UnsupportedEncodingException;

/**
 * @file BinaryCommand.java
 * @author Blue
 * @version 0.1
 * @brief Write the given text as binary code (accents not working)
 */
public class BinaryCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(args.length == 0) {return false;}
        else return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        String text = new String();
        String binary = new String("```");

        for(String arg : args) {
            text += arg + " ";
        }

        text = text.replaceAll("\\s+$", "");
        byte[] bytes = null;
        try {
            byte[] infoBin = null;
            infoBin = text.getBytes("ISO-8859-1");
            for (byte b : infoBin) {
                String padded = Integer.toBinaryString(b);
                while (padded.length() < 8) {
                    padded = "0" + padded;
                }
                binary += padded + " ";
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            event.getMessage().editMessage(binary + "```").queue();
        } catch (IllegalStateException e) {
            event.getMessage().editMessage("Message too big to be posted.").queue();
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        if(!success) {
            event.getMessage().delete().queue();
        }
    }
}
