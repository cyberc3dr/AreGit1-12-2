package me.dngynq.creative.player.data;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.dngynq.creative.core;
import net.md_5.bungee.api.ChatColor;

public class PlayerItemStack implements Listener {

	public static ItemStack item(Material a, String dataName, String dataLore) {
	    final ItemStack item = new ItemStack(a);
	    final ItemMeta itemMeta = item.getItemMeta();
	    if(core.instance.localizationConfig.contains(dataName)) {
	        itemMeta.setDisplayName(ChatColor.WHITE + core.instance.localizationConfig.getString(dataName));
	        } else {
	            itemMeta.setDisplayName(ChatColor.WHITE + dataName);
	        }
	    final List<String> list = new ArrayList<String>();	
	    if(core.instance.localizationConfig.contains(dataLore)) {
	    list.add(ChatColor.WHITE + core.instance.localizationConfig.getString(dataLore));
	    } else {
	    	list.add(dataLore);
	    }
	    itemMeta.setLore(list);   
	    item.setItemMeta(itemMeta);
	    return item;
	}
	
	public static ItemStack name(Material a, String dataName, String lore) {
	    final ItemStack item = new ItemStack(a);
	    final ItemMeta itemMeta = item.getItemMeta();
	        itemMeta.setDisplayName(ChatColor.WHITE + dataName);
	    item.setItemMeta(itemMeta);
	    List<String> list = new ArrayList<String>();
	    list.add(lore);
	    itemMeta.setLore(list); 
	    item.setItemMeta(itemMeta);
	    return item;
	}
	
	public static ItemStack MyDev() {
	    final ItemStack item = new ItemStack(Material.EMPTY_MAP);
	    final ItemMeta itemMeta = item.getItemMeta();
	    itemMeta.setDisplayName("§EВаши режимы.");
	    item.setItemMeta(itemMeta);
	    return item;
	}
	
	public static ItemStack OurDevs() {
	    final ItemStack item = new ItemStack(Material.NOTE_BLOCK);
	    final ItemMeta itemMeta = item.getItemMeta();
	    itemMeta.setDisplayName("§3Список режимов.");
	    item.setItemMeta(itemMeta);
	    return item;
	}
}

