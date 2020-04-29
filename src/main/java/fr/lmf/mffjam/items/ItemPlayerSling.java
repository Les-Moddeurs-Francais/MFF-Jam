package fr.lmf.mffjam.items;

import fr.lmf.mffjam.MoreExploration;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemPlayerSling extends Item
{

	private float force = 5.0f;

	public ItemPlayerSling()
	{
		super(new Item.Properties().maxStackSize(1).defaultMaxDamage(50).group(MoreExploration.me_group));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		playerIn.setActiveHand(handIn);
		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft)
	{

		if( !(entityLiving instanceof PlayerEntity) )
		{
			return;
		}
		PlayerEntity player = (PlayerEntity) entityLiving;

		if( !player.onGround )
		{
			return;
		}

		int i = this.getUseDuration(stack) - timeLeft;

		if( i < 20 )
		{
			return;
		}

		float charge = Math.min(i + 80 / 80f, 2f);

		Vec3d lookVec = player.getLookVec().normalize();

		if( lookVec.y > -0.55f )
		{
			return;
		}

		System.out.println(lookVec);
		player.addVelocity(lookVec.x * -force * charge, lookVec.y / (4f / charge) * -force, lookVec.z * -force * charge);
		player.getPersistentData().putBoolean("using_sling", true);
		if( worldIn.isRemote )
		{
			player.playSound(SoundEvents.ENTITY_SLIME_JUMP, 1.0f, 1.0f);
		}
	}

	@Override
	public int getUseDuration(ItemStack stack)
	{
		return 72000;
	}

	@Override
	public UseAction getUseAction(ItemStack stack)
	{
		return UseAction.BOW;
	}
}
