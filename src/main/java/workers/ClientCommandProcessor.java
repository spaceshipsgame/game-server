package workers;

import game.protocol.Command;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by DimaMir on 26.03.2016.
 */

public class ClientCommandProcessor {

    private ExecutorService pool;

    public ClientCommandProcessor(int poolSize) {
        Executors.newFixedThreadPool(poolSize);
    }

    public void put(Command command){
        //translate message into command and send command to game engine
    }
}
