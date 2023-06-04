package my.dngynq.creative.player.plotgen.flat;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import me.dngynq.creative.core;


public class FlatdGen implements Listener {
  public static Inventory donatemenu;
   
	  
         public static void flat(Player p) {
             p.closeInventory();
             p.sendTitle("", "Генерация мира..", 1, 8, 1);
             final WorldCreator wc = new WorldCreator( "worlds" + File.separator + p.getName());
             wc.generateStructures(false);
             wc.type(WorldType.FLAT);
             wc.generator(new FlatChunkGenerator());
             final World w = Bukkit.createWorld(wc);
             w.setGameRuleValue("doMobSpawning", "false");
             w.setGameRuleValue("doDaylightCycle", "false");
             w.setGameRuleValue("doWeatherCycle", "false");
             w.setGameRuleValue("keepInventory", "true");
             w.setSpawnLocation(0, 4, 0);
             final WorldBorder wb = w.getWorldBorder();
             wb.setCenter(0.0, 0.0);
             wb.setSize(96.0);
             
     		core.config().set("userdata." + p.getName() + ".world.join", true);
    		core.config().set("userdata." + p.getName() + ".world.exist", true);
    		core.config().set("userdata." + p.getName() + ".world.static", 0);
    		core.config().set("userdata." + p.getName() + ".world.name", "World of " + p.getName());
    		core.instance.saveConfig();
         }
}
