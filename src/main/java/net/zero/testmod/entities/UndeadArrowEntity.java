package net.zero.testmod.entities;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZoglinEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.Difficulty;
import net.zero.testmod.init.ItemInit;
import net.zero.testmod.init.EntityInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;

import static net.minecraft.entity.EntityType.*;

public class UndeadArrowEntity
        extends PersistentProjectileEntity {
    public PickupPermission pickupType = PickupPermission.DISALLOWED;

    public UndeadArrowEntity(EntityType<? extends UndeadArrowEntity> entityType, World world) {
        super((EntityType<? extends PersistentProjectileEntity>)entityType, world);
    }

    public UndeadArrowEntity(World world, double x, double y, double z) {
        super(EntityInit.UNDEAD_ARROW, x, y, z, world);
    }

    public UndeadArrowEntity(World world, LivingEntity owner) {
        super(EntityInit.UNDEAD_ARROW, owner, world);
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


    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        ServerWorld world = target.getCommandSource().getWorld();
        if (world.getDifficulty() != Difficulty.PEACEFUL) {

            EntityType<?> type = target.getType();
            if (VILLAGER.equals(type)) {
                MobEntity entity = (MobEntity) target;
                ZombieVillagerEntity zombieVillagerEntity = entity.convertTo(ZOMBIE_VILLAGER, true);
                if (zombieVillagerEntity != null) {
                    zombieVillagerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0));
                }
            } else if (PIGLIN.equals(type)) {
                MobEntity entity = (MobEntity) target;
                ZombifiedPiglinEntity zombifiedPiglinEntity = entity.convertTo(ZOMBIFIED_PIGLIN, true);
                if (zombifiedPiglinEntity != null) {
                    zombifiedPiglinEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0));
                }
            } else if (PIGLIN_BRUTE.equals(type)) {
                MobEntity entity = (MobEntity) target;
                ZombifiedPiglinEntity zombifiedPiglinEntity = entity.convertTo(ZOMBIFIED_PIGLIN, true);
                if (zombifiedPiglinEntity != null) {
                    zombifiedPiglinEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0));
                }
            } else if (HOGLIN.equals(type)) {
                MobEntity entity = (MobEntity) target;
                ZoglinEntity zoglinEntity = entity.convertTo(ZOGLIN, true);
                if (zoglinEntity != null) {
                    zoglinEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0));
                }
            } else {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0));
            }
        }
        else target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0));
    }

    protected ItemStack asItemStack() {
        return new ItemStack(ItemInit.UNDEAD_ARROW_ITEM);
    }
}