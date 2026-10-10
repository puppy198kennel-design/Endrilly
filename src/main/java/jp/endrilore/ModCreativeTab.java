package jp.endrilore;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class ModCreativeTab {

    private ModCreativeTab() {
    }

    // =========================
    // クリエイティブタブのID
    // =========================

    public static final ResourceKey<CreativeModeTab> ENDRIL_TAB_KEY =
            ResourceKey.create(
                    BuiltInRegistries.CREATIVE_MODE_TAB.key(),
                    EndrilOre.id("endril_tab")
            );

    // =========================
    // クリエイティブタブ本体
    // =========================

    public static final CreativeModeTab ENDRIL_TAB =
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ENDRIL_HARVESTER))
                    .title(Component.translatable("creativeTab.endril-ore"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.ENDRIL);
                        output.accept(ModItems.ENDRIL_ORE);
                        output.accept(ModItems.ENDRIL_DIAMOND_ORE);
                        output.accept(ModItems.ENDRIL_EMERALD_ORE);
                        output.accept(ModItems.ENDRIL_BLOCK);
                        output.accept(ModItems.ENDRIL_HARVESTER);
                        output.accept(ModItems.ENDRIL_SWORD);
                        output.accept(ModItems.ENDRIL_SMITHING_TEMPLATE);
                    })
                    .build();

    // =========================
    // 登録
    // =========================

    public static void initialize() {
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                ENDRIL_TAB_KEY,
                ENDRIL_TAB
        );
    }
}