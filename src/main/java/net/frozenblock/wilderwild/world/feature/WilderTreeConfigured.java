package net.frozenblock.wilderwild.world.feature;

import com.google.common.collect.ImmutableList;
import net.frozenblock.wilderwild.WilderWild;
import net.frozenblock.wilderwild.block.BaobabNutBlock;
import net.frozenblock.wilderwild.init.WWBlocks;
import net.frozenblock.wilderwild.world.feature.decorators.HeightBasedVineTrunkDecorator;
import net.frozenblock.wilderwild.world.feature.decorators.ShelfFungusTreeDecorator;
import net.frozenblock.wilderwild.world.feature.trunk.BaobabTrunkPlacer;
import net.frozenblock.wilderwild.world.feature.trunk.FallenTrunkWithLogs;
import net.frozenblock.wilderwild.world.gen.trunk.StraightTrunkWithLogs;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MangrovePropaguleBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.rootplacers.AboveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.UpwardsBranchingTrunkPlacer;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class WilderTreeConfigured {

    public static void init() { }

    private static final ShelfFungusTreeDecorator SHELF_FUNGUS_007 = new ShelfFungusTreeDecorator(0.074F, 0.3F);
    private static final ShelfFungusTreeDecorator SHELF_FUNGUS_006 = new ShelfFungusTreeDecorator(0.064F, 0.15F);
    private static final ShelfFungusTreeDecorator SHELF_FUNGUS_006_ONLY_BROWN = new ShelfFungusTreeDecorator(0.064F, 0.0F);
    private static final HeightBasedVineTrunkDecorator VINES_012_UNDER_76 = new HeightBasedVineTrunkDecorator(0.12F, 76, 0.25F);
    private static final HeightBasedVineTrunkDecorator VINES_008_UNDER_82 = new HeightBasedVineTrunkDecorator(0.08F, 82, 0.25F);
    private static final HeightBasedVineTrunkDecorator VINES_1_UNDER_260_03 = new HeightBasedVineTrunkDecorator(1F, 260, 0.3F);
    private static final HeightBasedVineTrunkDecorator VINES_1_UNDER_260_05 = new HeightBasedVineTrunkDecorator(1F, 260, 0.5F);
    private static final HeightBasedVineTrunkDecorator VINES_1_UNDER_260_075 = new HeightBasedVineTrunkDecorator(1F, 260, 0.75F);
    private static final HeightBasedVineTrunkDecorator VINES_08_UNDER_260_075 = new HeightBasedVineTrunkDecorator(0.8F, 260, 0.75F);
    private static final BeehiveDecorator BEES_0004 = new BeehiveDecorator(0.004F);
    private static final BeehiveDecorator BEES = new BeehiveDecorator(1.0F);
    //BIRCH
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> BIRCH_TREE = WilderConfiguredFeatures.register("birch_tree", Feature.TREE, birch().dirt(BlockStateProvider.simple(Blocks.DIRT)).decorators(ImmutableList.of(SHELF_FUNGUS_007)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> BIRCH_BEES_0004 = WilderConfiguredFeatures.register("birch_bees_0004", Feature.TREE, birch().decorators(ImmutableList.of(BEES_0004, SHELF_FUNGUS_007)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DYING_BIRCH = WilderConfiguredFeatures.register("dying_birch", Feature.TREE, birch().decorators(ImmutableList.of(BEES_0004, SHELF_FUNGUS_007)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SHORT_BIRCH_BEES_0004 = WilderConfiguredFeatures.register("short_birch_bees_0004", Feature.TREE, shortBirch().decorators(ImmutableList.of(BEES_0004, SHELF_FUNGUS_006)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SUPER_BIRCH_BEES_0004 = WilderConfiguredFeatures.register("super_birch_bees_0004", Feature.TREE, superBirch().decorators(ImmutableList.of(BEES_0004, SHELF_FUNGUS_007)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DYING_SUPER_BIRCH = WilderConfiguredFeatures.register("dying_super_birch", Feature.TREE, superBirch().decorators(ImmutableList.of(VINES_1_UNDER_260_05, SHELF_FUNGUS_007)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FALLEN_BIRCH_TREE = WilderConfiguredFeatures.register("fallen_birch_tree", Feature.TREE, fallen_birch().decorators(List.of(VINES_08_UNDER_260_075)).dirt(BlockStateProvider.simple(Blocks.DIRT)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SHORT_BIRCH = WilderConfiguredFeatures.register("short_birch", Feature.TREE, shortBirch().decorators(ImmutableList.of(SHELF_FUNGUS_006)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SHORT_DYING_BIRCH = WilderConfiguredFeatures.register("short_dying_birch", Feature.TREE, shortBirch().decorators(ImmutableList.of(SHELF_FUNGUS_006, VINES_1_UNDER_260_03)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SUPER_BIRCH_BEES = WilderConfiguredFeatures.register("super_birch_bees", Feature.TREE, superBirch().decorators(ImmutableList.of(BEES)).build());
    //OAK
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> OAK = WilderConfiguredFeatures.register("oak", Feature.TREE, oak().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SHORT_OAK = WilderConfiguredFeatures.register("short_oak", Feature.TREE, short_oak().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> OAK_BEES_0004 = WilderConfiguredFeatures.register("oak_bees_0004", Feature.TREE, oak().decorators(ImmutableList.of(BEES_0004, SHELF_FUNGUS_006)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DYING_OAK = WilderConfiguredFeatures.register("dying_oak", Feature.TREE, oak().decorators(ImmutableList.of(VINES_1_UNDER_260_03, SHELF_FUNGUS_006)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FANCY_OAK = WilderConfiguredFeatures.register("fancy_oak", Feature.TREE, fancyOak().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FANCY_DYING_OAK = WilderConfiguredFeatures.register("fancy_dying_oak", Feature.TREE, fancyOak().decorators(List.of(VINES_1_UNDER_260_05)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FANCY_DYING_OAK_BEES_0004 = WilderConfiguredFeatures.register("fancy_dying_oak_bees_0004", Feature.TREE, fancyOak().decorators(List.of(BEES_0004, VINES_1_UNDER_260_05)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FANCY_OAK_BEES_0004 = WilderConfiguredFeatures.register("fancy_oak_bees_0004", Feature.TREE, fancyOak().decorators(List.of(BEES_0004)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FALLEN_OAK_TREE = WilderConfiguredFeatures.register("fallen_oak_tree", Feature.TREE, fallen_oak().decorators(List.of(VINES_08_UNDER_260_075)).dirt(BlockStateProvider.simple(Blocks.DIRT)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FANCY_OAK_BEES = WilderConfiguredFeatures.register("fancy_oak_bees", Feature.TREE, fancyOak().decorators(List.of(BEES)).build());
    //DARK OAK
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DYING_DARK_OAK = WilderConfiguredFeatures.register("dying_dark_oak", Feature.TREE,
            (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.DARK_OAK_LOG), new DarkOakTrunkPlacer(6, 2, 1), BlockStateProvider.simple(Blocks.DARK_OAK_LEAVES),
                    new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))).decorators(List.of(VINES_1_UNDER_260_05)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> TALL_DARK_OAK = WilderConfiguredFeatures.register("tall_dark_oak", Feature.TREE, tallDarkOak().ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DYING_TALL_DARK_OAK = WilderConfiguredFeatures.register("dying_tall_dark_oak", Feature.TREE, tallDarkOak().decorators(List.of(VINES_1_UNDER_260_05)).ignoreVines().build());
    //SWAMP TREE
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SWAMP_TREE = WilderConfiguredFeatures.register("swamp_tree", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.MANGROVE_LOG),
            new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.simple(Blocks.MANGROVE_LEAVES),
            new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3), Optional.of(new MangroveRootPlacer(UniformInt.of(1, 1), BlockStateProvider.simple(Blocks.MANGROVE_ROOTS), Optional.of(new AboveRootPlacement(BlockStateProvider.simple(Blocks.MOSS_CARPET), 0.45F)),
            new MangroveRootPlacement(Registry.BLOCK.getOrCreateTag(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH), HolderSet.direct(Block::builtInRegistryHolder, Blocks.MUD, Blocks.MUDDY_MANGROVE_ROOTS), BlockStateProvider.simple(Blocks.MUDDY_MANGROVE_ROOTS), 8, 15, 0.2F))),
            new TwoLayersFeatureSize(2, 0, 2))
            .decorators(List.of(
                    new LeaveVineDecorator(0.125F),
                    new AttachedToLeavesDecorator(
                            0.12F,
                            1,
                            0,
                            new RandomizedIntStateProvider(BlockStateProvider.simple(
                                    Blocks.MANGROVE_PROPAGULE.defaultBlockState().setValue(MangrovePropaguleBlock.HANGING, true)
                            ),
                                    MangrovePropaguleBlock.AGE,
                                    UniformInt.of(0, 4)),
                            2,
                            List.of(Direction.DOWN)
                    )
            )).ignoreVines().dirt(BlockStateProvider.simple(Blocks.MANGROVE_ROOTS)).build()
    );

    //SPRUCE
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SPRUCE = WilderConfiguredFeatures.register("spruce", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), new StraightTrunkPlacer(8, 4, 2), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(2, 3)), new TwoLayersFeatureSize(2, 0, 2)).decorators(ImmutableList.of(SHELF_FUNGUS_006_ONLY_BROWN)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SPRUCE_SHORT = WilderConfiguredFeatures.register("spruce_short", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), new StraightTrunkPlacer(3, 1, 2), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new SpruceFoliagePlacer(UniformInt.of(1, 2), UniformInt.of(0, 2), UniformInt.of(2, 3)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FUNGUS_PINE = WilderConfiguredFeatures.register("fungus_pine", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), new StraightTrunkPlacer(6, 4, 2), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), UniformInt.of(3, 4)), new TwoLayersFeatureSize(2, 0, 2)).decorators(ImmutableList.of(SHELF_FUNGUS_006_ONLY_BROWN)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DYING_FUNGUS_PINE = WilderConfiguredFeatures.register("dying_fungus_pine", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), new StraightTrunkPlacer(6, 4, 2), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), UniformInt.of(3, 4)), new TwoLayersFeatureSize(2, 0, 2)).decorators(ImmutableList.of(SHELF_FUNGUS_006_ONLY_BROWN, VINES_1_UNDER_260_05)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> MEGA_FUNGUS_SPRUCE = WilderConfiguredFeatures.register("mega_fungus_spruce", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)), new TwoLayersFeatureSize(1, 1, 2)).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.PODZOL)), SHELF_FUNGUS_006_ONLY_BROWN)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> MEGA_FUNGUS_PINE = WilderConfiguredFeatures.register("mega_fungus_pine", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(3, 7)), new TwoLayersFeatureSize(1, 1, 2)).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.PODZOL)), SHELF_FUNGUS_006_ONLY_BROWN)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DYING_MEGA_FUNGUS_PINE = WilderConfiguredFeatures.register("dying_mega_fungus_pine", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), new GiantTrunkPlacer(13, 2, 14), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(3, 7)), new TwoLayersFeatureSize(1, 1, 2)).decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.PODZOL)), SHELF_FUNGUS_006_ONLY_BROWN, VINES_1_UNDER_260_075)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FALLEN_SPRUCE_TREE = WilderConfiguredFeatures.register("fallen_spruce_tree", Feature.TREE, fallen_spruce().decorators(List.of(VINES_1_UNDER_260_075)).dirt(BlockStateProvider.simple(Blocks.DIRT)).build());
    //BAOBAB
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> BAOBAB = WilderConfiguredFeatures.register("baobab", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(WWBlocks.BAOBAB_LOG.get()), new BaobabTrunkPlacer(13, 3, 2), BlockStateProvider.simple(WWBlocks.BAOBAB_LEAVES.get()), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).decorators(List.of(new AttachedToLeavesDecorator(0.04F, 1, 0,
            new RandomizedIntStateProvider(BlockStateProvider.simple(WWBlocks.BAOBAB_NUT.get().defaultBlockState().setValue(MangrovePropaguleBlock.HANGING, true)), BaobabNutBlock.AGE, UniformInt.of(0, 2)), 4, List.of(Direction.DOWN)))).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> BAOBAB_TALL = WilderConfiguredFeatures.register("baobab_tall", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(WWBlocks.BAOBAB_LOG.get()), new BaobabTrunkPlacer(16, 4, 2), BlockStateProvider.simple(WWBlocks.BAOBAB_LEAVES.get()), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).decorators(List.of(new AttachedToLeavesDecorator(0.04F, 1, 0,
            new RandomizedIntStateProvider(BlockStateProvider.simple(WWBlocks.BAOBAB_NUT.get().defaultBlockState().setValue(MangrovePropaguleBlock.HANGING, true)), BaobabNutBlock.AGE, UniformInt.of(0, 2)), 4, List.of(Direction.DOWN)))).ignoreVines().build());
    //CYPRESS
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CYPRESS = WilderConfiguredFeatures.register("cypress", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(WWBlocks.CYPRESS_LOG.get()), new StraightTrunkPlacer(6, 2, 3), BlockStateProvider.simple(WWBlocks.CYPRESS_LEAVES.get()), new SpruceFoliagePlacer(ConstantInt.of(1), UniformInt.of(1, 3), UniformInt.of(4, 6)), new TwoLayersFeatureSize(2, 1, 2)).decorators(ImmutableList.of(VINES_012_UNDER_76)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FALLEN_CYPRESS_TREE = WilderConfiguredFeatures.register("fallen_cypress_tree", Feature.TREE, fallen_cypress().decorators(List.of(VINES_008_UNDER_82)).dirt(BlockStateProvider.simple(Blocks.DIRT)).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FUNGUS_CYPRESS = WilderConfiguredFeatures.register("fungus_cypress", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(WWBlocks.CYPRESS_LOG.get()), new StraightTrunkPlacer(8, 4, 3), BlockStateProvider.simple(WWBlocks.CYPRESS_LEAVES.get()), new SpruceFoliagePlacer(ConstantInt.of(1), UniformInt.of(1, 3), UniformInt.of(6, 8)), new TwoLayersFeatureSize(2, 1, 2)).decorators(ImmutableList.of(SHELF_FUNGUS_006_ONLY_BROWN, VINES_008_UNDER_82)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SHORT_CYPRESS = WilderConfiguredFeatures.register("short_cypress", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(WWBlocks.CYPRESS_LOG.get()), new StraightTrunkPlacer(3, 2, 3), BlockStateProvider.simple(WWBlocks.CYPRESS_LEAVES.get()), new SpruceFoliagePlacer(ConstantInt.of(1), UniformInt.of(1, 3), UniformInt.of(4, 6)), new TwoLayersFeatureSize(2, 1, 2)).decorators(ImmutableList.of(VINES_012_UNDER_76)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SHORT_FUNGUS_CYPRESS = WilderConfiguredFeatures.register("short_fungus_cypress", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(WWBlocks.CYPRESS_LOG.get()), new StraightTrunkPlacer(4, 3, 1), BlockStateProvider.simple(WWBlocks.CYPRESS_LEAVES.get()), new SpruceFoliagePlacer(ConstantInt.of(1), UniformInt.of(1, 3), UniformInt.of(6, 8)), new TwoLayersFeatureSize(2, 1, 2)).decorators(ImmutableList.of(SHELF_FUNGUS_006_ONLY_BROWN, VINES_008_UNDER_82)).ignoreVines().build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SWAMP_CYPRESS = WilderConfiguredFeatures.register("swamp_cypress", Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(WWBlocks.CYPRESS_LOG.get()), new UpwardsBranchingTrunkPlacer(15, 5, 2, UniformInt.of(4, 5), 0.2F, UniformInt.of(1, 3), Registry.BLOCK.getOrCreateTag(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH)), BlockStateProvider.simple(WWBlocks.CYPRESS_LEAVES.get()), new RandomSpreadFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), ConstantInt.of(2), 14), new TwoLayersFeatureSize(1, 0, 1))).decorators(ImmutableList.of(new LeaveVineDecorator(0.1F), SHELF_FUNGUS_006_ONLY_BROWN, VINES_008_UNDER_82)).build());

    private static TreeConfiguration.TreeConfigurationBuilder builder(Block log, Block leaves, int baseHeight, int firstRandomHeight, int secondRandomHeight, float logChance, IntProvider maxLogs, IntProvider logHeightFromTop, IntProvider extraBranchLength, int radius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), new StraightTrunkWithLogs(baseHeight, firstRandomHeight, secondRandomHeight, logChance, maxLogs, logHeightFromTop, extraBranchLength),
                BlockStateProvider.simple(leaves), new BlobFoliagePlacer(ConstantInt.of(radius), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder fallenTrunkBuilder(Block log, Block leaves, int baseHeight, int firstRHeight, int secondRHeight, float logChance, float mossChance, IntProvider maxLogs, IntProvider maxHeightAboveHole, int radius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), new FallenTrunkWithLogs(baseHeight, firstRHeight, secondRHeight, logChance, mossChance, maxLogs, maxHeightAboveHole),
                BlockStateProvider.simple(leaves), new BlobFoliagePlacer(ConstantInt.of(radius), ConstantInt.of(0), 3), //FOILAGE PLACER DOES NOTHING
                new TwoLayersFeatureSize(1, 0, 1));
    }

    private static TreeConfiguration.TreeConfigurationBuilder darkOakBuilder(Block log, Block leaves, int baseHeight, int firstRandomHeight, int secondRandomHeight, int radius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), new DarkOakTrunkPlacer(baseHeight, firstRandomHeight, secondRandomHeight),
                BlockStateProvider.simple(leaves), new DarkOakFoliagePlacer(ConstantInt.of(radius), ConstantInt.of(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()));
    }

    private static TreeConfiguration.TreeConfigurationBuilder birch() {
        return builder(Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES, 8, 5, 4, 0.15F, UniformInt.of(1, 2), UniformInt.of(1, 3), ConstantInt.of(1), 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder superBirch() {
        return builder(Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES, 8, 6, 6, 0.15F, UniformInt.of(1, 2), UniformInt.of(1, 3), ConstantInt.of(1), 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder shortBirch() {
        return builder(Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES, 6, 2, 2, 0.12F, UniformInt.of(1, 2), UniformInt.of(1, 3), ConstantInt.of(1), 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder fallen_birch() {
        return fallenTrunkBuilder(WWBlocks.HOLLOWED_BIRCH_LOG.get(), Blocks.BIRCH_LEAVES, 3, 1, 2, 0.4F, 0.47F, UniformInt.of(1, 2), UniformInt.of(1, 2), 1).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder oak() {
        return builder(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 6, 2, 1, 0.1F, UniformInt.of(1, 2), UniformInt.of(1, 3), ConstantInt.of(1), 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder short_oak() {
        return builder(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 4, 1, 0, 0.095F, UniformInt.of(1, 2), UniformInt.of(1, 3), ConstantInt.of(1), 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder fancyOak() {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG), new FancyTrunkPlacer(5, 16, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(3), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder fallen_oak() {
        return fallenTrunkBuilder(WWBlocks.HOLLOWED_OAK_LOG.get(), Blocks.OAK_LEAVES, 3, 1, 2, 0.4F, 0.4F, UniformInt.of(1, 2), UniformInt.of(1, 2), 1).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder fallen_cypress() {
        return fallenTrunkBuilder(WWBlocks.HOLLOWED_CYPRESS_LOG.get(), WWBlocks.CYPRESS_LEAVES.get(), 3, 1, 2, 0.4F, 0.6F, UniformInt.of(1, 2), UniformInt.of(1, 2), 1).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder tallDarkOak() {
        return darkOakBuilder(Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_LEAVES, 7, 3, 2, 1).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder fallen_spruce() {
        return fallenTrunkBuilder(WWBlocks.HOLLOWED_SPRUCE_LOG.get(), Blocks.SPRUCE_LEAVES, 5, 1, 2, 0.0F, 0.5F, UniformInt.of(1, 2), UniformInt.of(1, 2), 1).ignoreVines();
    }

    public static void registerTreeConfigured() {
        WilderWild.logWild("Registering WilderTreeConfigured for", true);
    }

}

