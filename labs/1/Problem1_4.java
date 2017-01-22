package driver_proj0;

public class Problem1_4 
{

	public static void main(String[] args) 
	{
		System.out.printf("%3s  %5s  %5s\n", "a", "a^2", "a^3");
        for (int i = 1; i <= 4; i++) 
        {
            System.out.printf("%3d  %5d  %5d\n", i, i * i, i * i * i);
        }

	}

}
