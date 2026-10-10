    package jp.endrilore;

    import net.minecraft.core.registries.BuiltInRegistries;
    import net.minecraft.core.registries.Registries;
    import net.minecraft.resources.Identifier;
    import net.minecraft.resources.ResourceKey;
    import net.minecraft.tags.TagKey;
    import net.minecraft.world.item.BlockItem;
    import net.minecraft.world.item.Item;
    import net.minecraft.world.item.Rarity;
    import net.minecraft.world.item.SmithingTemplateItem;
    import net.minecraft.world.item.ToolMaterial;
    import net.minecraft.core.component.DataComponents;

    import java.util.function.Function;

    public final class ModItems {

        private ModItems() {
        }

        // =========================
        // エンドリル用ツール素材
        // =========================

        public static final TagKey<net.minecraft.world.level.block.Block> INCORRECT_FOR_ENDRIL_TOOL =
                TagKey.create(
                        Registries.BLOCK,
                        EndrilOre.id("incorrect_for_endril_tool")
                );

        public static final TagKey<Item> REPAIRS_ENDRIL =
                TagKey.create(
                        Registries.ITEM,
                        EndrilOre.id("repairs_endril")
                );

        public static final ToolMaterial ENDRIL_TOOL_MATERIAL =
                new ToolMaterial(
                        INCORRECT_FOR_ENDRIL_TOOL,
                        2500,
                        9.0F,
                        5.0F,
                        22,
                        REPAIRS_ENDRIL
                );

        // =========================
        // 鉱石
        // =========================

        public static final Item ENDRIL_ORE = registerBlockItem(
                "endril_ore",
                ModBlocks.ENDRIL_ORE
        );

        public static final Item ENDRIL_DIAMOND_ORE = registerBlockItem(
                "endril_diamond_ore",
                ModBlocks.ENDRIL_DIAMOND_ORE
        );

        public static final Item ENDRIL_EMERALD_ORE = registerBlockItem(
                "endril_emerald_ore",
                ModBlocks.ENDRIL_EMERALD_ORE
        );


        // =========================
        // エンドリルブロック
        // =========================

        public static final Item ENDRIL_BLOCK = registerBlockItem(
                "endril_block",
                ModBlocks.ENDRIL_BLOCK
        );


        // =========================
    // エンドリル
    // =========================

        public static final Item ENDRIL = register(
                "endril",
                Item::new,
                new Item.Properties()
        );

        // =========================
        // エンドリル・ハーベスター
        // =========================

        public static final Item ENDRIL_HARVESTER = register(
                "endril_harvester",
                Item::new,
                new Item.Properties()
                        .sword(ENDRIL_TOOL_MATERIAL, 5.0F, -2.4F)
        );

        // =========================
        // エンドリルソード
        // =========================

        public static final Item ENDRIL_SWORD = register(
                "endril_sword",
                Item::new,
                new Item.Properties()
                        .sword(ENDRIL_TOOL_MATERIAL, 8.0F, -2.4F)
        );

        // =========================
        // エンドリル鍛冶型
        // =========================

        public static final Item ENDRIL_SMITHING_TEMPLATE = register(
                "endril_smithing_template",
                SmithingTemplateItem::createArmorTrimTemplate,
                new Item.Properties()
                        .rarity(Rarity.EPIC)
        );

        // =========================
        // 登録処理
        // =========================

        private static Item register(
                String name,
                Function<Item.Properties, Item> factory
        ) {
            return register(
                    name,
                    factory,
                    new Item.Properties()
            );
        }

        private static <T extends Item> T register(
                String name,
                Function<Item.Properties, T> factory,
                Item.Properties properties
        ) {
            Identifier id = EndrilOre.id(name);

            ResourceKey<Item> key = ResourceKey.create(
                    Registries.ITEM,
                    id
            );

            T item = factory.apply(
                    properties.setId(key)
            );

            return net.minecraft.core.Registry.register(
                    BuiltInRegistries.ITEM,
                    key,
                    item
            );
        }

        private static Item registerBlockItem(
                String name,
                net.minecraft.world.level.block.Block block
        ) {
            Identifier id = EndrilOre.id(name);

            ResourceKey<Item> key = ResourceKey.create(
                    Registries.ITEM,
                    id
            );

            Item.Properties properties = new Item.Properties()
                    .setId(key);

            BlockItem item = new BlockItem(
                    block,
                    properties
            );

            return net.minecraft.core.Registry.register(
                    BuiltInRegistries.ITEM,
                    key,
                    item
            );
        }

        public static void initialize() {
        }
    }