package com.ruserious99.udemybot;

import com.ruserious99.udemybot.commands.Roles;
import com.ruserious99.udemybot.listeners.MessageReceived;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {

    private static JDA jda;

    public static void main(String[] args) {

        JDABuilder jdaBuilder = JDABuilder.createDefault("");

        jdaBuilder.setStatus(OnlineStatus.IDLE);
        jdaBuilder.setActivity(Activity.watching("you"));
        jdaBuilder.addEventListeners(new MessageReceived());
        jdaBuilder.addEventListeners(new Roles());

        try {
            jda = jdaBuilder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public static JDA getJda() {
        return jda;
    }
}
