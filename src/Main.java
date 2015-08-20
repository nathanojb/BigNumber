/**
 * Created by Jonathan on 19/08/2015.
 * Run code form here
 */
public class Main {

    public static void main(String[] args) throws Exception {

        /*
        Scanner scanC = new Scanner(System.in);


        System.out.println("Enter a digits");
        BigNumber myNumber = new BigNumber(scanC.next());

        System.out.println(myNumber.toString());
        myNumber.pad(55);
        System.out.println(myNumber.toString());
		*/

        /*

        File numberFile = new File("nums.txt");
        Scanner scanF = new Scanner(numberFile);

        BigNumber[] numberArray = new BigNumber[100];
        int i = 0;

        try {
            while (scanF.hasNextLine()) {
                String line = scanF.nextLine();
                numberArray[i] = new BigNumber(line);
                i += 1;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        scanF.close();

        BigNumber total = new BigNumber();
        for (int x = 0; x < numberArray.length; x++) {
            total = total.add(numberArray[x]);
        }

        System.out.println("Total of all numbers in nums.txt is: " + total.toString());
        */


        BigNumber one = new BigNumber("1234567890");
        BigNumber two = new BigNumber("36");
        System.out.println(one.multiply(two));
        System.out.println(two.multiply(one));
        System.out.println(two.add(one));
        System.out.println(one.add(two));


        System.out.println("::: " + one + " " + two);


    }


}
