package com.modcraft.helloworld;

import java.util.Set;

import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentText;

import com.google.common.collect.Sets;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

@Mod(modid = HelloWorldMod.MODID, version = HelloWorldMod.VERSION)
public class HelloWorldMod
{
    public static final String MODID = "modcraft_helloworld";
    public static final String VERSION = "1.0";
    
    public static final Set<String> MOD_DEVELOPERS = Sets.newHashSet(
    		/* If you're following the Modcraft tutorial, add your Minecraft username here! */
    		"DougHamil"
    		);
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	// Initialization
    }
    
    /**
     * This class is an event handler to listen for player logins to the server and then greets any known developers
     */
    public static class HelloWorldEventListener
    {
    	
    	@SubscribeEvent
    	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
    	{
    		if(MOD_DEVELOPERS.contains(event.player.getDisplayName()))
    		{
    			event.player.addChatComponentMessage(new ChatComponentText(String.format("Welcome developer, %s, thank you for contributing!", event.player.getDisplayName())));
    		}
    		else
    		{
    			event.player.addChatComponentMessage(new ChatComponentText(String.format("Welcome player, %s.", event.player.getDisplayName())));
    		}
    	}
    }
}
