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
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.potion.PotionEffect;

/*    */ public class dev
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/* 27 */     Player p = (Player)sender;
/*    */     
/* 29 */     p.getActivePotionEffects().stream().map(PotionEffect::getType).forEach(effect -> p.removePotionEffect(effect));
/*    */ 
/*    */     
/* 32 */     if (p.getLocation().getWorld().getName().equals("worlds" + File.separator + p.getName())) {
/* 33 */       WorldCreator lobby = new WorldCreator("worldsCoding" + File.separator + p.getName());
/* 34 */       World lobbyData = Bukkit.createWorld(lobby);
/* 35 */       p.teleport(lobbyData.getSpawnLocation());
/* 36 */       p.setHealth(20.00);
/* 37 */       p.setFoodLevel(20);
/* 38 */       p.setGameMode(GameMode.CREATIVE);
/* 39 */       inventory(p);
/*    */     }
/*    */     
/* 57 */     return false;
/*    */   }
 public void inventory(Player p) {
	 				PlayerInventory playerInventory = p.getInventory();
	 /* 40 */       playerInventory.clear();
	 /* 41 */       playerInventory.setItem(0, PlayerItemStack.item(Material.REDSTONE_BLOCK, "coding_item_name_trigger", "coding_item_lore_trigger"));
	 /* 42 */       playerInventory.setItem(1, PlayerItemStack.item(Material.COBBLESTONE, "coding_item_name_actions_1", "coding_item_lore_actions_1"));
 }
/*    */ }