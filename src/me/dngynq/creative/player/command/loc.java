package me.dngynq.creative.player.command;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dngynq.creative.*;

public class loc implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        final Player p = (Player)sender;
        
        if(p.isOp()) {
        	String text = "";
        	if(args[0].equals("del")) {
        		p.sendMessage("Deleted.");
         		core.instance.localizationConfig.set(args[1], null);	
        	}
        	if(args[0].equals("set")) {
        		for(int i = 2; i < args.length; i++) {
        			text = text + args[i] + " ";
        		}
        		p.sendMessage(args[1] + ": " + text.replace("&", "§"));
        		core.instance.localizationConfig.set(args[1], text.replace("&", "§"));
        		
        		try {    
        			core.instance.localizationConfig.save(core.instance.localization); 
        	    } catch (Exception e) {     
        	        e.printStackTrace();    
        	    }
        		
        	}
        } else {
        	p.sendMessage(core.get("creative.msg.noright"));
        }
        
        return false;
    }
    
}