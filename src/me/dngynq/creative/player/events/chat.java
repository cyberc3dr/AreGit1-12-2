package me.dngynq.creative.player.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import me.dngynq.creative.core;

@SuppressWarnings("deprecation")
public class chat implements Listener {
	
	@EventHandler
	public void event(PlayerChatEvent e) {
		Player p = e.getPlayer();
	      if(core.config().getString("userdata." + p.getName() + ".auth").equals("false")) {
		      p.sendMessage(core.get("no_auth_msg"));
		      e.setCancelled(true);
	      }
	}
	


}
