package bridge.model;

import bridge.BridgeNumberGenerator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeMaker {

    private static final int BRIDGE_UP_NUMBER = 1;
    private static final String BRIDGE_UP_SIGN = "U";
    private static final String BRIDGE_DOWN_SIGN = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .map(i -> bridgeNumberGenerator.generate())
                .mapToObj(this::convertIntegerToBridge)
                .collect(Collectors.toList());
    }

    private String convertIntegerToBridge(int operand) {
        if (operand == BRIDGE_UP_NUMBER) {
            return BRIDGE_UP_SIGN;
        }
        return BRIDGE_DOWN_SIGN;
    }
}
