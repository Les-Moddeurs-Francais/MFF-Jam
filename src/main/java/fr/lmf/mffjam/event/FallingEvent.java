package fr.lmf.mffjam.event;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FallingEvent
{

	@SubscribeEvent
	public void onPlayerFall(final LivingFallEvent e)
	{
		if( e.getEntityLiving() instanceof PlayerEntity )
		{
			PlayerEntity player = ((PlayerEntity) e.getEntityLiving());
			if( player.getPersistentData().getBoolean("using_sling") )
			{
				e.setCanceled(true);
				player.getPersistentData().remove("using_sling");
			}
		}
	}

}
