package spaceships.gameserver.model;

import java.util.List;


public class Team {

    private List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}