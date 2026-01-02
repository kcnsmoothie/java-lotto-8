package lotto.constant;

public enum Rank {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000);

    private final int winningHit;
    private final int bonusHit;
    private final double prize;

    Rank(int winningHit, int bonusHit, double prize) {
        this.winningHit = winningHit;
        this.bonusHit = bonusHit;
        this.prize = prize;
    }

    public int getWinningHit() {
        return winningHit;
    }

    public int getBonusHit() {
        return bonusHit;
    }

    public double getPrize() {
        return prize;
    }
}
