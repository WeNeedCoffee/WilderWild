/*
 * Copyright 2024 FrozenBlock
 * This file is part of Wilder Wild.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, see <https://www.gnu.org/licenses/>.
 */

package net.frozenblock.wilderwild.networking.packet;

import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PacketType;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.frozenblock.wilderwild.WWConstants;
import net.frozenblock.wilderwild.block.entity.StoneChestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

public record WWStoneChestLidPacket(BlockPos pos, float openProgress, float highestLidPoint, int cooldownTicks, int stillLidTicks, boolean closing) implements FabricPacket {
	public static final PacketType<WWStoneChestLidPacket> PACKET_TYPE = PacketType.create(
		WWConstants.id("stone_chest_lid"), WWStoneChestLidPacket::new
	);

	public WWStoneChestLidPacket(@NotNull FriendlyByteBuf buf) {
		this(buf.readBlockPos(), buf.readFloat(), buf.readFloat(), buf.readInt(), buf.readInt(), buf.readBoolean());
	}

	public static void sendToAll(@NotNull StoneChestBlockEntity blockEntity) {
		for (ServerPlayer player : PlayerLookup.tracking(blockEntity)) {
			ServerPlayNetworking.send(
				player,
				new WWStoneChestLidPacket(
					blockEntity.getBlockPos(),
					blockEntity.openProgress,
					blockEntity.highestLidPoint,
					blockEntity.cooldownTicks,
					blockEntity.stillLidTicks,
					blockEntity.closing
				)
			);
		}
	}

	@Override
	public void write(@NotNull FriendlyByteBuf buf) {
		buf.writeBlockPos(this.pos);
		buf.writeFloat(this.openProgress);
		buf.writeFloat(this.highestLidPoint);
		buf.writeInt(this.cooldownTicks);
		buf.writeInt(this.stillLidTicks);
		buf.writeBoolean(this.closing);
	}

	@Override
	public PacketType<?> getType() {
		return PACKET_TYPE;
	}
}
