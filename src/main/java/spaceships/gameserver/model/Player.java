package spaceships.gameserver.model;

public class Player {

    private String playerHash;
    private Connection connection;

    public String getPlayerHash() {
        return playerHash;
    }

    public void setPlayerHash(String playerHash) {
        this.playerHash = playerHash;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    //  now message parameter is string but  it must be changed when will be created model for output messages
//  maybe will be more than one method of messages here
    public void sendMessageToClient(String message){

    }
}
