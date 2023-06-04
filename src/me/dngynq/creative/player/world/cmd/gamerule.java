package me.dngynq.creative.player.world.cmd;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dngynq.creative.*;

public class gamerule implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        final Player p = (Player)sender;
        
        if(!p.getWorld().getName().equals("world")) {
        String worldowner = p.getWorld().getName().substring(7);
        if(p.getName().equals(worldowner)) {
    		if(args.length == 0) {
    			p.sendMessage("announceAdvencements, disableElytraMoventCheck, doDaylightCycle, doEntityDrops, doFireTick, doLimitedCrafting, doMobLoot, doMobSpawning, doTileDrops, doWeatherCycle, keepInventory, maxEnityCramming, mobGriefing, naturalRegenration");
    		} else {   			
    			if(args.length == 2) {
    				p.getWorld().setGameRuleValue(args[0], args[1]);
    				p.sendMessage(core.get("creative_gamerule_updated") + args[0] + "= " + args[1]);
    			} else {
    			String data = p.getWorld().getGameRuleValue(args[0]);
    			p.sendMessage(core.get("creative_gamerule_type") + args[0] + " = " + data);
    			}
    		}

        } else {
        p.sendMessage(core.get("creative_it_not_you_world"));
        }
        } else {
        p.sendMessage(core.get("creative_it_not_you_world"));	
        }
        return false;
    }

    
}