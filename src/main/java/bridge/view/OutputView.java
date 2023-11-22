package bridge.view;

import static bridge.constant.OutputMessage.BRIDGE_GAME_INTRODUCTION;
import static bridge.constant.OutputMessage.MAP_FORMAT;

import bridge.constant.OutputMessage;
import bridge.model.BridgeGame;
import java.util.List;

public class OutputView {

    private static final String DELIMITER = " | ";

    public void printGameIntroduction() {
        printOutputMessage(BRIDGE_GAME_INTRODUCTION);
        System.out.println();
    }

    public void printMap(BridgeGame bridgeGame) {
        List<String> upperBridge = bridgeGame.getUpperBridge();
        List<String> lowerBridge = bridgeGame.getLowerBridge();

        String upper = String.join(DELIMITER, upperBridge);
        String lower = String.join(DELIMITER, lowerBridge);
        System.out.printf(MAP_FORMAT.getMessage(), upper, lower);
    }

    public void printResult() {
    }

    private void printOutputMessage(OutputMessage outputMessage) {
        System.out.println(outputMessage.getMessage());
    }
}
