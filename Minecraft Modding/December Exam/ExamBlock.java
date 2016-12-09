package com.exam.exammod;
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
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
* Simon Guo's Minecraft Block, an inheritance from block
* <p>2016 Upper Canada College FY computer science exam 
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
* <p>Create a minecraft mod, which includes a block and a tool.
* <p>This block inherits from Block and uses material sand.
* <p>Note that some of the features only works in survival mode, such as hardness and health loss.
* <p>To switch to <strong>Survival Mode</strong>, please press <strong>T</strong> and type <strong>/gamemode 0</strong>, and then press enter
* <p>To switch back to <strong>Creative Mode</strong>, please press <strong>T</strong> and type <strong>/gamemode 1</strong>, and then press enter
* @since  2016-12-06
* @version 1.0
* @author simon.guo 
* <a href="http://simonguo.tech" target="blank">click here learn more about me</a>
*/
//creating class, inheritance methods from block.
public class ExamBlock extends Block{
	//constructor
	public  ExamBlock(){
		//set block texture
		super(Material.sand);
		//setter/mutators methods
		setBlockName("tutorialBlock");
		setCreativeTab(CreativeTabs.tabBlock);
		this.setLightLevel(1.0F);
		this.setLightOpacity(100);
	}
	
	/**
	 * Overriding Method, active when a block is being placed
	 * <p>ExamBlock placed, time should be set to night and block should glow (sunlight)
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
		world.setWorldTime(15000); //minecraft 7pm.
		world.setBlock(x, y, z, ExamMod.ExamBlock);
		return i4;
	}
	//create a public variable that counts unique wolf number
	public int wolfnumber;
	/**
	 * Overriding Method, active when a block is being destroyed only by the player hitting it. 
	 * <p>ExamBlock destroyed, 3 wolves attack player with custom name "attack wolf"
	 * <p>ExamBlock destroyed, also spawn a zombie named "Ezekial Poopscraper"
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param meta
	 */
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y , int z, int meta){
		//Create three enetities wolves
		
		for (int i = 0; i<3; i++){
			EntityWolf attackwolf = new EntityWolf(world);
			attackwolf.setPosition(x,y+1,z);
			//attack closest player
			attackwolf.setAttackTarget(world.getClosestPlayerToEntity(attackwolf, 25));
			String displaywolfname = "Attack Wolf ";
			//convert wolf number to string and add them together
			displaywolfname = displaywolfname +  String.valueOf(wolfnumber);
			attackwolf.setCustomNameTag(displaywolfname);
			wolfnumber += 1;
			//seperate server and client side data, make sure only one instance was created.
			if (!world.isRemote){
				world.spawnEntityInWorld(attackwolf);
			}
		}
		//spawn a zombie
		EntityZombie zombie = new EntityZombie(world);
		zombie.setPosition(x, y+1, z);
		//attack closest player
		zombie.setAttackTarget(world.getClosestPlayerToEntity(zombie, 25));
		zombie.setCustomNameTag("Ezekial Poopscraper");
		if (!world.isRemote){
			world.spawnEntityInWorld(zombie);
		}
	
		
	}
	
	/**
	 * Overloaded Constructor
	 * This sets the customized material and texture on the extended block class.
	 * @param myMaterial
	 */
	//overloaded consturctor that gives the option to set a material
	public ExamBlock(Material myMaterial){
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
	 * @param iconRegister
	 */
	//set the values for each of the texture variables
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(ExamMod.modid  + ":" + this.getUnlocalizedName().substring(5));
		this.topTexture = iconRegister.registerIcon(ExamMod.modid  + ":" + this.getUnlocalizedName().substring(5) + "_top");
		this.southTexture = iconRegister.registerIcon(ExamMod.modid  + ":" + this.getUnlocalizedName().substring(5) + "_south");
		this.northTexture = iconRegister.registerIcon(ExamMod.modid  + ":" + this.getUnlocalizedName().substring(5) + "_north");
		this.eastTexture = iconRegister.registerIcon(ExamMod.modid  + ":" + this.getUnlocalizedName().substring(5) + "_east");
		this.westTexture = iconRegister.registerIcon(ExamMod.modid  + ":" + this.getUnlocalizedName().substring(5) + "_west");
		this.bottomTexture = iconRegister.registerIcon(ExamMod.modid  + ":" + this.getUnlocalizedName().substring(5) + "_bottom");
	}

	
	/**
	 * Overriding Method, match each side of the block to the right texture.
	 * <p>match each side of the block to the right texture.
	 * @param side
	 * @param meta
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
