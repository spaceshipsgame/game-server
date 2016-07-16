package spaceships.gameserver;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spaceships.gameserver.config.AppConfig;
import spaceships.gameserver.engine.PlayerActionHandler;
import spaceships.gameserver.netty.NettyServer;
import spaceships.gameserver.server.MatchManager;

public class ServerRunner {

	private static Logger logger = Logger.getLogger(ServerRunner.class);

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		NettyServer server = context.getBean(NettyServer.class);
		server.initServer();
		try {
			server.startServer();
			logger.info("Server started");
		} catch (InterruptedException e) {
			logger.error("Server can`t start", e);
		}
	}

}
