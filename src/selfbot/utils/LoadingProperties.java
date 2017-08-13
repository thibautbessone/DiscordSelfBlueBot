package selfbot.utils;

import java.io.*;
import java.util.Properties;

/**
 * @file LoadingProperties.java
 * @author Blue
 * @version 0.1
 * @brief Loads a config file to launch the bot.
 */
public class LoadingProperties {

    private String token;
    private String clientID;
    private String prefix;
    private String activity;
    private String pwd;

    //Embed part for info command
    private String author;
    private String color;
    private String title;
    private String description;
    private String mainTextTitle;
    private String mainText;
    private String footer;

    public String getToken() {
        return token;
    }
    public String getClientID() {
        return clientID;
    }
    public String getPrefix() {
        return prefix;
    }
    public String getActivity() {
        return activity;
    }
    public String getPwd() {
        return pwd;
    }
    public String getAuthor() {
        return author;
    }
    public String getColor() {
        return color;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getMainTextTitle() {
        return mainTextTitle;
    }
    public String getMainText() {
        return mainText;
    }
    public String getFooter() {
        return footer;
    }

    public LoadingProperties() {
        try {
            File configFile = new File("config.self");
            FileInputStream fileInput = new FileInputStream(configFile);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

            token = properties.getProperty("token");
            clientID = properties.getProperty("clientID");
            prefix = properties.getProperty("prefix");
            activity = properties.getProperty("activity");
            pwd = properties.getProperty("pwd");
            author = properties.getProperty("author");
            color = properties.getProperty("color");
            title = properties.getProperty("title");
            description = properties.getProperty("description");
            mainTextTitle = properties.getProperty("mainTextTitle");
            mainText = properties.getProperty("mainText");
            footer = properties.getProperty("footer");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
