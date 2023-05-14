package example.marley;

public class ProjectEuler_19 {
	public int findDayOnStartOfMonths(int range, int startDay, int startMonth, int startYear, int targetDay)
	{
		int[] daysPerMonth = {31,29,31,30,31,30,31,31,30,31,30,31,
							  31,28,31,30,31,30,31,31,30,31,30,31,
							  31,28,31,30,31,30,31,31,30,31,30,31,
							  31,28,31,30,31,30,31,31,30,31,30,31
		};
		if(startDay > 6 || targetDay > 6 || startDay < 0 || targetDay < 0)
		{
			System.out.println("The start day and target day must be 0 - 6 representing Sunday - Saturday");
			return 0;
		}
		if(startMonth > 11 || startMonth < 0)
		{
			System.out.println("The start month must be 0 - 11 representing Janurary - December");
		}
		int thisMonthStartDay = startDay; 
		int monthsThatStartOnTargetDay = 0;
		int absoluteStartMonth = startMonth + (startYear * 12);
		for(int i = startYear; i < range + absoluteStartMonth; ++i)
		{
			if(thisMonthStartDay == targetDay)
			{
				++monthsThatStartOnTargetDay;
			}
			thisMonthStartDay = thisMonthStartDay + (daysPerMonth[i % 48]);
		}
		return 1;
	}
}
