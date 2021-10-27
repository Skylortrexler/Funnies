package website.skylorbeck.funnies.items;

import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import website.skylorbeck.funnies.Declarar;
import website.skylorbeck.funnies.entities.FairyEntity;

public class FairyJar extends BlockItem {
    public FairyJar(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getPlayer().isSneaking() && !context.getWorld().isClient){
            context.getStack().decrement(1);
            context.getPlayer().giveItemStack(new ItemStack(Items.GLASS_BOTTLE));
            FairyEntity entity = Declarar.FAIRYENTITY.create(context.getWorld());
            BlockPos pos = context.getBlockPos();
            entity.setPos(pos.getX(),pos.getY()+2,pos.getZ());
            context.getWorld().spawnEntity(entity);//important, will not spawn without
            return ActionResult.success(context.getWorld().isClient);
        }
        return super.useOnBlock(context);
    }
}
