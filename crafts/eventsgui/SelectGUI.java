package me.reparo.crafts.eventsgui;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.reparo.crafts.main;
import me.reparo.crafts.util.Data;
import me.reparo.crafts.util.util;

	public class SelectGUI implements Listener {

		public static Inventory inv = Bukkit.getServer().createInventory(null, 9*4, ChatColor.translateAlternateColorCodes('&', "&8[&4Craft Select&8]"));	
		
		public ItemStack createCraft(Material m, String name, String lore) {
			ItemStack a = new ItemStack(m);
			ItemMeta am = a.getItemMeta();
			am.setDisplayName(util.colour(name));
			ArrayList<String> newlore = new ArrayList<String>();
			newlore.add(lore);
			am.setLore(newlore);
			a.setItemMeta(am);
			return a;
		}
		
        public SelectGUI(main p) {
            ItemStack ninja = createCraft(Material.DIAMOND_SWORD, "&cNinja", "Become a ninja! WHOYYAAAAAAA!");
            ItemStack woodchucker = createCraft(Material.DIAMOND_AXE, "&aWoodchucker", "Get down here, apples! I'm hungry!");
            ItemStack fisherman = createCraft(Material.FISHING_ROD, "&bFisherman", "Blob blob blob, here fishy fishy!");
            
            inv.setItem(2, ninja);
            inv.setItem(4, woodchucker);
            inv.setItem(6, fisherman);
           
            Bukkit.getServer().getPluginManager().registerEvents(this, p);
    }
		

		public SelectGUI() {}

		public static void show(Player p) {
			p.openInventory(inv);
		}
		
		@EventHandler
		public void onInventoryClick(InventoryClickEvent e) {
			if (!e.getInventory().getName().equalsIgnoreCase(inv.getName())) return;
			if (e.getCurrentItem().getItemMeta() == null) return;
			
			Data pd = new Data(e.getWhoClicked().getUniqueId());
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Ninja")) {
				e.setCancelled(true);
				pd.setMainCraft("ninja");
				e.getWhoClicked().closeInventory();
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Woodchucker")) {
				e.setCancelled(true);
				pd.setMainCraft("woodchucker");
				e.getWhoClicked().closeInventory();
			}
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Fisherman")) {
				e.setCancelled(true);
				pd.setMainCraft("fisherman");
				e.getWhoClicked().closeInventory();
			}
		}

}
