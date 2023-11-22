package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String MOVABLE = "O";
    private static final String IMMOVABLE = "X";
    private static final String UNSELECTED = " ";

    private final Bridge bridge;
    private final List<String> upperBridge = new ArrayList<>();
    private final List<String> lowerBridge = new ArrayList<>();

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public void move(int count, MovingSign movingSign) {
        if (isBridgeValidSign(count, movingSign) && movingSign.isUpperSign()) {
            upperBridge.add(MOVABLE);
            lowerBridge.add(UNSELECTED);
            return;
        } else if (isBridgeValidSign(count, movingSign)) {
            upperBridge.add(UNSELECTED);
            lowerBridge.add(MOVABLE);
            return;
        } else if (movingSign.isUpperSign()) {
            upperBridge.add(IMMOVABLE);
            lowerBridge.add(UNSELECTED);
            return;
        }
        upperBridge.add(UNSELECTED);
        lowerBridge.add(IMMOVABLE);
    }

    public boolean isBridgeValidSign(int count, MovingSign movingSign) {
        return bridge.isBridgeValidSign(count, movingSign.getSign());
    }

    public void retry() {
        upperBridge.clear();
        lowerBridge.clear();
    }

    public boolean isGameSuccess(BridgeSize size) {
        return size.getSize() == upperBridge.size();
    }

    public List<String> getUpperBridge() {
        return upperBridge;
    }

    public List<String> getLowerBridge() {
        return lowerBridge;
    }
}
