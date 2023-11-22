package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private static final String MOVABLE = "O";
    private static final String IMMOVABLE = "X";
    private static final String UNSELECTED = " ";

    private final Bridge bridge;
    private final List<String> upperBridge = new ArrayList<>();
    private final List<String> lowerBridge = new ArrayList<>();
    private int count;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        count = 0;
    }

    public boolean validateGameContinue(BridgeSize bridgeSize) {
        return count < bridgeSize.getSize();
    }

    public void move(MovingSign movingSign) {
        if (isBridgeValidSign(movingSign) && movingSign.isUpperSign()) {
            upperBridge.add(MOVABLE);
            lowerBridge.add(UNSELECTED);
            count++;
            return;
        } else if (isBridgeValidSign(movingSign)) {
            upperBridge.add(UNSELECTED);
            lowerBridge.add(MOVABLE);
            count++;
            return;
        } else if (movingSign.isUpperSign()) {
            upperBridge.add(IMMOVABLE);
            lowerBridge.add(UNSELECTED);
            count++;
            return;
        }
        upperBridge.add(UNSELECTED);
        lowerBridge.add(IMMOVABLE);
        count++;
    }

    public boolean isBridgeValidSign(MovingSign movingSign) {
        return bridge.isBridgeValidSign(count, movingSign.getSign());
    }

    public GameResult getGameResult() {
        return new GameResult(isGameSuccess(), count);
    }

    public void retry() {
        upperBridge.clear();
        lowerBridge.clear();
        count = 0;
    }

    public boolean isGameSuccess() {
        return bridge.getSize() == upperBridge.size();
    }

    public List<String> getUpperBridge() {
        return upperBridge;
    }

    public List<String> getLowerBridge() {
        return lowerBridge;
    }
}
