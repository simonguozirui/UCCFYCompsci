package com.example.examplemod;
//import libraries 
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Simon Guo's Minecraft Block, an inheritance from block
 * <p>2016 Upper Canada College FY computer science exam 
 * <p>Create a minecraft mod, which includes a block and a tool.
 * <p>The block does....
 * <p>This block extends on the block class. 
 * <p>Note that some of the features only works in survival mode, such as hardness and health loss.
 * <p>To switch to <strong>Survival Mode</strong>, please press <strong>T</strong> and type <strong>/gamemode 0</strong>, and then press enter
 * <p>To switch back to <strong>Creative Mode</strong>, please press <strong>T</strong> and type <strong>/gamemode 1</strong>, and then press enter
 * @since  2016-12-06
 * @version 1.0
 * @author simon.guo 
 * <a href="http://simonguo.tech" target="blank">click here learn more about me</a>
 */
//creating class, inheritance methods from block.
public class BlockTutorialBlock extends Block{
	//constructor
	public  BlockTutorialBlock(){
		//set block texture
		super(Material.cactus);
		//setter/mutators methods
		setBlockName("tutorialBlock");
		setCreativeTab(CreativeTabs.tabBlock);
		this.setLightLevel(1);
		this.setLightOpacity(100);
		this.setStepSound(soundTypeMetal);
		this.setHardness(40F); //this feature only functions in survival mode
	}
	
	/**
	 * Overriding Method, active when a block is being placed.
	 * <p>Some zombies are actived when a block was being placed
	 * <p>Weather and Environment also changes
	 * <p>I chose to use Block Placed instead of Block Created.
	 * <p>Because Block Created would run both the server and client side, which creates double instances.
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param meta
	 * @param f1
	 * @param f2
	 * @param f3
	 * @param i4
	 */
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int meta, float f1, float f2, float f3, int i4) {
		//accessor and mutator
		world.getWorldInfo().setRaining(true);
		world.setRainStrength(10);
		world.setWorldTime(15000); //minecraft 7pm.
		world.setBlock(x, y, z, Tutorial.tutorialBlock);
		//Create enetities
		for (int i = 0; i<3; i++){
			EntityIronGolem mymonster = new EntityIronGolem(world);
			mymonster.setPosition(x,y+1,z);
			//attack closest player
			mymonster.setAttackTarget(world.getClosestPlayerToEntity(mymonster, 25));
			mymonster.setCustomNameTag("Killer Bot");
			//seperate server and client side data, make sure only one instance was created.
			if (!world.isRemote){
				world.spawnEntityInWorld(mymonster);
				//create a lightning bowl right on the block
				world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));	
			}
		}
		//Create enetities for 80 times
		for (int i = 0; i<80; i++){
			EntitySkeleton soldier = new EntitySkeleton(world);
			soldier.setPosition(x,y+1,z);
			//attack closest player
			soldier.setAttackTarget(world.getClosestPlayerToEntity(soldier, 25));
			soldier.setCustomNameTag("Skeleton Soldier");
			//seperate server and client side data, make sure only one instance was created.
			if (!world.isRemote){
				world.spawnEntityInWorld(soldier);
			}
		}
		return i4;

	}
	/**
	 * Overriding Method, active when a block is being destroyed only by the player hitting it. 
	 * <p>Weather and Environment changes when the block is destroyed
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param meta
	 */
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y , int z, int meta){
		world.setWorldTime(0); //minecraft 6am.
		//mutator
		world.getWorldInfo().setRaining(false);
	}
	
	/**
	 * Overloaded Constructor
	 * This sets the customized material and texture on the extended block class.
	 * @param myMaterial
	 */
	//overloaded consturctor that gives the option to set a material
	public BlockTutorialBlock(Material myMaterial){
		super(myMaterial);
		setBlockName("tutorialBlock");
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	
	//declare a variable for the texture for each side of the new block
	@SideOnly(Side.CLIENT)
	private IIcon topTexture;
	private IIcon southTexture;
	private IIcon northTexture;
	private IIcon eastTexture;
	private IIcon westTexture;
	private IIcon bottomTexture;
	
	/**
	 * Overriding Method, set the values for each of the texture variables
	 * <p>set target file names in order to fetch the designated files in assets.
	 */
	//set the values for each of the texture variables
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(Tutorial.modid  + ":" + this.getUnlocalizedName().substring(5));
		this.topTexture = iconRegister.registerIcon(Tutorial.modid  + ":" + this.getUnlocalizedName().substring(5) + "_top");
		this.southTexture = iconRegister.registerIcon(Tutorial.modid  + ":" + this.getUnlocalizedName().substring(5) + "_south");
		this.northTexture = iconRegister.registerIcon(Tutorial.modid  + ":" + this.getUnlocalizedName().substring(5) + "_north");
		this.eastTexture = iconRegister.registerIcon(Tutorial.modid  + ":" + this.getUnlocalizedName().substring(5) + "_east");
		this.westTexture = iconRegister.registerIcon(Tutorial.modid  + ":" + this.getUnlocalizedName().substring(5) + "_west");
		this.bottomTexture = iconRegister.registerIcon(Tutorial.modid  + ":" + this.getUnlocalizedName().substring(5) + "_bottom");
	}

	
	/**
	 * Overriding Method, match each side of the block to the right texture.
	 * <p>match each side of the block to the right texture.
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta){
		if (side == 1){
			return this.topTexture;
		}else if (side == 2){
			return this.northTexture;
		}else if (side == 3){
			return this.southTexture;
		}else if (side == 4){
			return this.westTexture;
		}else if (side == 5){
			return this.eastTexture;
		}else if (side == 0){
			return this.bottomTexture;
		}
		return blockIcon;
	}
}
