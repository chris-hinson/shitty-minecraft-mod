package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class EnderEmitterBlock extends Block
{
    public EnderEmitterBlock()
    {
        super(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.0f));
    }

    @Override
    public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack)
    {
        super.harvestBlock(worldIn,player,pos,state,te,stack);
        worldIn.setBlockState(pos,Blocks.AIR.getDefaultState());
    }


    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder )
    {
        List<ItemStack> drops = new ArrayList<>();
        TileEntity tile = builder.get(LootParameters.BLOCK_ENTITY);

        if (tile != null)
        {
            drops.add(new ItemStack(this,1));
        }

        return drops;

    }


}
