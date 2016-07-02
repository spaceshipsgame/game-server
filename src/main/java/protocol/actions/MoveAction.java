package protocol.actions;

import game.GameEngine;
import protocol.PlayerAction;

public class MoveAction implements PlayerAction{

    private Button button;
    private boolean isPressed;

    public MoveAction(String button, boolean isPressed) {
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
