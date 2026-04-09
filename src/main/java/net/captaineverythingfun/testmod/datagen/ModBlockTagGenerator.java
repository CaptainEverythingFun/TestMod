package net.captaineverythingfun.testmod.datagen;

import net.captaineverythingfun.testmod.TestMod;
import net.captaineverythingfun.testmod.block.ModBlocks;
import net.captaineverythingfun.testmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.TEST_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TEST_BLOCK.get(),
                        ModBlocks.TEST_BLOCK2.get(),
                        ModBlocks.TEST_ORE.get(),
                        ModBlocks.TEST_DEEPSLATE_ORE.get(),
                        ModBlocks.TEST_NETHER_ORE.get(),
                        ModBlocks.TEST_END_ORE.get(),
                        ModBlocks.SOUND_BLOCK.get()

                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.TEST_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TEST_BLOCK2.get(),
                ModBlocks.TEST_DEEPSLATE_ORE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TEST_ORE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.TEST_NETHER_ORE.get(),
                        ModBlocks.TEST_END_ORE.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.TEST_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.TEST_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.TEST_WALL.get());

    }
}
