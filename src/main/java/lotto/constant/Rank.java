package lotto.constant;

public enum Rank {
    THREE_MATCH(3, 0, 5_000),
    FOUR_MATCH(4, 0, 50_000),
    FIVE_MATCH(5, 0, 1_500_000),
    FIVE_PLUS_BONUS_MATCH(5, 1, 30_000_000),
    SIX_MATCH(6, 0, 2_000_000_000);

    private final int matchCount;
    private final int bonusMatch; // 0 or 1
    private final long prize;

    Rank(int matchCount, int bonusMatch, long prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getBonusMatch() {
        return bonusMatch;
    }

    public long getPrize() {
        return prize;
    }
}

