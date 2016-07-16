package spaceships.gameserver.engine;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import spaceships.gameserver.engine.event.Event;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EventQueue {

	private Queue<Event> buffer;

	public EventQueue() {
		buffer = new LinkedList<>();
	}

	public boolean offer(Event e) {
		return buffer.offer(e);
	}

	public Event poll() {
		return buffer.poll();
	}

	public boolean isEmpty() {
		return buffer.isEmpty();
	}
}
