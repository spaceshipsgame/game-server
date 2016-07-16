package spaceships.gameserver.netty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import spaceships.gameserver.engine.PlayerActionQueue;
import spaceships.gameserver.netty.handlers.ClientCommandHandler;

@Component
public class NettyServer {

	private ServerBootstrap bootstrap;

	private Channel channel;

	@Value(value = "${netty_port}")
	private int port;

	@Value(value = "${netty_boss_group_thread_count}")
	private int bossGroupThreadCount;

	@Value(value = "${netty_work_group_thread_count}")
	private int workerGroupThreadCount;

	public void initServer() {

		EventLoopGroup bossGroup = new NioEventLoopGroup(bossGroupThreadCount); // (1)
		EventLoopGroup workerGroup = new NioEventLoopGroup(workerGroupThreadCount);

		bootstrap = new ServerBootstrap(); // (2)
		bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class) // (3)
				.childHandler(new ChannelInitializer<SocketChannel>() { // (4)
					@Override
					public void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(new HttpServerCodec(), new HttpObjectAggregator(65536),
								new WebSocketServerProtocolHandler("/websocket", null, true),
								new ClientCommandHandler(new PlayerActionQueue()));
					}
				}).option(ChannelOption.SO_BACKLOG, 128) // (5)
				.childOption(ChannelOption.SO_KEEPALIVE, true); // (6)
	}

	public void startServer() throws InterruptedException {
		// Bind and start to accept incoming connections.
		ChannelFuture f = bootstrap.bind(port).sync(); // (7)
		// channel.closeFuture().sync();
	}
}
