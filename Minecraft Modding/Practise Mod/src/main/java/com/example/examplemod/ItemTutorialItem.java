package com.example.examplemod;
//import libraries 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;


/**
 * Simon Guo's Minecraft Item, an inheritance from Item
 * <p>2016 Upper Canada College FY computer science exam 
 * <p>Create a minecraft mod, which includes a block and a tool.
 * <p>The Item does....
 * <p>This item extends on the item class. 
 * <p>Note that some of the features only works in survival mode, such as health loss.
 * <p>To switch to <strong>Survival Mode</strong>, please press <strong>T</strong> and type <strong>/gamemode 0</strong>, and then press enter
 * <p>To switch back to <strong>Creative Mode</strong>, please press <strong>T</strong> and type <strong>/gamemode 1</strong>, and then press enter
 * @since  2016-12-06
 * @version 1.0
 * @author simon.guo 
 * <a href="http://simonguo.tech" target="blank">click here learn more about me</a>
 */
public class ItemTutorialItem extends Item {

       ItemStack stack = new ItemStack(this);
       
       // Constructor
       public ItemTutorialItem () {  
       	   super();
       	   //mutator methods
	   	   this.setMaxStackSize(64);
	   	   this.setUnlocalizedName("tutorialItem");
	   	   //set texture.
	       setTextureName(Tutorial.modid + ":" + this.getUnlocalizedName().substring(5));
	       setCreativeTab(CreativeTabs.tabMisc);
       }
       
      
       /**
	   	 * Overriding Method, active when the item is right clicked
	   	 * <p>A lightning hits the pointed location and create explosion.
	   	 * <p>There is also sound effect (input from assets)
	   	 * <p>Credit to Mr.Hoel and <a href="http://www.planetminecraft.com/blog/modding-tutorial-making-an-item-spawn-lightning" target="blank">this website</a>
	   	 * @param itemstack
	   	 * @param world
	   	 * @param entityplayer
	   	 * @author mark.hoel simon.guo
	   	 */
    	@Override
    	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
            
        	//complicated math to find out where entity player is
        	float f = 1.0F;
            float f1 = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f;
            float f2 = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;
            double d = entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * (double)f;
            double d1 = (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * (double)f + 1.6200000000000001D) - (double)entityplayer.yOffset;
            double d2 = entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * (double)f;
            Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
            float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
            float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
            float f5 = -MathHelper.cos(-f1 * 0.01745329F);
            float f6 = MathHelper.sin(-f1 * 0.01745329F);
            float f7 = f4 * f5;
            float f8 = f6;
            float f9 = f3 * f5;
            double d3 = 5000D;
            Vec3 vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3, (double)f9 * d3);
            //calculated object location.
            MovingObjectPosition movingobjectposition = world.rayTraceBlocks(vec3d, vec3d1);
            
            //function that decides what to do under different circumstances
            if (movingobjectposition == null) {
            	return itemstack;
            	//do nothing if nothing is hitted
            }

            //for tile: if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
            if (movingobjectposition.typeOfHit == MovingObjectType.BLOCK) {
            	//accessor / setter method
            	int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                // Create an instance of spawning a lightning bolt
                world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
                // Create explosion around the pointed area
                world.createExplosion(entityplayer, i, j, k, 4.5F, true);
                //play sound. Input from assets, passing that data through a .json file.
                entityplayer.worldObj.playSoundAtEntity(entityplayer, "tutorial:test", 1F, 1F);
                //world.spawnEntityInWorld(new EntityFireball(world,entityplayer, i, j, k));
                //world.spawnEntityInWorld(new EntityEnderPearl(world,entityplayer));
            }


            return itemstack;
        }
}


