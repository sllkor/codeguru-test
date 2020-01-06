package chat.common.packet.all;

import chat.common.enums.CloseCause;
import chat.common.listener.PacketAllSbListener;
import chat.common.main.Utils;
import chat.common.packet.Packet;
import io.netty.buffer.ByteBuf;

public class PacketAllSbDisconnect implements Packet<PacketAllSbListener> {

	public CloseCause cc;
	@Override
	public void decode(ByteBuf buf) {
		cc = CloseCause.decode(buf);
	}

	@Override
	public void encode(ByteBuf buf) {
		cc.encode(buf);
	}

	@Override
	public void process(PacketAllSbListener listener) {
		listener.process(this);
	}

	@Override
	public String toString() {
		return Utils.serializePacket(this);
	}
}
