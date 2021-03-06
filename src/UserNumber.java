import javax.swing.*;
import static java.lang.Integer.parseInt;

public class UserNumber {
    private int n1;
    private int n2;
    private int n3;
    private int n4;

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

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

    public void askUserForGuess() {

        setN1(0);
        do {
            String n1 = String.valueOf(JOptionPane.showInputDialog(null, "Enter first digit:","" , JOptionPane.INFORMATION_MESSAGE, new ImageIcon("question_mark.gif"), null, ""));
            try {
             if ( n1.length()>1){
              throw new Exception("You should type one digit");}
            setN1(parseInt(n1));}
            catch (Exception e){
             JOptionPane.showMessageDialog(null, "You should type a digit", null, JOptionPane.ERROR_MESSAGE);}
             } while (getN1()==0);

        setN2(0);
        do {
            String n2 =  String.valueOf(JOptionPane.showInputDialog(null, "Enter second digit:", "" , JOptionPane.INFORMATION_MESSAGE, new ImageIcon("question_mark.gif"), null, ""));
            try {
             if ( n2.length()>1){
              throw new Exception("You should type one digit");}
            setN2(parseInt(n2));}
            catch (Exception e) {JOptionPane.showMessageDialog(null, "You should type a digit", null, JOptionPane.ERROR_MESSAGE);}
            } while (getN2() == 0);

        setN3(0);
        do {
            String n3 = String.valueOf(JOptionPane.showInputDialog(null, "Enter third digit:", "" , JOptionPane.INFORMATION_MESSAGE, new ImageIcon("question_mark.gif"), null, ""));
            try {
             if ( n3.length()>1){
              throw new Exception("You should type one digit");}
                setN3(parseInt(n3));}
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "You should type a digit", null, JOptionPane.ERROR_MESSAGE);}
            } while (getN3() == 0);

        setN4(0);
        do {
            String n4 = String.valueOf(JOptionPane.showInputDialog(null, "Enter fourth digit:", "" , JOptionPane.INFORMATION_MESSAGE, new ImageIcon("question_mark.gif"), null, ""));
            try {
             if ( n4.length()>1){
              throw new Exception("You should type one digit");}
                setN4(parseInt(n4));}
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "You should type a digit", null, JOptionPane.ERROR_MESSAGE);}
            } while (getN4() == 0);

        JOptionPane.showMessageDialog(null, ("You think number is " + n1 + n2 + n3 + n4));
    }
}
