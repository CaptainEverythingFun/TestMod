package net.captaineverythingfun.testmod.item;

import net.captaineverythingfun.testmod.TestMod;
import net.captaineverythingfun.testmod.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEST_ITEM2 = ITEMS.register("test_item2",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
