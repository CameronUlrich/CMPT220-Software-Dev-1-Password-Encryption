package driver_proj0;
import java.util.Scanner;
public class Problem2_1 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a temperature that is in Celsius: ");
        double celsius = input.nextDouble();
        
        double fahrenheit = (9.0 / 5.0) * celsius + 32.0;
        System.out.println(celsius + " degrees Celsius is also equal to " + fahrenheit + " degrees in Fahrenheit");
		

	}

}
