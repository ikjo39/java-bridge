package bridge;

import bridge.controller.BridgeGameController;
import bridge.handler.ExceptionRetryHandler;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ExceptionRetryHandler retryHandler = new ExceptionRetryHandler(outputView::printExceptionMessage);
        BridgeGameController bridgeGameController = new BridgeGameController(inputView, outputView, retryHandler);
        bridgeGameController.run();
    }
}
