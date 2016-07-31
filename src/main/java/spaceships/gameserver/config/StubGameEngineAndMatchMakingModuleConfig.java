package spaceships.gameserver.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import spaceships.gameserver.netty.NettyServer;
import spaceships.gameserver.server.ConnectionResolverImpl;
import spaceships.gameserver.server.FailedConnectionPlayerPool;
import spaceships.gameserver.stubs.WaitMatchManagerStub;

@Configuration
@ComponentScan(basePackageClasses = { NettyServer.class, ConnectionResolverImpl.class,
		FailedConnectionPlayerPool.class, WaitMatchManagerStub.class })
@PropertySource(value = "server-config.properties")
public class StubGameEngineAndMatchMakingModuleConfig {
}
