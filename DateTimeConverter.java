import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

public class DateTimeConverter{
	public static String convertTime(Date date, String format, String timeZone) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		return sdf.format(date);
	}

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter time in 'dd-MM-yyyy hh:mm:ss a' format" + "\n" + "Example : 22-01-2015 08:15:55 AM");

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.ENGLISH);
		String dateInString = sc.nextLine();
		Date date = formatter.parse(dateInString);

		System.out.println("PST Date and Time for the provided Date and Time : "
				+ convertTime(date, "dd-MM-yyyy hh:mm:ss a", "PST"));
		System.out.println("GMT Date and Time for the provided Date and Time : "
				+ convertTime(date, "dd-MM-yyyy hh:mm:ss a", "GMT"));

	}
}
