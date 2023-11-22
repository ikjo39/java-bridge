package bridge.controller;

import bridge.model.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printGameIntroduction();
        BridgeSize bridgeSize = new BridgeSize(inputView.readBridgeSize());
    }
}
