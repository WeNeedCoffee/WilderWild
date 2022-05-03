package net.frozenblock.wilderwild.world.feature;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import static net.minecraft.world.gen.feature.VegetationPlacedFeatures.modifiers;
import static net.minecraft.world.gen.feature.VegetationPlacedFeatures.modifiersWithWouldSurvive;

public class WildPlacedFeature {
    //TREES
    public static final RegistryEntry<PlacedFeature> NEW_FALLEN_OAK_AND_BIRCH_PLACED = PlacedFeatures.register("new_fallen_oak_and_birch_placed",
            WildConfiguredFeatures.NEW_FALLEN_BIRCH_AND_OAK, RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> NEW_TREES_BIRCH_AND_OAK = PlacedFeatures.register("new_trees_birch_and_oak",
            WildConfiguredFeatures.NEW_TREES_BIRCH_AND_OAK, modifiers(PlacedFeatures.createCountExtraModifier(10, 0.1F, 1)));

    public static final RegistryEntry<PlacedFeature> NEW_FANCY_OAK_PLACED = PlacedFeatures.register("new_fancy_oak_placed",
            WildTreeConfigured.NEW_FANCY_OAK, modifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1F, 1), Blocks.OAK_SAPLING));

    public static final RegistryEntry<PlacedFeature> NEW_BIRCH_PLACED = PlacedFeatures.register("new_birch_placed",
            WildTreeConfigured.NEW_BIRCH_BEES_0004, modifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(10, 0.1F, 1), Blocks.BIRCH_SAPLING));

    public static final RegistryEntry<PlacedFeature> NEW_TALL_BIRCH_PLACED = PlacedFeatures.register("new_tall_birch_placed",
            WildTreeConfigured.NEW_SUPER_BIRCH_BEES_0004, modifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(10, 0.1F, 1), Blocks.BIRCH_SAPLING));

    public static final RegistryEntry<PlacedFeature> NEW_FALLEN_BIRCH_PLACED = PlacedFeatures.register("new_fallen_birch_placed",
            WildTreeConfigured.NEW_FALLEN_BIRCH_TREE, RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> HUGE_RED_MUSHROOM_PLACED = PlacedFeatures.register("huge_red_mushroom_placed",
            TreeConfiguredFeatures.HUGE_RED_MUSHROOM, RarityFilterPlacementModifier.of(90), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> NEW_TALL_DARK_OAK_PLACED = PlacedFeatures.register("new_tall_dark_oak_placed",
            WildTreeConfigured.NEW_TALL_DARK_OAK, modifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1F, 1), Blocks.DARK_OAK_SAPLING));

    //Decorations
    public static final RegistryEntry<PlacedFeature> NEW_MUSHROOM_PLACED = PlacedFeatures.register("new_mushroom_placed",
            VegetationConfiguredFeatures.MUSHROOM_ISLAND_VEGETATION, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> NEW_BROWN_MUSHROOM_PLACED = PlacedFeatures.register("new_brown_mushroom_placed",
            VegetationConfiguredFeatures.PATCH_BROWN_MUSHROOM, modifiers(10));

    public static final RegistryEntry<PlacedFeature> NEW_GRASS_PLACED = PlacedFeatures.register("new_grass_placed",
            VegetationConfiguredFeatures.PATCH_GRASS_JUNGLE, modifiers(20));

    public static final RegistryEntry<PlacedFeature> DATURA_BIRCH = PlacedFeatures.register("darura_birch",
            WildConfiguredFeatures.DATURA, RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> CARNATION_BIRCH = PlacedFeatures.register("carnation_birch",
            WildConfiguredFeatures.CARNATION, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> POLLEN_PLACED = PlacedFeatures.register("pollen",
            WildConfiguredFeatures.POLLEN_CONFIGURED, RarityFilterPlacementModifier.of(1), CountPlacementModifier.of(2), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, SquarePlacementModifier.of(), SurfaceThresholdFilterPlacementModifier.of(Heightmap.Type.MOTION_BLOCKING, 0, 128), BiomePlacementModifier.of());
}
