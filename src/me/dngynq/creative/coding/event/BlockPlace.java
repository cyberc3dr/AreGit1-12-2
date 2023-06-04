/*    */ package me.dngynq.creative.coding.event;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockPlaceEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockPlace
/*    */   implements Listener
/*    */ {
@SuppressWarnings("deprecation")
/*    */   @EventHandler
/*    */   public void place(BlockPlaceEvent e) {
/* 19 */     Player p = e.getPlayer();
/*    */     
/* 21 */     if (p.getLocation().getWorld().getName().startsWith("worldsCoding")) {
/* 22 */       e.setCancelled(true);
/*    */ 
/*    */ 
/*    */       
/* 26 */       if (e.getBlockPlaced().getType().equals(Material.REDSTONE_BLOCK) && e.getBlockAgainst().getType().equals(Material.STAINED_GLASS) && e.getBlockAgainst().getData() == 14) {
/* 29 */         e.setCancelled(false);
/* 30 */         int orex = e.getBlock().getX() - 1;
/* 31 */         Bukkit.getWorld(p.getWorld().getName()).getBlockAt(orex, e.getBlock().getY(), e.getBlock().getZ()).setType(Material.REDSTONE_ORE);
/*    */       } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 44 */       if (e.getBlockPlaced().getType().equals(Material.COBBLESTONE) && e.getBlockAgainst().getType().equals(Material.STAINED_GLASS) && e.getBlockAgainst().getData() == 5) {
/* 47 */         e.setCancelled(false);
/* 48 */         int orex = e.getBlock().getX() - 1;
/* 49 */         Bukkit.getWorld(p.getWorld().getName()).getBlockAt(orex, e.getBlock().getY(), e.getBlock().getZ()).setType(Material.STONE);
/*    */         
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\creative.jar!\creative\dngynq\coding\BlockPlace.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */