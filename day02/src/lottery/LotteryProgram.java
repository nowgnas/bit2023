package lottery;

import lottery.util.Reward;

import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Pattern;

public class LotteryProgram {
    List<Person> people; // 로또 구매한 사용자
    static int[] winner = new int[6]; // 로또 맞춘 개수(인덱스)에 따른 사람 수
    static int myRank = 0; // 내가 맞춘 개수

    public void Operator() {
        System.out.println("로또 프로그램을 시작합니다....");
        System.out.println("로또 번호를 입력하세요 : ");

        Set<Integer> numbers = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        while (numbers.size() < 5) {
            String usrInput = sc.next();
            if (!Pattern.matches("^[\\d]*$", usrInput)) {
                System.out.println("숫자를 입력하세요 !");
                continue;
            }
            int inference = Integer.parseInt(usrInput);
            if (numbers.contains(inference) || inference > 50) {
                System.out.println("다른 숫자를 입력하세요");
                continue;
            }
            numbers.add(inference);
        }
        sc.close();
        people = new ArrayList<>();
        // 로또 구매
        Person me = new Person();
        me.buy(numbers);
        people.add(me);

        System.out.println("999명 로또 사는 중....");
        for (int i = 0; i < 999; i++) {
            Person person = new Person();
            person.buy();
            people.add(person);
        }
        printResult();
    }

    public void printResult() {
        System.out.println("로또 번호 생성 중.....");
        Office office = new Office();
        office.pickNumbers();
        Set<Integer> answer = office.getNumbers();

        System.out.println("로또 결과는 다음과 같습니다.");
        for (Person person :
                people) {
            Lottery lottery = person.getLottery();
            Set<Integer> numbers = lottery.getNumbers();
            int countSameNumber = 0;
            for (Integer num :
                    numbers) {
                if (answer.contains(num)) {
                    countSameNumber += 1;
                }
            }
            if (person.isMyAnswer()) myRank = countSameNumber;
            winner[countSameNumber] += 1;
        }
        Reward myResult = Reward.getMyResult(winner, myRank);
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.KOREA);
        String sb = "로또 결과 : \n" +
                answer.toString() + "\n" +
                "1등 : " + winner[5] + "\n" +
                "2등 : " + winner[4] + "\n" +
                "3등 : " + winner[3] + "\n" +
                "4등 : " + winner[2] + "\n" +
                "5등 : " + winner[1] + "\n" +
                "\n" +
                "나의 결과 : \n" +
                "등수: " + myResult.getRank() + "\n" +
                "당첨 금액 : " + nf.format(myResult.getReward()) + "원";
        System.out.print(sb);
    }

    public static void main(String[] args) {
        LotteryProgram lotteryProgram = new LotteryProgram();
        lotteryProgram.Operator(); // 로또 시작

    }
}
