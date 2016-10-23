package spaceships.gameserver.server.protocol.action;

import spaceships.gameserver.model.server.Player;

public class MoveShipAction implements Action{

    private Player player;
    private MoveType type;
    private boolean isActive;

    public MoveShipAction(Player player, MoveType type, boolean isActive) {
        this.player = player;
        this.type = type;
        this.isActive = isActive;
    }

    @Override
    public void execute() {
    }

    public enum MoveType {
        LEFT, RIGHT, ACCELERATE;

        public static MoveType parse(String value){
            switch (value){
                case "LEFT":
                    return LEFT;
                case "RIGHT":
                    return RIGHT;
                case "UP":
                    return ACCELERATE;
                default:
                    return null;
            }
        }
    }
}
