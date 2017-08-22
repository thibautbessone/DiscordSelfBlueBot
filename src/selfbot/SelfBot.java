package selfbot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import selfbot.commands.fun.BinaryCommand;
import selfbot.commands.fun.IdgfCommand;
import selfbot.commands.infos.ServerCommand;
import selfbot.commands.misc.AvatarCommand;
import selfbot.commands.misc.GameCommand;
import selfbot.commands.infos.InfoCommand;
import selfbot.commands.fun.AsciiCommand;
import selfbot.commands.fun.LennyCommand;
import selfbot.commands.infos.WhoisCommand;
import selfbot.commands.misc.PollCommand;
import selfbot.utils.Command;
import selfbot.utils.CommandParser;
import selfbot.utils.LoadingProperties;
import selfbot.utils.listeners.CommandListener;

import javax.security.auth.login.LoginException;
import java.util.Map;
import java.util.TreeMap;

/**
 * @file SelfBot.java
 * @author Blue
 * @version 0.1
 * @brief Main class of the selfbot
 */
public class SelfBot {
    private static LoadingProperties config;
    private static String prefix;
    private static JDA jda;
    private static String clientID;
    private static String pwd;
    private static boolean avatarsRunning = false;
    public static Map<String, Command> commands = new TreeMap<String, Command>();
    public static final CommandParser parser = new CommandParser();

    public SelfBot() {
        config = new LoadingProperties();
        clientID = config.getClientID();
        prefix = config.getPrefix();
        pwd = config.getPwd();
        try {
            jda = new JDABuilder(AccountType.CLIENT).setToken(config.getToken()).buildBlocking();
            jda.addEventListener(new CommandListener());
            jda.getPresence().setGame(Game.of(config.getActivity()));
            System.out.println("\nSelfbot ready !");
        } catch (InterruptedException | LoginException | RateLimitedException e) {
            System.out.println("No internet connection or invalid or missing token. Please edit config.blue and try again.");
        }

        //Commands
        commands.put("lenny", new LennyCommand());
        commands.put("game", new GameCommand());
        commands.put("avatars", new AvatarCommand());
        commands.put("ascii", new AsciiCommand());
        commands.put("info", new InfoCommand());
        commands.put("whois", new WhoisCommand());
        commands.put("poll", new PollCommand());
        commands.put("server", new ServerCommand());
        commands.put("idgf", new IdgfCommand());
        commands.put("binary", new BinaryCommand());
    }

    public static void handleCommand(CommandParser.CommandContainer cmdContainer) {
        if(commands.containsKey(cmdContainer.invoke)) {
            boolean safe = commands.get(cmdContainer.invoke).called(cmdContainer.args, cmdContainer.event);
            if(safe) {
                commands.get(cmdContainer.invoke).action(cmdContainer.args, cmdContainer.event);
                commands.get(cmdContainer.invoke).executed(safe, cmdContainer.event);
            }
            else {
                commands.get(cmdContainer.invoke).executed(safe, cmdContainer.event);
            }
        }
    }

    public static String getPrefix() {
        return prefix;
    }
    public static JDA getJda() {
        return jda;
    }
    public static String getClientID() {
        return clientID;
    }
    public static String getPwd() {
        return pwd;
    }
    public static boolean isAvatarsRunning() {
        return avatarsRunning;
    }
    public static void setAvatarsRunning(boolean avatarsRunning) {
        SelfBot.avatarsRunning = avatarsRunning;
    }
    public static LoadingProperties getConfig() {
        return config;
    }

    public static void main(String[] args)
    {
        new SelfBot();
    }
}
