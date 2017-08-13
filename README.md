# Blue's SelfBot

This is a Discord Selfbot written in Java using the [JDA library](https://github.com/DV8FromTheWorld/JDA).
<br>It's really easy to install, run and customize.

## Commands :
* Change periodically your avatar ! (every 6 mins, Discord rate limit). To add your avatars, open the img/avatars folder and place your files starting to 0.jpg to ....jpg. The command will set all the avatars in numerous order.
* Post ASCII art without effort & ( ͡° ͜ʖ ͡°)
* Manually edit your activity (only visible for others, not for you)
* Create quick reaction-based polls !
* Quickly get info on servers / users
* More to come soon ! (for example, personal soundboard is in development)

This project shares a good part of its code with [BlueBot](https://github.com/thibautbessone/DiscordBlueBot) - feel free to check it out !

## Setup
* Get the latest release from the releases page (not available yet)
* Find your user token : in Discord, press Ctrl+Maj+I. Go to the Application tab, then Storage > LocalStorage > discordapp.com.Find the `token` row and get the value between the quotes.
<br>⚠ **NEVER SHARE THIS TOKEN** as it provides complete access to your Discord account. 
* Replace YOURTOKENHERE by this token
* Replace YOURIDHERE by your Discord ID
* replace YOURPASSWORDHERE by your Discord password (it is used to change your avatar by the `/avatars` command).
* Customize your prefix / activity if you want to
* Edit your personal info as you want (`\n` for new line)


## License

This project is realeased under the MIT License.

## Notes 

Selfbot aren't officially supported by Discord, and there are some semi-official rules :
* **A selfbot must not, under any circumstance, respond to other user's messages. This means it should not respond to commands, should not autoreply to certain keywords, etc. You must be the only one that can control it.**
* **A selfbot must not, under any circumstance, do "invite scraping". This is the action of detecting server invites in chat, and automatically joining a server using that invite.**
* **As selfbots run under your account they are subject to the same Terms of Service. Meaning they should not spam, insult or demean others, post NSFW material, spread viruses or illegal material, etc. They have to follow the same rules that you follow.**

Rules source : [TheRacingLion](https://github.com/TheRacingLion/Discord-SelfBot#rules)