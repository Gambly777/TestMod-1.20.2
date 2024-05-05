package net.zero.testmod.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import net.zero.testmod.init.EntityInit;
import net.zero.testmod.init.ItemInit;

public class ElderArrowEntity
        extends PersistentProjectileEntity {
    public PickupPermission pickupType = PickupPermission.DISALLOWED;

    public ElderArrowEntity(EntityType<? extends ElderArrowEntity> entityType, World world) {
        super((EntityType<? extends PersistentProjectileEntity>)entityType, world);
        this.setDamage(5.0);
    }

    public ElderArrowEntity(World world, double x, double y, double z) {
        super(EntityInit.ELDER_ARROW, x, y, z, world);
        this.setDamage(5.0);
    }

    public ElderArrowEntity(World world, LivingEntity owner) {
        super(EntityInit.ELDER_ARROW, owner, world);
        this.setDamage(5.0);
    }


    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            if (this.inGround) {
                if (this.inGroundTime % 5 == 0) {
                    this.spawnParticles(1);
                }
            } else {
                this.spawnParticles(2);
            }
        } else if (this.inGround && this.inGroundTime != 0 && this.inGroundTime >= 600) {
            this.getWorld().sendEntityStatus(this, (byte)0);
        }
    }

    private void spawnParticles(int amount) {
        double d = (double)(16 & 0xFF) / 255.0;
        double e = (double)(8 & 0xFF) / 255.0;
        double f = (double)(0) / 255.0;
        for (int j = 0; j < amount; ++j) {
            this.getWorld().addParticle(ParticleTypes.MYCELIUM, this.getParticleX(0.5), this.getRandomBodyY(), this.getParticleZ(0.5), d, e, f);
        }
    }
    protected ItemStack asItemStack() {
        return new ItemStack(ItemInit.ELDER_ARROW_ITEM);
    }
}