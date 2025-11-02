package lotto.constant;

public enum ViewMessage {
    PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),

    PURCHASE_RESULT_MESSAGE("%d개를 구매했습니다."),
    STATISTICS_HEADER("당첨 통계\n---"),

    FIFTH_PLACE_MESSAGE("3개 일치 (5,000원) - %d개"),
    FOURTH_PLACE_MESSAGE("4개 일치 (50,000원) - %d개"),
    THIRD_PLACE_MESSAGE("5개 일치 (1,500,000원) - %d개"),
    SECOND_PLACE_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_PLACE_MESSAGE("6개 일치 (2,000,000,000원) - %d개"),

    TOTAL_PROFIT_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

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

    public String getViewMessage(double value) {
        return String.format(viewMessage, value);
    }
}

