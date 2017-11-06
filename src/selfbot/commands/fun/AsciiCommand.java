package selfbot.commands.fun;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import selfbot.utils.Command;
import java.io.IOException;


/*
 * @file AsciiCommand.java
 * @author Blue
 * @version 0.1
 * @brief Write the given text as ASCII art
*/

public class AsciiCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(args.length == 0) {return false;}
        else return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        String query = new String();
        for(String arg : args) {
            query += arg + "+ ";
            query = query.substring(0, query.length()-1);
        }
        OkHttpClient caller = new OkHttpClient();
        Request request = new Request.Builder().url("http://artii.herokuapp.com/make?text=" + query).build();
        try {
            Response response = caller.newCall(request).execute();
            event.getMessage().editMessage("```\n" + response.body().string() + "\n```").queue();
        } catch (IOException | NullPointerException e) {
            event.getMessage().editMessage("The artii.herokuapp.com API might be down at the moment").queue();
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
