package net.frozenblock.wilderwild.misc.mod_compat;

import java.util.Objects;
import net.frozenblock.lib.FrozenBools;
import net.frozenblock.lib.damagesource.api.PlayerDamageSourceSounds;
import net.frozenblock.lib.impl.BlockScheduledTicks;
import net.frozenblock.lib.impl.DripstoneDripWaterFrom;
import net.frozenblock.lib.impl.HopperUntouchableList;
import net.frozenblock.lib.impl.StructurePoolElementIdReplacements;
import net.frozenblock.lib.integration.api.ModIntegration;
import net.frozenblock.lib.item.api.RemoveableItemTags;
import static net.frozenblock.lib.sound.api.block_sound_group.BlockSoundGroupOverwrites.*;
import net.frozenblock.lib.sound.api.predicate.SoundPredicate;
import net.frozenblock.wilderwild.entity.Firefly;
import net.frozenblock.wilderwild.misc.WilderSharedConstants;
import net.frozenblock.wilderwild.misc.interfaces.WilderEnderman;
import net.frozenblock.wilderwild.registry.RegisterBlockEntities;
import static net.frozenblock.wilderwild.registry.RegisterBlockSoundTypes.*;
import static net.frozenblock.wilderwild.registry.RegisterBlocks.*;
import net.frozenblock.wilderwild.registry.RegisterSounds;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.InstrumentItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import static net.minecraft.world.level.block.Blocks.*;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

public class FrozenLibIntegration extends ModIntegration {
    public FrozenLibIntegration() {
        super("frozenlib");
    }

    @Override
    public void init() {
        WilderSharedConstants.log("FrozenLib mod integration ran!", WilderSharedConstants.UNSTABLE_LOGGING);
        SoundPredicate.register(WilderSharedConstants.id("instrument"),(SoundPredicate.LoopPredicate<Player>) player ->
                (player.getUseItem().getItem() instanceof InstrumentItem)
        );
        SoundPredicate.register(WilderSharedConstants.id("nectar"), (SoundPredicate.LoopPredicate<Firefly>) entity ->
                !entity.isSilent() && entity.hasCustomName() && Objects.requireNonNull(entity.getCustomName()).getString().toLowerCase().contains("nectar")
        );
        SoundPredicate.register(WilderSharedConstants.id("enderman_anger"), new SoundPredicate.LoopPredicate<EnderMan>() {
            @Override
            public boolean test(EnderMan entity) {
                if (entity.isSilent() || !entity.isAlive() || entity.isRemoved()) {
                    return false;
                }
                return entity.isCreepy();
            }

            @Override
            public void onStart(@Nullable EnderMan entity) {
                if (entity != null) {
                    ((WilderEnderman) entity).setCanPlayLoopingSound(false);
                }
            }

            @Override
            public void onStop(@Nullable EnderMan entity) {
                if (entity != null) {
                    ((WilderEnderman) entity).setCanPlayLoopingSound(true);
                }
            }
        });

        PlayerDamageSourceSounds.addDamageSound(DamageSource.CACTUS, RegisterSounds.PLAYER_HURT_CACTUS, WilderSharedConstants.id("cactus"));
        BlockScheduledTicks.TICKS.put(Blocks.DIRT, (blockState, serverLevel, blockPos, randomSource) -> serverLevel.setBlock(blockPos, Blocks.MUD.defaultBlockState(), 3));
        HopperUntouchableList.BLACKLISTED_TYPES.add(RegisterBlockEntities.STONE_CHEST);
        FrozenBools.useNewDripstoneLiquid = true;
        DripstoneDripWaterFrom.ON_DRIP_BLOCK.put(Blocks.WET_SPONGE, (level, fluidInfo, blockPos) -> {
            BlockState blockState = Blocks.SPONGE.defaultBlockState();
            level.setBlockAndUpdate(fluidInfo.pos(), blockState);
            Block.pushEntitiesUp(fluidInfo.sourceState(), blockState, level, fluidInfo.pos());
            level.gameEvent(GameEvent.BLOCK_CHANGE, fluidInfo.pos(), GameEvent.Context.of(blockState));
            level.levelEvent(LevelEvent.DRIPSTONE_DRIP, blockPos, 0);
        });
        DripstoneDripWaterFrom.ON_DRIP_BLOCK.put(Blocks.MUD, (level, fluidInfo, blockPos) -> {
            BlockState blockState = Blocks.CLAY.defaultBlockState();
            level.setBlockAndUpdate(fluidInfo.pos(), blockState);
            Block.pushEntitiesUp(fluidInfo.sourceState(), blockState, level, fluidInfo.pos());
            level.gameEvent(GameEvent.BLOCK_CHANGE, fluidInfo.pos(), GameEvent.Context.of(blockState));
            level.levelEvent(LevelEvent.DRIPSTONE_DRIP, blockPos, 0);
        });

        RemoveableItemTags.register("wilderwild_is_ancient", (level, entity, slot, selected) -> true, true);

        StructurePoolElementIdReplacements.RESOURCE_LOCATION_REPLACEMENTS.put(WilderSharedConstants.vanillaId("ancient_city/structures/barracks"), WilderSharedConstants.id("ancient_city/structures/barracks"));
        StructurePoolElementIdReplacements.RESOURCE_LOCATION_REPLACEMENTS.put(WilderSharedConstants.vanillaId("ancient_city/structures/chamber_1"), WilderSharedConstants.id("ancient_city/structures/chamber_1"));
        StructurePoolElementIdReplacements.RESOURCE_LOCATION_REPLACEMENTS.put(WilderSharedConstants.vanillaId("ancient_city/structures/chamber_2"), WilderSharedConstants.id("ancient_city/structures/chamber_2"));
        StructurePoolElementIdReplacements.RESOURCE_LOCATION_REPLACEMENTS.put(WilderSharedConstants.vanillaId("ancient_city/structures/chamber_3"), WilderSharedConstants.id("ancient_city/structures/chamber_3"));
        StructurePoolElementIdReplacements.RESOURCE_LOCATION_REPLACEMENTS.put(WilderSharedConstants.vanillaId("ancient_city/structures/sauna_1"), WilderSharedConstants.id("ancient_city/structures/sauna_1"));
        StructurePoolElementIdReplacements.RESOURCE_LOCATION_REPLACEMENTS.put(WilderSharedConstants.vanillaId("ancient_city/structures/tall_ruin_1"), WilderSharedConstants.id("ancient_city/structures/tall_ruin_1"));
        StructurePoolElementIdReplacements.RESOURCE_LOCATION_REPLACEMENTS.put(WilderSharedConstants.vanillaId("ancient_city/structures/tall_ruin_2"), WilderSharedConstants.id("ancient_city/structures/tall_ruin_2"));
        StructurePoolElementIdReplacements.RESOURCE_LOCATION_REPLACEMENTS.put(WilderSharedConstants.vanillaId("ancient_city/structures/tall_ruin_3"), WilderSharedConstants.id("ancient_city/structures/tall_ruin_3"));
        StructurePoolElementIdReplacements.RESOURCE_LOCATION_REPLACEMENTS.put(WilderSharedConstants.vanillaId("ancient_city/structures/tall_ruin_4"), WilderSharedConstants.id("ancient_city/structures/tall_ruin_4"));
        StructurePoolElementIdReplacements.RESOURCE_LOCATION_REPLACEMENTS.put(WilderSharedConstants.vanillaId("ancient_city/structures/ice_box_1"), WilderSharedConstants.id("ancient_city/structures/ice_box_1"));

        addBlocks(new Block[]{CACTUS, PRICKLY_PEAR_CACTUS}, SoundType.SWEET_BERRY_BUSH, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::cactusSounds);
        addBlock(CLAY, CLAY_BLOCK, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::claySounds);
        addBlock(COARSE_DIRT, COARSEDIRT, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::coarseDirtSounds);
        addBlock(COBWEB, WEB, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::cobwebSounds);
        addBlock(DEAD_BUSH, SoundType.NETHER_SPROUTS, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::deadBushSounds);
        addBlocks(new Block[]{DANDELION, POPPY, BLUE_ORCHID, ALLIUM, AZURE_BLUET, RED_TULIP, ORANGE_TULIP, WHITE_TULIP, PINK_TULIP, OXEYE_DAISY, CORNFLOWER, LILY_OF_THE_VALLEY, SEEDING_DANDELION, CARNATION, GLORY_OF_THE_SNOW}, FLOWER, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::flowerSounds);
        addBlocks(new Block[]{FROSTED_ICE}, ICE_BLOCKS, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::frostedIceSounds);
        addBlock(GRAVEL, GRAVELSOUNDS, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::gravelSounds);
        addBlockTag(BlockTags.LEAVES, LEAVES, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::leafSounds);
        addBlocks(new Block[]{ACACIA_LEAVES, BIRCH_LEAVES, DARK_OAK_LEAVES, JUNGLE_LEAVES, MANGROVE_LEAVES, OAK_LEAVES, SPRUCE_LEAVES, BAOBAB_LEAVES, CYPRESS_LEAVES, PALM_LEAVES}, LEAVES, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::leafSounds);
        addBlocks(new Block[]{LILY_PAD, FLOWERING_LILY_PAD}, LILYPAD, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::lilyPadSounds);
        addBlocks(new Block[]{RED_MUSHROOM, BROWN_MUSHROOM}, MUSHROOM, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::mushroomBlockSounds);
        addBlocks(new Block[]{RED_MUSHROOM_BLOCK, BROWN_MUSHROOM_BLOCK, MUSHROOM_STEM}, MUSHROOM_BLOCK, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::mushroomBlockSounds);
        addBlock(PODZOL, SoundType.ROOTED_DIRT, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::podzolSounds);
        addBlock(REINFORCED_DEEPSLATE, REINFORCEDDEEPSLATE, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::reinforcedDeepslateSounds);
        addBlock(SUGAR_CANE, SUGARCANE, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::sugarCaneSounds);
        addBlock(WITHER_ROSE, SoundType.SWEET_BERRY_BUSH, WilderModIntegrations.CLOTH_CONFIG_INTEGRATION.getIntegration()::witherRoseSounds);
    }
}
