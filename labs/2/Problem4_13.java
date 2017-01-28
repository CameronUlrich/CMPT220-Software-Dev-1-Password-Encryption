import java.util.Scanner;

public class Problem4_13 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a letter: ");
		
		char letter = input.next().charAt(0);
		letter = Character.toUpperCase(letter);
		if((letter != 'A' && letter != 'E' && letter != 'I' && letter != 'O' && letter != 'U') && (letter >= 'A' && letter <= 'Z'))
		{
			System.out.println(letter + " is a consonant.");
		}
		else if(letter >= 'A' && letter <= 'Z')
		{
			System.out.println(letter + " is a vowel.");
		}
		else
		{
			System.out.println("Invalid input");
		}
		

	}

}
