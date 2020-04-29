package fr.lmf.mffjam.data.loot;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

public class MEEntityLootTables extends EntityLootTables
{

	private HashMap<EntityType<?>, LootTable.Builder> lootTables = new HashMap<>();
	private List<EntityType<?>> entities = Lists.newArrayList();

	@Override
	protected void addTables()
	{
	}

	@Override
	public void accept(BiConsumer<ResourceLocation, LootTable.Builder> p_accept_1_)
	{
		this.addTables();
		Set<ResourceLocation> set = Sets.newHashSet();
		Iterator iterator = this.entities.iterator();

		EntityType<?> entitytype;
		ResourceLocation resourcelocation;
		while ( true )
		{
			if( !iterator.hasNext() )
			{
				this.lootTables.forEach((type, builder) -> p_accept_1_.accept(type.getRegistryName(), builder));
				return;
			}

			entitytype = (EntityType) iterator.next();
			resourcelocation = entitytype.getLootTable();
			if( isNonLiving(entitytype) )
			{
				if( resourcelocation != LootTables.EMPTY && this.lootTables.remove(resourcelocation) != null )
				{
					break;
				}
			}
			else if( resourcelocation != LootTables.EMPTY && set.add(resourcelocation) )
			{
				LootTable.Builder loottable$builder = this.lootTables.remove(entitytype);
				if( loottable$builder == null )
				{
					throw new IllegalStateException(String.format("Missing loottable '%s' for '%s'", resourcelocation, Registry.ENTITY_TYPE.getKey(entitytype)));
				}

				p_accept_1_.accept(resourcelocation, loottable$builder);
			}
		}

		throw new IllegalStateException(String.format("Weird loottable '%s' for '%s', not a LivingEntity so should not have loot", resourcelocation, Registry.ENTITY_TYPE.getKey(entitytype)));

	}

	@Override
	protected void registerLootTable(EntityType<?> type, LootTable.Builder table)
	{
		this.lootTables.put(type, table);
		if( !this.entities.contains(type) )
		{
			this.entities.add(type);
		}
	}

}
