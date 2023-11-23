package bridge.constant;

public enum OutputMessage {
    BRIDGE_GAME_INTRODUCTION("다리 건너기 게임을 시작합니다."),
    ENTER_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    ENTER_MOVING_SIGN("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    ENTER_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_RESULT_OF_THE_GAME("최종 게임 결과"),

    MAP_FORMAT("[ %s ]%n[ %s ]%n"),
    IS_GAME_SUCCESS_FORMAT("게임 성공 여부: %s%n"),
    TOTAL_GAME_COUNT("총 시도한 횟수: %d%n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
