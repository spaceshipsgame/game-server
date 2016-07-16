package spaceships.gameserver.engine;

import java.util.LinkedList;
import java.util.Queue;

import spaceships.gameserver.engine.event.Event;

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

    public boolean isEmpty(){
        return buffer.isEmpty();
    }
}
