/*    */ package me.dngynq.creative.coding.event;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockBreak
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void br(BlockBreakEvent e) {
/* 18 */     Player p = e.getPlayer();
/*    */     
/* 21 */     if (p.getLocation().getWorld().getName().startsWith("worldsCoding")) {
/* 21 */       e.setCancelled(true);
/* 22 */       p.closeInventory();
/* 23 */       if (e.getBlock().getType().equals(Material.REDSTONE_BLOCK)) {
/* 24 */         e.setCancelled(false);
/* 25 */         int orex = e.getBlock().getX() - 1;
/*    */         
/* 27 */         Bukkit.getWorld(p.getWorld().getName()).getBlockAt(orex, e.getBlock().getY(), e.getBlock().getZ()).setType(Material.AIR);
/*    */       } 
/*    */       
/* 33 */       if (e.getBlock().getType().equals(Material.COBBLESTONE)) {
/* 34 */         e.setCancelled(false);
/* 35 */         int orex = e.getBlock().getX() - 1;
/* 36 */         Bukkit.getWorld(p.getWorld().getName()).getBlockAt(orex, e.getBlock().getY(), e.getBlock().getZ()).setType(Material.AIR);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\creative.jar!\creative\dngynq\coding\BlockBreak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */