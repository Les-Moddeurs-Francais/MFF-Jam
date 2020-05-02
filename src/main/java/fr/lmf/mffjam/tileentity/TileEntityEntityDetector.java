package fr.lmf.mffjam.tileentity;

import fr.lmf.mffjam.blocks.BlockEntityDetector;
import fr.lmf.mffjam.init.TileEntityInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class TileEntityEntityDetector extends TileEntity implements ITickableTileEntity
{
	public TileEntityEntityDetector()
	{
		super(TileEntityInit.TE_ENTITY_DETECTOR.get());
	}


	@Override
	public void tick()
	{

		if( getWorld() == null || getWorld().isRemote )
		{
			return;
		}

		BlockPos pos = getPos();
		Direction direction = getBlockState().get(BlockEntityDetector.FACING);
		AxisAlignedBB boundingBox = null;

		switch ( direction )
		{

			case NORTH:
				boundingBox = new AxisAlignedBB(pos.getX() - 1, pos.getY(), pos.getZ() - 1, pos.getX() + 2, pos.getY() + 1, pos.getZ() - 5);
				break;
			case SOUTH:
				boundingBox = new AxisAlignedBB(pos.getX() - 1, pos.getY(), pos.getZ() + 1, pos.getX() + 2, pos.getY() + 1, pos.getZ() + 5);
				break;
			case WEST:
				boundingBox = new AxisAlignedBB(pos.getX() - 1, pos.getY(), pos.getZ() - 1, pos.getX() - 5, pos.getY() + 1, pos.getZ() + 2);
				break;
			case EAST:
				boundingBox = new AxisAlignedBB(pos.getX() + 1, pos.getY(), pos.getZ() - 1, pos.getX() + 5, pos.getY() + 1, pos.getZ() + 2);
				break;
		}

		if( boundingBox == null )
		{
			return;
		}

		List<Entity> entitiesWithinAABB = getWorld().getEntitiesWithinAABB(LivingEntity.class
				, boundingBox, null);

		if( !entitiesWithinAABB.isEmpty() )
		{
			getTileData().putLong("redstoneDelay", System.currentTimeMillis() / 1000L);
			getWorld().setBlockState(getPos(), getBlockState().with(BlockEntityDetector.POWERED, true), 11);
		}

		if( getTileData().getLong("redstoneDelay") + 1L <= System.currentTimeMillis() / 1000L )
		{
			getWorld().setBlockState(getPos(), getBlockState().with(BlockEntityDetector.POWERED, false), 11);
		}
	}
}

