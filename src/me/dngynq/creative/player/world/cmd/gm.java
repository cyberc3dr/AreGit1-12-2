package me.dngynq.creative.player.world.cmd;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dngynq.creative.*;
import net.md_5.bungee.api.ChatColor;

public class gm implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        final Player p = (Player)sender;
        
        if(!p.getWorld().getName().equals("world")) {
        String worldowner = p.getWorld().getName().substring(7);
        if(p.getName().equals(worldowner)) {
        	gmChanger(p, args);
        } else if(core.config().getString("userdata." + p.getName() + ".group").equals("admin")) {
        	gmChanger(p, args);
        } else {
        p.sendMessage(core.get("creative_it_not_you_world"));
        }
        } else {
        p.sendMessage(core.get("creative_it_not_you_world"));	
        }
        return false;
    }
    
    public static void gmChanger(Player p, String[] args) {
		if(args.length != 1) {
			Player p2 = Bukkit.getPlayer(args[1]);
			if(core.config().contains("userdata." + args[1])) {
			if(p2.isOnline()) {
				if(p2.getLocation().getWorld().equals(p.getLocation().getWorld())) {
					p.sendMessage(core.get("creative_msg_change_gamem_mode"));
					p2.sendMessage(core.get("creative_msg_change_gamem_mode_to"));
					if(args[0].equals("0")) {
    					p2.setGameMode(GameMode.SURVIVAL);
        			}
        			if(args[0].equals("1")) {
        				p2.setGameMode(GameMode.CREATIVE);
        			}
        			if(args[0].equals("2")) {
    					p2.setGameMode(GameMode.ADVENTURE);
        			}
        			if(args[0].equals("3")) {
        				p2.setGameMode(GameMode.SPECTATOR);
        			}
				} else {
					p.sendMessage(ChatColor.RED + "Player not exist");
				}
			} else {
				p.sendMessage(ChatColor.RED + "Player not exist");
			}
			} else {
				p.sendMessage(ChatColor.RED + "Player not exist");
			}
		} else {
			p.sendMessage(core.get("creative_msg_change_gamem_mode"));
			if(args[0].equals("0")) {
    			p.setGameMode(GameMode.SURVIVAL);
        	}
        	if(args[0].equals("1")) {
    			p.setGameMode(GameMode.CREATIVE);
        	}
        	if(args[0].equals("2")) {
    			p.setGameMode(GameMode.ADVENTURE);
        	}
        	if(args[0].equals("3")) {
    			p.setGameMode(GameMode.SPECTATOR);
        	}
		}
    }
}