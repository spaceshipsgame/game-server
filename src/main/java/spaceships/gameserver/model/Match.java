package spaceships.gameserver.model;

import spaceships.gameserver.engine.EventQueue;
import spaceships.gameserver.model.Team;
import spaceships.gameserver.model.server.Player;

public class Match {

    private EventQueue notHandledEvents;

    private Team team1;
    private Team team2;

    public void connectToGame(Player player){

    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }
}
