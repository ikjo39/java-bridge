package bridge.model;

public class BridgeGame {
    private static final int INIT_INDEX = 0;
    private static final int INIT_COUNT = 1;

    private final Bridge bridge;
    private final CrossPosition crossPosition;
    private int index;
    private int tryCount;

    public BridgeGame(Bridge bridge, CrossPosition crossPosition) {
        this.bridge = bridge;
        this.crossPosition = crossPosition;
        index = INIT_INDEX;
        tryCount = INIT_COUNT;
    }

    public boolean validateGameContinue() {
        return index < bridge.getSize();
    }

    public void move(MovingSign movingSign) {
        index++;
        crossPosition.move(isBridgeValidSign(movingSign), movingSign.isUpperSign());
    }

    public boolean isBridgeValidSign(MovingSign movingSign) {
        return bridge.isBridgeValidSign(index - 1, movingSign.getSign());
    }

    public void plusTryCount() {
        tryCount++;
    }

    public GameResult getGameResult() {
        return new GameResult(isGameSuccess(), tryCount);
    }

    public void retry() {
        crossPosition.clear();
        index = INIT_INDEX;
    }

    public boolean isGameSuccess() {
        return bridge.getSize() == crossPosition.getSize();
    }

    public CrossPosition getCrossPosition() {
        return crossPosition;
    }
}
