package game.protocol;

import game.GameEngine;

/**
 * Created by DimaMir on 26.03.2016.
 */
public class MoveCommand implements Command{

    private Button button;
    private boolean isPressed;

    public MoveCommand(String button, boolean isPressed) {
        this.button = Button.buttonFromString(button);
        this.isPressed = isPressed;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }

    public void execute(GameEngine engine) {

    }

    public enum Button{
        UP, DOWN, LEFT, RIGHT;

        public static Button buttonFromString(String s) {
            switch (s){
                case "UP":
                    return UP;
                case "DOWN":
                    return DOWN;
                case "LEFT":
                    return LEFT;
                case "RIGHT":
                    return RIGHT;
                default:
                    return null;
            }
        }
    }
}
