package com.example.examplemod;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class StartupClientOnly {

    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event)
    {
        for(int i=0; i<StartupCommon.blocks.length; i++)
        {
            RenderTypeLookup.setRenderLayer(StartupCommon.blocks[i], RenderType.getSolid());
        }
    }
}
