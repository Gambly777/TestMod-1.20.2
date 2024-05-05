package net.zero.testmod.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.zero.testmod.TestMod;
import net.zero.testmod.init.ItemInit;

public class ModItemGroups {
    public static final ItemGroup COSMONITE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TestMod.MOD_ID, "cosmonite"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.cosmonite"))
                    .icon(() -> new ItemStack(ModItems.COSMONITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.COSMONITE);
                        entries.add(ItemInit.FIRE_ARROW_ITEM);
                        entries.add(ItemInit.UNDEAD_ARROW_ITEM);
                        entries.add(ItemInit.ELDER_ARROW_ITEM);

                    }).build());


    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering Item Groups for " + TestMod.MOD_ID);
    }
}
