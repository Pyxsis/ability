package me.reparo.crafts.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.reparo.crafts.main;

public class Data {
	
	 File f;
	 FileConfiguration config;
	UUID u;
	
	public Data(UUID u){
		this.u = u;
		f = new File(main.getInstance().getDataFolder() + File.separator + "Data" + File.separator, u + ".yml");
		config = YamlConfiguration.loadConfiguration(f);
	}
	public void createConfig(){
		if(!f.exists()){
			try {
				f.createNewFile();
				setConfigOptions();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void setConfigOptions() {
		config.set("Crafts.Main", "null");
		config.set("General Data.First joined", System.currentTimeMillis());
		config.set("General Data.Username", "unknown");
		saveConfig();
	}
	public FileConfiguration getConfig(){
		return config;
	}
	public void saveConfig(){
		try {
			config.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getMainCraft(){
		return config.getString("Crafts.Main");
	}
	public void setMainCraft(String s){
		config.set("Crafts.Main", s.toLowerCase());
		saveConfig();
	}
	
	
	
	public void reset(Player t){
		config.set("Crafts", null);
		t.kickPlayer(util.colour("&4An administrator has reset your data\n&cTo avoid a glitch, we had to kick you.\n&cPlease rejoin."));
		saveConfig();
		setConfigOptions();
		saveConfig();
	}
	
	
	public String getUsername() {
		return config.getString("General Data.Username");
	}
	public void updateUsername(Player p) {
		if(p.getName().equals(getUsername())) {
			return;
		} else {
			config.set("General Data.Username", p.getName());
			saveConfig();
		}
	}
	
	
	
	public long getTimeJoined(){
		return config.getLong("General Data.First joined");
	}
	public String getTimePlayed(CommandSender s) {
		long played = System.currentTimeMillis() - getTimeJoined();
		  if(played < 0) {
	            util.sendMsg(s, "&cThe user has not played very long..");
	        }

	        long days = TimeUnit.MILLISECONDS.toDays(played);
	        played -= TimeUnit.DAYS.toMillis(days);
	        long hours = TimeUnit.MILLISECONDS.toHours(played);
	        played -= TimeUnit.HOURS.toMillis(hours);
	        long minutes = TimeUnit.MILLISECONDS.toMinutes(played);
	        played -= TimeUnit.MINUTES.toMillis(minutes);
	        long seconds = TimeUnit.MILLISECONDS.toSeconds(played);

	        StringBuilder sb = new StringBuilder(64);
	        sb.append(days);
	        sb.append(" Days ");
	        sb.append(hours);
	        sb.append(" Hours ");
	        sb.append(minutes);
	        sb.append(" Minutes ");
	        sb.append(seconds);
	        sb.append(" Seconds");
	        
	        return(sb.toString());
	}
	
	
}
