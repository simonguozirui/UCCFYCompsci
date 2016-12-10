package com.example.examplemod;
//import libraries 
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

/**
 * Register and active the mod
 * <p>2016 Upper Canada College FY computer science exam 
 * <p>Create a minecraft mod, which includes a block and a tool.
 * <p>This class registers and active the mod
 * <p>Some of the features only works in survival mode, such as hardness and health loss.
 * <p>To switch to <strong>Survival Mode</strong>, please press <strong>T</strong> and type <strong>/gamemode 0</strong>
 * <p>To switch back to <strong>Creative Mode</strong>, please press <strong>T</strong> and type <strong>/gamemode 1</strong>
 * @since  2016-12-06
 * @version 1.0
 * @author simon.guo 
 * <a href="http://simonguo.tech" target="blank">click here learn more about me</a>
 */
@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
	//register and active the mod
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    /**
     * Initializing the mod
     * @param event
     */
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	//initialization
    }
}
