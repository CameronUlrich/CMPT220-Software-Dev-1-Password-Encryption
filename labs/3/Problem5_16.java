import java.util.Scanner;
public class Problem5_16 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
        System.out.print("Enter first integer number: ");
        int num = input.nextInt();
        input.close();
		
		for (int i = 2; i < num; ) 
		{

	           if (num % i == 0) 
	            {
	                System.out.print(i + " ");
	                num /= i;
	            } 
	            else 
	            {
	                i++;
	            }
	     }

	}

}
