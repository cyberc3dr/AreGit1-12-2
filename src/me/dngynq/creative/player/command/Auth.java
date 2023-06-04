package me.dngynq.creative.player.command;

import me.dngynq.creative.core;

/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;


public class Auth implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
     Player p = (Player)sender;
     
     if(core.config().getString("userdata." + p.getName() + ".reg").equals("false")) {
     p.sendMessage(core.get("you_dont_have_acc"));
     } else {
    	if(args.length != 0) {
    	if(args[0].equals(core.config().get("userdata." + p.getName() + ".pass"))) {
    		p.sendMessage(core.get("auth_yes"));
    		me.dngynq.creative.player.data.PlayerUtilits.PlayerPrefix(p);
    		core.config().set("userdata." + p.getName() + ".auth", "true");
    	} else {
    	    p.sendMessage(core.get("auth_no"));
    	}
    	} else {
    		p.sendMessage(core.get("auth_help"));
    	}
     }
     
     return false;
   }
}