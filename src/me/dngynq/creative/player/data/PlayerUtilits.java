package me.dngynq.creative.player.data;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.dngynq.creative.core;
import net.md_5.bungee.api.ChatColor;

public class PlayerUtilits implements Listener {

	public static void PlayerPrefix(Player p) {
		if(core.config().getString("userdata." + p.getName() + ".group").equals("default")) {
			prefixgive(p, ChatColor.GRAY + "+ " + ChatColor.WHITE + p.getName() + ChatColor.WHITE);
		}
		if(core.config().getString("userdata." + p.getName() + ".group").equals("lite")) {
			prefixgive(p, ChatColor.GREEN + "Lite " + ChatColor.WHITE + p.getName() + ChatColor.WHITE);
			}
		if(core.config().getString("userdata." + p.getName() + ".group").equals("vip")) {
			prefixgive(p, ChatColor.YELLOW + "Vip " + ChatColor.WHITE + p.getName() + ChatColor.WHITE);
			}
		if(core.config().getString("userdata." + p.getName() + ".group").equals("squat")) {
			prefixgive(p, ChatColor.BOLD + "Squat " + ChatColor.WHITE + p.getName() + ChatColor.WHITE);
			}
		if(core.config().getString("userdata." + p.getName() + ".group").equals("moder")) {
			prefixgive(p, ChatColor.BLUE + "[M] " + ChatColor.WHITE + p.getName() + ChatColor.WHITE);
			}
		if(core.config().getString("userdata." + p.getName() + ".group").equals("build")) {
			prefixgive(p, ChatColor.GOLD + "[B] " + ChatColor.WHITE + p.getName() + ChatColor.WHITE);
			}	
		if(core.config().getString("userdata." + p.getName() + ".group").equals("admin")) {
			prefixgive(p, ChatColor.RED + "[A] " + ChatColor.WHITE + p.getName() + ChatColor.WHITE);
			}
		if(core.config().contains("userdata." + p.getName() + ".prefix")) {
			prefixgive(p, core.config().getString("userdata." + p.getName() + ".prefix").replace("&", "§"));
		}
	}
	
	public static void prefixgive(Player p, String prefix) {
		      p.setDisplayName(prefix);
		      p.setPlayerListName(prefix);
	}
}

