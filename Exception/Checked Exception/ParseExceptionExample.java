package FileReading;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ParseExceptionExample {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.ENGLISH);
		String dateInString = sc.next();
		try {
			Date date_1 = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
}
