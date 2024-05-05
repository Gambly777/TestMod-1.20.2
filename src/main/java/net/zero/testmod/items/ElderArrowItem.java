package net.zero.testmod.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.zero.testmod.entities.ElderArrowEntity;

public class ElderArrowItem extends ArrowItem {

    public ElderArrowItem(Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new ElderArrowEntity(world, shooter);
    }
}