 package me.dngynq.creative.player.gui;
 
 import me.dngynq.creative.core;
 import me.dngynq.creative.player.data.PlayerItemStack;

import java.io.File;

import org.bukkit.Bukkit;
 import org.bukkit.GameMode;
 import org.bukkit.Material;
 import org.bukkit.World;
 import org.bukkit.WorldCreator;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.inventory.InventoryClickEvent;
 import org.bukkit.inventory.Inventory;
 
 
 
 
 public class WorldList
   implements CommandExecutor, Listener
 {
   public static Inventory menu = Bukkit.createInventory(null, 45, "");
   
   public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
     Player p = (Player)sender;
     
     if (!p.getWorld().getName().equals("world"));
     menu.clear();
     
     for (int i = 0; i < Bukkit.getWorlds().size(); i++) {
       if (!((World)Bukkit.getWorlds().get(i)).getName().equals("world") && (
         (World)Bukkit.getWorlds().get(i)).getPlayers().size() >= 1 && 
         !((World)Bukkit.getWorlds().get(i)).getName().startsWith("worldsCoding"))
       {
    	   if(core.instance.getConfig().getString("userdata." + p.getName() + ".world.type").equals("build")) {
         menu.addItem(PlayerItemStack.name(Material.GLASS, core.instance.getConfig().getString("userdata." + ((World)Bukkit.getWorlds().get(i)).getName().substring(7) + ".world.name"), "§fВладелец мира: §d" + ((World)Bukkit.getWorlds().get(i)).getName().substring(7)));
    	   } else {
    	 menu.addItem(PlayerItemStack.name(Material.REDSTONE_ORE, core.instance.getConfig().getString("userdata." + ((World)Bukkit.getWorlds().get(i)).getName().substring(7) + ".world.name"), "§fВладелец мира: §d" + ((World)Bukkit.getWorlds().get(i)).getName().substring(7)));   
    	   }
    	   }
     } 
 
 
 
 
     
     p.openInventory(menu);
     
     return true;
   }
   
   @EventHandler
   public void inventoryClick(InventoryClickEvent e) {
     Player p = (Player)e.getWhoClicked();
     Inventory i = e.getInventory();
     if (i.equals(menu)) {
       e.setCancelled(true);
       if(!e.getCurrentItem().getType().equals(Material.AIR)) {  
	  WorldCreator lobby = new WorldCreator("worlds" + File.separator + e.getCurrentItem().getItemMeta().getLore().get(0).substring(19));
      World lobbyData = Bukkit.createWorld(lobby);
      p.teleport(lobbyData.getSpawnLocation());
      p.setHealth(20);
      p.setFoodLevel(20);
      Inventory pinv = p.getInventory();
		pinv.clear();
      if(!p.getName().equals(e.getCurrentItem().getItemMeta().getLore().get(0).substring(19))) {
      p.setGameMode(GameMode.ADVENTURE);
      } else {
      p.setGameMode(GameMode.CREATIVE);	  
      pinv.setItem(8, PlayerItemStack.item(Material.FERMENTED_SPIDER_EYE, "creative_world_item_name_settings", "creative_world_lore_settings"));
      }
      }
     } 
   }
 }