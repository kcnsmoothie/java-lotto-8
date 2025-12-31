package lotto.constant;

public enum ErrorMessage {
    NULL_OR_EMPTY_ERROR("입력값은 비워둘 수 없습니다."),
    NUMBER_FORMAT_ERROR("숫자만 입력할 수 있습니다."),
    MULTIPLES_OF_1000_ERROR("구입금액은 1000원 단위로 입력해야합니다.");

    private final static String ANNOTATE_ERROR = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String inputMessage) {
        this.errorMessage = inputMessage;
    }

    public String getErrorMessage() {
        return ANNOTATE_ERROR + errorMessage;
    }
}
