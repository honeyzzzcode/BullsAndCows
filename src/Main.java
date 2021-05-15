import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ImageIcon welcomeIcon = new ImageIcon("welcome.jpg");
        ImageIcon won = new ImageIcon("won.jpg");
        UserNumber userNumber = new UserNumber();
        boolean gameOn = true;

        do {

            boolean userWin = true;
            var rand = new Random();
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

            for (int attempts = 1; attempts <= 7; attempts++) {


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
                JOptionPane.showMessageDialog(null, "bulls : " + bulls + " and cows: " + cows + " \n" + attempts + " of 7 attempts are used.");

                if (bulls == 4) {

                    JOptionPane.showMessageDialog(null, "Congratulations!You won " + attempts + " attempts were used.", null, JOptionPane.ERROR_MESSAGE, won);
                    userWin = false;
                    break;
                }
            }

            if (userWin) {
                JOptionPane.showMessageDialog(null, "You lost :( Number was " + generatedDigits, null, JOptionPane.ERROR_MESSAGE);
            }

            String[] yesOrNo = {"Yes", "No"};
            String userChoice = (String) JOptionPane.showInputDialog(null, "Do you want to play again ?",
                    null,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    yesOrNo,
                    yesOrNo[0]);
            switch (userChoice) {
                case "Yes":

                    break;
                case "No":
                    gameOn = false;
                    break;

            }
        } while (gameOn);
    }
}
