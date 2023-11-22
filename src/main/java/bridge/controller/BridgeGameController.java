package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeMaker;
import bridge.model.BridgeSize;
import bridge.model.MovingSign;
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
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        MovingSign movingSign = new MovingSign(inputView.readMoving());
    }
}
