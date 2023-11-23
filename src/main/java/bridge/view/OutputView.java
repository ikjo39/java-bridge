package bridge.view;

import static bridge.constant.OutputMessage.BRIDGE_GAME_INTRODUCTION;
import static bridge.constant.OutputMessage.FINAL_RESULT_OF_THE_GAME;
import static bridge.constant.OutputMessage.IS_GAME_SUCCESS_FORMAT;
import static bridge.constant.OutputMessage.MAP_FORMAT;
import static bridge.constant.OutputMessage.TOTAL_GAME_COUNT;

import bridge.constant.OutputMessage;
import bridge.model.BridgeGame;
import bridge.model.CrossPosition;
import bridge.model.GameResult;
import java.util.List;

public class OutputView {
    private static final String DELIMITER = " | ";

    public void printGameIntroduction() {
        printOutputMessage(BRIDGE_GAME_INTRODUCTION);
        System.out.println();
    }

    public void printMap(BridgeGame bridgeGame) {
        CrossPosition crossPosition = bridgeGame.getCrossPosition();
        List<String> upperBridge = crossPosition.getUpperBridge();
        List<String> lowerBridge = crossPosition.getLowerBridge();

        String upper = String.join(DELIMITER, upperBridge);
        String lower = String.join(DELIMITER, lowerBridge);
        System.out.printf(MAP_FORMAT.getMessage(), upper, lower);
        System.out.println();
    }

    public void printResult(BridgeGame bridgeGame) {
        printOutputMessage(FINAL_RESULT_OF_THE_GAME);
        printMap(bridgeGame);

        GameResult gameResult = bridgeGame.getGameResult();
        System.out.printf(IS_GAME_SUCCESS_FORMAT.getMessage(), gameResult.getIsGameSuccess());
        System.out.printf(TOTAL_GAME_COUNT.getMessage(), gameResult.getTryCount());
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    private void printOutputMessage(OutputMessage outputMessage) {
        System.out.println(outputMessage.getMessage());
    }
}
