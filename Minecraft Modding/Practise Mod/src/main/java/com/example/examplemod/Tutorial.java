package com.example.examplemod;
//import libraries 
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


/**
 * A Class to register my block and item, and create an instance in minecraft
 * <p>2016 Upper Canada College FY computer science exam 
 * <p>This class actually inherit from java.lang.Object
 * <p>This class register my block and item's names, materials, and textures.
 * <p>It also create an instance of them so they are ready in the game
 * <p>Create a minecraft mod, which includes a block and a tool
 * <p>Some of the features only works in survival mode, such as hardness and health loss.
 * <p>To switch to <strong>Survival Mode</strong>, please press <strong>T</strong> and type <strong>/gamemode 0</strong>
 * <p>To switch back to <strong>Creative Mode</strong>, please press <strong>T</strong> and type <strong>/gamemode 1</strong>
 * @since  2016-12-06
 * @version 1.0
 * @author simon.guo 
 * <a href="http://simonguo.tech" target="blank">click here learn more about me</a>
 */
@Mod(modid = Tutorial.modid, name = "basic tutorial", version = "1.0")
public class Tutorial {
	public static final String modid = "tutorial";
	public static Block tutorialBlock;
	public static Item tutorialItem;
	
	/**
	 * Method that initialize and register blocks and items in the game.
	 * @param event
	 */
	@EventHandler
	public void load(FMLInitializationEvent event){
		//instatniate my block
		tutorialBlock = new BlockTutorialBlock();
		//instatniate my item
		tutorialItem = new ItemTutorialItem();
		//register your custom block with Minecraft
		GameRegistry.registerBlock(tutorialBlock, modid + tutorialBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tutorialItem,modid + tutorialItem.getUnlocalizedName().substring(5));
	}
}
