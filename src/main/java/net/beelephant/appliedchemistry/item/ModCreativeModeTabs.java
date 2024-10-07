package net.beelephant.appliedchemistry.item;

import net.beelephant.appliedchemistry.AppliedChemistry;
import net.beelephant.appliedchemistry.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AppliedChemistry.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BASE_RESOURCES_TAB = CREATIVE_MODE_TABS.register("base_resources_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.SULFUR.get()))
                    .title(Component.translatable("creativetab.appliedchemistry.base_resources"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SULFUR.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> BASE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("base_blocks_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.SULFUR_ORE.get()))
                    .withTabsBefore(BASE_RESOURCES_TAB.getId())
                    .title(Component.translatable("creativetab.appliedchemistry.base_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.SULFUR_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SULFUR_ORE.get());
                        output.accept(ModBlocks.SULFUR_BLOCK.get());
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
