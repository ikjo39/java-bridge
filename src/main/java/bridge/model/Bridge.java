package bridge.model;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isBridgeValidSign(int index, String sign) {
        return sign.equals(bridge.get(index));
    }

    public int getSize() {
        return bridge.size();
    }
}
