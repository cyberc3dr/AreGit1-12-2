/*    */ package me.dngynq.creative.player.events;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.dngynq.creative.core;
/*    */ 
/*    */ 
/*    */ public class PlayerCommand
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void CmdPrep(PlayerCommandPreprocessEvent e) {
/* 17 */     Player p = e.getPlayer();
/*    */     
/* 19 */     List<String> block = new ArrayList<String>();
/* 20 */     block.add("/minecraft:gamemode");
/* 21 */     block.add("/gamemode");
/* 22 */     block.add("/bukkit");
/* 23 */     block.add("/pl");
/* 24 */     block.add("/plugins");
/* 25 */     block.add("/?");
/* 26 */     block.add("/about");
/* 27 */     block.add("/timings");
/* 28 */     block.add("/ver");
/* 29 */     block.add("/version");
/* 30 */     block.add("/about");
			 block.add("/op");
			 block.add("/deop");
			 block.add("/ban");
			 block.add("/pardon");
			 block.add("/kick");
			 block.add("/stop");
			 block.add("/reload");
			 block.add("/ban-ip");
			 block.add("/pardon-ip");
			 block.add("/restart");
			 block.add("/fill");
			 block.add("/setblock");
			 block.add("/execute");
			 block.add("/kill");
			 block.add("/give");
			 block.add("/setworldspawn");
			 block.add("/whitelist");
			 block.add("/worldborder");
			 block.add("/summon");
			 block.add("/gm");
/*    */ 
/*    */    if(core.config().getString("userdata." + p.getName() + ".auth").equals("false")) {
/* 33 */     for (int i = 0; i < block.size(); i++) {
/* 34 */       if (e.getMessage().startsWith("" + block.get(i))) {
/* 35 */         e.setCancelled(true);
				p.sendMessage(core.get("no_auth_msg"));
/*    */       } 
			}
/*    */     } 
/*    */     
/*    */   }
/*    */ }


/* Location:              D:\creative.jar!\creative\dngynq\player\events\PlayerCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */