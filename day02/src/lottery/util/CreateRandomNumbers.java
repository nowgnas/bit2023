package lottery.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CreateRandomNumbers {
    private final static int LOTTERY_MAX_NUMBER = 40;
    public static Set<Integer> getRandomNumbers(){
        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();
        while (numbers.size() < 6) {
            Integer newNum = random.nextInt(LOTTERY_MAX_NUMBER) + 1;
            if (numbers.contains(newNum)) {
                continue;
            }
            numbers.add(newNum);
        }
        return numbers;
    }
}
