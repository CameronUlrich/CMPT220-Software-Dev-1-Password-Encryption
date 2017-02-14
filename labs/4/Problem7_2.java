import java.util.Scanner;
public class Problem7_2 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
        System.out.print("Enter ten integers: ");
        int[] n = new int[10];

        // passing input values to array
        for (int i = 0; i < 10; i++) n[i] = input.nextInt();
        // displaying array in reverse order
        for (int i = n.length - 1; i >= 0; i--) System.out.print(n[i] + " ");

	}

}
