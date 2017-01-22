package driver_proj0;
import java.util.Scanner;
public class Problem2_6 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer between 0 and 1000: ");
		int number = input.nextInt();
		
		int firstDigit = number % 10;
        int theNumber = number / 10;
        int SecondDigit = theNumber % 10;
        theNumber = theNumber / 10;
        int thirdDigit = theNumber % 10;

        int sum = thirdDigit + SecondDigit + firstDigit;

        System.out.println("The sum of all digits in the number " + number + " is " + sum + ".");

	}

}
