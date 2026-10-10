package jp.endrilore;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public final class ModBlocks {

    private ModBlocks() {
    }

    public static final Block ENDRIL_ORE = register(
            "endril_ore",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(3.0F, 9.0F)
                    .requiresCorrectToolForDrops()
    );

    public static final Block ENDRIL_DIAMOND_ORE = register(
            "endril_diamond_ore",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(3.0F, 9.0F)
                    .requiresCorrectToolForDrops()
    );

    public static final Block ENDRIL_EMERALD_ORE = register(
            "endril_emerald_ore",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(3.0F, 9.0F)
                    .requiresCorrectToolForDrops()
    );

    // エンドリルブロック（鉱石ではない普通のブロック）
    public static final Block ENDRIL_BLOCK = register(
            "endril_block",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(5.0F, 6.0F)
                    .requiresCorrectToolForDrops()
    );

    private static Block register(
            String name,
            Function<BlockBehaviour.Properties, Block> factory,
            BlockBehaviour.Properties properties
    ) {
        Identifier id = EndrilOre.id(name);
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, id);

        return Blocks.register(key, factory, properties);
    }

    public static void initialize() {
    }
}