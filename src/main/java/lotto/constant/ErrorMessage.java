package lotto.constant;

public enum ErrorMessage {

    NULL_OR_EMPTY_ERROR("입력값은 비워둘 수 없습니다"),
    NOT_MULTIPLE_OF_1000_ERROR("1,000원 단위로만 구매할 수 있습니다"),
    INVALID_WINNING_NUMBER_SIZE_ERROR("당첨 번호는 6개를 입력해야합니다"),
    INVALID_NUMBER_RANGE_ERROR("당첨 번호는 1~45 사이의 숫자만 입력할 수 있습니다"),
    INVALID_NUMBER_DUPLICATE_ERROR("당첨 번호는 중복된 값을 입력할 수 없습니다");

    private final static String ANNOTATE_ERROR = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String inputMessage) {
        this.errorMessage = inputMessage;
    }

    public String getErrorMessage() {
        return ANNOTATE_ERROR + errorMessage;
    }
}
