package bridge.constant;

public enum OutputMessage {
    BRIDGE_GAME_INTRODUCTION("다리 건너기 게임을 시작합니다."),
    ENTER_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    ENTER_MOVING_SIGN("이동할 칸을 선택해주세요. (위: U, 아래: D)");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
