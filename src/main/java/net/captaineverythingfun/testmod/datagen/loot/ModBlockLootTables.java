package net.captaineverythingfun.testmod.datagen.loot;

import net.captaineverythingfun.testmod.block.ModBlocks;
import net.captaineverythingfun.testmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.TEST_BLOCK.get());
        this.dropSelf(ModBlocks.TEST_BLOCK2.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.add(ModBlocks.TEST_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.TEST_ORE.get(), ModItems.TEST_ITEM.get()));
        this.add(ModBlocks.TEST_DEEPSLATE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.TEST_DEEPSLATE_ORE.get(), ModItems.TEST_ITEM.get()));
        this.add(ModBlocks.TEST_NETHER_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.TEST_NETHER_ORE.get(), ModItems.TEST_ITEM.get()));
        this.add(ModBlocks.TEST_END_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.TEST_END_ORE.get(), ModItems.TEST_ITEM.get()));

        this.dropSelf(ModBlocks.TEST_STAIRS.get());
        this.dropSelf(ModBlocks.TEST_BUTTON.get());
        this.dropSelf(ModBlocks.TEST_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.TEST_TRAPDOOR.get());
        this.dropSelf(ModBlocks.TEST_FENCE.get());
        this.dropSelf(ModBlocks.TEST_FENCE_GATE.get());
        this.dropSelf(ModBlocks.TEST_WALL.get());

        this.add(ModBlocks.TEST_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TEST_SLAB.get()));
        this.add(ModBlocks.TEST_DOOR.get(),
                block -> createDoorTable(ModBlocks.TEST_DOOR.get()));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
