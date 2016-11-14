package me.reparo.crafts.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.reparo.crafts.main;
import me.reparo.crafts.util.Data;
import me.reparo.crafts.util.util;

public class craftadmin implements CommandExecutor {
	
	  public craftadmin(main main) {}

	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args)
	  {
		  if(cmd.getName().equalsIgnoreCase("craftadmin")) {
			  if(s.hasPermission("craft.admin")) {
				  if(args.length == 1) {
					  if(args[0].equalsIgnoreCase("help")) {
						  util.sendMsg(s, "&8&m--------------------&2 He&3lp &8&m--------------------\n"
						          + "&a/craftadmin help &8// &bDisplay this menu\n"
						          + "&a/craftadmin reset [name] &8// &bReset a user's data\n"
						          + "&a/craftadmin joined [name] &8// &bSee when a user first joined");
					  } else {
						  util.noCmdA(s);
					  }
				  } else if (args.length == 2) {
					  if(util.targetNull(s, args[1]) == false) {
						  Player t = Bukkit.getPlayer(args[1]);
						  Data td = new Data(t.getUniqueId());
						  if(args[0].equalsIgnoreCase("reset")) {
							  if(s.hasPermission("craft.admin.reset")) {
								  td.reset(t);
								  util.sendMsg(s, "&aSuccess! &2" + t.getName() + "&a's data is now reset.");  
							  } else {
								  util.noPerm(s, "craft.admin.reset");
							  }
						  } else if (args[0].equalsIgnoreCase("joined")) {
							  if(s.hasPermission("craft.admin.joined")) {
								  util.sendMsg(s, "&aSuccess! &2" + t.getName() + "&a first joined &2" + td.getTimePlayed(s) + "&a ago!");  
							  } else {
								  util.noPerm(s, "craft.admin.joined");
							  }
						  } else {
							  util.noCmdA(s);
						  }
					  } else {
						  util.sendMsg(s, "&4" + args[1] + "&c is not online!");
					  }
				  } else if (args.length == 3) {
					  
				  } else {
					  util.noCmdA(s);
				  }
			  } else {
				  util.noPerm(s, "craft.admin");
			  }
		  }
		  
		  
		  return true;
	  }

}
