package netty;

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
import netty.handlers.ClientCommandHandler;
import workers.ClientCommandProcessor;

/**
 * Created by DimaMir on 20.03.2016.
 */
public class NettyServer {

    private final static int PROCESS_COMMAND_THREAD_COUNT = 1;

    private ServerBootstrap bootstrap;
    private Channel channel;

    public void initServer(){

        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        bootstrap = new ServerBootstrap(); // (2)
        bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class) // (3)
                .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(
                                new HttpServerCodec(),
                                new HttpObjectAggregator(65536),
                                new WebSocketServerProtocolHandler("/websocket", null, true),
                                new ClientCommandHandler(new ClientCommandProcessor(1))
                        );
                    }
                })
                .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)
    }

    public void startServer(int port) throws InterruptedException {
        // Bind and start to accept incoming connections.
        ChannelFuture f = bootstrap.bind(port).sync(); // (7)
        //channel.closeFuture().sync();
    }
}
