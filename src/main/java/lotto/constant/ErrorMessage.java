package lotto.constant;

public enum ErrorMessage {
    DEFAULT_MESSAGE("입력값이 잘못되었습니다. 다시 입력해주세요.");

    private final static String ANNOTATE_ERROR = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String inputMessage) {
        this.errorMessage = inputMessage;
    }

    public String getErrorMessage() {
        return ANNOTATE_ERROR + errorMessage;
    }
}
