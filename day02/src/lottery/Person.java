package lottery;

import java.util.Set;

public class Person {
    private Lottery lottery;
    private long reward;
    private boolean myAnswer;

    public Lottery getLottery() {
        return lottery;
    }

    public boolean isMyAnswer() {
        return myAnswer;
    }

    public void buy(Set<Integer> numbers) {
        this.lottery = new Lottery();
        this.lottery.addNumbers(numbers);
        this.myAnswer = true;
    }

    public void buy() {
        this.lottery = new Lottery();
        this.lottery.addNumbers();
    }


    @Override
    public String toString() {
        return "Person{" +
                "lottery=" + lottery +
                ", reward=" + reward +
                '}';
    }
}
