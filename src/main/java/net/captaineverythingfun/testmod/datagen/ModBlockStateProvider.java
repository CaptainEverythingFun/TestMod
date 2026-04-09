package net.captaineverythingfun.testmod.datagen;

import net.captaineverythingfun.testmod.TestMod;
import net.captaineverythingfun.testmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TestMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.TEST_BLOCK);
        blockWithItem(ModBlocks.TEST_BLOCK2);

        blockWithItem(ModBlocks.TEST_ORE);
        blockWithItem(ModBlocks.TEST_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.TEST_NETHER_ORE);
        blockWithItem(ModBlocks.TEST_END_ORE);

        blockWithItem(ModBlocks.SOUND_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.TEST_STAIRS.get()), blockTexture(ModBlocks.TEST_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.TEST_SLAB.get()), blockTexture(ModBlocks.TEST_BLOCK.get()), blockTexture(ModBlocks.TEST_BLOCK.get()));


        buttonBlock(((ButtonBlock) ModBlocks.TEST_BUTTON.get()), blockTexture(ModBlocks.TEST_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.TEST_PRESSURE_PLATE.get()), blockTexture(ModBlocks.TEST_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.TEST_FENCE.get()), blockTexture(ModBlocks.TEST_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.TEST_FENCE_GATE.get()), blockTexture(ModBlocks.TEST_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.TEST_WALL.get()), blockTexture(ModBlocks.TEST_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.TEST_DOOR.get()), modLoc("block/sapphire_door_bottom"), modLoc("block/sapphire_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.TEST_TRAPDOOR.get()), modLoc("block/sapphire_trapdoor"), true, "cutout");

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
