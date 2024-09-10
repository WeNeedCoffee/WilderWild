/*
 * Copyright 2024 FrozenBlock
 * This file is part of Wilder Wild.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, see <https://www.gnu.org/licenses/>.
 */

package net.frozenblock.wilderwild.datagen.recipe;

import com.google.common.collect.ImmutableList;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.frozenblock.lib.recipe.api.ShapedRecipeUtil;
import net.frozenblock.wilderwild.WWConstants;
import net.frozenblock.wilderwild.registry.WWBlocks;
import net.frozenblock.wilderwild.registry.WWDataComponents;
import net.frozenblock.wilderwild.registry.WWItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class WWRecipeProvider extends FabricRecipeProvider {
	public WWRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput exporter) {
		return new RecipeProvider(registries, exporter) {
			@Override
			public void buildRecipes() {
				HollowedLogRecipeProvider.buildRecipes(this, exporter);
				WWWoodRecipeProvider.buildRecipes(this, exporter);
				MesogleaRecipeProvider.buildRecipes(this, exporter);
				FireflyBottleRecipeProvider.buildRecipes(this, exporter);
				CopperHornRecipeProvider.buildRecipes(this, registries, exporter);
				WWNaturalRecipeProvider.buildRecipes(this, exporter);
				WWCookRecipeProvider.buildRecipes(this, exporter);

				ShapedRecipeUtil.withResultPatch(
					this.shaped(RecipeCategory.DECORATIONS, WWBlocks.DISPLAY_LANTERN)
						.define('X', Ingredient.of(Items.IRON_NUGGET))
						.define('#', Ingredient.of(Items.GLASS_PANE))
						.pattern("XXX")
						.pattern("X#X")
						.pattern("XXX")
						.unlockedBy(RecipeProvider.getHasName(Items.IRON_INGOT), this.has(Items.IRON_INGOT))
						.unlockedBy(RecipeProvider.getHasName(Items.IRON_NUGGET), this.has(Items.IRON_NUGGET)),
					DataComponentPatch.builder()
						.set(WWDataComponents.FIREFLIES, ImmutableList.of())
						.build()
				).save(exporter);

				this.shaped(RecipeCategory.MISC, WWBlocks.STONE_CHEST)
					.group("stone_chest")
					.define('_', Ingredient.of(Items.COBBLED_DEEPSLATE_SLAB))
					.define('#', Ingredient.of(Items.COBBLED_DEEPSLATE))
					.pattern("___")
					.pattern("# #")
					.pattern("###")
					.unlockedBy(RecipeProvider.getHasName(Items.COBBLED_DEEPSLATE), this.has(Items.COBBLED_DEEPSLATE))
					.save(exporter);

				this.shapeless(RecipeCategory.BUILDING_BLOCKS, WWItems.ECHO_GLASS)
					.requires(Items.ECHO_SHARD, 2)
					.requires(Items.TINTED_GLASS)
					.unlockedBy(RecipeProvider.getHasName(Items.ECHO_SHARD), this.has(Items.ECHO_SHARD))
					.save(exporter);

				this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.SANDSTONE, 2)
					.group("sandstone")
					.define('#', Ingredient.of(Items.SAND))
					.define('X', Ingredient.of(WWItems.SCORCHED_SAND))
					.pattern("#X")
					.pattern("X#")
					.unlockedBy(RecipeProvider.getHasName(Items.SAND), this.has(Items.SAND))
					.save(exporter, WWConstants.id(RecipeProvider.getConversionRecipeName(Items.SANDSTONE, WWItems.SCORCHED_SAND)));

				this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.RED_SANDSTONE, 2)
					.group("red_sandstone")
					.define('#', Ingredient.of(Items.RED_SAND))
					.define('X', Ingredient.of(WWItems.SCORCHED_RED_SAND))
					.pattern("#X")
					.pattern("X#")
					.unlockedBy(RecipeProvider.getHasName(Items.RED_SAND), this.has(Items.RED_SAND))
					.save(exporter, WWConstants.id(RecipeProvider.getConversionRecipeName(Items.RED_SANDSTONE, WWItems.SCORCHED_RED_SAND)));

				this.shaped(RecipeCategory.MISC, WWBlocks.NULL_BLOCK, 2)
					.define('#', Ingredient.of(Items.BLACK_CONCRETE))
					.define('X', Ingredient.of(Items.MAGENTA_CONCRETE))
					.pattern("#X")
					.pattern("X#")
					.unlockedBy(RecipeProvider.getHasName(Items.BLACK_CONCRETE), this.has(Items.BLACK_CONCRETE))
					.unlockedBy(RecipeProvider.getHasName(Items.MAGENTA_CONCRETE), this.has(Items.MAGENTA_CONCRETE))
					.save(exporter);

				this.shaped(RecipeCategory.REDSTONE, WWBlocks.GEYSER, 2)
					.define('#', Items.MAGMA_BLOCK)
					.define('X', Items.BASALT)
					.define('U', Items.LAVA_BUCKET)
					.pattern("#X#")
					.pattern("XUX")
					.pattern("#X#")
					.unlockedBy(getHasName(Items.MAGMA_BLOCK), has(Items.MAGMA_BLOCK))
					.save(exporter);

				this.shapeless(RecipeCategory.MISC, WWItems.FERMENTED_SCORCHED_EYE)
					.requires(WWItems.SCORCHED_EYE)
					.requires(Items.BROWN_MUSHROOM)
					.requires(Items.SUGAR)
					.unlockedBy(RecipeProvider.getHasName(WWItems.SCORCHED_EYE), this.has(WWItems.SCORCHED_EYE))
					.save(exporter);

				this.shapeless(RecipeCategory.MISC, WWItems.SCORCHED_EYE)
					.requires(Items.SPIDER_EYE)
					.requires(Items.BLAZE_POWDER)
					.unlockedBy(RecipeProvider.getHasName(Items.BLAZE_POWDER), this.has(Items.BLAZE_POWDER))
					.unlockedBy(RecipeProvider.getHasName(WWItems.SCORCHED_EYE), this.has(WWItems.SCORCHED_EYE))
					.save(exporter);

				this.shaped(RecipeCategory.MISC, Items.SPONGE)
					.define('#', WWBlocks.SPONGE_BUD)
					.pattern("###")
					.pattern("###")
					.pattern("###")
					.group("sponge")
					.unlockedBy(getHasName(WWBlocks.SPONGE_BUD), has(WWBlocks.SPONGE_BUD))
					.save(exporter, WWConstants.id(getConversionRecipeName(Items.SPONGE, WWBlocks.SPONGE_BUD)));

				// MUD BRICKS

				SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.MUD_BRICKS), RecipeCategory.BUILDING_BLOCKS, WWBlocks.CRACKED_MUD_BRICKS.asItem(), 0.1F, 200)
					.unlockedBy("has_mud_bricks", has(Blocks.MUD_BRICKS))
					.save(exporter);

				this.shaped(RecipeCategory.BUILDING_BLOCKS, WWBlocks.CHISELED_MUD_BRICKS)
					.define('#', Ingredient.of(Items.MUD_BRICK_SLAB))
					.pattern("#")
					.pattern("#")
					.unlockedBy(RecipeProvider.getHasName(Items.MUD_BRICKS), this.has(Items.MUD_BRICKS))
					.unlockedBy(RecipeProvider.getHasName(Items.MUD_BRICK_SLAB), this.has(Items.MUD_BRICK_SLAB))
					.unlockedBy(RecipeProvider.getHasName(WWBlocks.CHISELED_MUD_BRICKS), this.has(WWBlocks.CHISELED_MUD_BRICKS))
					.save(exporter);

				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, WWBlocks.CHISELED_MUD_BRICKS, Blocks.PACKED_MUD);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, WWBlocks.CHISELED_MUD_BRICKS, Blocks.MUD_BRICKS);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICKS, Blocks.PACKED_MUD);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_SLAB, Blocks.MUD_BRICKS, 2);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_SLAB, Blocks.PACKED_MUD, 2);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_STAIRS, Blocks.MUD_BRICKS);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_STAIRS, Blocks.PACKED_MUD);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_WALL, Blocks.MUD_BRICKS);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_WALL, Blocks.PACKED_MUD);

				// MOSSY MUD BRICKS

				this.shapeless(RecipeCategory.BUILDING_BLOCKS, WWBlocks.MOSSY_MUD_BRICKS)
					.requires(Blocks.MUD_BRICKS)
					.requires(Blocks.VINE)
					.group("mossy_mud_bricks")
					.unlockedBy("has_vine", has(Blocks.VINE))
					.save(exporter, getConversionRecipeName(WWBlocks.MOSSY_MUD_BRICKS, Blocks.VINE));

				this.shapeless(RecipeCategory.BUILDING_BLOCKS, WWBlocks.MOSSY_MUD_BRICKS)
					.requires(Blocks.MUD_BRICKS)
					.requires(Blocks.MOSS_BLOCK)
					.group("mossy_mud_bricks")
					.unlockedBy("has_moss_block", has(Blocks.MOSS_BLOCK))
					.save(exporter, getConversionRecipeName(WWBlocks.MOSSY_MUD_BRICKS, Blocks.MOSS_BLOCK));

				stairBuilder(
					WWBlocks.MOSSY_MUD_BRICK_STAIRS,
					Ingredient.of(WWBlocks.MOSSY_MUD_BRICKS)
				).unlockedBy(getHasName(WWBlocks.MOSSY_MUD_BRICKS), has(WWBlocks.MOSSY_MUD_BRICKS)).save(exporter);

				slab(RecipeCategory.BUILDING_BLOCKS, WWBlocks.MOSSY_MUD_BRICK_SLAB, WWBlocks.MOSSY_MUD_BRICKS);

				wall(RecipeCategory.MISC, WWBlocks.MOSSY_MUD_BRICK_WALL, WWBlocks.MOSSY_MUD_BRICKS);

				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, WWBlocks.MOSSY_MUD_BRICK_SLAB, WWBlocks.MOSSY_MUD_BRICKS, 2);
				stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, WWBlocks.MOSSY_MUD_BRICK_STAIRS, WWBlocks.MOSSY_MUD_BRICKS);
				stonecutterResultFromBase(RecipeCategory.DECORATIONS, WWBlocks.MOSSY_MUD_BRICK_WALL, WWBlocks.MOSSY_MUD_BRICKS);
			}
		};
	}

	public static void stonecutterResultFromBase(RecipeProvider provider, RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, ItemLike material, int resultCount) {
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(material), category, result, resultCount)
			.unlockedBy(RecipeProvider.getHasName(material), provider.has(material))
			.save(recipeOutput, WWConstants.id(RecipeProvider.getConversionRecipeName(result, material) + "_stonecutting"));
	}

	@Override
	@NotNull
	public String getName() {
		return "Wilder Wild Recipes";
	}
}
