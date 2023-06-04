package me.dngynq.creative.player.gui;

import java.io.File;
import java.util.List;

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

import me.dngynq.creative.core;
import me.dngynq.creative.delete;
import me.dngynq.creative.player.data.PlayerItemStack;




public class mygame implements CommandExecutor, Listener {
	public static Inventory menu = Bukkit.createInventory(null, 27, ""); 
	
    public boolean onCommand(final CommandSender sender, final Command cmd, final String lbl, final String[] args) {
        final Player p = (Player)sender;
        
        
	      if(core.config().getString("userdata." + p.getName() + ".auth").equals("false")) {
		      p.sendMessage(core.get("no_auth_msg"));
	      } else {
        if(!p.getWorld().getName().equals("world")) {
        	return false;
        }	
        
        if(!core.config().getBoolean("userdata." + p.getName() + "." + "world.exist")) {
   			   menu.setItem(10, PlayerItemStack.item(Material.GRASS, "creative_gui_name_flat", "creative_gui_lore_flat"));

    		   menu.setItem(13, PlayerItemStack.item(Material.GLASS, "creative_gui_name_empty", "creative_gui_lore_empty"));
    			   
    			   
    		   	
        } else {
        	menu.clear();
        	menu.setItem(13, PlayerItemStack.item(Material.LAVA_BUCKET, "creative_gui_deleteworld", "creative_gui_deleteworld_lore"));
        	menu.setItem(10, PlayerItemStack.item(Material.EMPTY_MAP, "creative_gui_my_world", "creative_gui_myworld_lore"));	
        	
        }
        
    
        	p.openInventory(menu);
	      }    
            return true;
        }
	
	@EventHandler
    public void inventoryClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        Inventory i = e.getInventory();
        if(i.equals(mygame.menu)) {
        	e.setCancelled(true);
        	
        	
            if(!core.config().getBoolean("userdata." + p.getName() + "." + "world.exist")) {
            	if(e.getSlot() == 10) {
            		me.dngynq.creative.player.world.cod.CodingGen.flat(p);
            		my.dngynq.creative.player.plotgen.flat.FlatdGen.flat(p);
            		
            	    Inventory pinv = p.getInventory();
            		pinv.clear();
            		 pinv.setItem(8, PlayerItemStack.item(Material.FERMENTED_SPIDER_EYE, "creative_world_item_name_settings", "creative_world_lore_settings"));
          	     
            		 WorldCreator lobby = new WorldCreator("worlds" + File.separator + p.getName());
        	      World lobbyData = Bukkit.createWorld(lobby);
        	      p.teleport(lobbyData.getSpawnLocation());
        	      p.setHealth(20);
        	      p.setFoodLevel(20);
        	      p.setGameMode(GameMode.CREATIVE);
        	   
        		
            	}
            } else {
            	
             if(e.getSlot() == 10) {
             	Inventory pinv = p.getInventory();
        		pinv.clear();
        		
        		pinv.setItem(8, PlayerItemStack.item(Material.FERMENTED_SPIDER_EYE, "creative_world_item_name_settings", "creative_world_lore_settings"));
         	      WorldCreator lobby = new WorldCreator("worlds" + File.separator + p.getName());
       	      World lobbyData = Bukkit.createWorld(lobby);
       	      p.teleport(lobbyData.getSpawnLocation());
       	      p.setHealth(20);
       	      p.setFoodLevel(20);
       	      p.setGameMode(GameMode.CREATIVE);
             }
             
             if(e.getSlot() == 13) {
            	 
            	 
         		WorldCreator wc = new WorldCreator("worlds" + File.separator + p.getName());
        	      World worldz = Bukkit.createWorld(wc);
  	            List<Player> playersList = (List<Player>)worldz.getPlayers();
	  	            for (int v = 0; v < playersList.size(); ++v) {
	  	                Player pz = playersList.get(v);
	  	                	pz.performCommand("hub");
  	            }
	  	            
	         		WorldCreator wc2 = new WorldCreator("worldsCoding" + File.separator + p.getName());
	        	      World worldz2 = Bukkit.createWorld(wc2);
	  	            List<Player> playersList2 = (List<Player>)worldz2.getPlayers();
		  	            for (int v = 0; v < playersList2.size(); ++v) {
		  	                Player pz2 = playersList2.get(v);
		  	                	pz2.performCommand("hub");
	  	            }
            	 core.config().set("userdata." + p.getName() + ".world.exist", false);
            	 core.instance.saveConfig();
                 Bukkit.unloadWorld("worlds" + File.separator + p.getName(), false);
                 File worldFolder = new File(Bukkit.getWorldContainer() + File.separator + "worlds" + File.separator + p.getName());
                 delete.usage(worldFolder);
                 
                 Bukkit.unloadWorld("worldsCoding" + File.separator + p.getName(), false);
                 File worldFolder2 = new File(Bukkit.getWorldContainer() + File.separator + "worldsCoding" + File.separator + p.getName());
                 delete.usage(worldFolder2);
                 p.sendTitle("", "Мир удалён.", 1 , 8 , 1);
                 p.closeInventory();
             }
             
            }
        	      
        	}   
        }
        
}
