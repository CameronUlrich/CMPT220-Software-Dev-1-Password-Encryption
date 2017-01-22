package driver_proj0;
import java.util.Scanner;
public class Problem2_5 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your tip percent for your meal: ");
		double gratuity = input.nextDouble();
		System.out.println("Enter your total for your meal: ");
		double total = input.nextDouble();
		
		double tip = (gratuity * total);
		double subTotal = (tip + total);
		System.out.println("Your total for your meal plus tip is " + subTotal * .1);

	}

}
