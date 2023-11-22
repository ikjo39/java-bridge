package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.BridgeSize;
import bridge.model.GameCommand;
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
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize.getSize()));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        while (bridgeGame.validateGameContinue(bridgeSize)) {
            MovingSign movingSign = new MovingSign(inputView.readMoving());
            bridgeGame.move(movingSign);
            outputView.printMap(bridgeGame);
            if (!bridgeGame.isBridgeValidSign(movingSign)) {
                GameCommand gameCommand = new GameCommand(inputView.readGameCommand());
                if (gameCommand.isGameEnd()) {
                    outputView.printResult(bridgeGame);
                    return;
                }
                bridgeGame.retry();
            }
        }
        outputView.printResult(bridgeGame);
    }
}
