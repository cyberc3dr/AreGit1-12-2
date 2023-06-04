package me.dngynq.creative;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class core extends JavaPlugin implements Listener {
    public static core instance;
    private static FileConfiguration configuration;
    public File localization = new File(getDataFolder() + File.separator + "localization.yml");
    public FileConfiguration localizationConfig = YamlConfiguration.loadConfiguration(localization);
	
	public void register(String type, Object o, String name) {
		if(type=="class") {
		getLogger().info("Completed registration Class: " + o.getClass().getName());
		 Bukkit.getPluginManager().registerEvents((Listener) o, this);
		}
		if(type=="cmd") {
		getLogger().info("Completed registration Command: " + name);
		getCommand(name).setExecutor((CommandExecutor) o);	
		}
		if(type=="menu") {
		Bukkit.getPluginManager().registerEvents((Listener) o, this);
		getLogger().info("Completed registration GUI-menu: " + name);
		getCommand(name).setExecutor((CommandExecutor) o);	
		}
	}
	
	@Override
	public void onEnable() {
	configuration = getConfig();
	core.instance = this;
    File config = new File(getDataFolder() + File.separator + "config.yml");
    if (!config.exists()) {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    } 
    register("class", new me.dngynq.creative.player.events.join(), null);
    register("class", new me.dngynq.creative.player.events.interact(), null);
    register("class", new me.dngynq.creative.player.events.death(), null);
    register("class", new me.dngynq.creative.coding.event.BlockBreak(), null);
    register("class", new me.dngynq.creative.coding.event.BlockPlace(), null);
    register("class", new me.dngynq.creative.player.events.chat(), null);
    register("class", new me.dngynq.creative.player.events.PlayerCommand(), null);
    
    register("menu", new me.dngynq.creative.player.gui.profile(), "profile");
    register("menu", new me.dngynq.creative.player.gui.donate(), "donate");
    register("menu", new me.dngynq.creative.player.gui.mygame(), "mygames");
    register("menu", new me.dngynq.creative.player.gui.worldsettings(), "settings");
    register("menu", new me.dngynq.creative.player.gui.WorldList(), "list");
    
    register("cmd", new me.dngynq.creative.player.command.hub(), "hub");
    register("cmd", new me.dngynq.creative.player.command.dev(), "dev");
    register("cmd", new me.dngynq.creative.player.command.loc(), "loc");
    register("cmd", new me.dngynq.creative.player.command.locate(), "locate");
    register("cmd", new me.dngynq.creative.player.world.cmd.gm(), "gm");
    register("cmd", new me.dngynq.creative.player.command.help(), "help");
    
    register("cmd", new me.dngynq.creative.player.command.Register(), "r");
    register("cmd", new me.dngynq.creative.player.command.Register(), "reg");
    register("cmd", new me.dngynq.creative.player.command.Register(), "register");
    
    register("cmd", new me.dngynq.creative.player.command.Auth(), "l");
    register("cmd", new me.dngynq.creative.player.command.Auth(), "login");
    
    register("cmd", new me.dngynq.creative.player.world.cmd.gamerule(), "gamerule");
    register("cmd", new me.dngynq.creative.player.command.build(), "build");
	getLogger().info("1.2");
	}
	
    public static String get(String msg) {
    	String text = "";
    	if(core.instance.localizationConfig.contains(msg)) {
    	text = core.instance.localizationConfig.getString(msg);
    	} else {
    	text = msg;
    	}
    	return text;
   }

	public static FileConfiguration config() {
		return configuration;
	}
	
	
}
