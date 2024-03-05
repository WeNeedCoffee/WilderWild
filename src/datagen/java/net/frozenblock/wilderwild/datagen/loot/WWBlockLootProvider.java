/*
 * Copyright 2023-2024 FrozenBlock
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

package net.frozenblock.wilderwild.datagen.loot;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.frozenblock.wilderwild.registry.RegisterBlocks;
import net.frozenblock.wilderwild.registry.RegisterDataComponents;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

public final class WWBlockLootProvider extends FabricBlockLootTableProvider {

	public WWBlockLootProvider(@NotNull FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registries) {
		super(dataOutput, registries);
	}

	@Override
	public void generate() {
		this.dropSelf(RegisterBlocks.BAOBAB_LOG);
		this.dropSelf(RegisterBlocks.STRIPPED_BAOBAB_LOG);
		this.dropSelf(RegisterBlocks.BAOBAB_WOOD);
		this.dropSelf(RegisterBlocks.STRIPPED_BAOBAB_WOOD);
		this.dropSelf(RegisterBlocks.HOLLOWED_BAOBAB_LOG);
		this.dropSelf(RegisterBlocks.STRIPPED_HOLLOWED_BAOBAB_LOG);
		this.dropSelf(RegisterBlocks.BAOBAB_PLANKS);
		this.dropSelf(RegisterBlocks.BAOBAB_BUTTON);
		this.dropSelf(RegisterBlocks.BAOBAB_PRESSURE_PLATE);
		this.dropSelf(RegisterBlocks.BAOBAB_TRAPDOOR);
		this.dropSelf(RegisterBlocks.BAOBAB_STAIRS);
		this.add(RegisterBlocks.BAOBAB_SLAB, this::createSlabItemTable);
		this.dropSelf(RegisterBlocks.BAOBAB_FENCE);
		this.dropSelf(RegisterBlocks.BAOBAB_FENCE_GATE);
		this.add(RegisterBlocks.BAOBAB_DOOR, this::createDoorTable);
		this.dropSelf(RegisterBlocks.BAOBAB_SIGN);
		this.dropSelf(RegisterBlocks.BAOBAB_HANGING_SIGN);

		this.dropSelf(RegisterBlocks.CYPRESS_LOG);
		this.dropSelf(RegisterBlocks.STRIPPED_CYPRESS_LOG);
		this.dropSelf(RegisterBlocks.CYPRESS_WOOD);
		this.dropSelf(RegisterBlocks.STRIPPED_CYPRESS_WOOD);
		this.dropSelf(RegisterBlocks.HOLLOWED_CYPRESS_LOG);
		this.dropSelf(RegisterBlocks.STRIPPED_HOLLOWED_CYPRESS_LOG);
		this.dropSelf(RegisterBlocks.CYPRESS_PLANKS);
		this.dropSelf(RegisterBlocks.CYPRESS_BUTTON);
		this.dropSelf(RegisterBlocks.CYPRESS_PRESSURE_PLATE);
		this.dropSelf(RegisterBlocks.CYPRESS_TRAPDOOR);
		this.dropSelf(RegisterBlocks.CYPRESS_STAIRS);
		this.add(RegisterBlocks.CYPRESS_SLAB, this::createSlabItemTable);
		this.dropSelf(RegisterBlocks.CYPRESS_FENCE);
		this.dropSelf(RegisterBlocks.CYPRESS_FENCE_GATE);
		this.add(RegisterBlocks.CYPRESS_DOOR, this::createDoorTable);
		this.dropSelf(RegisterBlocks.CYPRESS_SIGN);
		this.dropSelf(RegisterBlocks.CYPRESS_HANGING_SIGN);
		this.dropSelf(RegisterBlocks.CYPRESS_SAPLING);
		this.add(RegisterBlocks.CYPRESS_LEAVES, block -> this.createLeavesDrops(block, RegisterBlocks.CYPRESS_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));

		this.dropSelf(RegisterBlocks.PALM_LOG);
		this.dropSelf(RegisterBlocks.STRIPPED_PALM_LOG);
		this.dropSelf(RegisterBlocks.PALM_WOOD);
		this.dropSelf(RegisterBlocks.STRIPPED_PALM_WOOD);
		this.dropSelf(RegisterBlocks.HOLLOWED_PALM_LOG);
		this.dropSelf(RegisterBlocks.STRIPPED_HOLLOWED_PALM_LOG);
		this.dropSelf(RegisterBlocks.PALM_CROWN);
		this.dropSelf(RegisterBlocks.PALM_PLANKS);
		this.dropSelf(RegisterBlocks.PALM_BUTTON);
		this.dropSelf(RegisterBlocks.PALM_PRESSURE_PLATE);
		this.dropSelf(RegisterBlocks.PALM_TRAPDOOR);
		this.dropSelf(RegisterBlocks.PALM_STAIRS);
		this.add(RegisterBlocks.PALM_SLAB, this::createSlabItemTable);
		this.dropSelf(RegisterBlocks.PALM_FENCE);
		this.dropSelf(RegisterBlocks.PALM_FENCE_GATE);
		this.add(RegisterBlocks.PALM_DOOR, this::createDoorTable);
		this.dropSelf(RegisterBlocks.PALM_SIGN);
		this.dropSelf(RegisterBlocks.PALM_HANGING_SIGN);

		this.dropSelf(RegisterBlocks.HOLLOWED_ACACIA_LOG);
		this.dropSelf(RegisterBlocks.STRIPPED_HOLLOWED_ACACIA_LOG);
		this.dropSelf(RegisterBlocks.HOLLOWED_BIRCH_LOG);
		this.dropSelf(RegisterBlocks.STRIPPED_HOLLOWED_BIRCH_LOG);
		this.dropSelf(RegisterBlocks.HOLLOWED_CHERRY_LOG);
		this.dropSelf(RegisterBlocks.STRIPPED_HOLLOWED_CHERRY_LOG);
		this.dropSelf(RegisterBlocks.HOLLOWED_CRIMSON_STEM);
		this.dropSelf(RegisterBlocks.STRIPPED_HOLLOWED_CRIMSON_STEM);
		this.dropSelf(RegisterBlocks.HOLLOWED_DARK_OAK_LOG);
		this.dropSelf(RegisterBlocks.STRIPPED_HOLLOWED_DARK_OAK_LOG);
		this.dropSelf(RegisterBlocks.HOLLOWED_JUNGLE_LOG);
		this.dropSelf(RegisterBlocks.STRIPPED_HOLLOWED_JUNGLE_LOG);
		this.dropSelf(RegisterBlocks.HOLLOWED_MANGROVE_LOG);
		this.dropSelf(RegisterBlocks.STRIPPED_HOLLOWED_MANGROVE_LOG);
		this.dropSelf(RegisterBlocks.HOLLOWED_OAK_LOG);
		this.dropSelf(RegisterBlocks.STRIPPED_HOLLOWED_OAK_LOG);
		this.dropSelf(RegisterBlocks.HOLLOWED_SPRUCE_LOG);
		this.dropSelf(RegisterBlocks.STRIPPED_HOLLOWED_SPRUCE_LOG);
		this.dropSelf(RegisterBlocks.HOLLOWED_WARPED_STEM);
		this.dropSelf(RegisterBlocks.STRIPPED_HOLLOWED_WARPED_STEM);

		this.dropSelf(RegisterBlocks.SEEDING_DANDELION);
		this.dropSelf(RegisterBlocks.CARNATION);
		this.dropSelf(RegisterBlocks.GLORY_OF_THE_SNOW);
		this.dropSelf(RegisterBlocks.FLOWERING_LILY_PAD);

		this.dropPottedContents(RegisterBlocks.POTTED_SHORT_GRASS);
		this.dropPottedContents(RegisterBlocks.POTTED_BUSH);
		this.dropPottedContents(RegisterBlocks.POTTED_BAOBAB_NUT);
		this.dropPottedContents(RegisterBlocks.POTTED_COCONUT);
		this.dropPottedContents(RegisterBlocks.POTTED_CYPRESS_SAPLING);
		this.dropPottedContents(RegisterBlocks.POTTED_CARNATION);
		this.dropPottedContents(RegisterBlocks.POTTED_SEEDING_DANDELION);
		this.dropPottedContents(RegisterBlocks.POTTED_TUMBLEWEED_PLANT);
		this.dropPottedContents(RegisterBlocks.POTTED_TUMBLEWEED);
		this.dropPottedContents(RegisterBlocks.POTTED_PRICKLY_PEAR);
		this.dropPottedContents(RegisterBlocks.POTTED_BIG_DRIPLEAF);
		this.dropPottedContents(RegisterBlocks.POTTED_SMALL_DRIPLEAF);

		this.dropSelf(RegisterBlocks.NULL_BLOCK);
		this.dropSelf(RegisterBlocks.CHISELED_MUD_BRICKS);
		this.dropSelf(RegisterBlocks.TERMITE_MOUND);
		this.dropSelf(RegisterBlocks.BLUE_MESOGLEA);
		this.dropWhenSilkTouch(RegisterBlocks.BLUE_NEMATOCYST);
		this.dropSelf(RegisterBlocks.LIME_MESOGLEA);
		this.dropWhenSilkTouch(RegisterBlocks.LIME_NEMATOCYST);
		this.dropSelf(RegisterBlocks.PINK_MESOGLEA);
		this.dropWhenSilkTouch(RegisterBlocks.PINK_NEMATOCYST);
		this.dropSelf(RegisterBlocks.YELLOW_MESOGLEA);
		this.dropWhenSilkTouch(RegisterBlocks.YELLOW_NEMATOCYST);
		this.dropSelf(RegisterBlocks.RED_MESOGLEA);
		this.dropWhenSilkTouch(RegisterBlocks.RED_NEMATOCYST);
		this.dropSelf(RegisterBlocks.BLUE_PEARLESCENT_MESOGLEA);
		this.dropWhenSilkTouch(RegisterBlocks.BLUE_PEARLESCENT_NEMATOCYST);
		this.dropSelf(RegisterBlocks.PURPLE_PEARLESCENT_MESOGLEA);
		this.dropWhenSilkTouch(RegisterBlocks.PURPLE_PEARLESCENT_NEMATOCYST);
		this.dropSelf(RegisterBlocks.OSTRICH_EGG);
		this.dropSelf(RegisterBlocks.GEYSER);
		this.dropWhenSilkTouch(RegisterBlocks.HANGING_TENDRIL);
		this.dropWhenSilkTouch(RegisterBlocks.OSSEOUS_SCULK);
		this.dropWhenSilkTouch(RegisterBlocks.SCULK_WALL);
		this.dropWhenSilkTouch(RegisterBlocks.SCULK_STAIRS);
		this.dropSelf(RegisterBlocks.STONE_CHEST);

		this.add(
			RegisterBlocks.DISPLAY_LANTERN,
			LootTable.lootTable()
				.withPool(
					LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(RegisterBlocks.DISPLAY_LANTERN))
						.apply(
							CopyComponentsFunction.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY).copy(RegisterDataComponents.FIREFLIES)
								.when(
									MatchTool.toolMatches(
										ItemPredicate.Builder.item().hasEnchantment(
											new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.ANY)
										)
									)
								)
						)
				)
		);

	}

}
