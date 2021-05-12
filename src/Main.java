import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ImageIcon welcomeIcon = new ImageIcon("welcome.jpg");
        ImageIcon won = new ImageIcon("won.jpg");
        UserNumber userNumber = new UserNumber();
        var rand = new Random();
        /* To make it not repeat the digits separate times (like computer can generate two times 3 and again 3 )
         we make LinkedHashSet, because it does not allow us to repeat numbers and then on line 18 we put it into simple List
          so that it would be possible to compare generatedDigits with userDigits after on line 38
         */
        var set = new LinkedHashSet<Integer>();
        while (set.size() < 4) {
            var n = rand.nextInt(10);
            set.add(n);
        }
        List<Integer> generatedDigits;
        generatedDigits = List.copyOf(set);
        System.out.println(generatedDigits);

        JOptionPane.showMessageDialog(null,
                "Welcome to bulls and cows game ! \n" +
                " There is  a 4-digit secret number. The digits are all different.\n " +
                "Then the players try to guess number.\n " +
                "If the matching digits are in their right positions, they are \"bulls\",\n " +
                "if in different positions,but right digits -  they are \"cows\". \nLET'S GO!",
                "Welcome to the game!",
                JOptionPane.INFORMATION_MESSAGE,
                welcomeIcon);


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
            JOptionPane.showMessageDialog(null, "bulls : " + bulls + " and cows: " + cows);
            if (bulls == 4) {

                JOptionPane.showMessageDialog(null,"Congratulations!You won",null, JOptionPane.ERROR_MESSAGE, won );
                userWin = false;
            }else {
                JOptionPane.showMessageDialog(null, "Maybe again?", null, JOptionPane.ERROR_MESSAGE);
            }
        } while (userWin);

    }

}
