package lotto.constant;

public enum LottoNumberConstant {
    LOTTO_PRICE(1000),
    LOTTO_RANGE_MIN(1),
    LOTTO_RANGE_MAX(45),
    LOTTO_NUMBER_SIZE(6);

    private final int intValue;

    LottoNumberConstant(int intValue) {
        this.intValue = intValue;
    }

    public int getValue() {
        return intValue;
    }
}
