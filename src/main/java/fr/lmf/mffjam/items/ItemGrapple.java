package fr.lmf.mffjam.items;

import fr.lmf.mffjam.MoreExploration;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

public class ItemGrapple extends Item
{
	public ItemGrapple()
	{
		super(new Item.Properties().group(MoreExploration.me_group).maxStackSize(1).defaultMaxDamage(250));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{

		ItemStack stack = playerIn.getHeldItem(handIn);

		RayTraceResult rayTraceResult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.NONE);

		if( rayTraceResult.getType() == RayTraceResult.Type.BLOCK )
		{
			BlockRayTraceResult rayTraceResult1 = (BlockRayTraceResult) rayTraceResult;

			Direction face = rayTraceResult1.getFace();

			BlockPos pos = rayTraceResult1.getPos();

			if( playerIn.getPosition().withinDistance(pos, 10.D) )
			{
				Vec3d targetPos = new Vec3d(pos);
				Vec3d playerPos = new Vec3d(playerIn.getPosition());


				//MathHelper.lerp(playerPos.x, targetPos.x, )

			}
		}

		return ActionResult.resultSuccess(stack);
	}
}
