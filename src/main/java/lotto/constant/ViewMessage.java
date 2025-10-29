package lotto.constant;

public enum ViewMessage {
    PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String inputMessage;

    ViewMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }
}

