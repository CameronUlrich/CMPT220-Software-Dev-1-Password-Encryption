import java.util.Scanner;
public class Problem5_1 
{

	public static void main(String[] args) 
	{
		int pos = 0;
        int neg = 0;
        int total = 0;
        double average = 0;
        
        System.out.print("Enter an integer, the input ends if it is 0: ");
        Scanner input = new Scanner(System.in);

        for (int buffer = -1; buffer != 0; ) 
        {

            buffer = input.nextInt();
            if (buffer > 0) pos++;
            else if (buffer < 0) neg++;
            total += buffer;
        }
        if (pos + neg == 0) 
        {
            System.out.println("No numbers are entered except 0");
            System.exit(0);
        }
        average = total /(double)(pos + neg);
        System.out.println("The number of positives is " + pos);
        System.out.println("The number of negatives is " + neg);
        System.out.println("The total is " + total);
        System.out.println("The average is " + average);

	}

}
