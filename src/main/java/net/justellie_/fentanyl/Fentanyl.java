package net.justellie_.fentanyl;

import net.fabricmc.api.ModInitializer;

import net.justellie_.fentanyl.item.ModItems;
import net.justellie_.fentanyl.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fentanyl implements ModInitializer {

	public static final String MOD_ID = "fentanyl";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		LOGGER.info("Hello Fabric world!");
	}
}