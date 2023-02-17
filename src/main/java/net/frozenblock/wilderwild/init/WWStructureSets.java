package net.frozenblock.wilderwild.init;

import net.frozenblock.wilderwild.WilderWild;
import net.frozenblock.wilderwild.world.structure.AbandonedCabinGenerator;
import net.frozenblock.wilderwild.world.structure.WilderStructureProcessors;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import java.util.Map;

public class WWStructureSets {

    public static final ResourceKey<StructureSet> ABANDONED_CABINS_KEY = ofSet("abandoned_cabins");

    private static ResourceKey<StructureSet> ofSet(String id) {
        return ResourceKey.create(Registry.STRUCTURE_SET_REGISTRY, WilderWild.id(id));
    }

    private static Holder<StructureSet> register(ResourceKey<StructureSet> key, StructureSet structureSet) {
        return BuiltinRegistries.register(BuiltinRegistries.STRUCTURE_SETS, key, structureSet);
    }

    private static Holder<StructureSet> register(ResourceKey<StructureSet> key, Holder<Structure> structure, StructurePlacement placement) {
        return register(key, new StructureSet(structure, placement));
    }

    private static final ResourceKey<Structure> ABANDONED_CABIN_KEY = of("abandoned_cabin");

    public static final Holder<Structure> ABANDONED_CABIN = register(
            ABANDONED_CABIN_KEY,
            new JigsawStructure(
                    createConfig(
                            WWBiomeTags.ABANDONED_CABIN_HAS_STRUCTURE,
                            GenerationStep.Decoration.UNDERGROUND_DECORATION,
                            TerrainAdjustment.BURY
                    ),
                    AbandonedCabinGenerator.CABIN,
                    5,
                    UniformHeight.of(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(0)),
                    false
            )
    );

    public static final Holder<StructureSet> ABANDONED_CABINS = register(
            ABANDONED_CABINS_KEY,
            ABANDONED_CABIN,
            new RandomSpreadStructurePlacement(
                    13,
                    5,
                    RandomSpreadType.LINEAR,
                    25388232
            )
    );

    public static void init() {
        WilderWild.logWild("Registering Structures for", WilderWild.UNSTABLE_LOGGING);
        WilderStructureProcessors.init();
        AbandonedCabinGenerator.init();
    }

    private static ResourceKey<Structure> of(String id) {
        return ResourceKey.create(Registry.STRUCTURE_REGISTRY, WilderWild.id(id));
    }

    private static Structure.StructureSettings createConfig(TagKey<Biome> biomeTag, Map<MobCategory, StructureSpawnOverride> spawns, GenerationStep.Decoration featureStep, TerrainAdjustment terrainAdaptation) {
        return new Structure.StructureSettings(getOrCreateBiomeTag(biomeTag), spawns, featureStep, terrainAdaptation);
    }

    private static Structure.StructureSettings createConfig(TagKey<Biome> biomeTag, GenerationStep.Decoration featureStep, TerrainAdjustment terrainAdaptation) {
        return createConfig(biomeTag, Map.of(), featureStep, terrainAdaptation);
    }

    private static Holder<Structure> register(ResourceKey<Structure> key, Structure structure) {
        return BuiltinRegistries.register(BuiltinRegistries.STRUCTURES, key, structure);
    }

    private static HolderSet<Biome> getOrCreateBiomeTag(TagKey<Biome> key) {
        return BuiltinRegistries.BIOME.getOrCreateTag(key);
    }
}
