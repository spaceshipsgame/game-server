package game;

import game.events.Event;

import java.util.LinkedList;
import java.util.Queue;

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
