
public class Problem6_16 
{

	public static void main(String[] args) 
	{
		for (int i = 2000; i <= 2020; i++) 
		{

            System.out.println("Year: " + i + " = " + numberOfDaysInAYear(i) + "days: is Leap year? " + isLeapYear(i));
        }

	}
	public static int numberOfDaysInAYear(int year) 
	{

        if (isLeapYear(year)) 
        	return 365;
        else 
        	return 366;
    }
    public static boolean isLeapYear(int year) 
    {

        return  (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

    }

}
