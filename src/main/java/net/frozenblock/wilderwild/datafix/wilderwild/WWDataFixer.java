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

package net.frozenblock.wilderwild.datafix.wilderwild;

import com.mojang.datafixers.DSL;
import com.mojang.datafixers.schemas.Schema;
import java.util.Map;
import net.fabricmc.fabric.api.datafixer.v1.DataFixerEntrypoint;
import net.fabricmc.fabric.api.datafixer.v1.FabricDataFixerBuilder;
import net.fabricmc.fabric.api.datafixer.v1.FabricDataFixes;
import net.fabricmc.fabric.api.datafixer.v1.SchemaRegistry;
import net.fabricmc.fabric.api.datafixer.v1.SimpleFixes;
import net.fabricmc.loader.api.ModContainer;
import net.frozenblock.wilderwild.datafix.wilderwild.datafixers.DrySandStateFix;
import net.frozenblock.wilderwild.datafix.wilderwild.datafixers.NematocystStateFix;
import net.frozenblock.wilderwild.datafix.wilderwild.datafixers.OsseousSculkStateFix;
import net.frozenblock.wilderwild.datafix.wilderwild.datafixers.ScorchedSandStateFix2;
import net.frozenblock.wilderwild.misc.WilderSharedConstants;
import net.minecraft.util.datafix.DataFixers;
import net.minecraft.util.datafix.fixes.BlockEntityRenameFix;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.util.datafix.schemas.NamespacedSchema;
import net.minecraft.util.datafix.schemas.V100;
import org.jetbrains.annotations.NotNull;

public class WWDataFixer implements DataFixerEntrypoint {

	@Override
	public void onRegisterBlockEntities(SchemaRegistry registry, Schema schema) {
		registry.register(
			WilderSharedConstants.id("display_lantern"),
			() -> DSL.optionalFields("Items", DSL.list(References.ITEM_STACK.in(schema)))
		);
		registry.register(
			WilderSharedConstants.id("hanging_tendril"),
			DSL::remainder
		);
		registry.register(
			WilderSharedConstants.id("scorched_block"),
			DSL::remainder
		);
		registry.register(
			WilderSharedConstants.id("stone_chest"),
			() -> DSL.optionalFields("Items", DSL.list(References.ITEM_STACK.in(schema)))
		);
		registry.register(
			WilderSharedConstants.id("termite_mound"),
			DSL::remainder
		);
		registry.register(
			WilderSharedConstants.id("geyser"),
			DSL::remainder
		);
	}

	@Override
	public void onRegisterEntities(SchemaRegistry registry, Schema schema) {
		registry.register(
			WilderSharedConstants.id("jellyfish"),
			() -> V100.equipment(schema)
		);
		registry.register(
			WilderSharedConstants.id("ostrich"),
			() -> V100.equipment(schema)
		);
		registry.register(
			WilderSharedConstants.id("crab"),
			() -> V100.equipment(schema)
		);
		registry.register(
			WilderSharedConstants.id("firefly"),
			() -> V100.equipment(schema)
		);
		registry.register(
			WilderSharedConstants.id("tumbleweed"),
			(string) -> DSL.optionalFields("Items", References.ITEM_STACK.in(schema), V100.equipment(schema))
		);
		registry.register(
			WilderSharedConstants.id("ancient_horn_vibration"),
			DSL::remainder
		);
		registry.register(
			WilderSharedConstants.id("coconut"),
			DSL::remainder
		);
		registry.register(
			WilderSharedConstants.id("chest_bubbler"),
			DSL::remainder
		);
		registry.register(
			WilderSharedConstants.id("sculk_spreader"),
			DSL::remainder
		);
		registry.register(
			WilderSharedConstants.id("scorched"),
			() -> V100.equipment(schema)
		);
	}

	public static final int DATA_VERSION = 18;

	public static void applyDataFixes(final @NotNull ModContainer mod) {
		WilderSharedConstants.log("Applying DataFixes for Wilder Wild with Data Version " + DATA_VERSION, true);
		var builder = new FabricDataFixerBuilder(DATA_VERSION);
		builder.addSchema(0, FabricDataFixes.BASE_SCHEMA);

		Schema schemaV1 = builder.addSchema(1, NamespacedSchema::new);
		SimpleFixes.addBlockRenameFix(builder, "Rename white_dandelion to blooming_dandelion", WilderSharedConstants.id("white_dandelion"), WilderSharedConstants.id("blooming_dandelion"), schemaV1);
		SimpleFixes.addBlockRenameFix(builder, "Rename potted_white_dandelion to potted_blooming_dandelion", WilderSharedConstants.id("potted_white_dandelion"), WilderSharedConstants.id("potted_blooming_dandelion"), schemaV1);

		Schema schemaV2 = builder.addSchema(2, NamespacedSchema::new);
		SimpleFixes.addBlockRenameFix(builder, "Rename blooming_dandelion to seeding_dandelion", WilderSharedConstants.id("blooming_dandelion"), WilderSharedConstants.id("seeding_dandelion"), schemaV2);
		SimpleFixes.addBlockRenameFix(builder, "Rename potted_blooming_dandelion to potted_seeding_dandelion", WilderSharedConstants.id("potted_blooming_dandelion"), WilderSharedConstants.id("potted_seeding_dandelion"), schemaV2);

		Schema schemaV3 = builder.addSchema(3, NamespacedSchema::new);
		SimpleFixes.addBlockRenameFix(builder, "Rename floating_moss to algae", WilderSharedConstants.id("floating_moss"), WilderSharedConstants.id("algae"), schemaV3);
		SimpleFixes.addItemRenameFix(builder, "Rename floating_moss to algae", WilderSharedConstants.id("floating_moss"), WilderSharedConstants.id("algae"), schemaV3);

		Schema schemaV4 = builder.addSchema(4, NamespacedSchema::new);
		SimpleFixes.addBlockRenameFix(builder, "Rename test_1 to null_block", WilderSharedConstants.id("test_1"), WilderSharedConstants.id("null_block"), schemaV4);

		Schema schemaV5 = builder.addSchema(5, NamespacedSchema::new);
		SimpleFixes.addBlockRenameFix(builder, "Rename sculk_echoer to null_block", WilderSharedConstants.id("sculk_echoer"), WilderSharedConstants.id("null_block"), schemaV5);
		SimpleFixes.addBlockRenameFix(builder, "Rename sculk_jaw to null_block", WilderSharedConstants.id("sculk_jaw"), WilderSharedConstants.id("null_block"), schemaV5);

		Schema schemaV6 = builder.addSchema(6, NamespacedSchema::new);
		SimpleFixes.addBlockRenameFix(builder, "Rename baobab_sapling to baobab_nut", WilderSharedConstants.id("baobab_sapling"), WilderSharedConstants.id("baobab_nut"), schemaV6);
		SimpleFixes.addBlockRenameFix(builder, "Rename baobab_nut_sapling to baobab_nut", WilderSharedConstants.id("baobab_nut_sapling"), WilderSharedConstants.id("baobab_nut"), schemaV6);
		SimpleFixes.addBlockRenameFix(builder, "Rename potted_baobab_sapling to potted_baobab_nut", WilderSharedConstants.id("potted_baobab_sapling"), WilderSharedConstants.id("potted_baobab_nut"), schemaV6);

		Schema schemaV7 = builder.addSchema(7, NamespacedSchema::new);
		SimpleFixes.addBlockRenameFix(builder, "Rename firefly_lantern to display_lantern", WilderSharedConstants.id("firefly_lantern"), WilderSharedConstants.id("display_lantern"), schemaV7);
		SimpleFixes.addBlockRenameFix(builder, "Rename mesoglea to blue_pearlescent_mesoglea", WilderSharedConstants.id("mesoglea"), WilderSharedConstants.id("blue_pearlescent_mesoglea"), schemaV7);
		SimpleFixes.addItemRenameFix(builder, "Rename mesoglea to blue_pearlescent_mesoglea", WilderSharedConstants.id("mesoglea"), WilderSharedConstants.id("blue_pearlescent_mesoglea"), schemaV7);

		Schema schemaV8 = builder.addSchema(8, NamespacedSchema::new);
		org.quiltmc.qsl.frozenblock.misc.datafixerupper.api.SimpleFixes.addBlockStateRenameFix(builder, "display_lantern_rename_fix", WilderSharedConstants.id("display_lantern"), "light", "0", "display_light", schemaV8);

		Schema schemaV9 = builder.addSchema(9, NamespacedSchema::new);
		builder.addFixer(new NematocystStateFix(schemaV9, "blue_nematocyst_fix", WilderSharedConstants.id("blue_nematocyst")));
		builder.addFixer(new NematocystStateFix(schemaV9, "blue_pearlescent_nematocyst_fix", WilderSharedConstants.id("blue_pearlescent_nematocyst")));
		builder.addFixer(new NematocystStateFix(schemaV9, "lime_nematocyst_fix", WilderSharedConstants.id("lime_nematocyst")));
		builder.addFixer(new NematocystStateFix(schemaV9, "pink_nematocyst_fix", WilderSharedConstants.id("pink_nematocyst")));
		builder.addFixer(new NematocystStateFix(schemaV9, "purple_pearlescent_nematocyst_fix", WilderSharedConstants.id("purple_pearlescent_nematocyst")));
		builder.addFixer(new NematocystStateFix(schemaV9, "red_nematocyst_fix", WilderSharedConstants.id("red_nematocyst")));
		builder.addFixer(new NematocystStateFix(schemaV9, "yellow_nematocyst_fix", WilderSharedConstants.id("yellow_nematocyst")));

		Schema schemaV10 = builder.addSchema(10, NamespacedSchema::new);
		SimpleFixes.addBlockRenameFix(builder, "Rename palm_sapling to coconut", WilderSharedConstants.id("palm_sapling"), WilderSharedConstants.id("coconut"), schemaV10);

		Schema schemaV11 = builder.addSchema(11, NamespacedSchema::new);
		builder.addFixer(new DrySandStateFix(schemaV11, "dry_sand_crackness_to_crackedness", WilderSharedConstants.id("dry_sand")));
		SimpleFixes.addBlockRenameFix(builder, "Rename dry_sand to scorched_sand", WilderSharedConstants.id("dry_sand"), WilderSharedConstants.id("scorched_sand"), schemaV11);
		SimpleFixes.addItemRenameFix(builder, "Rename dry_sand to scorched_sand", WilderSharedConstants.id("dry_sand"), WilderSharedConstants.id("scorched_sand"), schemaV11);
		builder.addFixer(new DrySandStateFix(schemaV11, "scorched_sand_crackness_to_crackedness", WilderSharedConstants.id("scorched_sand")));

		Schema schemaV13 = builder.addSchema(13, NamespacedSchema::new);
		SimpleFixes.addBlockRenameFix(builder, "Rename palm_leaves to palm_fronds", WilderSharedConstants.id("palm_leaves"), WilderSharedConstants.id("palm_fronds"), schemaV13);
		SimpleFixes.addItemRenameFix(builder, "Rename palm_leaves to palm_fronds", WilderSharedConstants.id("palm_leaves"), WilderSharedConstants.id("palm_fronds"), schemaV13);

		Schema schemaV14 = builder.addSchema(14, NamespacedSchema::new);
		builder.addFixer(new ScorchedSandStateFix2(schemaV14, "scorched_sand_integer_to_boolean", WilderSharedConstants.id("scorched_sand")));
		builder.addFixer(new ScorchedSandStateFix2(schemaV14, "scorched_red_sand_integer_to_boolean", WilderSharedConstants.id("scorched_red_sand")));

		Schema schemaV15 = builder.addSchema(15, NamespacedSchema::new);
		builder.addFixer(new OsseousSculkStateFix(schemaV15, "osseous_sculk_axis_to_direction", WilderSharedConstants.id("osseous_sculk")));

		Schema schemaV16 = builder.addSchema(16, NamespacedSchema::new);
		SimpleFixes.addItemRenameFix(builder, "Replace wilderwild:music_disc_back with minecraft:music_disc_5", WilderSharedConstants.id("music_disc_back"), WilderSharedConstants.vanillaId("music_disc_5"), schemaV16);
		SimpleFixes.addItemRenameFix(builder, "Replace wilderwild:music_disc_goathorn_symphony with minecraft:music_disc_otherside", WilderSharedConstants.id("music_disc_goathorn_symphony"), WilderSharedConstants.vanillaId("music_disc_otherside"), schemaV16);
		SimpleFixes.addEntityRenameFix(builder, "Rename ancient_horn_projectile to ancient_horn_vibration", WilderSharedConstants.id("ancient_horn_projectile"), WilderSharedConstants.id("ancient_horn_vibration"), schemaV16);

		Schema schemaV17 = builder.addSchema(17, NamespacedSchema::new);
		SimpleFixes.addBiomeRenameFix(builder, "Rename wilderwild:magma_caves to wilderwild:magmatic_caves", Map.of(WilderSharedConstants.id("magma_caves"), WilderSharedConstants.id("magmatic_caves")), schemaV17);

		Schema schemaV18 = builder.addSchema(18, WWV18::new);
		SimpleFixes.addBlockRenameFix(builder, "Rename stone chest to metal chest", WilderSharedConstants.id("stone_chest"), WilderSharedConstants.id("metal_chest"), schemaV18);
		SimpleFixes.addItemRenameFix(builder, "Rename stone chest item to metal chest", WilderSharedConstants.id("stone_chest"), WilderSharedConstants.id("metal_chest"), schemaV18);
		builder.addFixer(BlockEntityRenameFix.create(schemaV18, "Rename stone chest to metal chest", DataFixers.createRenamer(WilderSharedConstants.string("stone_chest"), WilderSharedConstants.string("metal_chest"))));

		FabricDataFixes.buildAndRegisterFixer(mod, builder);
		WilderSharedConstants.log("DataFixes for Wilder Wild have been applied", true);
	}
}
