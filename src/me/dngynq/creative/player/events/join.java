package me.dngynq.creative.player.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

import me.dngynq.creative.core;
import net.md_5.bungee.api.ChatColor;

public class join implements Listener {
	
	@EventHandler
	public void event(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		String[] nick = p.getName().split(" ");
		nick = p.getName().split("	");
		if(!p.getName().equals(nick[0])) {
			p.kickPlayer(ChatColor.RED + "Your nickname contains invalid characters. Use a different nickname. Sorry ;(");
		}
		
		//e.setJoinMessage("");
		
		Inventory pinv = p.getInventory();
		pinv.clear();
		pinv.setItem(6, me.dngynq.creative.player.data.PlayerItemStack.MyDev());
		pinv.setItem(2, me.dngynq.creative.player.data.PlayerItemStack.OurDevs());
		
	      WorldCreator lobby = new WorldCreator("world");
	      World lobbyData = Bukkit.createWorld(lobby);
	      p.teleport(lobbyData.getSpawnLocation());
	      p.setHealth(20);
	      p.setFoodLevel(20);
	      p.setGameMode(GameMode.ADVENTURE);
	      
	      p.setDisplayName(ChatColor.DARK_GRAY + "? " + ChatColor.GRAY + p.getName() + ChatColor.WHITE);
	      p.setPlayerListName(ChatColor.DARK_GRAY + "? " + ChatColor.GRAY + p.getName() + ChatColor.WHITE);
	          
		if(!core.config().contains("userdata." + p.getName())) {
			core.config().set("userdata." + p.getName() + ".group", "default");
			core.config().set("userdata." + p.getName() + ".world.exist", false);
			core.config().set("userdata." + p.getName() + ".world.exist", false);
			core.config().set("userdata." + p.getName() + ".world.type", "build");
			core.config().set("userdata." + p.getName() + ".auth", "false");
			core.config().set("userdata." + p.getName() + ".reg", "false");
			core.config().set("userdata." + p.getName() + ".coins", 0);
		}
		core.config().set("userdata." + p.getName() + ".auth", "false");
		core.instance.saveConfig();
		

			
		
	      if(core.config().getString("userdata." + p.getName() + ".auth").equals("false")) {
		      p.sendMessage(core.get("pls_auth"));
	      }
	}

}
