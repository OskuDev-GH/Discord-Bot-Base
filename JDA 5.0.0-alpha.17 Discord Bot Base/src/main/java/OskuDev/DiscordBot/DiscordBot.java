package OskuDev.DiscordBot;

import OskuDev.DiscordBot.Commands.Commands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import javax.security.auth.login.LoginException;

public class DiscordBot {

    public static void main(String[] args) throws LoginException, InterruptedException {

        JDA jda = JDABuilder
                .createDefault("your token here.")
                .setActivity(Activity.watching("OskuDevs profile on GitHub."))
                .addEventListeners(new Commands())
                .build().awaitReady();

        Guild guild = jda.getGuildById("your servers guild id");

        if (guild != null) {

            guild.upsertCommand("image", "Ask DiscordBot to send a picture").queue();

            OptionData sayMsg = new OptionData(OptionType.STRING, "message", "The message that you want DiscordBot to say", true);
            guild.upsertCommand("say", "Ask DiscordBot to say something").addOptions(sayMsg).queue();

            OptionData useridMsg = new OptionData(OptionType.USER, "user", "The name that you want DiscordBot to say", true);
            guild.upsertCommand("userid", "Ask DiscordBot to get someones user id").addOptions(useridMsg).queue();

        }

    }

}