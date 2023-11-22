package bridge.model;

import bridge.BridgeNumberGenerator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int BRIDGE_UP_NUMBER = 0;
    private static final String BRIDGE_UP_SIGN = "U";
    private static final String BRIDGE_DOWN_SIGN = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
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
