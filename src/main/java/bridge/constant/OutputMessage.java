package bridge.constant;

public enum OutputMessage {
    BRIDGE_GAME_INTRODUCTION("다리 건너기 게임을 시작합니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
