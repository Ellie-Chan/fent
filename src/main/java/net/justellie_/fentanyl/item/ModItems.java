package net.justellie_.fentanyl.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.justellie_.fentanyl.Fentanyl;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item FENTANYL = registerItem("fentanyl", new Item(new FabricItemSettings()));
    public static final Item RAW_FENTANYL = registerItem("raw_fentanyl", new Item(new FabricItemSettings()));

    public static final Item FENT_AND_STEAL = registerItem("fent_and_steal", new Item(new FabricItemSettings()));

    public static final Item FENTANYL_HELMET = registerItem("fentanyl_helmet", new ArmorItem(ModArmorMaterials.FENTANYL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item FENTANYL_CHESTPLATE = registerItem("fentanyl_chestplate", new ArmorItem(ModArmorMaterials.FENTANYL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item FENTANYL_LEGGINGS = registerItem("fentanyl_leggings", new ArmorItem(ModArmorMaterials.FENTANYL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item FENTANYL_BOOTS = registerItem("fentanyl_boots", new ArmorItem(ModArmorMaterials.FENTANYL, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item FENTANYL_SWORD = registerItem("fentanyl_sword", new SwordItem(ModToolMaterial.FENTANYL, 6, -3.6f, new FabricItemSettings()));

    public static final Item FENTANYL_PICKAXE = registerItem("fentanyl_pickaxe", new PickaxeItem(ModToolMaterial.FENTANYL, 4, -3.8f, new FabricItemSettings()));
    public static final Item FENTANYL_SHOVEL = registerItem("fentanyl_shovel", new ShovelItem(ModToolMaterial.FENTANYL, 4, -3f, new FabricItemSettings()));
    public static final Item FENTANYL_AXE = registerItem("fentanyl_axe", new AxeItem(ModToolMaterial.FENTANYL, 7, -3f, new FabricItemSettings()));
    public static final Item FENTANYL_HOE = registerItem("fentanyl_hoe", new HoeItem(ModToolMaterial.FENTANYL, 0, 0f, new FabricItemSettings()));

    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(FENTANYL_PICKAXE);
        entries.add(FENTANYL_SHOVEL);
        entries.add(FENTANYL_AXE);
        entries.add(FENTANYL_HOE);
        entries.add(FENT_AND_STEAL);
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(FENTANYL_HELMET);
        entries.add(FENTANYL_CHESTPLATE);
        entries.add(FENTANYL_LEGGINGS);
        entries.add(FENTANYL_BOOTS);

        entries.add(FENTANYL_SWORD);
    }

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(FENTANYL);
        entries.add(RAW_FENTANYL);
    }

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(Fentanyl.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        Fentanyl.LOGGER.info("Register Items for " + Fentanyl.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
    }




}
