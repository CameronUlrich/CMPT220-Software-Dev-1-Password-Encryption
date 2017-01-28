import java.util.Scanner;

public class Problem4_20 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String string = input.next();
		
		System.out.println("String: " + string);
        System.out.println("Length of the string = " + string.length());
        System.out.println("The first character of the string is: " + string.charAt(0));

	}

}
