import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Jonathan on 18/01/2015.
 */
public class BigNumber {

    ArrayList<Integer> number;

    public BigNumber() {
        number = new ArrayList<Integer>(1);
        number.add(0, 0);
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
	
	public void unPad() {
		for (int i = number.size() - 1; i >= 0; i--) {
			if (number.get(i) == 0) {
				number.remove(i);
				
			} else 
			{ break; }
		}
	}
    
    public int size() { return number.size(); }
	public int get(int i) { return number.get(i); }
	public void set(int i, int x) { number.set(i, x); }
	public void add(int i, int x) { number.add(i ,x); }

    
    public String toString() {
        String temp = "";
        for (int i = number.size() - 1; i >= 0; i--) {
            temp += number.get(i);
        }
        return temp;
    }
    
    public BigNumber add(BigNumber numberTwo) {
        BigNumber temp = new BigNumber();
        int digits = number.size();
		int carry = 0;
		int units = 0;
        
        if (numberTwo.size() > number.size()) { 
			digits = numberTwo.size(); 
			this.pad(digits);
		}
		else { numberTwo.pad(number.size()); }
		
        temp.pad(digits);
		
		for (int i = 0; i < digits; i++) {
			int sum = number.get(i) + numberTwo.get(i) + carry;			
			carry = sum/10;
			units = sum%10;			
			temp.set(i, units);
		}
		
		if (carry > 0) { temp.add(digits, carry); }
		
        return temp;
    }

    public static void main(String[] args) throws Exception {

        /*
		Scanner scanC = new Scanner(System.in);
		

        System.out.println("Enter a number");
        BigNumber myNumber = new BigNumber(scanC.next());
        
        System.out.println(myNumber.toString());
        myNumber.pad(55);
        System.out.println(myNumber.toString());
		*/
		
		File numberFile = new File("nums.txt");
		Scanner scanF = new Scanner(numberFile);
		
		BigNumber[] numArray = new BigNumber[100];
		int i = 0;
		
		try {
			while (scanF.hasNextLine()) {
				String line = scanF.nextLine();
				//System.out.println(line);
				numArray[i] = new BigNumber(line);
				i += 1;
				
				}
		} 
		catch (Exception e) { 
				System.out.println("Exception: ");				
		}
				
		scanF.close();
		
		BigNumber total = new BigNumber();
		for (int x = 0; x < numArray.length; x++) {
			//System.out.println(total); 	
			total = total.add(numArray[x]);	
		}
		
		System.out.println(total.toString());
		
    }
}
