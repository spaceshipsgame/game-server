package protocol.actions;

import protocol.PlayerAction;

public class LogInCommand implements PlayerAction {

    private String playerHash;

    public LogInCommand(String playerHash) {
        this.playerHash = playerHash;
    }

    public String getPlayerHash() {
        return playerHash;
    }

    public void setPlayerHash(String playerHash) {
        this.playerHash = playerHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogInCommand command = (LogInCommand) o;

        return playerHash.equals(command.playerHash);

    }

    @Override
    public int hashCode() {
        return playerHash.hashCode();
    }
}
