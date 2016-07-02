package protocol;


public class ChainHandlersFactory {

    public PlayerActionHandler createChain(PlayerActionHandler ... handlers){
        if(handlers.length == 0){
            return null;
        }
        for(int i = 0;i < handlers.length - 1;i++){
            handlers[i].setSuccessor(handlers[i + 1]);
        }
        return handlers[0];
    }
}
