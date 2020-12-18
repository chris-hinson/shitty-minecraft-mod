package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class StartupCommon
{
    public static Block[] blocks = new Block[2];

    @SubscribeEvent
    public static void onBlockRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
        blocks[0] = new EnderEmitterBlock().setRegistryName("ender_redstone","ender_redstone_emitter");
        blocks[1] = new EnderReceiverBlock().setRegistryName("ender_redstone", "ender_redstone_receiver");

        for(int i=0; i<blocks.length; i++)
        {
            blockRegisterEvent.getRegistry().register(blocks[i]);
        }
    }

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent)
    {
        final int MAXIMUM_STACK_SIZE = 64;
        Item.Properties itemProperties = new Item.Properties().maxStackSize(MAXIMUM_STACK_SIZE).group(ItemGroup.REDSTONE);

        //Assumes stack size of 64 and Redstone item group for all items, which is currently true
        for(int i=0; i<blocks.length; i++)
        {
            BlockItem itemBlock = new BlockItem(blocks[i], itemProperties);
            itemBlock.setRegistryName(blocks[i].getRegistryName());
            itemRegisterEvent.getRegistry().register(itemBlock);
        }


    }
}
