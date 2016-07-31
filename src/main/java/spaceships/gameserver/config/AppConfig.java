package spaceships.gameserver.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import spaceships.gameserver.engine.EventQueue;
import spaceships.gameserver.engine.PlayerActionQueue;
import spaceships.gameserver.netty.NettyServer;
import spaceships.gameserver.netty.handlers.ClientCommandHandler;
import spaceships.gameserver.server.ConnectionResolverImpl;
import spaceships.gameserver.server.FailedConnectionPlayerPool;
import spaceships.gameserver.server.MatchManager;
import spaceships.gameserver.server.WaitMatchManagerImpl;

@Configuration
//@ComponentScan(basePackageClasses = { NettyServer.class,ConnectionResolverImpl.class,
//		FailedConnectionPlayerPool.class, WaitMatchManagerImpl.class, PlayerActionQueue.class, EventQueue.class })
@ComponentScan(basePackages="spaceships.gameserver.*")
@PropertySource(value = "server-config.properties")
public class AppConfig {

	
}
