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

    public Object clone() {
     return this;
    }
    
    public void pad(int padTo) {
        for (int i = number.size(); i < padTo; i++) {
                number.add(i,0);
            }
    }
    
    public int size() { return number.size(); }
    
    public String toString() {
        String temp = "";
        for (int i = number.size() - 1; i >= 0; i--) {
            temp += number.get(i);
        }
        return temp;
    }
    
    public BigNumber add(BigNumber numberTwo) {
        BigNumber temp = (BigNumber)this.clone();
        int digits = number.size();
        
        
        
        
        return temp;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number");
        BigNumber myNumber = new BigNumber(scan.next());
        
        System.out.println(myNumber.toString());
        myNumber.pad(55);
        System.out.println(myNumber.toString());
    }
}
     
        
        