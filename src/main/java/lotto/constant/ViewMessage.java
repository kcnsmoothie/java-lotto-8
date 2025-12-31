package lotto.constant;

public enum ViewMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_LOTTO_QUANTITY("%d개를 구매했습니다.");

    private final String viewMessage;

    ViewMessage(String inputMessage) {
        this.viewMessage = inputMessage;
    }

    public String getViewMessage() {
        return viewMessage;
    }

    public String getViewMessage(int intValue) {
        return String.format(viewMessage, intValue);
    }
}
