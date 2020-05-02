package fr.lmf.mffjam.event;

import fr.lmf.mffjam.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.storage.loot.ConstantRange;
import net.minecraft.world.storage.loot.ItemLootEntry;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MELootTablesEvent
{

	@SubscribeEvent
	public void lootTables(final LootTableLoadEvent e)
	{
		for ( Block block : BlockTags.LEAVES.getAllElements() )
		{
			if( e.getName() == block.getLootTable() )
			{
				e.getTable().addPool(LootPool.builder()
											 .name("fruits")
											 .rolls(new ConstantRange(1))
											 .addEntry(ItemLootEntry.builder(ItemInit.CHERRY.get()).weight(1).cast())
											 .addEntry(ItemLootEntry.builder(ItemInit.ORANGE.get()).weight(1).cast())
											 .addEntry(ItemLootEntry.builder(ItemInit.PEAR.get()).weight(1).cast())
											 .addEntry(ItemLootEntry.builder(ItemInit.CLEMENTINE.get()).weight(1).cast())
											 .build());
			}
		}
	}

}
