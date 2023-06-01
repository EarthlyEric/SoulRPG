package dev.destinysoul.soulrpg.magic.enity;

import dev.destinysoul.soulrpg.magic.item.MagicItems;
import dev.destinysoul.soulrpg.magic.item.inventory.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MinecartItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CoalFiredRefiningFurnaceBlockEnity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(4, ItemStack.EMPTY);
    public CoalFiredRefiningFurnaceBlockEnity(BlockPos pos, BlockState state) {
        super(MagicBlockEnities.CoalFiredRefiningFurnaceBlock,pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return null;
    }

    @Override
    public Text getDisplayName() {
        return null;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return null;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
    }
    public static void tick(World world, BlockPos pos, BlockState state, CoalFiredRefiningFurnaceBlockEnity entity) {
        if(hasRecipe(entity) && hasNotReachedStackLimit(entity)) {
            craftItem(entity);
        }
    }

    private static void craftItem(CoalFiredRefiningFurnaceBlockEnity entity) {
        entity.removeStack(0, 1);
        entity.removeStack(1, 1);
        entity.removeStack(2, 1);

        entity.setStack(3, new ItemStack(MagicItems.magic_crystal,
                entity.getStack(3).getCount() + 1));
    }

    private static boolean hasRecipe(CoalFiredRefiningFurnaceBlockEnity entity) {
        boolean hasItemInFirstSlot = entity.getStack(0).getItem() == MinecartItem.byRawId(5);
        boolean hasItemInSecondSlot = entity.getStack(1).getItem() == MagicItems.magic_crystal_ore_sand;
        boolean hasItemInThirdSlot = entity.getStack(2).getItem() == MinecartItem.byRawId(5);

        return hasItemInFirstSlot && hasItemInSecondSlot && hasItemInThirdSlot;
    }

    private static boolean hasNotReachedStackLimit(CoalFiredRefiningFurnaceBlockEnity entity) {
        return entity.getStack(3).getCount() < entity.getStack(3).getMaxCount();
    }
}
