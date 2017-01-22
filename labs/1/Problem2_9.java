package driver_proj0;
import java.util.Scanner;
public class Problem2_9 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a variable for v0: ");
		double vZero = input.nextDouble();
		System.out.println("Enter a variable for v1: ");
		double vOne = input.nextDouble();
		System.out.println("Enter a variable for t: ");
		double time = input.nextDouble();
		
		double accel = ((vZero - vOne)/(time));
		System.out.println("The acceleration = " + accel);
		
		

	}

}
