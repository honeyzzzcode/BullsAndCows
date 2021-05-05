import java.util.*;

public class Main {

    public static void main(String[] args) {
        UserNumber userNumber = new UserNumber();
        var rand = new Random();
        /* To make it not repeat the digits separate times (like computer can generate two times 3 and again 3 )
         we make LinkedHashSet, because it does not allow us to repeat numbers and then on line 18 we put it into simple List
          so that it would be possible to compare generatedDigits with userDigits after on line 37
         */
        var set = new LinkedHashSet<Integer>();
        while (set.size() < 4) {
            var n = rand.nextInt(10);
            set.add(n);
        }
        List<Integer> generatedDigits;
        generatedDigits = List.copyOf(set);
        System.out.println(generatedDigits);

        System.out.println("Welcome to bulls and cows game ! \n" +
                " There is  a 4-digit secret number. The digits are all different.\n " +
                "Then the players try to guess number.\n " +
                "If the matching digits are in their right positions, they are \"bulls\",\n " +
                "if in different positions,but right digits -  they are \"cows\". LETS GO!");

        boolean userWin = true;
        do {
            userNumber.askUserForGuess();
            var userDigits = List.of(userNumber.getN1(), userNumber.getN2(), userNumber.getN3(), userNumber.getN4());

            int bulls = 0;
            int cows = 0;
            for (int j = 0; j < 4; j++) {
                int myN = generatedDigits.get(j);
                for (int z = 0; z < 4; z++) {
                    int usrN = userDigits.get(z);
                    if (myN == usrN) {
                        if (j == z) {
                            bulls++;
                        } else {
                            cows++;
                        }

                    }
                }
            }
            var all = new ALLInformation();
            all.setBulls(bulls);
            all.setCows(cows);
            System.out.println("bulls : " + bulls + " and cows: " + cows);
            if (bulls == 4) {

                System.out.println("Congratulations!You won");
                userWin = false;
            }else {
                System.out.println("Maybe again?");
            }
        } while (userWin);

    }

}
