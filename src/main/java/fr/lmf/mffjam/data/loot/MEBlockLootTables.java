package fr.lmf.mffjam.data.loot;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTables;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

public class MEBlockLootTables extends BlockLootTables
{

	private HashMap<ResourceLocation, LootTable.Builder> lootTables = new HashMap<>();
	private List<Block> blocks = Lists.newArrayList();

	@Override
	protected void addTables()
	{
	}

	@Override
	public void accept(BiConsumer<ResourceLocation, LootTable.Builder> p_accept_1_)
	{
		this.addTables();
		Set<ResourceLocation> set = Sets.newHashSet();

		for ( Block block : this.blocks )
		{
			ResourceLocation resourcelocation = block.getLootTable();
			if( resourcelocation != LootTables.EMPTY && set.add(resourcelocation) )
			{
				LootTable.Builder loottable$builder = this.lootTables.remove(resourcelocation);
				if( loottable$builder == null )
				{
					throw new IllegalStateException(String.format("Missing loottable '%s' for '%s'", resourcelocation, Registry.BLOCK.getKey(block)));
				}

				p_accept_1_.accept(resourcelocation, loottable$builder);
			}
		}

		if( !this.lootTables.isEmpty() )
		{
			throw new IllegalStateException("Created block loot tables for non-blocks: " + this.lootTables.keySet());
		}
	}

	protected void registerLootTable(Block blockIn, LootTable.Builder table)
	{
		this.lootTables.put(blockIn.getLootTable(), table);
		if( !this.blocks.contains(blockIn) )
		{
			this.blocks.add(blockIn);
		}
	}

}
