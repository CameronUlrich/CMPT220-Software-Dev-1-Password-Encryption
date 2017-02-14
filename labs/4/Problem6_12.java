
public class Problem6_12 
{

	public static void main(String[] args) 
	{
		printChars('1', 'Z', 10);

	}
	public static void printChars(char ch1, char ch2, int numberPerLine) 
	{


        for (int count = 1; ch1 <= ch2; count++, ch1++) 
        {

            System.out.print(ch1 + " ");
            if (count % numberPerLine == 0) System.out.println("");

        }

    }

}
