package com.ruserious99.udemybot.commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Roles extends ListenerAdapter {

    //Roles command set for owner only
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        String[] args = e.getMessage().getContentRaw().split(" ");

        if (args[0].equals("!Roles")) {
            boolean members = e.getMessage().getMentionedMembers().isEmpty();
            if (!members) {
                Member member = e.getMessage().getMentionedMembers().get(0);
                Role role = e.getGuild().getRoleById(args[2]);
                if(role != null){
                    e.getGuild().addRoleToMember(member, role).queue();
                    e.getChannel().sendMessage("Role " + role.getAsMention() + " given to " + member.getUser().getName()).queue();
                }
            }
        }
    }
}
