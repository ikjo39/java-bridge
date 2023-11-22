package bridge.model;

import static bridge.constant.ExceptionMessage.INVALID_MOVING_SIGN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovingSign {
    private static final String UP_SIGN = "U";
    private static final String DOWN_SIGN = "D";
    private static final String IS_VALID_SIGN_REGEX = String.format("%s|%s", UP_SIGN, DOWN_SIGN);
    private static final Pattern IS_VALID_SIGN = Pattern.compile(IS_VALID_SIGN_REGEX);

    private final String sign;

    public MovingSign(String sign) {
        validateSign(sign);
        this.sign = sign;
    }

    private void validateSign(String sign) {
        Matcher matcher = IS_VALID_SIGN.matcher(sign);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_MOVING_SIGN.getMessage());
        }
    }
}
