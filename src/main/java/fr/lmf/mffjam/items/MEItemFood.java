package fr.lmf.mffjam.items;

import fr.lmf.mffjam.MoreExploration;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class MEItemFood extends Item
{
	public MEItemFood(int hunger, float saturation)
	{
		super(new Item.Properties().group(MoreExploration.me_group).food(new Food.Builder().hunger(hunger).meat().saturation(saturation).build()));
	}
}
