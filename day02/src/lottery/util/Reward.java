package lottery.util;

import lottery.Office;

public class Reward {
    private int rank;
    private long reward;

    public int getRank() {
        return rank;
    }

    public long getReward() {
        return reward;
    }

    private Reward(Builder builder) {
        this.rank = builder.rank;
        this.reward = builder.reward;
    }

    public static class Builder {
        private int rank;
        private long reward;

        public Builder reward(long reward) {
            this.reward = reward;
            return this;
        }

        public Builder rank(int rank) {
            this.rank = rank;
            return this;
        }

        public Reward build() {
            return new Reward(this);
        }
    }


    public static Reward getMyResult(int[] leaderBoard, int correct) {
        long totalReward = Office.getTotalReward();
        int rank = (1 - 6) * -1;
        switch (rank) {
            case 1:
                totalReward = totalReward * (100 / Rate.first);
                break;
            case 2:
                totalReward = totalReward * (100 / Rate.second);
                break;
            case 3:
                totalReward = totalReward * (100 / Rate.third);
                break;
            case 4:
                totalReward = totalReward * (100 / Rate.forth);
                break;
            case 5:
                totalReward = totalReward * (100 / Rate.fifth);
                break;
        }
        long getReward = totalReward / leaderBoard[correct];
        return new Reward.Builder().reward(getReward).rank(rank).build();
    }
}
