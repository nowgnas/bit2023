package lottery;

import lottery.util.CreateRandomNumbers;

import java.util.Set;

public class Office {
    private static final long totalReward = (long) (Math.pow(10, 9) * 5);
    private Set<Integer> winNumbers;

    public void pickNumbers() {
        this.winNumbers = CreateRandomNumbers.getRandomNumbers();
    }

    public Set<Integer> getNumbers() {
        return this.winNumbers;
    }

    public static long getTotalReward() {
        return totalReward;
    }
}
