package net.frozenblock.wilderwild.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public abstract class FaceClusterBlock extends MultifaceClusterBlock {
    public FaceClusterBlock(int height, int xzOffset, BlockBehaviour.Properties properties) {
        super(height, xzOffset, properties);
    }

    public boolean isValidStateForPlacement(BlockGetter level, BlockState state, BlockPos pos, Direction direction) {
        if (this.isFaceSupported(direction) && !state.is(this)) {
            BlockPos blockPos = pos.relative(direction);
            return canAttachTo(level, direction, blockPos, level.getBlockState(blockPos));
        } else {
            return false;
        }
    }
}
