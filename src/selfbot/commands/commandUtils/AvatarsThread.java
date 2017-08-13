package selfbot.commands.commandUtils;

import net.dv8tion.jda.core.entities.Icon;
import selfbot.SelfBot;

import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @file AvatarsThread.java
 * @author Blue
 * @version 0.1
 * @brief Thread to periodically change the avatar (every 6 mins - can't make it faster due to Discord rate limits)
 */
public class AvatarsThread extends Thread {

    private File folder = new File("img/avatars/");
    private ArrayList<String> filesList = new ArrayList<>();
    private int counter;
    private int i = 0;

    public void run() {
        try {
            counter = folder.listFiles().length;
            for (File file : folder.listFiles()) {
                if(file.getName().contains(".jpg")) {
                    filesList.add(folder.getName() + "/" + file.getName());
                }
            }
            Timer timer = new Timer ();
            TimerTask changeAvatarTask = new TimerTask () {
                @Override
                public void run () {
                    try {
                        File avatar = new File(filesList.get(i));
                        SelfBot.getJda().getSelfUser().getManager().setAvatar(Icon.from(avatar), SelfBot.getPwd()).queue();
                        if(i == counter) {i = 0;}
                        else {++i;}
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            timer.schedule(changeAvatarTask, 100, 1000*60*6);
        } catch (NullPointerException e) {
            e.printStackTrace();
            this.interrupt();
        }
    }
}
