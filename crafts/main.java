package me.reparo.crafts;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.reparo.crafts.commands.craft;
import me.reparo.crafts.commands.craftadmin;
import me.reparo.crafts.eventsgui.SelectGUI;
import me.reparo.crafts.eventsgui.join;

public class main extends JavaPlugin {
	
	static main instance;
	
	public void onEnable() {
		instance = this;
		File file = new File(this.getDataFolder() + File.separator + "Data");
		if(!file.exists()){
			file.mkdirs();	
		}
		registerGUIs();
		registerEvents();
		registerCommands();
	}
	public void onDisable(){
		instance = null;
	}
	public static main getInstance() {
		return instance;
	}
	  private void registerCommands() {
		  getCommand("craft").setExecutor(new craft(this));
		  getCommand("craftadmin").setExecutor(new craftadmin(this));
	  }
	  private void registerGUIs() {
		  @SuppressWarnings("unused")
		  SelectGUI menu;
		  menu = new SelectGUI(this);
	  }
	  private void registerEvents() {
		  Bukkit.getServer().getPluginManager().registerEvents(new join(), this);
		  Bukkit.getServer().getPluginManager().registerEvents(new SelectGUI(), this);
	  }

}
