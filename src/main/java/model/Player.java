package model;

public class Player {

    private String playerHash;

    public String getPlayerHash() {
        return playerHash;
    }

    public void setPlayerHash(String playerHash) {
        this.playerHash = playerHash;
    }

//  now message parameter is string but  it must be changed when will be created model for output messages
//  maybe will be more than one method of messages here
    public void sendMessageToClient(String message){

    }
}
