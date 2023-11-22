package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class CrossPosition {
    private static final String MOVABLE = "O";
    private static final String IMMOVABLE = "X";
    private static final String UNSELECTED = " ";

    private final List<String> upperBridge = new ArrayList<>();
    private final List<String> lowerBridge = new ArrayList<>();

    public void move(boolean isBridgeValid, boolean isUpperSign) {
        if (isBridgeValid && isUpperSign) {
            upperBridge.add(MOVABLE);
            lowerBridge.add(UNSELECTED);
            return;
        } else if (isBridgeValid) {
            upperBridge.add(UNSELECTED);
            lowerBridge.add(MOVABLE);
            return;
        } else if (isUpperSign) {
            upperBridge.add(IMMOVABLE);
            lowerBridge.add(UNSELECTED);
            return;
        }
        upperBridge.add(UNSELECTED);
        lowerBridge.add(IMMOVABLE);
    }

    public void clear() {
        upperBridge.clear();
        lowerBridge.clear();
    }

    public int getSize() {
        return upperBridge.size();
    }

    public List<String> getUpperBridge() {
        return upperBridge;
    }

    public List<String> getLowerBridge() {
        return lowerBridge;
    }
}
