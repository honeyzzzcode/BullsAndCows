import java.util.List;
import java.util.Scanner;

public class UserNumber {

    private int n1;
    private int n2;
    private int n3;
    private int n4;

    public int getN2() {
        return n2;
    }
    public void setN2(int n2) {
        this.n2 = n2;
    }
    public int getN3() {
        return n3;
    }
    public void setN3(int n3) {
        this.n3 = n3;
    }
    public int getN4() {
        return n4;
    }
    public void setN4(int n4) {
        this.n4 = n4;
    }
    public int getN1() {
        return n1;
    }
    public void setN1(int n1) {
        this.n1 = n1;
    }


    public String askUserForGuess() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Try to guess!");
        System.out.println("Enter first digit:");
        setN1(scanner.nextInt());;
        System.out.println("Enter second digit:");
       setN2(scanner.nextInt());
        System.out.println("Enter third digit:");
        setN3(scanner.nextInt());
        System.out.println("Enter fourth digit:");
       setN4(scanner.nextInt());

        var userNumbers = List.of(n1,n2,n3,n4);
        return "You think the number is : "+n1+n2+n3+n4;

    }
}
