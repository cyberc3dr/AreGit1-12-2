/*    */ package me.dngynq.creative.player.world.cod;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.WorldBorder;
/*    */ import org.bukkit.WorldCreator;
/*    */ import org.bukkit.WorldType;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ 
/*    */ 
/*    */ public class CodingGen
/*    */   implements Listener
/*    */ {
/*    */   public static Inventory donatemenu;
/*    */   
/*    */   public static void flat(Player p) {
/* 21 */     p.closeInventory();
/* 22 */     p.sendTitle("", "Генерация..", 1, 8, 1);
/* 23 */     WorldCreator wc = new WorldCreator("worldsCoding" + File.separator + p.getName());
/* 24 */     wc.generateStructures(false);
/* 25 */     wc.type(WorldType.FLAT);
/* 26 */     wc.generator(new CodingChunkGenerator());
/* 27 */     World w = Bukkit.createWorld(wc);
/* 28 */     w.setGameRuleValue("doMobSpawning", "false");
/* 29 */     w.setGameRuleValue("doDaylightCycle", "false");
/* 30 */     w.setGameRuleValue("doWeatherCycle", "false");
/* 31 */     w.setGameRuleValue("keepInventory", "true");
/* 32 */     w.setSpawnLocation(45, 4, 43);
/* 33 */     WorldBorder wb = w.getWorldBorder();
/* 34 */     wb.setCenter(0.0D, 0.0D);
/* 35 */     wb.setSize(500.0D);
/* 36 */     generateCodingWorld(p, w.getName());
/*    */   }

/*    */   @SuppressWarnings("deprecation")

public static void generateCodingWorld(Player p, String worldName) {
/*    */     int z;
/* 40 */     for (z = -50; z < 46; z++) {
/* 41 */       z += 3;
/* 42 */       for (int x = -48; x < 46; x++) {
/* 43 */         x++;
/*    */         
/* 45 */         Bukkit.getWorld(worldName).getBlockAt(x, 0, z).setType(Material.STAINED_GLASS);
/* 46 */         Bukkit.getWorld(worldName).getBlockAt(x, 0, z).setData((byte)5);
/*    */       } 
/*    */     } 
/*    */     
/* 50 */     for (z = -50; z < 46; z++) {
/* 51 */       z += 3;
/* 52 */       Bukkit.getWorld(worldName).getBlockAt(45, 0, z).setType(Material.STAINED_GLASS);
/* 53 */       Bukkit.getWorld(worldName).getBlockAt(45, 0, z).setData((byte)14);
/*    */     } 
/*    */   }
/*    */ }