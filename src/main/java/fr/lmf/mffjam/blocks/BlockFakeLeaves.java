package fr.lmf.mffjam.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class BlockFakeLeaves extends Block
{
	public BlockFakeLeaves()
	{
		super(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.5f, 10.f).sound(SoundType.GROUND).harvestLevel(0));
	}

	@Override
	public boolean isTransparent(BlockState state)
	{
		return true;
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		return VoxelShapes.empty();
	}
}
