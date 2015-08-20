import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jonathan on 18/01/2015.
 * Represents numbers to0 large for generics, and also offers basic arithmetic on them.
 * Currently only supports positive integers
 */
public class BigNumber {

    private static Pattern p = Pattern.compile("\\d*");
    private ArrayList<Integer> digits;

    /**
     * Basic Constructor, creates number with value 0
     */
    public BigNumber() {
        digits = new ArrayList<Integer>(1);
        digits.add(0, 0);
    }

    /**
     * Constructor
     *
     * @param newNum string of digits representing the value the BigNumber will be
     */
    public BigNumber(String newNum) {

        //Invalid parameter check
        Matcher m = p.matcher(newNum);
        if (!m.matches()) throw new IllegalArgumentException("Method requires string of digits");

        //get number of digits
        int numberOfDigits = newNum.length();
        digits = new ArrayList<Integer>(numberOfDigits);

        //addDigitToFront digits into array
        for (int i = numberOfDigits; 0 < i; i--) {
            int currentDigits = Character.getNumericValue(newNum.charAt(i - 1));
            digits.add(currentDigits);
        }

    }

    /**
     * Get a copy of the number
     *
     * @return a copy of the number
     */
    public BigNumber getCopy() {
        //create new number with same value
        return new BigNumber(this.toString());
    }

    /**
     * Adds leading zeros to eliminate index out of bounds errors. Does nothing if number larger than specified value..
     *
     * @param padTo number of digits the number should have
     */
    private void pad(int padTo) {
        for (int i = digits.size(); i < padTo; i++) {
            digits.add(i, 0);
        }
    }

    /**
     * Removes all leading zeros
     */
    private void unPad() {
        for (int i = digits.size() - 1; i >= 0; i--) {
            if (digits.get(i) == 0) {
                digits.remove(i);

            } else {
                break;
            }
        }
    }

    /**
     * The magnitude of the number
     *
     * @return the amount of digits the number has (includes leading zeros)
     */
    private int size() {
        return digits.size();
    }

    /**
     * Get digit at position (also the base^power column)
     *
     * @param i position to get
     * @return the digit at position given
     */
    private int getDigitAtPosition(int i) {
        try {
            return digits.get(i);
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    /**
     * Set number at a specified position. Replaces value that is there.
     *
     * @param i position number should go
     * @param x value to set
     */
    private void setDigit(int i, int x) {
        digits.set(i, x);
    }

    /**
     * Adds digit to front of number
     *
     * @param x the digit to add
     */
    private void addDigitToFront(int x) {
        digits.add(x);
    }

    /**
     * Increases magnitude of number for multiplication
     */
    private void shiftLeft() {
        digits.add(0, 0);
    }


    public String toString() {
        String temp = "";
        for (int i = digits.size() - 1; i >= 0; i--) {
            temp += digits.get(i);
        }
        return temp;
    }

    /**
     * Add a BigNumber to this one
     *
     * @param numberTwo the number to addDigitToFront
     * @return the sum of the two numbers
     */
    public BigNumber add(BigNumber numberTwo) {
        BigNumber result = new BigNumber();
        int resultLength;
        int carry = 0;
        int units;

        //make result the correct length
        if (numberTwo.size() > this.digits.size()) {
            resultLength = numberTwo.size();
        } else {
            resultLength = this.size();
        }

        result.pad(resultLength);

        //addition here
        for (int i = 0; i < resultLength; i++) {
            int sum = this.getDigitAtPosition(i) + numberTwo.getDigitAtPosition(i) + carry;
            carry = sum / 10; //eg 17/10 --> carry 1 to next column
            units = sum % 10;    //eg 17%10 --> put 7 as result
            result.setDigit(i, units);
        }

        if (carry > 0) {
            result.addDigitToFront(carry);
        }

        return result;
    }

    /**
     * Multiplies by the BigNumber given
     *
     * @param numberTwo the number to multiply by
     * @return the product
     */
    public BigNumber multiply(BigNumber numberTwo) {
        BigNumber result = new BigNumber();
        BigNumber tempTwo = numberTwo.getCopy();
        int numberLength = this.digits.size();

        //for all digits in first number//times second number by 10 to simulate extra magnitude of digits of the first number
        for (int x = 0; x < numberLength; x++) {
            //get value of that digit
            int timesToAdd = this.getDigitAtPosition(x);
            //and add second number that amount of times
            for (int i = 1; i <= timesToAdd; i++) {
                result = result.add(tempTwo);
            }

            //times second number by 10 (or base of bigNumber) to simulate change of magnitude of first number digits
            tempTwo.shiftLeft();
        }

        result.unPad();
        return result;
    }
}
     
        
        
