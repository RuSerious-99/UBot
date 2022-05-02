package com.ruserious99.udemybot.listeners;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageReceived extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        Member member;
        String name = e.getAuthor().getName();
        String message = e.getMessage().getContentRaw();
        String[] args = e.getMessage().getContentRaw().split(" ");

        if (message.equalsIgnoreCase("hello") && !e.getAuthor().isBot()) {
            e.getChannel().sendMessage("Hello " + name).queue();
        } else {
            if (args[0].equals("!mention")) {
                boolean members = e.getMessage().getMentionedMembers().isEmpty();
                if (!members) {
                    member = e.getMessage().getMentionedMembers().get(0);
                    if (!member.getUser().isBot()) {
                        e.getChannel().sendMessage("Successfully mentioned " + member.getUser().getAsMention()).queue();
                    } else {
                        e.getChannel().sendMessage("Sorry, I cant mention a Bot").queue();
                    }
                }else{
                    e.getChannel().sendMessage("Unsuccessfully mentioned").queue();
                }
            }
        }
    }
}


