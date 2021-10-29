package website.skylorbeck.funnies.blocks;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;
import website.skylorbeck.funnies.entities.FairyJarEntity;

import java.util.Random;

public class FairyJarBlock extends BlockWithEntity {
    private int cooldown = 0;
    protected static final VoxelShape BOUNDING_SHAPE =
            VoxelShapes.union(
                    Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 7.0D, 11.0D),
                    VoxelShapes.union(
                            Block.createCuboidShape(6, 7, 6, 10, 8, 10),
                            Block.createCuboidShape(7, 8, 7, 9, 9, 9))
            );

    public FairyJarBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BOUNDING_SHAPE;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = (double) pos.getX() + 0.5D;
        double e = (double) pos.getY() + 0.7D;
        double f = (double) pos.getZ() + 0.5D;
        if (world.random.nextInt(5) == 0) {
            if (cooldown == 0) {
                world.addParticle(ParticleTypes.ANGRY_VILLAGER, d, e, f, 0.0D, 0.0D, 0.0D);
                cooldown = 20;
            } else {
                cooldown--;
            }
        }
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !this.canPlaceAt(state, world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FairyJarEntity(pos,state);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }
}