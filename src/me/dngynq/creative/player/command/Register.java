package me.dngynq.creative.player.command;

import me.dngynq.creative.core;

/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;


public class Register implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
     Player p = (Player)sender;
     
     if(core.config().getString("userdata." + p.getName() + ".reg").equals("true")) {
     p.sendMessage(core.get("you_have_acc"));
     } else {
    	if(args.length != 0) {
    		core.config().set("userdata." + p.getName() + ".reg", "true");
    		core.config().set("userdata." + p.getName() + ".pass", args[0]);
    		core.instance.saveConfig();
    		p.kickPlayer(core.get("reg_yes"));
    	} else {
    		p.sendMessage(core.get("register_help"));
    	}
     }
     
     return false;
   }
}