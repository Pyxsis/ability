package me.reparo.crafts.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class util {

	
	public static String colour(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	public static Boolean targetNull(CommandSender s, String name) {
		Player t = Bukkit.getPlayer(name);
		if(t == null) {
			sendMsg(s, "&4" + name + "&c is not online!");
			return true;
		} else {
			return false;
		}
	}
	public static void log(String s) {
		Bukkit.broadcastMessage(colour(s));
	}
	public static void sendMsg(CommandSender s, String msg) {
		s.sendMessage(colour(msg));
	}
	public static void noPerm(CommandSender s, String perm) {
		s.sendMessage(colour("&cYou are missing the permission node &4" + perm));
	}
	public static void noCmdA(CommandSender s) {
		s.sendMessage(colour("&cSilly! That isn't a command. Type &4/craftadmin help&c for help."));
	}
	public static void noCmdP(CommandSender s) {
		s.sendMessage(colour("&cSilly! That isn't a command. Type &4/craft help&c for help."));
	}
	
}
