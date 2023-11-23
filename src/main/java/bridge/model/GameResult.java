package bridge.model;

public class GameResult {
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    private final boolean isGameSuccess;
    private final int tryCount;

    public GameResult(boolean isGameSuccess, int tryCount) {
        this.isGameSuccess = isGameSuccess;
        this.tryCount = tryCount;
    }

    public String getIsGameSuccess() {
        if (isGameSuccess) {
            return SUCCESS;
        }
        return FAIL;
    }

    public int getTryCount() {
        return tryCount;
    }
}
