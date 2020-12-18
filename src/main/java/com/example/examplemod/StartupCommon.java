package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class StartupCommon
{
    public static Block block;
    public static BlockItem itemBlock;

    @SubscribeEvent
    public static void onBlockRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
        block = new EnderEmitterBlock();
        block.setRegistryName("ender_redstone","ender_redstone_emitter");

        blockRegisterEvent.getRegistry().register(block);
    }

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent)
    {
        final int MAXIMUM_STACK_SIZE = 64;

        Item.Properties itemProperties = new Item.Properties().maxStackSize(MAXIMUM_STACK_SIZE).group(ItemGroup.REDSTONE);

        itemBlock = new BlockItem(block,itemProperties);
        itemBlock.setRegistryName(block.getRegistryName());

        itemRegisterEvent.getRegistry().register(itemBlock);

    }
}
