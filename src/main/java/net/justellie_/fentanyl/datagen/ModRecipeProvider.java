package net.justellie_.fentanyl.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.justellie_.fentanyl.block.ModBlocks;
import net.justellie_.fentanyl.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> FENT_SMELTABLE =
            List.of(ModItems.RAW_FENTANYL,
                    ModBlocks.DEEPSLATE_FENTANYL_ORE,
                    ModBlocks.FENTANYL_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter,
                FENT_SMELTABLE,
                RecipeCategory.MISC,
                ModItems.FENTANYL,
                0.7f,
                200,
                "fentanyl");

        offerBlasting(exporter,
                FENT_SMELTABLE,
                RecipeCategory.MISC,
                ModItems.FENTANYL,
                0.7f,
                100,
                "fentanyl");

        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.BUILDING_BLOCKS,
                ModItems.FENTANYL,
                RecipeCategory.DECORATIONS,
                ModBlocks.FENTANYL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_FENTANYL, 1)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .input('C', ModItems.FENTANYL)
                .input('S', Items.STONE)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.FENTANYL), conditionsFromItem(ModItems.FENTANYL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_FENTANYL)));
    }
}
