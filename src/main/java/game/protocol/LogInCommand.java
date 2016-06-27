package game.protocol;

import game.GameEngine;

/**
 * Created by DimaMir on 26.03.2016.
 */
public class LogInCommand implements Command {

    private String login;
    private String password;

    public LogInCommand(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogInCommand command = (LogInCommand) o;

        if (!login.equals(command.login)) return false;
        return password.equals(command.password);

    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    public void execute(GameEngine engine) {

    }
}
