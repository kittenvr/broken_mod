package com.pizzav.tradebot;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.LecternBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.village.VillagerProfession;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.s2c.play.OpenScreenS2CPacket;
import net.minecraft.network.packet.s2c.play.SetTradeOffersS2CPacket;
import net.minecraft.util.math.Direction;
import net.minecraft.village.TradeOfferList;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static org.spongepowered.asm.mixin.MixinEnvironment.Phase.INIT;
public class TradeBot implements ModInitializer extends module {
    private static MinecraftClient client;
    public static boolean enabled;
    private static BlockPos lecternPos;
}
public class TradeBot implements ModInitializer {
    @Override
    public void onInitialize() {

    }

    public void tick(MinecraftClient client) {
        if (bruteTrade.wasPressed()) {
            text.literal("trading: " + refresh), true);
        }
}
if(!refresh) {
state = INIT;
}
// INIT: start, we look for a librarian in the area
    if(state == INIT && refresh)
        ClientPlayerEntity player = client.player;
        Vec3d playerPos = player.getPos();
        if (entity instanceof VillagerEntity && entity.Pos.distanceTo(playerPos) < closestDistance) {
            double closestDistance = double.POSITIVE_INFINITY;
            Entity closestEntity = null;

    }
        for(Entity entity : client.world.getEntities()) {
            Vec3d entityPos = entity.getPos();
            if (entity instanceof VillagerEntity && entityPos.distanceTo(playerPos)< closestDistance) {
                closestDistance = entityPos.distanceTo(playerPos);
                closestEntity = entity;
            }
    }
VillagerEntity villager = (VillagerEntity) closestEntity;
        //we found librarian
    if(villager.getVillagerData( ).getProfession( ) == VillagerProfession.LIBRARIAN) {
        librarian = villager;
        state = WAITING_FOR_TRADEOFFERS;
        client.interactionManager.interactEntity(client.player, closestEntity, Hand.MAIN_HAND);
    } else if(state == GOT_OFFER) {
        if(client.player != null) {
            for (int y = -1; <= 0; y++) {
                for (int z = -4; x <= 4; z++)
                    BlockPos pos = client.player.getBlockPos ( ).add(x,y,z);
                    Blockstate blockstate = client.world.getBlockState(pos);
                    if(blockstate.getBlock( ) instanceof LecternBlock) {
                        LecternPos = pos;
                        state = WAIT_FOR_BLOCK_BREAK
                        return;
                    }
            }
        }
    }
}
state = INIT;
} else if( state == WAIR_FOR_BLOCK_BREAK) {
    //we got an offer packet from the server
        if(librarian != null && librarian.getVillagerData( ).getProfession( ) != VillagerProffesion.LIBRARIAN)
            LiveOverflowMod.getInstance( ).client.player.SendMessage(Text.Literal("-"),true);

        BlockHitResult hitResult = new BlockHitResult(new Vec3d(lecternPos.getX(),lecternPos.getY(),lecternPos.getZ()), Direction.UP,lecternPos,false);

        client.interactionManager.interactBlock(client.player, Hand.OFF_HAND, hit);
        state = INIT;
}
