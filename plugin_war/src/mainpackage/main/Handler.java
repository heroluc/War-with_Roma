package mainpackage.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.avaje.ebeaninternal.server.deploy.generatedproperty.GeneratedInsertTimestamp;

import mainpackage.main.particleeffect.ParticleEffect;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;

import org.bukkit.inventory.Inventory; 



public class Handler implements Listener 
{

	private plugin_war plugin;
	
	public Handler(plugin_war plugin_war) 
	{
		plugin = plugin_war;
	}
	
	@EventHandler
	public void DvijInInventory(InventoryClickEvent click) 
	{
		if (click.getAction().equals(InventoryAction.CLONE_STACK)) 
		{
			return;
		}
		else
		click.setCancelled(true);
	}
	
	
	@EventHandler
	public void Scoreboard(PlayerJoinEvent player) 
	{
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Team team_red = board.registerNewTeam("Red");
		Team team_blue = board.registerNewTeam("Blue");
		team_red.setPrefix("§c");
		team_blue.setPrefix("§9");
		player.getPlayer().setScoreboard(board);
		team_blue.addPlayer(player.getPlayer());
		String idinaxui = plugin.getConfig().getString("pizda.typay");
		player.getPlayer().sendMessage(idinaxui);
	}
	
	@EventHandler
	public void playerHitPlayerEvent(EntityDamageByEntityEvent event)
	{
	Entity damager = event.getDamager(); 
		if (damager instanceof Player) 
		{	
			Player player = (Player) damager;
			if(player.getLevel() >= 100) 
			{
				return;
			}
			else 
			{
				player.giveExpLevels(5);
			}
		}
	}
	
	@EventHandler
	public void excontroler(PlayerExpChangeEvent ChangeEx) 
	{
		Player player = ChangeEx.getPlayer();
		if (player.getExpToLevel() >= 1) 
		{
			int giveEx = player.getExpToLevel();
			player.giveExp(-giveEx);
		}
	}
	
	@EventHandler
	public void join(PlayerToggleSneakEvent join) 
	{	
		Inventory inv = Bukkit.createInventory(null, 3 * 9);
		Player player = join.getPlayer();
		player.sendMessage("вхахв");
		player.openInventory(inv); 
		
		/*String tets = plugin.getConfig().getString("test.lol");
		player.sendMessage(tets);*/
	}
	
	@EventHandler
	public void healdefault(PlayerInteractEvent heal) 
	{
		if(heal.getAction() != Action.RIGHT_CLICK_AIR && heal.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		if(heal.getPlayer().getItemInHand().getType() != Material.INK_SACK) return;
		Player player = heal.getPlayer();
		ItemStack item_heal = player.getItemInHand();
		if(!item_heal.getItemMeta().hasLore() || !item_heal.getItemMeta().hasDisplayName()) return;
		if(!item_heal.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Лечение") || !item_heal.getItemMeta().getLore().get(0).equals(ChatColor.RED + "Стоит 25 маны, мнговенное лечение")) return;
		if(player.getLevel() < 50) return;
		if(player.getHealth() == 20) 
		{
			return;
		}
		
		else if (player.getHealth() <= 14) 
		{
			int hp = 6;
			int hpPlayer = (int) player.getHealth(); 
			player.setHealth(hp + hpPlayer);
		}
		
		else if (player.getHealth() == 15) 
		{
			int hp = 5;
			int hpPlayer = (int) player.getHealth(); 
			player.setHealth(hp + hpPlayer);
		}
		
		else if (player.getHealth() == 16) 
		{
			int hp = 4;
			int hpPlayer = (int) player.getHealth(); 
			player.setHealth(hp + hpPlayer);
		}
		
		else if (player.getHealth() == 17) 
		{
			int hp = 3;
			int hpPlayer = (int) player.getHealth(); 
			player.setHealth(hp + hpPlayer);
		}
		
		else if (player.getHealth() == 18) 
		{
			int hp = 2;
			int hpPlayer = (int) player.getHealth(); 
			player.setHealth(hp + hpPlayer);
		}
		
		else if (player.getHealth() == 19) 
		{
			int hp = 1;
			int hpPlayer = (int) player.getHealth(); 
			player.setHealth(hp + hpPlayer);
		}
		
		player.giveExpLevels(-50);
		player.sendMessage("агада");
	}
	
	@EventHandler
	public void speedDefault(PlayerInteractEvent speed) 
	{
		if(speed.getAction() != Action.RIGHT_CLICK_AIR && speed.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		if(speed.getPlayer().getItemInHand().getType() != Material.STONE_SWORD) return;
		Player player = speed.getPlayer();
		ItemStack item_speed = player.getItemInHand();
		if(!item_speed.getItemMeta().hasDisplayName() || !item_speed.getItemMeta().hasLore()) return;
		if(!item_speed.getItemMeta().getDisplayName().equals(ChatColor.BOLD + "Меч базовика") || !item_speed.getItemMeta().getLore().get(0).equals(ChatColor.RED + "Стоит 50 маны, увеличивает на несколько секунд скорость передвижения")) return;
		if(player.getLevel() < 25 ) return;
		player.giveExpLevels(-25);
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1 ));
		ParticleEffect.CLOUD.display(1 , 1 , 1 , 0, 50, player.getLocation(), 25);
	}
	
	
}
