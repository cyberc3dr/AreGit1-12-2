package me.dngynq.creative.player.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.Inventory;

import me.dngynq.creative.core;
import me.dngynq.creative.player.data.PlayerItemStack;




@SuppressWarnings("deprecation")
public class worldsettings implements CommandExecutor, Listener {
	public static Inventory menu = Bukkit.createInventory(null, 45, ""); 
	public int changename = 0;
	public String newworldname = "World";
	public String playerworldname = "";
	
    public boolean onCommand(final CommandSender sender, final Command cmd, final String lbl, final String[] args) {
        final Player p = (Player)sender;
        	playerworldname = p.getName();
		    menu.setItem(16, PlayerItemStack.item(Material.NAME_TAG, "creative_gui_change_world_name", "creative_gui_change_world_name_lore"));
        	menu.setItem(10, PlayerItemStack.item(Material.EMERALD_ORE, "creative_gui_gamemode", "creative_gui_gamemode_lore"));
        	menu.setItem(12, PlayerItemStack.item(Material.APPLE, "creative_gui_gamerule", "creative_gui_gamerule_lore"));
        	p.openInventory(menu);
        	
            return true;
        }
    
	@EventHandler
	public void event(PlayerChatEvent e) {
		Player p = e.getPlayer();
		if(p.getName().equals(playerworldname)) {
		if(changename == 1) {
		e.setCancelled(true);
		p.sendMessage(core.get("creative_change_world_name") + e.getMessage());
		core.config().set("userdata." + p.getName() + ".world.name", e.getMessage().replace("&", "§"));
		changename = 0;
		core.instance.saveConfig();
		} 
		}
	}
    
	@EventHandler
    public void inventoryClick(InventoryClickEvent e) {
        Inventory i = e.getInventory();
        Player p = (Player)e.getWhoClicked();
        
        if(i.equals(worldsettings.menu)) {
        	e.setCancelled(true);       	   
        	if(e.getSlot() == 16) {
        		p.sendMessage(core.get("creative_enter_world_name"));
        		p.closeInventory();
        		changename = 1;
        	}
        	}   
        }
        
}
