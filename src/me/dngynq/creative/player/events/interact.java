package me.dngynq.creative.player.events;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import me.dngynq.creative.core;
import me.dngynq.creative.player.data.PlayerItemStack;

public class interact implements Listener {
	
	@EventHandler
	public void click(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getLocation().getWorld().getName().equals("world")) {
			if(e.getItem() == null) { 
			} else {
			if(e.getItem().getType().equals(Material.EMPTY_MAP)) {
			      if(core.config().getString("userdata." + p.getName() + ".auth").equals("false")) {
				      p.sendMessage(core.get("no_auth_msg"));
			      } else {
				p.performCommand("mygames");
			      }
				e.setCancelled(true);
			}
			if(e.getItem().getType().equals(Material.NOTE_BLOCK)) {
				p.performCommand("list");
				e.setCancelled(true);
			}
			}
		} else {
			if(e.getItem() == null) { 
			} else {
			if(e.getItem().getType().equals(Material.FERMENTED_SPIDER_EYE)) {
				if(e.getItem().equals(PlayerItemStack.item(Material.FERMENTED_SPIDER_EYE, "creative_world_item_name_settings", "creative_world_lore_settings"))) {
				p.performCommand("settings");
				e.setCancelled(true);
			}
			}
		}
		}
	}
}
