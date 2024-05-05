package net.zero.testmod;

import net.fabricmc.api.ModInitializer;

import net.zero.testmod.init.EntityInit;
import net.zero.testmod.init.ItemInit;
import net.zero.testmod.items.ModItemGroups;
import net.zero.testmod.items.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {

	public static final String MOD_ID = "testmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ItemInit.registerItems();
		EntityInit.init();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}