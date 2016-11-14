package me.reparo.crafts.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.reparo.crafts.main;
import me.reparo.crafts.eventsgui.SelectGUI;
import me.reparo.crafts.util.Data;
import me.reparo.crafts.util.util;

public class craft implements CommandExecutor {
	
	  public craft(main main) {}

	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args)
	  {
		  if(cmd.getName().equalsIgnoreCase("craft")) {
			  if(s instanceof Player) {
				  Player p = (Player) s;
				  Data pd = new Data(p.getUniqueId());
				  if(args.length == 1) {
					  if(args[0].equalsIgnoreCase("select")) {
						  if(pd.getMainCraft().equals("null") && pd.getMainCraft() != null) {
							  p.openInventory(SelectGUI.inv);
						  } else {
							  util.sendMsg(s, "&cYou already have a main craft!");
						  }
					  } else if (args[0].equalsIgnoreCase("help")) {
						  util.sendMsg(s, "&8&m--------------------&2 He&3lp &8&m--------------------\n"
						          + "&a/craft help &8// &bDisplay this menu\n"
						          + "&a/craft select &8// &bSelect your main craft\n"
						          + "&a/craft upgrade &8// &bUpgrade your main craft");
					  } else {
						  util.noCmdP(s);
					  }  
				  } else {
					  util.noCmdP(s);
				  }
			  } else {
				  s.sendMessage("This is the player command. Type /craftadmin for administrator commands.");
			  }
		  }
		  
		  
		  return true;
	  }

}
