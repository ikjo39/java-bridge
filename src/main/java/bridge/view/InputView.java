package bridge.view;

import static bridge.constant.ExceptionMessage.INVALID_NUMBER_FORMAT;
import static bridge.constant.OutputMessage.ENTER_BRIDGE_SIZE;
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

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
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
