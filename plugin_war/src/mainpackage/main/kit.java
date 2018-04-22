package mainpackage.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_8_R1.NBTTagCompound;


public class kit implements CommandExecutor, Listener 
{
	private plugin_war plugin;
	public kit(plugin_war plugin_war) 
	{
		plugin = plugin_war;
	}

	
	//String healfodefault = plugin.getConfig().getString("Kit.Default.Classitem.Armor.Helmet.ID");
	String helmetfodefault = plugin.getConfig().getString("Kit.Default.Classitem.Armor.Helmet.ID");
	String chestplatefodefault = plugin.getConfig().getString("Kit.Default.Classitem.Armor.Chestplate.ID");
	String leggingsfodefault = plugin.getConfig().getString("Kit.Default.Classitem.Armor.Leggings.ID");
	String bootsfodefault = plugin.getConfig().getString("Kit.Default.Classitem.Armor.Boots.ID");
	
	ItemStack HelmetForDefault = new ItemStack(Material.getMaterial(helmetfodefault));
    ItemStack ChestplateForDefault = new ItemStack(Material.getMaterial(chestplatefodefault));
    ItemStack LeggingsForDefault = new ItemStack(Material.getMaterial(leggingsfodefault));
    ItemStack BootsForDefault = new ItemStack(Material.getMaterial(bootsfodefault));
    
    
	
	@Override
	public boolean onCommand(CommandSender Sender, Command cmd, String lable, String[] args)

	{
		
	
		//item for kit
		
		
		
		// kit default
		// Heal
		// { 
		ItemStack HealForDefault = new ItemStack(Material.INK_SACK);
		ItemMeta MetaHeal = HealForDefault.getItemMeta();
		MetaHeal.setDisplayName(ChatColor.GREEN + "Лечение");
		List<String> loreHeal = new ArrayList<String>();
		loreHeal.add(ChatColor.RED + "Стоит 25 маны, мнговенное лечение");
		MetaHeal.setLore(loreHeal);
		HealForDefault.setItemMeta(MetaHeal);
		// }
		// Sword
		// {
		ItemStack SwordForDefault = new ItemStack(Material.STONE_SWORD);
		net.minecraft.server.v1_8_R1.ItemStack NBTstackSword = CraftItemStack.asNMSCopy(SwordForDefault);
		NBTTagCompound Swordtag = new NBTTagCompound();
        Swordtag.setBoolean("Unbreakable", true);
        NBTstackSword.setTag(Swordtag);
        SwordForDefault = CraftItemStack.asBukkitCopy(NBTstackSword);
		ItemMeta MetaSwordDefault = SwordForDefault.getItemMeta();
		MetaSwordDefault.setDisplayName(ChatColor.BOLD + "Меч базовика");
		List<String> loreSwordDefault = new ArrayList<String>();
		loreSwordDefault.add(ChatColor.RED + "Стоит 50 маны, увеличивает на несколько секунд скорость передвижения");
		MetaSwordDefault.setLore(loreSwordDefault);
		SwordForDefault.setItemMeta(MetaSwordDefault);
        // }
        // Bow
        // {
        ItemStack BowForDefault = new ItemStack(Material.BOW);
        
    	net.minecraft.server.v1_8_R1.ItemStack NBTstackBow = CraftItemStack.asNMSCopy(BowForDefault);
		NBTTagCompound Bowtag = new NBTTagCompound();
		Bowtag.setBoolean("Unbreakable", true);
        NBTstackBow.setTag(Bowtag);
        BowForDefault = CraftItemStack.asBukkitCopy(NBTstackBow);
        
        
        // }
        // Armor
        // {
        
        
        
    	net.minecraft.server.v1_8_R1.ItemStack NBTstackHelmet = CraftItemStack.asNMSCopy(HelmetForDefault);
		NBTTagCompound Helmettag = new NBTTagCompound();
        Helmettag.setBoolean("Unbreakable", true);
        NBTstackHelmet.setTag(Helmettag);
        HelmetForDefault = CraftItemStack.asBukkitCopy(NBTstackHelmet);
        HelmetForDefault.getItemMeta().setDisplayName(plugin.getConfig().getString("Kit.Default.Classitem.Armor.Helmet.Name"));
		//HelmetForDefault.getItemMeta().setLore(plugin.getConfig().getString("Kit.Default.Classitem.Armor.Helmet.Lore"));        
		
    	net.minecraft.server.v1_8_R1.ItemStack NBTstackChestplate = CraftItemStack.asNMSCopy(ChestplateForDefault);
		NBTTagCompound Chestplatetag = new NBTTagCompound();
        Chestplatetag.setBoolean("Unbreakable", true);
        NBTstackChestplate.setTag(Chestplatetag);
        ChestplateForDefault = CraftItemStack.asBukkitCopy(NBTstackChestplate);
        ItemMeta MetaChestplateDefault = ChestplateForDefault.getItemMeta();
		MetaChestplateDefault.setDisplayName(ChatColor.GRAY + "Нагрудник базовика");
		ChestplateForDefault.setItemMeta(MetaChestplateDefault);
        
    	net.minecraft.server.v1_8_R1.ItemStack NBTstackLeggings = CraftItemStack.asNMSCopy(LeggingsForDefault);
		NBTTagCompound Leggingstag = new NBTTagCompound();
		Leggingstag.setBoolean("Unbreakable", true);
        NBTstackLeggings.setTag(Leggingstag);
        LeggingsForDefault = CraftItemStack.asBukkitCopy(NBTstackLeggings);
        ItemMeta MetaLeggingsDefault = LeggingsForDefault.getItemMeta();
		MetaLeggingsDefault.setDisplayName(ChatColor.GRAY + "Штаны базовика");
		LeggingsForDefault.setItemMeta(MetaLeggingsDefault);
        
    	net.minecraft.server.v1_8_R1.ItemStack NBTstackBoots = CraftItemStack.asNMSCopy(BootsForDefault);
		NBTTagCompound Bootstag = new NBTTagCompound();
		Bootstag.setBoolean("Unbreakable", true);
        NBTstackBoots.setTag(Bootstag);
        BootsForDefault = CraftItemStack.asBukkitCopy(NBTstackBoots);
        ItemMeta MetaBootsDefault = BootsForDefault.getItemMeta();
		MetaBootsDefault.setDisplayName(ChatColor.GRAY + "Ботинки базовика");
		BootsForDefault.setItemMeta(MetaBootsDefault);
        
        
        // }
        
		//
		//kit scout
		
		//
		
		//
		
		if (!(Sender instanceof Player)) 
		{
			Sender.sendMessage("Ti doljen bit` igrakom, TAK 4TO idi ot cedogo");
			return true;
		}
		if (args.length >= 2 || args.length <= 0) 
		{
			return false;
		}
		else 
		{
				Player sender = (Player) Sender;
				String namekit = args[0];
				switch(namekit)
				{
				case "default":
					sender.getInventory().clear();
					sender.getInventory().setItem(0, SwordForDefault);
					sender.getInventory().setItem(1, BowForDefault);
					sender.getInventory().setItem(2, HealForDefault);
					sender.getInventory().setHelmet(HelmetForDefault);
					sender.getInventory().setChestplate(ChestplateForDefault);
					sender.getInventory().setLeggings(LeggingsForDefault);
					sender.getInventory().setBoots(BootsForDefault);
					sender.sendMessage("робит 1");
					break;
				case "scout":
					sender.sendMessage("робит 2");
					break;
				case "default3":
					sender.sendMessage("робит 3");
					break;
				case "default4":
					sender.sendMessage("робит 4");
					break;
				case "default5":
					sender.sendMessage("робит 5");
					break;
				case "default6":
					sender.sendMessage("робит 6");
					break;
				case "default7":
					sender.sendMessage("робит 7");
					break;
				case "default8":
					sender.sendMessage("робит 8");
					break;
				case "default9":
					sender.sendMessage("робит 9");
					break;
				case "default10":
					sender.sendMessage("робит 10");
					break;
				case "default11":
					sender.sendMessage("робит 11");
					break;
				case "default12":
					sender.sendMessage("робит 12");
					break;
				default:
					sender.sendMessage("Ты шо дурак?");
					break;
				}
		}
		return true;
		
	}


}
