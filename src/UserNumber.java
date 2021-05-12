import javax.swing.*;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

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


    public void askUserForGuess() {

       // Scanner scanner = new Scanner(System.in);
       //JOptionPane.showMessageDialog(null,"Try to guess!");
        String n1 = JOptionPane.showInputDialog(null,"Enter first digit:");
        setN1(parseInt(n1));
        String n2 = JOptionPane.showInputDialog(null,"Enter second digit:");
        setN2(parseInt(n2));
        String n3 = JOptionPane.showInputDialog(null,"Enter third digit:");
        setN3(parseInt(n3));
        String n4 = JOptionPane.showInputDialog(null,"Enter fourth digit:");
        setN4(parseInt(n4));

       // var userNumbers = List.of(n1,n2,n3,n4);
        JOptionPane.showMessageDialog(null,("You think number is "+n1+n2+n3+n4));
    }
}
