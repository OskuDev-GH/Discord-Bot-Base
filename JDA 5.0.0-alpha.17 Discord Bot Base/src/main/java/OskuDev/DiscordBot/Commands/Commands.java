package OskuDev.DiscordBot.Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.io.*;

public class Commands extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (event.getName().equals("image")) {

            event.reply("Here: ").addFile(new File("C:\\Users\\YOUR USER HERE!\\OneDrive\\Pictures\\image.png")).queue();

        }

        if (event.getName().equals("say")) {

            OptionMapping messageOption =  event.getOption("message");
            event.reply(messageOption.getAsString()).queue();

        }

        if (event.getName().equals("userid")) {

            OptionMapping messageOption = event.getOption("user");
            event.reply(messageOption.getAsString()).queue();

        }

    }

}

