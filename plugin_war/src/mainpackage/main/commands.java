package mainpackage.main;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commands implements CommandExecutor 
{
	private plugin_war plugin;
	public commands(plugin_war plugin) 
	{
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		Player p = (Player) sender;
		switch(cmd.getName()) 
		{
		case "speed":
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 2 ));
			p.sendMessage("— Œ–Œ—“‹");
		break;
		}
		return true;
	}
}

