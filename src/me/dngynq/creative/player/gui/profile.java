package me.dngynq.creative.player.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.dngynq.creative.core;




public class profile implements CommandExecutor, Listener {
	public static Inventory menu = Bukkit.createInventory(null, 27, ""); 
	
    public boolean onCommand(final CommandSender sender, final Command cmd, final String lbl, final String[] args) {
        final Player p = (Player)sender;
        		   
        ItemStack game = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta gameMeta = game.getItemMeta();
		gameMeta.setDisplayName("§3Wallet");
	    List<String> list2 = new ArrayList<String>();
	    list2.add("§f Donate/Донат:" + core.config().getString("userdata." + p.getName() + ".group"));
	    list2.add("§e Gold/Золото: §d" + core.config().getInt("userdata." + p.getName() + ".coins"));
	    list2.add("§7");
	    list2.add("§f Well/Курс: 1р = 3 gold");
		    gameMeta.setLore(list2);
		    game.setItemMeta(gameMeta);
		   menu.setItem(16, game);
    
        	p.openInventory(menu);
            
            return true;
        }
	
	@EventHandler
    public void inventoryClick(InventoryClickEvent e) {
        Inventory i = e.getInventory();
        if(i.equals(profile.menu)) {
        	e.setCancelled(true);       	      
        	}   
        }
        
}
