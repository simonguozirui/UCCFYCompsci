package com.exam.exammod;
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
 * <p>Create mod that has the following. Do not add code that serves no purpose. I will take marks away for unused imports and code (i.e., no blind copy and paste please).
 * <p>Create a package called exam.
 * <p>1. Class called ExamBlock - inherits from Block and uses material sand
 * <p>2. Class called ExamItem - inherits from ItemSword with ToolMaterial IRON
 * <p>3. Mod class called ExamMod - registers and instantiates ExamBlock and ExamItem
 * <p>4. Assets in correct resource packages and make sure code points to them
 * <p>5. ExamItem on right click should check world time and set to 0 when > 5000 else 14000
 * <p>6. ExamItem on right click should spawn a lightning bolt
 * <p>7. ExamItem on right click should spawn an ender pearl that transports you
 * <p>8. ExamBlock placed, time should be set to night and block should glow (sunlight)
 * <p>9. ExamBlock destroyed, 3 wolves attack player with custom name "attack wolf"
 * <p>10. ExamBlock destroyed, also spawn a zombie named "Ezekial Poopscraper"
 * <p>Bonus +1 - make each attack wolf have a unique number (e.g., Attack Wolf 0)
 * <p>This class actually inherit from java.lang.Object
 * <p>This class register my block and item's names, materials, and textures.
 * <p>It also create an instance of them so they are ready in the game
 * <p>Create a minecraft mod, which includes a block and a tool
 * <p>Some of the features only works in survival mode, such as hardness and health loss.
 * <p>To switch to <strong>Survival Mode</strong>, please press <strong>T</strong> and type <strong>/gamemode 0</strong>
 * <p>To switch back to <strong>Creative Mode</strong>, please press <strong>T</strong> and type <strong>/gamemode 1</strong>
 *
 * @since  2016-12-06
 * @version 1.0
 * @author simon.guo 
 * <a href="http://simonguo.tech" target="blank">click here learn more about me</a>
 */
@Mod(modid = ExamMod.modid, name = "basic tutorial", version = "1.0")
public class ExamMod {
	public static final String modid = "tutorial";
	public static Block ExamBlock;
	public static Item ExamItem;
	
	/**
	 * Method that initialize and register blocks and items in the game.
	 * @param event
	 */
	@EventHandler
	public void load(FMLInitializationEvent event){
		//instatniate my block
		ExamBlock = new ExamBlock();
		//instatniate my item
		ExamItem = new ExamItem();
		
		//
		//ExamItem = new ExamItem();
		//register your custom block with Minecraft
		GameRegistry.registerBlock(ExamBlock, modid + ExamBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ExamItem,modid + ExamItem.getUnlocalizedName().substring(5));
		//GameRegistry.registerItem(ExamItem,modid + ExamItem.getUnlocalizedName().substring(5));
		
	}
}
