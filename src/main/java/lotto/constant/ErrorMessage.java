package lotto.constant;

public enum ErrorMessage {

    NULL_OR_EMPTY_ERROR("입력값은 비워둘 수 없습니다"),
    NOT_MULTIPLE_OF_1000_ERROR("1,000원 단위로만 구매할 수 있습니다");

    private final static String ANNOTATE_ERROR = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String inputMessage) {
        this.errorMessage = inputMessage;
    }

    public String getErrorMessage() {
        return ANNOTATE_ERROR + errorMessage;
    }
}
