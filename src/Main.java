import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        List<Integer> myNumbers;
        var rand = new Random();
        var set = new LinkedHashSet<Integer>();
        while (set.size() < 4) {
            var n = rand.nextInt(10);
            set.add(n);
        }
        myNumbers = List.copyOf(set);
        System.out.println(myNumbers);

        System.out.println("Welcome to bulls and cows game ! " );
        do {
            System.out.println("Try to guess the number:");

            var n1 = scanner.nextInt();
            var n2 = scanner.nextInt();
            var n3 = scanner.nextInt();
            var n4 = scanner.nextInt();
            var guess ="" + n1 + n2 + n3 + n4 ;

            var userNumbers = List.of(n1,n2,n3,n4);
            System.out.println(userNumbers);

            int bulls = 0;
            int cows = 0;
            for (int j = 0; j < 4; j++) {
                int myN = myNumbers.get(j);
                for (int z = 0; z < 4; z++) {
                    int usrN = userNumbers.get(z);
                    if (myN == usrN) {
                        if (j == z) {
                            bulls++;
                        } else {
                            cows++;
                        }

                    }
                }
            }
            var all = new All();
            count++;
            all.setGuess(guess);
            all.setNr(count);
            all.setBulls(bulls);
            all.setCows(cows);
            System.out.println("bulls : "+bulls+" and cows: "+ cows);
            if (bulls == 4) {

                System.out.println("Congratulations!You won");
                running=false;
            }
        }while (running);



    }
}
