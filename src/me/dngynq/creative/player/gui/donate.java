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




public class donate implements CommandExecutor, Listener {
	public static Inventory menu = Bukkit.createInventory(null, 27, ""); 
	
    public boolean onCommand(final CommandSender sender, final Command cmd, final String lbl, final String[] args) {
        final Player p = (Player)sender;
        
        
        ItemStack game1 = new ItemStack(Material.YELLOW_FLOWER);
        ItemMeta game1Meta = game1.getItemMeta();
		game1Meta.setDisplayName("§aLite");
	    List<String> list21 = new ArrayList<String>();
	    list21.add("§7");
	    list21.add("§7  Возможности:");
	    list21.add("§7    ");
	    list21.add("§7");
	    list21.add("§7  Прифекс в чате и табе:");
	    list21.add("§a        Lite §f" + p.getName());
	    list21.add("§7");
	    list21.add("§7 Цена: §a37 gold");
	    
	    
		    game1Meta.setLore(list21);
		    game1.setItemMeta(game1Meta);
		    menu.setItem(10, game1);
        
		    final ItemStack item = new ItemStack(Material.MELON);
		    final ItemMeta itemMeta = item.getItemMeta();
		    itemMeta.setDisplayName("§eVip");
		    final List<String> list = new ArrayList<String>();
		    list.add("§7 ");
		    list.add("§7");
		    list.add("§7  Прифекс в чате и табе:");
		    list.add("§e        VIP §f" + p.getName());
		    list.add("§7");
		    list.add("§7 Цена: §e~76 gold");
		    itemMeta.setLore(list);
		    item.setItemMeta(itemMeta);
		    menu.setItem(13, item);
		   
        ItemStack game = new ItemStack(Material.CARROT_ITEM);
        ItemMeta gameMeta = game.getItemMeta();
		gameMeta.setDisplayName("§3Squat");
	    List<String> list2 = new ArrayList<String>();
	    list2.add("§7");
	    list2.add("§7");
	    list2.add("§7  Прифекс в чате и табе:");
	    list2.add("§3        Squat §f" + p.getName());
	    list2.add("§7");
	    list2.add("§7 Цена: §3~137 gold");
		    gameMeta.setLore(list2);
		    game.setItemMeta(gameMeta);
		   menu.setItem(16, game);
    
        	p.openInventory(menu);
            
            return true;
        }
	
	@EventHandler
    public void inventoryClick(InventoryClickEvent e) {
        Inventory i = e.getInventory();
        Player p = (Player) e.getWhoClicked();
        if(i.equals(donate.menu)) {
        	e.setCancelled(true);      	      
        	if(e.getSlot() == 10) {
        		if(core.config().getInt("userdata." + p.getName() + ".coins") >= 37) {
        		int newBalance = core.config().getInt("userdata." + p.getName() + ".coins")-37;
        			core.config().set("userdata." + p.getName() + ".coins", newBalance);
        			p.sendMessage(core.get("yes_buy"));
        		} else {
        		p.sendMessage(core.get("you_dont_have_money"));
        		}
        	}
        	}   
        }
        
}
