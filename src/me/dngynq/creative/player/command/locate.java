package me.dngynq.creative.player.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dngynq.creative.core;

public class locate implements CommandExecutor {

    @SuppressWarnings("static-access")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        final Player p = (Player)sender;
        if(args.length != 0) {
        	Player find = Bukkit.getPlayer(args[0]);
        	if(!find.getWorld().getName().equals("world")) {
        	p.sendMessage(args[0] + core.get("creative_msg_player_in_world") + core.instance.config().get("userdata." + find.getWorld().getName().substring(7) + ".world.name"));
        	} else {
        	p.sendMessage(args[0] + core.get("creative_msg_player_in_hub"));
        	}
        } else {
        	p.sendMessage(core.get("creative_syntex_error"));
        }
        return false;
    }
    
}