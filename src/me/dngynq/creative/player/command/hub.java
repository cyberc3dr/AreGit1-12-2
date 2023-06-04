package me.dngynq.creative.player.command;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;

public class hub implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        final Player p = (Player)sender;
        
        p.getActivePotionEffects().stream().map(PotionEffect::getType).forEach(effect -> p.removePotionEffect(effect));
        
        
        
        
	      WorldCreator lobby = new WorldCreator("world");
	      World lobbyData = Bukkit.createWorld(lobby);
	      p.teleport(lobbyData.getSpawnLocation());
	      p.setHealth(20);
	      p.setFoodLevel(20);
	      p.setGameMode(GameMode.ADVENTURE);
			Inventory pinv = p.getInventory();
			pinv.clear();
			pinv.setItem(6, me.dngynq.creative.player.data.PlayerItemStack.MyDev());
			pinv.setItem(2, me.dngynq.creative.player.data.PlayerItemStack.OurDevs());
			
        
        return false;
    }
    
}