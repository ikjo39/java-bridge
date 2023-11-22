package bridge.view;

import static bridge.constant.ExceptionMessage.INVALID_NUMBER_FORMAT;
import static bridge.constant.OutputMessage.ENTER_BRIDGE_SIZE;
import static bridge.constant.OutputMessage.ENTER_GAME_COMMAND;
import static bridge.constant.OutputMessage.ENTER_MOVING_SIGN;

import bridge.constant.OutputMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        printOutputMessage(ENTER_BRIDGE_SIZE);
        String input = Console.readLine();
        System.out.println();
        return parseInt(input);
    }

    public String readMoving() {
        printOutputMessage(ENTER_MOVING_SIGN);
        return Console.readLine();
    }

    public String readGameCommand() {
        printOutputMessage(ENTER_GAME_COMMAND);
        return Console.readLine();
    }

    private int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private void printOutputMessage(OutputMessage outputMessage) {
        System.out.println(outputMessage.getMessage());
    }
}
