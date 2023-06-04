package me.dngynq.creative.player.command;

import me.dngynq.creative.player.data.PlayerItemStack;

/*    */ import java.io.File;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.GameMode;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.WorldCreator;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.potion.PotionEffect;

/*    */ public class build
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 27 */     Player p = (Player)sender;
/*    */     
/* 29 */     p.getActivePotionEffects().stream().map(PotionEffect::getType).forEach(effect -> p.removePotionEffect(effect));
/*    */ 
/*    */     
/* 32 */     if (p.getLocation().getWorld().getName().equals("worldsCoding" + File.separator + p.getName())) {
/* 33 */       WorldCreator lobby = new WorldCreator("worlds" + File.separator + p.getName());
/* 34 */       World lobbyData = Bukkit.createWorld(lobby);
/* 35 */       p.teleport(lobbyData.getSpawnLocation());
/* 36 */       p.setHealth(20.00);
/* 37 */       p.setFoodLevel(20);
/* 38 */       p.setGameMode(GameMode.CREATIVE);
				Inventory pinv = p.getInventory();
				pinv.clear();
				pinv.setItem(8, PlayerItemStack.item(Material.FERMENTED_SPIDER_EYE, "creative_world_item_name_settings", "creative_world_lore_settings"));
/*    */     }
/*    */     
/* 57 */     return false;
/*    */   }
/*    */ }