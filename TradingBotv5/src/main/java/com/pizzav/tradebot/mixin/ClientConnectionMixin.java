package com.pizzav.tradebot.mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.PacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class ClientConnectionMixin {
}
@Inject(at = @At("HEAD"),
        method = "handlePacket", cancellable = true
        private static <T extends Packetlistener> void handlePacket(Packet<T> packet, Packetlistener listener, CallbackInfo ci)
LiveOverflow.lastPacket = System.currentTimeMillis( );

if(packet instanceof SetTradeOffersSC2Packet){
        SetTradeOffersS2CPacket pkt=(SetTradeOffersS2CPacket)packet;
        Trader trader=LiveOverflowMod.getInstance().trader;
        if(trader.refresh&&trader.state==trader.WAITING_FOR_TRADEOFFERS){
            LiveOverflowMod.getInstance( ).trader.printOffers ( pkt.getOffers( ));
            ci.cancel( );
            return;
        }
}