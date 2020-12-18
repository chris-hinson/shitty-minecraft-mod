package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class EnderEmitterBlock extends Block
{
    public EnderEmitterBlock()
    {
        super(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.0f));
    }
}
