import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jonathan on 18/01/2015.
 */
public class BigNumber {

    ArrayList<Integer> number;

    public BigNumber() {
        number = new ArrayList<Integer>(1);
        number.add(0, 1);
    }

    public BigNumber(String newNum) {
        number = new ArrayList<Integer>(newNum.length());
        for (int i = 0; i < newNum.length(); i++) {
            number.add(i, Character.getNumericValue(newNum.charAt(newNum.length() - i - 1)));
        }

    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < number.size(); i++) {
            temp += number.get(i);
        }
        return temp;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number");
        BigNumber myNumber = new BigNumber(scan.next());
    }
}
     
        
        