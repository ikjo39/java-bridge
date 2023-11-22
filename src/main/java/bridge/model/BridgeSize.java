package bridge.model;

import static bridge.constant.ExceptionMessage.NOT_IN_RANGE_BRIDGE_SIZE;

public class BridgeSize {
    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;

    private final int size;

    public BridgeSize(int size) {
        validateBridgeLength(size);
        this.size = size;
    }

    private void validateBridgeLength(int size) {
        if (!isLengthInRange(size)) {
            throw new IllegalArgumentException(NOT_IN_RANGE_BRIDGE_SIZE.getMessage());
        }
    }

    private boolean isLengthInRange(int size) {
        return size >= MINIMUM_BRIDGE_SIZE && size <= MAXIMUM_BRIDGE_SIZE;
    }
}
