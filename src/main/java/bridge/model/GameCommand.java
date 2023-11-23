package bridge.model;

import static bridge.constant.ExceptionMessage.INVALID_RETRY_SIGN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameCommand {
    private static final String RESTART = "R";
    private static final String END = "Q";
    private static final String IS_VALID_COMMAND_REGEX = String.format("%s|%s", RESTART, END);
    private static final Pattern IS_VALID_COMMAND = Pattern.compile(IS_VALID_COMMAND_REGEX);

    private final String command;

    public GameCommand(String command) {
        validateSign(command);
        this.command = command;
    }

    private void validateSign(String command) {
        Matcher matcher = IS_VALID_COMMAND.matcher(command);
        if(!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_RETRY_SIGN.getMessage());
        }
    }

    public boolean isGameEnd() {
        return END.equals(command);
    }
}
