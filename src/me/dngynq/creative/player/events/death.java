package me.dngynq.creative.player.events; 

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

 public class death implements Listener {
   @EventHandler
   public void onRespawn(PlayerRespawnEvent event) {
     event.setRespawnLocation(event.getPlayer().getWorld().getSpawnLocation());
   }
}