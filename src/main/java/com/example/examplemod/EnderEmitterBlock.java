package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EnderEmitterBlock extends Block
{
    public static int power = 0;

    public EnderEmitterBlock()
    {
        super(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.0f));
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        power = worldIn.getRedstonePowerFromNeighbors(pos);
    }
}
