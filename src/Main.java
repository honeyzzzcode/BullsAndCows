import User.User;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class Main {
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final ArrayList<User> leaderboard = new ArrayList<>();
    private static File leaderboardFile = new File("Leaderboard.txt");
    public static void main(String[] args) {



        ImageIcon won = new ImageIcon("won.jpg");

        UserNumber userNumber = new UserNumber();
        boolean gameOn = true;

        do {

            boolean userWin = true;
            var rand = new Random();
            var set = new LinkedHashSet<Integer>();
            while (set.size() < 4) {
                var n = rand.nextInt(9);
                set.add(n+1);
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
                    new ImageIcon("welcome.jpg") );
           String userName = String.valueOf(JOptionPane.showInputDialog(null, "Enter your name:", "Player VS PC" , JOptionPane.INFORMATION_MESSAGE, new ImageIcon("player-vs-pc.jpg"), null, ""));
            long startTime = System.currentTimeMillis();
            for (int attempts = 1; attempts <= 2; attempts++) {
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
                    long endTime = System.currentTimeMillis();
                    User user = new User();
                    user.setUsername(userName);
                    user.setAttempts(attempts);
                    user.setDuration(endTime - startTime);
                    user.setStarttime(startTime);
leaderboard.add(user);

                    JOptionPane.showMessageDialog(null, "Congratulations!You won " + attempts + " attempts were used.", null, JOptionPane.ERROR_MESSAGE,new ImageIcon("won.jpg"));
                    userWin = false;
                    break;
                }
            }

            if (userWin) {
                JOptionPane.showMessageDialog(null, "You lost :( Number was " + generatedDigits, null, JOptionPane.ERROR_MESSAGE,new ImageIcon("bull.png"));
            }

            String[] yesOrNo = {"Yes", "No"};
            String userChoice = (String) JOptionPane.showInputDialog(null, "Do you want to play again ?",
                    null,
                    JOptionPane.WARNING_MESSAGE,
                    new ImageIcon("yesorno.jpeg"),
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
        saveLeaderboard();
        printleaderboard();
    }
    private static void saveLeaderboard() {

        try (var out = new PrintWriter(leaderboardFile)) {
            for (var gr : leaderboard) {
                out.printf("%s %d  %d %d \n", gr.getUsername(), gr.getAttempts(), gr.getDuration(), gr.getStarttime());
            }

        } catch (FileNotFoundException e) {
            System.out.println("cannot save leaderboard");
        }

    }
    private static void printleaderboard() {
        Date date = new Date();
        leaderboard.sort(
                Comparator.comparingInt(User::getAttempts)
                        .thenComparingLong(User::getDuration)
        );
        int maxLen = 0;
        for (User gr : leaderboard) {
            var len = gr.getUsername().length();
            if (maxLen < len) {
                maxLen = len;
            }
        }
        System.out.printf("NAME  \t     ATTEMPTS \t     DURATION     \t     START TIME\n");
        var num = Math.min(5, leaderboard.size());
        var sublist = leaderboard.subList(0, num);
        for (User gr : sublist) {

            System.out.printf("%1$-" + maxLen + "s      %2$8d   \t      %3$5.1fs         \t %4$tD\t %4$tR%n", gr.getUsername(), gr.getAttempts(), gr.getDuration() / 1000.0, gr.getStarttime(), gr.getStarttime());
        }
    }
}
