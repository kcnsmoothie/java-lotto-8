package lotto.constant;

public enum ViewMessage {
    PURCHASE_AMOUNT("%d개를 구매했습니다.");

    private final String viewMessage;

    ViewMessage(String inputMessage) {
        this.viewMessage = inputMessage;
    }

    public String getViewMessage() {
        return viewMessage;
    }

    public String getViewMessage(int value) {
        return String.format(viewMessage, value);
    }
}
