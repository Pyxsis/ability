package me.reparo.crafts.eventsgui;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.reparo.crafts.util.Data;

public class join implements Listener {

	
	@EventHandler
	public void playerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Data pd = new Data(p.getUniqueId());
		if(pd.getMainCraft() == null) {
			pd.createConfig();
			pd.updateUsername(p);
		} else if (pd.getMainCraft().equals("null")){
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', 
					        "&8&m[---&c  Welcome, " + p.getName() + "! We see that this is your first time &8&m---]"
							+ "\n&8&m[---&c  You need to pick a craft and begin your journey!  &8&m---]"
							+ "\n&8&m[---&c         Type &8[&4/Craft Select&8] &cwhen you are ready!        &8&m---]"));
		} else {
			pd.updateUsername(p);
			return;
		}
	}
	
}
