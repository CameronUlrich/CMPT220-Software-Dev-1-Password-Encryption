
public class Problem6_9 
{

	public static void main(String[] args) 
	{


		        String feets = "Feet";
		        String meter = "Meters";
		        System.out.printf("%5s%10s | %5s%9s\n", feets, meter, meter, feets);
		        for (double feet = 1, meters = 20; feet <= 10; feet++, meters += 5) 
		        {

		            System.out.printf("%5.2f%10.2f | %5.2f%10.2f\n", feet, footToMeter(feet),
		                    meters, meterToFoot(meters));


		        }
		    }

		    /** Convert from feet to meters */
		    public static double footToMeter(double foot) 
		    {
		        return 0.305 * foot;
		    }

		    /** Convert from meters to feet */
		    public static double meterToFoot(double meter) 
		    {
		        return 3.279 * meter;
		    }

	

}
