package lotto.constant;

public enum LottoNumberConstant {
    LOTTO_PRICE(1000);

    private final int intValue;

    LottoNumberConstant(int intValue) {
        this.intValue = intValue;
    }

    public int getValue() {
        return intValue;
    }
}
