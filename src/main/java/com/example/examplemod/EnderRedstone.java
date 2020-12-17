package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EnderRedstone.MODID)
public class EnderRedstone
{
    public static final String MODID = "ender_redstone";

    public static IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

    public EnderRedstone()
    {
        registerCommonEvents();
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> EnderRedstone::registerClientOnlyEvents);
    }

    public static void registerCommonEvents()
    {
        MOD_EVENT_BUS.register(EnderEmitterBlock.class);
        MOD_EVENT_BUS.register(EnderReceiverBlock.class);
    }

    public static void registerClientOnlyEvents()
    {

    }
}
