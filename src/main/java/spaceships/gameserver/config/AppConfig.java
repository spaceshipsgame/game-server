package spaceships.gameserver.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan(basePackageClasses = { NettyServer.class,ConnectionResolverImpl.class,
//		FailedConnectionPlayerPool.class, WaitMatchManagerImpl.class, PlayerActionQueue.class, EventQueue.class })
@ComponentScan(basePackages="spaceships.gameserver.*")
@PropertySource(value = "server-config.properties")
public class AppConfig {

	
}
