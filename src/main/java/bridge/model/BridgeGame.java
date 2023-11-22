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

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        upperBridge.clear();
        lowerBridge.clear();
    }

    public List<String> getUpperBridge() {
        return upperBridge;
    }

    public List<String> getLowerBridge() {
        return lowerBridge;
    }
}
