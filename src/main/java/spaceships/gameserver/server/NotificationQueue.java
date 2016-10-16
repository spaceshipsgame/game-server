package spaceships.gameserver.server;


import spaceships.gameserver.engine.event.Event;
import spaceships.gameserver.model.server.Player;
import spaceships.gameserver.server.protocol.notification.Notification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class NotificationQueue {

//  TODO: implement or use some library for effective collections and HashMap with multiple values for one key
    private Map<Player, List<Notification>> notificationMap = new HashMap<Player, List<Notification>>();

    public NotificationQueue() {}

    public void put(Notification notification, Player player) {
        List<Notification> notificationList = notificationMap.get(player);
        if(notificationList == null){
            notificationList = new ArrayList<>();
        }
        notificationList.add(notification);
    }

    public List<Notification> get(Player player) {
        return notificationMap.get(player);
    }

    public Map<Player, List<Notification>> getAll() {
        return notificationMap;
    }

    public boolean isEmpty(){
        return notificationMap.isEmpty();
    }
}
