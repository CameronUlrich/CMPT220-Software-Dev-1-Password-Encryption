import java.util.Scanner;

public class Problem3_5 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("What is today's day: ");
		int day = input.nextInt();
		
		System.out.println("Enter the number of days elapsed since today: ");
		int elapsed = input.nextInt();
		
		int future = (day + elapsed) % 7;
		
		String[] dayConv = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		System.out.println("Today is " + dayConv[day] + " and the future day is " + dayConv[future]);
		
		
		
			
		
		
		
		
		
		
		
	}
	

}
