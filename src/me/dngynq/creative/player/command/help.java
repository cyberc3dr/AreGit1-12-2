package me.dngynq.creative.player.command;

import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;

public class help implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player)sender;
    if(p.isOp()) {
    	
    	if(args.length != 0) {
    	
    if(args[0].equals("AuthMe")) {
    	p.sendMessage(ChatColor.YELLOW + "---------" + ChatColor.WHITE + " Help: AuthMe " + ChatColor.YELLOW + "---------");
    	p.sendMessage(ChatColor.GOLD + "/r: " + ChatColor.WHITE + "Register cmd");
    	p.sendMessage(ChatColor.GOLD + "/reg: " + ChatColor.WHITE + "Register cmd");
    	p.sendMessage(ChatColor.GOLD + "/register: " + ChatColor.WHITE + "Register cmd");
    	p.sendMessage(ChatColor.GOLD + "/l: " + ChatColor.WHITE + "Register cmd");
    	p.sendMessage(ChatColor.GOLD + "/login: " + ChatColor.WHITE + "Register cmd");
    }
    if(args[0].equals("Creative")) {
    	p.sendMessage(ChatColor.YELLOW + "---------" + ChatColor.WHITE + " Help: Creatove " + ChatColor.YELLOW + "---------");
    	p.sendMessage(ChatColor.GOLD + "/mygames: " + ChatColor.WHITE + "Open you mygames menu");
    	p.sendMessage(ChatColor.GOLD + "/hub: " + ChatColor.WHITE + "Goto hub");
    	p.sendMessage(ChatColor.GOLD + "/loc: " + ChatColor.WHITE + "Change text");
    	p.sendMessage(ChatColor.GOLD + "/gm: " + ChatColor.WHITE + "World CMD");
    	p.sendMessage(ChatColor.GOLD + "/gamerule: " + ChatColor.WHITE + "World CMD");
    	p.sendMessage(ChatColor.GOLD + "/settings: " + ChatColor.WHITE + "World CMD");
    	p.sendMessage(ChatColor.GOLD + "/list: " + ChatColor.WHITE + "World list");
    	p.sendMessage(ChatColor.GOLD + "/dev: " + ChatColor.WHITE + "Open dev");
    	p.sendMessage(ChatColor.GOLD + "/locate: " + ChatColor.WHITE + "Player locate");
    	p.sendMessage(ChatColor.GOLD + "/build: " + ChatColor.WHITE + "Open build");
    }
    } else {
     p.sendMessage(ChatColor.YELLOW + "---------" + ChatColor.WHITE + " Help: Index (1/1) " + ChatColor.YELLOW + "---------");
 	p.sendMessage(ChatColor.GOLD + "Creative: " + ChatColor.WHITE + "All commands for Creative");
 	p.sendMessage(ChatColor.GOLD + "AuthMe: " + ChatColor.WHITE + "All commands for AuthMe");
    }
    }
    return false;
  }
}