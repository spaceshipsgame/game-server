package game.protocol;

import game.GameEngine;

/**
 * Created by DimaMir on 26.03.2016.
 */
public interface Command {

    public void execute(GameEngine engine);
}
