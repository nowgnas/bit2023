package lottery;

import lottery.util.CreateRandomNumbers;

import java.util.Set;

public class Office {
    private static long totalReward = 5 * 10 ^ 9;
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
