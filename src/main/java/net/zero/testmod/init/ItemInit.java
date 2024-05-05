package net.zero.testmod.init;

import net.zero.testmod.entities.*;
import net.zero.testmod.items.FireArrowItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;

import static net.zero.testmod.TestMod.MOD_ID;


public class ItemInit {

    public static final FireArrowItem FIRE_ARROW_ITEM = new FireArrowItem(new Item.Settings());

    public static void registerDispenserBlockBehavior(Item item){
        DispenserBlock.registerBehavior(item, new ProjectileDispenserBehavior() {
            @Override
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {

                if (item instanceof FireArrowItem)
                {
                    FireArrowEntity arrowEntity = new FireArrowEntity(world, position.getX(), position.getY(), position.getZ());
                    arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
                    return arrowEntity;
                } else return null;
            }
        });
    }


    public static void registerItems()
    {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "fire_arrow"), FIRE_ARROW_ITEM);


        registerDispenserBlockBehavior(FIRE_ARROW_ITEM);
    }
}
