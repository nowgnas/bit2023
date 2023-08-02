package lottery;

import lottery.util.CreateRandomNumbers;

import java.util.Set;

public class Lottery {
    private Set<Integer> numbers;

    public Set<Integer> getNumbers() {
        return numbers;
    }

    /**
     * 랜덤 숫자 생성
     * - 컴퓨터 999개 생성
     */
    public void addNumbers() {
        this.numbers = CreateRandomNumbers.getRandomNumbers();
    }

    public void addNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Lottery{" +
                "numbers=" + numbers +
                '}';
    }
}
