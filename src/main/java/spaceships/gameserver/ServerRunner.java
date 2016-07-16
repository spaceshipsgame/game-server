package spaceships.gameserver;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spaceships.gameserver.config.AppConfig;
import spaceships.gameserver.netty.NettyServer;

public class ServerRunner {

	private final static int PORT = 8888;

	private static Logger logger = Logger.getLogger(ServerRunner.class);

	public static void main(String[] args) {
		NettyServer server = new NettyServer();
		server.initServer();
		try {
			server.startServer(PORT);
			logger.info("Server started");
		} catch (InterruptedException e) {
			logger.error("Server can`t start", e);
		}
	}

}
