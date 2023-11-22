package bridge.model;

public class GameResult {
    private final boolean isGameSuccess;
    private final int tryCount;

    public GameResult(boolean isGameSuccess, int tryCount) {
        this.isGameSuccess = isGameSuccess;
        this.tryCount = tryCount;
    }

    public boolean isGameSuccess() {
        return isGameSuccess;
    }

    public int getTryCount() {
        return tryCount;
    }
}
