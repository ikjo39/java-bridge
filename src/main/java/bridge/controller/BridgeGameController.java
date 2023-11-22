package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.handler.ExceptionRetryHandler;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.BridgeSize;
import bridge.model.CrossPosition;
import bridge.model.GameCommand;
import bridge.model.MovingSign;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ExceptionRetryHandler retryHandler;

    public BridgeGameController(InputView inputView, OutputView outputView, ExceptionRetryHandler retryHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.retryHandler = retryHandler;
    }

    public void run() {
        outputView.printGameIntroduction();
        BridgeSize bridgeSize = getBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize.getSize()));
        BridgeGame bridgeGame = new BridgeGame(bridge, new CrossPosition());

        while (bridgeGame.validateGameContinue()) {
            MovingSign movingSign = getMovingSign();
            bridgeGame.move(movingSign);
            outputView.printMap(bridgeGame);
            if (!bridgeGame.isBridgeValidSign(movingSign)) {
                bridgeGame.plusTryCount();
                GameCommand gameCommand = getGameCommand();
                if (gameCommand.isGameEnd()) {
                    outputView.printResult(bridgeGame);
                    return;
                }
                bridgeGame.retry();
            }
        }
        outputView.printResult(bridgeGame);
    }

    private BridgeSize getBridgeSize() {
        return retryHandler.retryUntilValid(() -> new BridgeSize(inputView.readBridgeSize()));
    }

    private MovingSign getMovingSign() {
        return retryHandler.retryUntilValid(() -> new MovingSign(inputView.readMoving()));
    }

    private GameCommand getGameCommand() {
        return retryHandler.retryUntilValid(() -> new GameCommand(inputView.readGameCommand()));
    }
}
