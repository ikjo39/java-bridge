package bridge.constant;

public enum ExceptionMessage {
    INVALID_NUMBER_FORMAT("올바른 숫자 형식을 입력하셔야 합니다."),
    NOT_IN_RANGE_BRIDGE_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private static final String HEADER = "[ERROR]";

    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format("%s %s", HEADER, message);
    }

    public String getMessage() {
        return message;
    }
}
