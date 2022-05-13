package net.frozenblock.wilderwild.mixin.worldgen;

import net.frozenblock.wilderwild.world.feature.WildTreeConfigured;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.block.sapling.SpruceSaplingGenerator;
import net.minecraft.util.math.random.AbstractRandom;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SpruceSaplingGenerator.class)
public class SpruceSaplingGeneratorMixin extends SaplingGenerator {

    @Override
    public RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(AbstractRandom random, boolean bees) {
        return WildTreeConfigured.NEW_SPRUCE;
    }
}
